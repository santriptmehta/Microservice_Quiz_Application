package com.blankSpace.Question_Service.Entity;

import jakarta.persistence.*;


@Entity
@Table(name = "question_bank")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String category;
    private String difficultylevel;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String question_title;
    private String right_answer;

    public Question() {
    }

    public Question(Integer id, String category, String difficultylevel, String option1, String option2, String option3, String option4, String question_title, String right_answer) {
        this.id = id;
        this.category = category;
        this.difficultylevel = difficultylevel;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.question_title = question_title;
        this.right_answer = right_answer;
    }

    public Integer getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getDifficultylevel() {
        return difficultylevel;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    public String getQuestion_title() {
        return question_title;
    }

    public String getRight_answer() {
        return right_answer;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDifficultylevel(String difficultylevel) {
        this.difficultylevel = difficultylevel;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public void setQuestion_title(String question_title) {
        this.question_title = question_title;
    }

    public void setRight_answer(String right_answer) {
        this.right_answer = right_answer;
    }
}
