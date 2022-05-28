package pl.ans.server.model;

import pl.ans.server.quiz.Answer;
import java.util.List;

public interface DocumentComponent {
    void createDocument(List<Answer> answers, String fileDestination);
}
