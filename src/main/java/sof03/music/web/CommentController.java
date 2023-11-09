package sof03.music.web;

import java.sql.Timestamp;

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
import sof03.music.domain.BandRepository;
import sof03.music.domain.Comment;
import sof03.music.domain.CommentRepository;
import sof03.music.domain.SongRepository;
import sof03.music.domain.User;
import sof03.music.domain.UserRepository;

@Controller
public class CommentController {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    BandRepository bandRepository;

    @Autowired
    SongRepository songRepository;

    @Autowired
    UserRepository userRepository;

    // get current user
    private User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUserName(auth.getName());
        return user;
    }

    // save new comment
    @PostMapping("/savecomment")
    public String saveComment(@Valid @ModelAttribute("newComment") Comment comment, BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("band", bandRepository.findById(comment.getBand().getBandId()).orElse(null));
            model.addAttribute("songs", songRepository.findByBandOrderByPublicationYear(comment.getBand()));
            model.addAttribute("comments", commentRepository.findByBand(comment.getBand()));
            return "bandinfo";

        } else {

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            comment.setTimestamp(timestamp);
            comment.setUser(getCurrentUser());
            commentRepository.save(comment);
            return "redirect:/bandinfo/" + comment.getBand().getBandId();
        }
    }

    // delete comment
    @GetMapping("/deletecomment/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteComment(@PathVariable("id") Long commentId) {

        Long bandId = commentRepository.findById(commentId).get().getBand().getBandId();
        commentRepository.deleteById(commentId);
        return "redirect:/bandinfo/" + bandId;
    }
}