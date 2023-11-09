package sof03.music.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import sof03.music.domain.Band;
import sof03.music.domain.BandRepository;
import sof03.music.domain.Comment;
import sof03.music.domain.CommentRepository;
import sof03.music.domain.SongRepository;
import sof03.music.domain.User;
import sof03.music.domain.UserRepository;

@Controller
public class BandController {

    @Autowired
    private BandRepository bandRepository;

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    // get current user
    private User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUserName(auth.getName());
        return user;
    }

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
        model.addAttribute("songs", songRepository.findByBandOrderByPublicationYear(band));

        // listing comments of the band
        model.addAttribute("comments", commentRepository.findByBand(band));
        Comment newComment = new Comment();
        newComment.setBand(band);
        newComment.setUser(getCurrentUser());
        model.addAttribute("newComment", newComment);
        return "bandinfo";
    }

    // add new band
    @GetMapping("/addband")
    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('USER')")
    public String addNewBand(Model model) {

        model.addAttribute("band", new Band());
        return "addband";
    }

    // save new band
    @PostMapping("/saveband")
    public String saveBand(@Valid @ModelAttribute("band") Band band, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("band", band);
            return "addband";
        } else {

            bandRepository.save(band);
            return "redirect:/bandinfo/" + band.getBandId();
        }
    }

    // edit band information
    @GetMapping("/editband/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String editBand(@PathVariable("id") Long bandId, Model model) {
        model.addAttribute("band", bandRepository.findById(bandId).orElse(null));
        return "editband";
    }

    // save edited band
    @PostMapping("/savebandedit")
    public String saveEditedSong(@Valid @ModelAttribute("band") Band band, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("song", band);
            return "editband";

        } else {

            bandRepository.save(band);
            return "redirect:/bandinfo/" + band.getBandId();
        }
    }

    // delete band and all songs associated with the band
    @GetMapping("deleteband/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteBand(@PathVariable("id") Long bandId) {
        bandRepository.deleteById(bandId);
        return "redirect:/bandlist";
    }

}