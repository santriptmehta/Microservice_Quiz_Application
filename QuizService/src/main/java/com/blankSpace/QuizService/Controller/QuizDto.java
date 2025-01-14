package com.blankSpace.QuizService.Controller;


import lombok.Data;

@Data
public class QuizDto {
    String category;
    Integer numberOfQuestions;
    String title;

    public QuizDto() {
    }

    public QuizDto(String category, Integer numberOfQuestions, String title) {
        this.category = category;
        this.numberOfQuestions = numberOfQuestions;
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(Integer numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
