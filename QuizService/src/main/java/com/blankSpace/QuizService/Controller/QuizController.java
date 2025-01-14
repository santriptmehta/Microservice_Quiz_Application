package com.blankSpace.QuizService.Controller;


import com.blankSpace.QuizService.Entity.QuestionWrapper;
import com.blankSpace.QuizService.Entity.Response;
import com.blankSpace.QuizService.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;
    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto) {

        return quizService.createQuiz(quizDto.getCategory(), quizDto.getNumberOfQuestions(), quizDto.getTitle());
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable Integer id) {
        return quizService.getQuizQuestion(id);
    }

    @PostMapping("/submit")
    public ResponseEntity<Integer> submitQuiz( @RequestBody List<Response> response) {
        return quizService.calculateScore(response);
    }

}
