package sof03.music.web;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import sof03.music.domain.Comment;
import sof03.music.domain.CommentRepository;

@CrossOrigin
@Controller
public class CommentController {

    @Autowired
    CommentRepository commentRepository;

    // save new comment
    @PostMapping("/savecomment")
    public String saveComment(@Valid @ModelAttribute Comment comment, BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            // model.addAttribute("band",
            // commentRepository.findById(comment.getBand().getBandId()).orElse(null));
            return "redirect:/bandinfo/" + comment.getBand().getBandId();

        } else {

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            comment.setTimestamp(timestamp);
            commentRepository.save(comment);
            return "redirect:/bandinfo/" + comment.getBand().getBandId();
        }
    }
}