package pl.ans.server.quiz;


import java.util.Arrays;


public class Answer {
    private Long questionId;
    private Integer[] selectedAnswers;
    private int points;
    private Integer[] correctAnswers;

    public Answer() {
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setSelectedAnswers(Integer[] selectedAnswers) {
        this.selectedAnswers = selectedAnswers;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
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

    public void setCorrectAnswers(Integer[] correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    @Override
    public String toString() {
        return "Answers{" +
                "questionId=" + questionId +
                ", selectedAnswers=" + Arrays.toString(selectedAnswers) +
                '}';
    }
}

