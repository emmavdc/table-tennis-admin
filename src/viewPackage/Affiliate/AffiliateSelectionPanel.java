package viewPackage.Affiliate;

import controllerPackage.AffiliateController;
import exceptionPackage.AbsenceAccessException;
import exceptionPackage.AffiliateAccessException;
import exceptionPackage.RankingAccessException;
import modelPackage.Affiliate;
import viewPackage.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AffiliateSelectionPanel extends JPanel {

    private AffiliateController controller;
    private MainWindow parent;
    private JButton affiliateButton, closeButton;
    private JComboBox affiliateComboBox;

    public AffiliateSelectionPanel(MainWindow parent) {
        this.parent = parent;

        controller = new AffiliateController();
        affiliateComboBox = new JComboBox();
        affiliateComboBox.setMaximumRowCount(5);
        closeButton = new JButton("Close");
        closeButton.addActionListener(new CloseListener());

    }

    public void setMode(AffiliateFormMode mode) {
       switch (mode){
           case UPDATE:
               removeAll();
               this.add(affiliateComboBox);
               affiliateButton = new JButton("Select");
               affiliateButton.addActionListener(new SelectListener());
               add(affiliateButton);
               add(closeButton);

               break;
           case DELETE:
               removeAll();
               this.add(affiliateComboBox);
               affiliateButton = new JButton("Delete");
               affiliateButton.addActionListener(new DeleteListener());
               add(affiliateButton);
               add(closeButton);
               break;

       }
    }

    public void loadAffiliates(){

        try {
            AffiliateComboBoxModel affiliateComboBoxModel = new AffiliateComboBoxModel(controller.getAllAffiliates().toArray(new Affiliate[0]));
            affiliateComboBox.setModel(affiliateComboBoxModel);
        } catch (AffiliateAccessException e) {
            e.printStackTrace();
        }
    }

    private class SelectListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            try {

                parent.setAffiliate((Affiliate)affiliateComboBox.getSelectedItem());
            } catch (AffiliateAccessException affiliateAccessException) {
                affiliateAccessException.printStackTrace();
            } catch (RankingAccessException rankingAccessException) {
                rankingAccessException.printStackTrace();
            } catch (AbsenceAccessException absenceAccessException) {
                absenceAccessException.printStackTrace();
            }
        }
    }

    private class DeleteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                parent.setAffiliate((Affiliate)affiliateComboBox.getSelectedItem());
            } catch (AffiliateAccessException affiliateAccessException) {
                affiliateAccessException.printStackTrace();
            } catch (RankingAccessException rankingAccessException) {
                rankingAccessException.printStackTrace();
            } catch (AbsenceAccessException absenceAccessException) {
                absenceAccessException.printStackTrace();
            }

        }
    }

    private class CloseListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
                parent.closeCurrentForm();
        }
    }

}
