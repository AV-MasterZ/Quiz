package org.zhadaev.answers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.zhadaev.questionnaires.model.UserAnswer;
import org.zhadaev.questionnaires.service.IUserAnswerService;
import org.zhadaev.user.model.User;
import org.zhadaev.user.service.UserService;

import java.util.List;
import java.util.Set;

@Controller
public class AnswersController {

    @Autowired
    private UserService userService;

    @Autowired
    private IUserAnswerService userAnswerService;

    @GetMapping("/users")
    public String usersPage(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/useranswers/{id}")
    public String useranswersPage(@PathVariable("id") String id, Model model) {
        Long userId = Long.parseLong(id);
        Set<UserAnswer> userAnswers =  userAnswerService.findByUserId(userId);
        User user = userService.findById(userId);
        model.addAttribute("userAnswers", userAnswers);
        model.addAttribute("user", user);
        return "useranswers";
    }

}
