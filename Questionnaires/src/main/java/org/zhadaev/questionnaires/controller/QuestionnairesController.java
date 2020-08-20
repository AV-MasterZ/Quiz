package org.zhadaev.questionnaires.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.zhadaev.constructor.service.IQuestionnaireService;

import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class QuestionnairesController {

    @Autowired
    IQuestionnaireService questionnaireService;

    @GetMapping("/questionnaires")
    public String questionnairesPage(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Set<String> roles = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).collect(Collectors.toSet());

        model.addAttribute("questionnaires", questionnaireService.findAll());
        model.addAttribute("role", roles.iterator().next());
        return "questionnaires";
    }

    @GetMapping("/questionnaires/{id}")
    public String questionnairePage(@PathVariable("id") String id, Model model) {
        long n = Long.parseLong(id);
        model.addAttribute("questionnaire", questionnaireService.findById(n));
        return "questionnaire";
    }

    @GetMapping("/questionnaires/delete/{id}")
    public String deleteQuestionnaire(@PathVariable("id") String id, Model model) {
        Long qid = Long.parseLong(id);
        questionnaireService.delete(qid);
        return "redirect:/questionnaires";
    }

}
