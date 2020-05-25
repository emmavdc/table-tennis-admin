package viewPackage.Affiliate;

import controllerPackage.AffiliateController;
import exceptionPackage.*;
import modelPackage.Affiliate;
import modelPackage.ValidationResult;
import viewPackage.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AffiliateForm extends JPanel {

    private AffiliatePanel affiliatePanel;
    private AffiliateButtonsPanel affiliateButtonsPanel;
    private AffiliateController controller;
    private MainWindow parent;
    private AffiliateFormMode mode;
    private AffiliateRankingDialog rankingDialog;
    private AffiliateAbsenceDialog absenceDialog;
    private Affiliate currentAffiliate;

    public AffiliateForm(MainWindow parent) throws EquipmentAccessException, TrainingAccessException {
        this.parent = parent;
        controller = new AffiliateController();
        setLayout(new BorderLayout());
        affiliatePanel = new AffiliatePanel();
        add(affiliatePanel, BorderLayout.CENTER);
        affiliateButtonsPanel = new AffiliateButtonsPanel(this);
        add(affiliateButtonsPanel, BorderLayout.SOUTH);
    }

    public Affiliate getCurrentAffiliate() {
        return currentAffiliate;
    }

    public void setMode(AffiliateFormMode mode) {

        this.mode = mode;
        affiliatePanel.setMode(mode);
        affiliateButtonsPanel.setMode(mode);
        revalidate();
        repaint();

    }

    public void reset() {
        affiliatePanel.reset();
    }

    public void setAffiliate(Affiliate affiliate) throws AffiliateAccessException, RankingAccessException, AbsenceAccessException {

        currentAffiliate = controller.getAffiliate(affiliate.getAffiliateID());
        affiliatePanel.setAffiliate(currentAffiliate);

    }

    public void save() {

        try {

            String messageFeedback = "";
            ArrayList<ValidationResult> validationResults = null;

            Affiliate affiliate = affiliatePanel.getAffiliate();
            if (affiliate != null) {

                switch (mode) {
                    case NEW:
                        validationResults = controller.insertAffiliate(affiliate);
                        if (validationResults.size() == 0) {
                            setAffiliate(affiliate);
                        }
                        messageFeedback = "saved!";
                        break;
                    case UPDATE:
                        validationResults = controller.updateAffiliate(affiliate);
                        messageFeedback = "updated!";
                        break;
                }
                affiliatePanel.resetValidation();
                if (validationResults.size() == 0) {
                    JOptionPane.showMessageDialog(null, "The Affiliate is " + messageFeedback, "Affiliate management", JOptionPane.INFORMATION_MESSAGE);
                    setMode(AffiliateFormMode.UPDATE);
                } else {
                    affiliatePanel.setValidationResult(validationResults);
                }
            }
        } catch (AffiliateAccessException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }  catch (AbsenceAccessException e) {
            e.printStackTrace();
        } catch (RankingAccessException e) {
            e.printStackTrace();
        }

    }

    public void delete() {

        try {
            controller.deleteAffiliate(affiliatePanel.getAffiliate().getAffiliateID());
            JOptionPane.showMessageDialog(null, "The Affiliate is " + "deleted!", "Affiliate management", JOptionPane.INFORMATION_MESSAGE);
            parent.closeCurrentForm();
        } catch (AffiliateAccessException affiliateAccessException) {
            affiliateAccessException.printStackTrace();
        }
    }

    public void cancel() {
        parent.closeCurrentForm();
    }

    public void showRankingDialog(String gender) throws RankingAccessException {

        rankingDialog = new AffiliateRankingDialog(this, currentAffiliate, gender);
        rankingDialog.setVisible(true);

    }

    public void closeRankingDialog() {
        rankingDialog.setVisible(false);
        affiliatePanel.setAffiliate(currentAffiliate);
    }

    public void showAbsenceDialog() {
        absenceDialog = new AffiliateAbsenceDialog(this,currentAffiliate);
        absenceDialog.setVisible(true);
    }

    public void closeAbsenceDialog(){
        absenceDialog.setVisible(false);
    }


}
