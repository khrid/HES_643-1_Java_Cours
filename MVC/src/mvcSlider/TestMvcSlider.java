package mvcSlider;

import javax.swing.*;

public class TestMvcSlider {
    public static void main(String[] args) {
        // Pour changer le look de la fenêtre et appliquer le style par défaut du système
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }

        // Modèle pour les JSlider
        BoundedRangeModel[] sliderModels = {new DefaultBoundedRangeModel(),
                new DefaultBoundedRangeModel(),
                new DefaultBoundedRangeModel()};

        // Modèle pour les checkboxes (bien prendre ToggleButtonModel sinon pas cliquable)
        ButtonModel[] checkBoxModels = {new JToggleButton.ToggleButtonModel(),
                new JToggleButton.ToggleButtonModel(),
                new JToggleButton.ToggleButtonModel()};

        // Frame 1
        ViewSlider slider1 = new ViewSlider(sliderModels, checkBoxModels);
        // Frame 2
        ViewSlider slider2 = new ViewSlider(sliderModels, checkBoxModels);
        slider1.setVisible(true);
        slider2.setVisible(true);
    }
}
