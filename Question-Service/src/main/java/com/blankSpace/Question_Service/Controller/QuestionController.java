package com.blankSpace.Question_Service.Controller;


import com.blankSpace.Question_Service.Entity.Question;
import com.blankSpace.Question_Service.Entity.QuestionWrapper;
import com.blankSpace.Question_Service.Entity.Response;
import com.blankSpace.Question_Service.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @Autowired
    Environment environment;
    @GetMapping("/getQuestion")
    public ResponseEntity<List<Question>> getAllQuestion() {
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionCategory(@PathVariable String category) {
        return questionService.getQuestionByCategory(category);
    }

    @PostMapping("/postQuestion")
    public ResponseEntity<Question> postQuestion(@RequestBody Question question) {
        return questionService.postQuestion(question);
    }

    @DeleteMapping("/deleteQuestion/{id}")
    public String deleteQuestion(@PathVariable Integer id) {
        return questionService.deleteQuestion(id);
    }

    @GetMapping("/generate")
    public ResponseEntity<List<Integer>> gnereateQuestionForQuiz(@RequestParam String category, @RequestParam Integer numberOfQuestion) {
        return questionService.getQuestionForQuiz(category, numberOfQuestion);
    }

    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> ids) {
        System.out.println(environment.getProperty("local.server.port"));
        return questionService.getQuestionsFromId(ids);
    }

    @PostMapping("/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
        return questionService.getScore(responses);
    }
}
