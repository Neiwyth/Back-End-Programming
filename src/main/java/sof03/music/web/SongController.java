package sof03.music.web;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import io.micrometer.common.util.StringUtils;
import jakarta.validation.Valid;
import sof03.music.domain.Band;
import sof03.music.domain.BandRepository;
import sof03.music.domain.Song;
import sof03.music.domain.SongRepository;

@Controller
public class SongController {

    private static final String spotifyRegex = "^spotify:track:[a-zA-Z0-9]+$";
    private static final String youtubeRegex = "^(https?://)?(www\\.)?youtube\\.com/.+";

    @Autowired
    SongRepository songRepository;

    @Autowired
    BandRepository bandRepository;

    // add new song for selected band
    @GetMapping("/addsong/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public String addNewSong(@PathVariable("id") Long bandId, Model model) {

        Song newSong = new Song();
        Band band = bandRepository.findById(bandId).orElse(null);
        newSong.setBand(band);
        model.addAttribute("newSong", newSong);
        return "addsong";
    }

    // save new song
    @PostMapping("/savesong")
    public String saveSong(@Valid @ModelAttribute("newSong") Song song, BindingResult bindingResult, Model model) {

        if (StringUtils.isNotBlank(song.getSpotifyLink()) && !Pattern.matches(spotifyRegex, song.getSpotifyLink())) {
            bindingResult.rejectValue("spotifyLink", "err.spotifyLink",
                    "Invalid spotify link, please use the spotify-URI format (spotify:track:)");
        }

        if (StringUtils.isNotBlank(song.getYoutubeLink()) && !Pattern.matches(youtubeRegex, song.getYoutubeLink())) {
            bindingResult.rejectValue("youtubeLink", "err.youtubeLink",
                    "Invalid youtube link, please use full https:// link");
        }

        if (bindingResult.hasErrors()) {
            model.addAttribute("newSong", song);
            return "addsong";

        } else {

            songRepository.save(song);
            return "redirect:/bandinfo/" + song.getBand().getBandId();
        }
    }

    // delete one song
    @GetMapping("/deletesong/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteSong(@PathVariable("id") Long songId) {

        Song deletedSong = songRepository.findById(songId).orElse(null);
        Long bandId = deletedSong.getBand().getBandId();
        songRepository.deleteById(songId);
        return "redirect:/bandinfo/" + bandId;
    }

    // edit a song
    @GetMapping("/editsong/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String editSong(@Valid @PathVariable("id") Long songId, Model model) {

        model.addAttribute("song", songRepository.findById(songId).orElse(null));
        return "editsong";
    }

    // save editet song
    @PostMapping("/savesongedit")
    public String saveEditedSong(@Valid @ModelAttribute("song") Song song, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("song", song);
            return "editsong";

        } else {

            songRepository.save(song);
            return "redirect:/bandinfo/" + song.getBand().getBandId();
        }
    }

}