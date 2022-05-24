package pl.ans.server.quiz;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class Question {
    @JsonIgnore
    private Long id;
    private String question;
    private String[] answers;
    private int points;
    @JsonIgnore
    private Integer[] correct;
    private boolean lastQuestion;


    public Question(String question, String[] answers, int points, boolean lastQuestion) {
        this.question = question;
        this.answers = answers;
        this.points = points;
        this.lastQuestion = lastQuestion;
    }

    public Question(Long id, String question, String[] answers, int points, Integer[] correct) {
        this.id = id;
        this.question = question;
        this.answers = answers;
        this.points = points;
        this.correct = correct;
    }

    public Integer[] getCorrect() {
        return correct;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getAnswers() {
        return answers;
    }

    public int getPoints() {
        return points;
    }

    public boolean isLastQuestion() {
        return lastQuestion;
    }

    public void setLastQuestion(boolean lastQuestion) {
        this.lastQuestion = lastQuestion;
    }
}
