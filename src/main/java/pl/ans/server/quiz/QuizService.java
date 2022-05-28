package pl.ans.server.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ans.server.dao.QuestionDao;

import java.util.ArrayList;
import java.util.List;


@Service
public class QuizService {
private List<Answer> answers = new ArrayList<>();

@Autowired
private QuestionDao questionDao;

    public Question getQuestions(Long questionId) throws Exception {
        Question question =  questionDao.findAll().get(Math.toIntExact(questionId));
        return new Question(question.getQuestion(), question.getAnswers(), question.getPoints(), question.isLastQuestion());
    }


}
