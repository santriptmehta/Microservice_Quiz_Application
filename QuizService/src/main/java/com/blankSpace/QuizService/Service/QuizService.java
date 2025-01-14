package com.blankSpace.QuizService.Service;


import com.blankSpace.QuizService.DAO.QuizDao;
import com.blankSpace.QuizService.Entity.QuestionWrapper;
import com.blankSpace.QuizService.Entity.Quiz;
import com.blankSpace.QuizService.Entity.Response;
import com.blankSpace.QuizService.Feing.QuizInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Indexed;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuizInterface quizInterfase;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
          List<Integer> questions = quizInterfase.gnereateQuestionForQuiz(category, numQ).getBody();
          Quiz quiz = new Quiz();
          quiz.setTitle(title);
          quiz.setQuestionList(questions);
          quizDao.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer quizId) {
           Quiz quiz = quizDao.findById(quizId).get();
            List<Integer>questionId = quiz.getQuestionList();
            quizInterfase.getQuestionsFromId(questionId);
            ResponseEntity<List<QuestionWrapper>> question = quizInterfase.getQuestionsFromId(questionId);
            return question;
    }

    public ResponseEntity<Integer> calculateScore(List<Response> response) {
        ResponseEntity<Integer> score = quizInterfase.getScore(response);
        return score;
    }
}
