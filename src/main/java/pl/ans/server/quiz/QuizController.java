package pl.ans.server.quiz;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path= "/quiz")
public class QuizController {

    @Autowired
    public QuizController(QuizService quizService) {
    }


    @GetMapping("/question/{questionId}")
    public void getQuestions(@PathVariable String questionId) {
        //GET
        }
    }
