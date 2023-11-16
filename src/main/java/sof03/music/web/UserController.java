package sof03.music.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import sof03.music.domain.SignupForm;
import sof03.music.domain.User;
import sof03.music.domain.UserRepository;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String login() {

        return "login";
    }

    // add new user
    @GetMapping("/signup")
    @PreAuthorize("!hasAnyAuthority('ADMIN', 'USER')")
    public String addUser(Model model) {
        model.addAttribute("signupForm", new SignupForm());

        return "signup";
    }

    // save new user
    @PostMapping("/saveuser")
    @PreAuthorize("!hasAnyAuthority('ADMIN', 'USER')")
    public String saveNewUser(@Valid @ModelAttribute("signupForm") SignupForm signupForm, BindingResult bindingResult) {

        if (!bindingResult.hasErrors()) {

            if (signupForm.getPassword().equals(signupForm.getConfirmPassword())) {
                String pwd = signupForm.getPassword();
                BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
                String hashpwd = bc.encode(pwd);

                User newUser = new User();
                newUser.setPasswordHash(hashpwd);
                newUser.setUserName(signupForm.getUsername());
                newUser.setRole("USER");

                if (userRepository.findByUserNameIgnoreCase(signupForm.getUsername()) == null) {
                    userRepository.save(newUser);
                } else {

                    bindingResult.rejectValue("username", "err.username", "Username already exists");
                    return "signup";
                }
            } else {

                bindingResult.rejectValue("confirmPassword", "err.passCheck", "Passwords does not match");
                return "signup";
            }
        } else {

            return "signup";
        }
        return "redirect:/login";
    }

}