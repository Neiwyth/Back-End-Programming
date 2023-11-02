package sof03.music.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import sof03.music.domain.Band;
import sof03.music.domain.BandRepository;
import sof03.music.domain.Song;
import sof03.music.domain.SongRepository;

@CrossOrigin
@Controller
public class BandController {

    @Autowired
    private BandRepository bandRepository;

    @Autowired
    private SongRepository songRepository;

    // list all bands
    @GetMapping("/bandlist")
    public String showAllBands(Model model) {

        model.addAttribute("bands", bandRepository.findAll());
        return "bandlist";
    }

    // show the information of one band
    @GetMapping("/bandinfo/{id}")
    public String showOneBand(@PathVariable("id") Long bandId, Model model) {
        Band band = bandRepository.findById(bandId).orElse(null);
        model.addAttribute("band", band);
        List<Song> songs = songRepository.findByBand(band);
        model.addAttribute("songs", songs);
        return "bandinfo";
    }

    // add new band
    @GetMapping("/addband")
    public String addNewBand(Model model) {

        model.addAttribute("band", new Band());
        return "addband";
    }

    // save new band or save edits for existing band
    @PostMapping("/saveband")
    public String saveBand(Band band) {

        bandRepository.save(band);
        Long bandId = band.getBandId();
        return "redirect:/bandinfo/" + bandId;
    }

    // edit band information
    @GetMapping("/editband/{id}")
    public String editBand(@PathVariable("id") Long bandId, Model model) {
        model.addAttribute("band", bandRepository.findById(bandId).orElse(null));
        return "editband";
    }

    // delete band and all songs associated with the band
    @GetMapping("deleteband/{id}")
    public String deleteBand(@PathVariable("id") Long bandId) {
        bandRepository.deleteById(bandId);
        return "redirect:/bandlist";
    }

}