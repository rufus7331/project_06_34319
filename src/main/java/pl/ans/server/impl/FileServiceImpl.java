package pl.ans.server.impl;

import pl.ans.server.model.DocumentComponent;
import pl.ans.server.model.Resource;
import pl.ans.server.quiz.Answer;
import pl.ans.server.dto.FileData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.ZonedDateTime;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileServiceImpl.class);

    @Autowired
    private Resource resource;

    @Autowired
    private DocumentComponent documentComponent;

    @Override
    public FileData createFile(List<Answer> answers, String path) {
        String fileName = "raport_końcowy" + ".pdf";
        String fileDestination = path + fileName;

        try {

            Files.createDirectories(Paths.get(path));
            documentComponent.createDocument(answers, fileDestination);

            FileData fileData = new FileData(fileName, getFileSize(fileDestination), ZonedDateTime.now());
            resource.saveOne(fileData, path);

            return fileData;

        } catch (IOException e) {
            LOGGER.error("i can't save data");
        }

        return null;
    }

    private Long getFileSize(String fileDestination) throws IOException {
        Path filePath = Paths.get(fileDestination);
        BasicFileAttributes fileAttributes = Files.readAttributes(filePath, BasicFileAttributes.class);

        return fileAttributes.size();
    }

    @Override
    public List<FileData> findAll(String path) {
        return resource.findAll(path);
    }
}

