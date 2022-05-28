package pl.ans.server.dao;


import org.springframework.stereotype.Repository;
import pl.ans.server.quiz.Question;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CsvQuestionDao implements QuestionDao{

    /*
        odczytywanie pytań z pliku csv i zwracanie ich w postaci listy obiektu Question

     */
    @Override
    public List<Question> findAll() throws Exception{

        List<Question> results = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("src/main/java/pl/ans/server/dao/questions.csv"));
        String line;
        while((line = br.readLine()) != null){
            String[] fields = line.split(",");

            Long questionId = Long.valueOf(fields[0]);
            String questionContent = fields[1];
            String answer1 = fields[2];
            String answer2 = fields[3];
            String answer3 = fields[4];
            String answer4 = fields[5];
            String correct = fields[6];

            String[] corrects = correct.split("-");
            Integer[] correctAns = new Integer[corrects.length];
            for(int i=0; i < corrects.length; i++){
                correctAns[i] = Integer.parseInt(corrects[i]);
            }

            int points = Integer.parseInt(fields[7]);


            Question question = new Question(questionId, questionContent, new String[]{answer1,answer2, answer3, answer4}, points, correctAns);
            results.add(question);
        }

        for(int i = 0; i < results.size(); i++){
            if(i == results.size()-1) results.get(results.size()-1).setLastQuestion(true);
            else results.get(i).setLastQuestion(false);
        }

        br.close();
        return results;
    }


}
