package Server;

public class Question {
    private Long id;
    private String question;
    private String[] answers;
    private int points;
    private Integer[] correct;
    private boolean lastQuestion;

    public String getQuestion() {
        return question;
    }

    public String[] getAnswers() {
        return answers;
    }

    public int getPoints() {
        return points;
    }

    public Integer[] getCorrect() {
        return correct;
    }
    public boolean isLastQuestion() {
        return true;
    }
    public void setLastQuestion(boolean obj){

    }

    public Question() {
        long id;
        String question;
        String[] answers;
        int points;
        Integer[] correct;
        boolean lastQuestion;
    }

}
