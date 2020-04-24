package mvcSlider;

import javax.swing.*;
import java.awt.*;

public class ViewSlider extends JFrame {
    public ViewSlider(BoundedRangeModel[] models, ButtonModel[] checkBoxModels) {
        Container pane = getContentPane();
        // Pour stopper l'application au clic sur Close
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Titre de la fenêtre
        setTitle("MVCSlider");

        // Sliders
        JSlider sliderAll = new JSlider(JSlider.VERTICAL);
        JSlider sliderAux1 = new JSlider(JSlider.VERTICAL);
        JSlider sliderAux2 = new JSlider(JSlider.VERTICAL);

        // Application des modèles aux sliders
        sliderAll.setModel(models[0]);
        sliderAux1.setModel(models[1]);
        sliderAux2.setModel(models[2]);

        // Checkboxes
        JCheckBox checkBoxAll = new JCheckBox("Mute all");
        JCheckBox checkBoxAux1 = new JCheckBox("Mute aux 1");
        JCheckBox checkBoxAux2 = new JCheckBox("Mute aux 2");

        // Application des modèles aux checkboxes
        checkBoxAll.setModel(checkBoxModels[0]);
        checkBoxAux1.setModel(checkBoxModels[1]);
        checkBoxAux2.setModel(checkBoxModels[2]);

        // Configuration du layot et ajout
        pane.setLayout(new GridLayout(0, 3));
        pane.add(sliderAll);
        pane.add(sliderAux1);
        pane.add(sliderAux2);
        pane.add(checkBoxAll);
        pane.add(checkBoxAux1);
        pane.add(checkBoxAux2);
        pack();
    }
}
