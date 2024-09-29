package ru.kiomaru.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kiomaru.entity.User;
import ru.kiomaru.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userServiceImpl;

    public UserController(UserService userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping()
    public String index() {
        return "index";
    }

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", userServiceImpl.getAllUsers());
        return "users";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping("/users/create")
    public String newUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new";
        }
        userServiceImpl.save(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userServiceImpl.getUser(id));
        return "edit";
    }

    @PostMapping("/users/edit")
    public String editUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, @RequestParam("id") int id, Model model) {
        if (bindingResult.hasErrors()) {
            User originalUser = userServiceImpl.getUser(id);
            model.addAttribute("user", originalUser);
            model.addAttribute("org.springframework.validation.BindingResult.user", bindingResult);
            return "edit";
        }
        userServiceImpl.saveEditedUser(id, user);
        return "redirect:/users";
    }


    @PostMapping("/users/delete")
    public String deleteUser(@RequestParam("id") int id) {
        userServiceImpl.delete(id);
        return "redirect:/users";
    }
}
