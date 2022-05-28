package pl.ans.server.quiz;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;


@RestController
@RequestMapping(path= "/quiz")
public class QuizController {

    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }


    @GetMapping("/question/{questionId}")
    public Question getQuestions(@PathVariable("questionId") Long questionId) throws Exception {
        try {
            return quizService.getQuestions(questionId);
        } catch (IndexOutOfBoundsException | FileNotFoundException e) {
            throw new ResourceNotFoundException();
        }
    }
}
