package pl.ans.server.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import pl.ans.server.quiz.Answer;
import pl.ans.server.quiz.BadRequestException;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;

@Component
public class DocumentComponentImpl implements DocumentComponent {
    private int suma = 0;
    private static final int progPunktowy = 10;

    private static final Logger LOGGER = LoggerFactory.getLogger(DocumentComponentImpl.class);

    public DocumentComponentImpl() {}

    @Override
    public void createDocument(List<Answer> answers, String fileDestination) {
        try {

            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(fileDestination));
            document.open();
            PdfPTable table = new PdfPTable(4);
            table.setWidths(new int[]{1, 1, 1, 1});
            table.addCell(createCell("ID pytania", 2, Element.ALIGN_LEFT));
            table.addCell(createCell("Twoje odpowiedzi", 2, Element.ALIGN_LEFT));
            table.addCell(createCell("Odpowiedzi poprawne", 2, Element.ALIGN_LEFT));
            table.addCell(createCell("Uzyskane punkty", 2, Element.ALIGN_LEFT));

            for(Answer a: answers) {
                suma+=a.getPoints();

                table.addCell(createCell(a.getQuestionId().toString(), 1, Element.ALIGN_LEFT));
                table.addCell(createCell(Arrays.toString(a.getSelectedAnswers()), 1, Element.ALIGN_LEFT));
                table.addCell(createCell(Arrays.toString(a.getCorrectAnswers()), 1, Element.ALIGN_LEFT));
                table.addCell(createCell(String.valueOf(a.getPoints()), 1, Element.ALIGN_LEFT));
            }

            String wynikTestu;
            if(suma < progPunktowy){
                wynikTestu = "Negatywny";

            }else wynikTestu = "Pozytywny";


            table.addCell(createCell("Wynik: ", 2, Element.ALIGN_LEFT));
            table.addCell(createCell(wynikTestu, 2, Element.ALIGN_LEFT));
            table.addCell(createCell("Uzyskane punkty: ", 2, Element.ALIGN_LEFT));
            table.addCell(createCell(String.valueOf(suma), 2, Element.ALIGN_LEFT));

            document.add(table);
            setBackgroundAsGradient(document, writer);
            document.close();
            if(wynikTestu.equals("Negatywny"))  throw new BadRequestException();

        } catch (DocumentException | FileNotFoundException e) {
            LOGGER.error("i can't create document or file not exists");
        }
    }

    private PdfPCell createCell(String content, float borderWidth, int alignment) {
        final String FONT = "static/arial.ttf";

        Font font = FontFactory.getFont(FONT, BaseFont.IDENTITY_H, true);

        PdfPCell cell = new PdfPCell(new Phrase(content, font));
        cell.setBorderWidth(borderWidth);
        cell.setHorizontalAlignment(alignment);
        cell.setPaddingTop(3);
        cell.setPaddingBottom(6);
        cell.setPaddingLeft(3);
        cell.setPaddingRight(3);
        return cell;
    }

    private void setBackgroundAsGradient(Document document, PdfWriter writer) {
        Rectangle pageSize = document.getPageSize();
        PdfShading axial = PdfShading.simpleAxial(writer,
                pageSize.getLeft(pageSize.getWidth()/10), pageSize.getBottom(),
                pageSize.getRight(pageSize.getWidth()/10), pageSize.getBottom(),
                new BaseColor(124,185,232),
                new BaseColor(240,248,255), true, true);
        PdfContentByte canvas = writer.getDirectContentUnder();
        canvas.paintShading(axial);
    }
}