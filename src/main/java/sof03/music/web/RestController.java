package sof03.music.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import sof03.music.domain.Band;
import sof03.music.domain.BandRepository;

@CrossOrigin
@Controller
public class RestController {

    @Autowired
    private BandRepository bandRepository;

    // get all bands
    @GetMapping("/bands")
    public @ResponseBody List<Band> getBandsRest() {
        return bandRepository.findAllBands();
    }

    // get band by id
    @GetMapping("/bands/{bandId}")
    public @ResponseBody Optional<Band> getBandByIdRest(@PathVariable("bandId") Long bandId) {
        return bandRepository.getAllSongsForBand(bandId);
    }

    // add new band
    @PostMapping("/bands")
    public @ResponseBody Band addNewBandRest(@RequestBody Band band) {
        return bandRepository.save(band);

    }

    // delete band by id
    @DeleteMapping("/bands/{bandId}")
    void deleteBand(@PathVariable("bandId") Long bandId) {
        bandRepository.deleteById(bandId);
    }

    // edit a band
    @PutMapping("/bands/{bandId}")
    Band editBand(@RequestBody Band editedBand, @PathVariable Long bandId) {
        editedBand.setBandId(bandId);
        return bandRepository.save(editedBand);
    }
}
