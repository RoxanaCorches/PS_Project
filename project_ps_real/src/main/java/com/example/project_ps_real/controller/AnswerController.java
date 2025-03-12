package com.example.project_ps_real.controller;

import com.example.project_ps_real.entity.Answers;
import com.example.project_ps_real.service.AnswersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answers")
public class AnswerController {
    @Autowired
    private AnswersService answersService;

    @GetMapping("/getAll")
    @ResponseBody
    public List<Answers> getAllPost() {
        return this.answersService.getAllAnswers();
    }

    @GetMapping("/getById")
    @ResponseBody
    public Answers getAnswerById(@RequestParam("id") Long id) {
        System.out.println("Received request for post ID: " + id);
        return this.answersService.getAnswersId(id);
    }

    @PostMapping("/addAnswer")
    @ResponseBody
    public Answers addAnswer(@RequestBody Answers answer) {
        return this.answersService.addAnswer(answer);
    }

    @PutMapping("/updateAnswer")
    @ResponseBody
    public Answers updateAnswer(@RequestBody Answers answer) {
        return this.answersService.updateAnswer(answer);
    }

    @DeleteMapping("/deleteById")
    @ResponseBody
    public String deleteAnswerById(@RequestParam("id") Long id) {
        System.out.println("Received request for post ID: " + id);
        return this.answersService.deleteAnswer(id);

    }
}
