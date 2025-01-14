package com.blankSpace.Question_Service.Service;


import com.blankSpace.Question_Service.DAO.QuestionDAO;
import com.blankSpace.Question_Service.Entity.Question;
import com.blankSpace.Question_Service.Entity.QuestionWrapper;
import com.blankSpace.Question_Service.Entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionDAO questionDAO;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDAO.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDAO.findByCategory(category), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Question> postQuestion(Question question) {
        try {
            return new ResponseEntity<>(questionDAO.save(question), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public String deleteQuestion(Integer id) {
        questionDAO.deleteById(id);
        return "Successfully deleted";
    }

    public ResponseEntity<List<Integer>> getQuestionForQuiz(String category, Integer numberOfQuestion) {
        List<Integer> questions = questionDAO.findRandomQuestionByCategory(category, numberOfQuestion);

        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> ids) {
        List<QuestionWrapper> wrapper = new ArrayList<>();
        List<Question> questions = new ArrayList<>();
        for (Integer id : ids) {
            questions.add(questionDAO.findById(id).get());
        }
        for(Question qu : questions) {
            QuestionWrapper qw = new QuestionWrapper(qu.getId(), qu.getQuestion_title(), qu.getOption1(), qu.getOption2(), qu.getOption3(), qu.getOption4());
            wrapper.add(qw);
        }

        return new ResponseEntity<>(wrapper, HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore(List<Response> responses) {
        int score = 0;
        for (Response response : responses) {
            Question question = questionDAO.findById(response.getId()).get();
            if (question.getRight_answer().equals(response.getResponse())) {
                score++;
            }
        }

        return new ResponseEntity<>(score, HttpStatus.OK);
    }
}
