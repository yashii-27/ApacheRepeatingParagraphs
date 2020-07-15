import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.HashSet;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class ReadDoc {

    public static void main(String[] args) {
        HashMap<String,Integer> hm=new HashMap<>();
        int s=0;
        XWPFDocument document=new XWPFDocument();

        try {
            FileInputStream fis = new FileInputStream("createparagraph.docx");
            FileOutputStream out = new FileOutputStream(new File("createparagraph1.docx"));
            XWPFDocument doc    = new XWPFDocument(OPCPackage.open(fis));
            java.util.List<XWPFParagraph> paragraphs =  doc.getParagraphs();

            for (XWPFParagraph paragraph: paragraphs){

                if(!hm.containsKey(paragraph.getText())) {
                    hm.put(paragraph.getText(), 1);
                    XWPFParagraph p = document.createParagraph();
                    XWPFRun run = p.createRun();
                    run.setText(paragraph.getText()
                    );

                }
                else {
                    XWPFParagraph p1 = document.createParagraph();
                    XWPFRun run1 = p1.createRun();
                        run1.setColor("FFF000");
                        run1.setText(paragraph.getText());

                    }

                }
                document.write(out);
        }catch(Exception e) {
            System.out.println(e);
        }
    }
}