package Server;

import java.util.Arrays;

public class Answer {
    public Long getQuestionid() {
        return questionid;
    }

    public Integer[] getSelectedAnswers() {
        return selectedAnswers;
    }

    public int getPoints() {
        return points;
    }

    public Integer[] getCorrectAnswers() {
        return correctAnswers;
    }

    public void setQuestionid(Long questionid) {
        this.questionid = questionid;
    }

    public void setSelectedAnswers(Integer[] selectedAnswers) {
        this.selectedAnswers = selectedAnswers;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setCorrectAnswers(Integer[] correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "questionid=" + questionid +
                ", selectedAnswers=" + Arrays.toString(selectedAnswers) +
                ", points=" + points +
                ", correctAnswers=" + Arrays.toString(correctAnswers) +
                '}';
    }

    private Long questionid;
    private Integer[] selectedAnswers;
    private int points;
    private Integer[] correctAnswers;

    public Answer() {
        Long questionid;
        Integer[] selectedAnswers;
        int points;
        Integer[] correctAnswers;
    }

}
