package pl.ans.server.impl;

import pl.ans.server.dto.FileData;
import pl.ans.server.quiz.Answer;

import java.util.List;

public interface FileService {
    FileData createFile(List<Answer> answers, String path);
    List<FileData> findAll(String path);
}
