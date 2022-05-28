package pl.ans.server.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ans.server.dao.QuestionDao;
import pl.ans.server.impl.FileService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class QuizService {
private List<Answer> answers = new ArrayList<>();

@Autowired
private QuestionDao questionDao;

@Autowired
private FileService fileService;

private static final String PATH = "C:\\Quiz\\";

    public Question getQuestions(Long questionId) throws Exception {
        Question question =  questionDao.findAll().get(Math.toIntExact(questionId));
        return new Question(question.getQuestion(), question.getAnswers(), question.getPoints(), question.isLastQuestion());
    }

    public void report(){
        fileService.createFile(answers ,PATH);
    }

    public void updateAnswer(Answer answer) throws Exception {
        Question question =  questionDao.findAll().get(Math.toIntExact(answer.getQuestionId()));
        Answer answer1 = new Answer();

        if(Arrays.equals(question.getCorrect(), answer.getSelectedAnswers())){
            answer1.setPoints(question.getPoints());
        }

        answer1.setQuestionId(answer.getQuestionId());
        answer1.setSelectedAnswers(answer.getSelectedAnswers());
        answer1.setCorrectAnswers(question.getCorrect());

        answers.add(answer1);

        System.out.println("Uzyskane punkty: " + answer1.getPoints());
        System.out.println("Twoje odpowiedzi" + Arrays.toString(answer1.getSelectedAnswers()));
        System.out.println("Poprawne: " + Arrays.toString(answer1.getCorrectAnswers()));
    }


}
