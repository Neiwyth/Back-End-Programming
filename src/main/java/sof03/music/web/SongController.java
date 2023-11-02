package sof03.music.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import sof03.music.domain.Band;
import sof03.music.domain.BandRepository;
import sof03.music.domain.Song;
import sof03.music.domain.SongRepository;

@CrossOrigin
@Controller
public class SongController {

    @Autowired
    SongRepository songRepository;

    @Autowired
    BandRepository bandRepository;

    // add new song for selected band
    @GetMapping("/addsong/{id}")
    public String addNewSong(@PathVariable("id") Long bandId, Model model) {
        Song newSong = new Song();
        Band band = bandRepository.findById(bandId).orElse(null);
        newSong.setBand(band);
        model.addAttribute("newSong", newSong);
        return "addsong";
    }

    // save new song
    @PostMapping("/savesong")
    public String saveSong(@ModelAttribute Song song) {
        songRepository.save(song);
        Long bandId = song.getBand().getBandId();
        return "redirect:/bandinfo/" + bandId;
    }

    // delete one song
    @GetMapping("/deletesong/{id}")
    public String deleteSong(@PathVariable("id") Long songId) {
        Long bandId = songRepository.findById(songId).get().getBand().getBandId();
        songRepository.deleteById(songId);
        return "redirect:/bandinfo/" + bandId;
    }

    // edit a song
    @GetMapping("/editsong/{id}")
    public String editSong(@PathVariable("id") Long songId, Model model) {
        model.addAttribute("song", songRepository.findById(songId).orElse(null));
        return "editsong";
    }

}