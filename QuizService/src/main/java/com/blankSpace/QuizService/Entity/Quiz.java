package com.blankSpace.QuizService.Entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    @ElementCollection
    private List<Integer> questionList;

    public Quiz() {
    }

    public Quiz(Integer id, String title, List<Integer> questionList) {
        this.id = id;
        this.title = title;
        this.questionList = questionList;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<Integer> getQuestionList() {
        return questionList;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setQuestionList(List<Integer> questionList) {
        this.questionList = questionList;
    }
}
