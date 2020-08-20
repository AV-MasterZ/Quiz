package org.zhadaev.constructor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.zhadaev.constructor.model.Answer;
import org.zhadaev.constructor.model.Question;
import org.zhadaev.constructor.model.QuestionType;
import org.zhadaev.constructor.model.Questionnaire;
import org.zhadaev.constructor.service.IQuestionnaireService;

import java.util.HashSet;
import java.util.Set;

@Controller
public class ConstructorController {

    @Autowired
    IQuestionnaireService questionnaireService;

    @GetMapping("/constructor")
    public String constructorPage(Model model) {
        return "constructor";
    }

    @GetMapping("/constructor/{id}")
    public String editQuestionnaire(@PathVariable("id") String id, Model model) {
        long i = Long.parseLong(id);
        Questionnaire q = questionnaireService.findById(i);
        model.addAttribute("questionnaire", q);
        return "constructor";
    }

    @PostMapping("/constructor")
    public String saveQuestionnaire(@RequestBody MultiValueMap<String, String> form, Model model) {
        questionnaireService.save(parseMap(form));
        return "redirect:/questionnaires";
    }

    private Questionnaire parseMap(MultiValueMap<String, String> form) {

        Set<String> keys = form.keySet();
        Set<String> questions = new HashSet<>();
        Set<String> answers = new HashSet<>();
        for (String key: keys) {
            if (Character.isDigit(key.charAt(key.length() - 1))) {
                if (key.matches("q(\\d*)")) questions.add(key);
                if (key.matches("q(\\d*)a(\\d*)")) answers.add(key);
            }
        }

        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setTitle(form.get("title").get(0));
        String qus = form.get("id").get(0);
        if (!qus.equals("")) {
            questionnaire.setId(Long.parseLong(qus));
        }

        for (String q: questions) {
            Question question = new Question();
            question.setQuestion(form.get(q).get(0));
            String qs = form.get(q + "id").get(0);
            if (!qs.equals("")) {
                question.setId(Long.parseLong(qs));
            }

            QuestionType qt = new QuestionType();
            qt.setType(form.get(q + "type").get(0));
            question.setType(qt);

            questionnaire.addQuestion(question);

            for (String a: answers) {
                if (a.startsWith(q)) {
                    Answer answer = new Answer();
                    answer.setAnswer(form.get(a).get(0));
                    String as = form.get(a + "id").get(0);
                    if (!as.equals("")) {
                        answer.setId(Long.parseLong(as));
                    }
                    question.addAnswer(answer);
                }
            }
        }

        return questionnaire;

    }

}
