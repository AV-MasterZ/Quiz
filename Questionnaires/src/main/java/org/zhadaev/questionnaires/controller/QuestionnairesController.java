package org.zhadaev.questionnaires.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.zhadaev.constructor.service.IQuestionnaireService;
import org.zhadaev.questionnaires.service.IUserAnswerService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
public class QuestionnairesController {

    @Autowired
    private IQuestionnaireService questionnaireService;

    @Autowired
    private IUserAnswerService userAnswerService;

    @GetMapping("/questionnaires")
    public String questionnairesPage(Model model) {
        model.addAttribute("questionnaires", questionnaireService.findAll());
        return "questionnaires";
    }

    @GetMapping("/questionnaires/{id}")
    public String questionnairePage(@PathVariable("id") String id, Model model) {
        long n = Long.parseLong(id);
        model.addAttribute("questionnaire", questionnaireService.findById(n));
        return "questionnaire";
    }

    @PostMapping("/questionnaires/{id}")
    public String saveAnswers(@PathVariable("id") String id, @RequestBody MultiValueMap<String, String> form, Model model) {
        Long qid = Long.parseLong(id);
        Collection<List<String>> allAnswers = form.values();
        List<String> answers = new ArrayList<>();
        for (List<String> ans: allAnswers) {
            answers.addAll(ans);
        }
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        userAnswerService.save(answers, qid, username);
        return "redirect:/questionnaires";
    }

    @GetMapping("/questionnaires/delete/{id}")
    public String deleteQuestionnaire(@PathVariable("id") String id, Model model) {
        Long qid = Long.parseLong(id);
        questionnaireService.delete(qid);
        return "redirect:/questionnaires";
    }

}
