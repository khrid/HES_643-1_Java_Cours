package mvcMultipleFrameView;

import intro.View;

import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;

public class TestMvcMultipleFrameView {
    public static void main(String[] args) {

        Document model = new DefaultStyledDocument();

        ViewTextArea viewTextArea = new ViewTextArea(model);
        ViewTextField viewTextField = new ViewTextField(model);
        ViewTextPane viewTextPane = new ViewTextPane(model);
        viewTextArea.setVisible(true);
        viewTextField.setVisible(true);
        viewTextPane.setVisible(true);
    }
}
