package viewPackage;

import controllerPackage.TrainingController;
import exceptionPackage.TrainingAccessException;
import modelPackage.TrainingGroup;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HeaderPanel extends JPanel {

    private JLabel label;
    private ArrayList<TrainingGroup> trainings;
    private CarouselThread carousel;
    private TrainingController trainingController;
    public HeaderPanel() {
        try{


            trainingController = new TrainingController();
            trainings = trainingController.getAllTrainingGroups();
            label = new JLabel("Training...");
            label.setForeground(Color.WHITE);
            add(label);
            carousel = new CarouselThread();
            carousel.start();


        }
        catch(TrainingAccessException e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private class CarouselThread extends Thread {

        public void run(){
            int i = 0;
            while(true) {
                try {
                    Thread.sleep(5000);
                    label.setText(String.valueOf(trainings.get(i++)));
                    if (i == trainings.size()) i = 0;
                }
                catch (Exception e) {
                }
            }
        }
    }
}
