package viewPackage.Affiliate;

import controllerPackage.RankingController;
import exceptionPackage.RankingAccessException;
import modelPackage.*;
import utils.Formating;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Optional;

public class AffiliateRankingDialog extends JDialog {

    private JLabel title;
    private Formating formatingHelper;
    private RankingController rankingController;
    private ArrayList<Ranking> rankings;
    private JTextField seasonTextField;
    private JComboBox rankingJComboBox;
    private JButton saveButton, deleteButton, closeButton;
    private JScrollPane rankingScrollPane;
    private Affiliate affiliate;
    private JTable rankingTable;
    private String gender;
    private JPanel topPanel, bottomPanel;
    private RankingsDialogModel rankingsDialogModel;
    private JLabel seasonErrorMessage;
    private AffiliateForm parent;


    public AffiliateRankingDialog(AffiliateForm parent, Affiliate affiliate, String gender) throws RankingAccessException {

        this.affiliate = affiliate;
        this.gender = gender;
        this.parent = parent;

        setTitle("Ranking");
        setModal(true);
        setUndecorated(true);
        getRootPane().setBorder(BorderFactory.createLineBorder(new Color(54,90,168),3));
        setSize(800, 600);
        setLocationRelativeTo(null); //null=center
        setLayout(new BorderLayout());

        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        add(topPanel, BorderLayout.NORTH);

        rankingsDialogModel =
                new RankingsDialogModel(mapAffiliateRankingsToRankingSeason(affiliate.getAffiliateRankings()));
        rankingTable = new JTable(rankingsDialogModel);
        rankingScrollPane = new JScrollPane(rankingTable);
        add(rankingScrollPane, BorderLayout.CENTER);
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        add(bottomPanel, BorderLayout.SOUTH);

        formatingHelper = new Formating();

        rankingController = new RankingController();
        rankings = rankingController.getAllRankings();

        if (this.gender.equalsIgnoreCase("M")) {
            title = new JLabel("Man Ranking");
            rankingJComboBox = new JComboBox(rankings.toArray());
        } else {
            title = new JLabel("Woman Ranking");
            rankingJComboBox = new JComboBox(rankings.stream().filter(r->!r.getName().startsWith("E")).toArray());
        }

        formatingHelper.formatTitleLabel(title);
        topPanel.add(title);

        bottomPanel.add(new JLabel("Season :"));
        seasonTextField = new JTextField(4);
        bottomPanel.add(seasonTextField);
        seasonErrorMessage = new JLabel("Invalid value");
        seasonErrorMessage.setVisible(false);
        seasonErrorMessage.setForeground(Color.RED);
        bottomPanel.add(seasonErrorMessage);
        bottomPanel.add(new JLabel("Ranking :"));
        bottomPanel.add(rankingJComboBox);
        saveButton = new JButton("Save");
        saveButton.addActionListener(new SaveListener());
        bottomPanel.add(saveButton);
        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new DeleteListener());
        bottomPanel.add(deleteButton);
        closeButton = new JButton("Close");
        closeButton.addActionListener(new CloseListener());
        bottomPanel.add(closeButton);

    }


    private class SaveListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (!validateForm()) return;

            int season = Integer.parseInt(seasonTextField.getText());

            int rankingId = ((Ranking) rankingJComboBox.getSelectedItem()).getRankingID();

            Optional<AffiliateRanking> affiliateRanking =
                    affiliate.getAffiliateRankings()
                            .stream()
                            .filter(r -> r.getSeason().intValue() == season && r.getGender().equalsIgnoreCase(gender))
                            .findFirst();


            if (!affiliateRanking.isPresent()) {

                try {
                    AffiliateRanking insertAffiliateRanking =
                            new AffiliateRanking(null, null, gender, season, affiliate.getAffiliateID(), rankingId);

                    rankingController.insertAffiliateRanking(insertAffiliateRanking);
                    refreshAffiliateData();

                } catch (RankingAccessException rankingAccessException) {
                    rankingAccessException.printStackTrace();
                }

            } else {

                try {
                    AffiliateRanking updateAffiliateRanking =
                            new AffiliateRanking(affiliateRanking.get().getAffiliateRankingID(),
                                    null, null, null, null, rankingId);

                    rankingController.updateAffiliateRanking(updateAffiliateRanking);
                    refreshAffiliateData();
                } catch (RankingAccessException rankingAccessException) {
                    rankingAccessException.printStackTrace();
                }

            }

        }
    }

    private class DeleteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (!validateForm()) return;

            int season = Integer.parseInt(seasonTextField.getText());

            Optional<AffiliateRanking> affiliateRanking =
                    affiliate.getAffiliateRankings()
                            .stream()
                            .filter(r->r.getSeason().intValue() == season).findFirst();
            
            if (affiliateRanking.isPresent()) {
                int affiliateRankingId = affiliateRanking.get().getAffiliateRankingID();
                try {
                    rankingController.deleteAffiliateRanking(affiliateRankingId);
                    refreshAffiliateData();
                } catch (RankingAccessException rankingAccessException) {
                    rankingAccessException.printStackTrace();
                }
            }
        }
    }

    private class CloseListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            parent.closeRankingDialog();
        }
    }

    private ArrayList<RankingSeason> mapAffiliateRankingsToRankingSeason(ArrayList<AffiliateRanking> affiliateRankings) {

        ArrayList<RankingSeason> rankingSeasons = new ArrayList<RankingSeason>();
        for (AffiliateRanking affiliateRanking: affiliateRankings) {
            if (affiliateRanking.getGender().equalsIgnoreCase(gender)) {
            rankingSeasons.add(new RankingSeason (affiliateRanking.getSeason(), affiliateRanking.getName()));
            }
        }
        return rankingSeasons;

    }

    private boolean validateForm() {
        boolean isValid = true;

        seasonErrorMessage.setVisible(false);

        int season;
        try {
            season = Integer.parseInt(seasonTextField.getText());
        } catch (NumberFormatException numberFormatException) {
            seasonErrorMessage.setVisible(true);
            isValid = false;
        }

        return isValid;
    }

    private void refreshAffiliateData() throws RankingAccessException {
        affiliate. setAffiliateRankings(rankingController.getRankingsByAffiliateId(affiliate.getAffiliateID()));
        rankingsDialogModel.setContents(mapAffiliateRankingsToRankingSeason(affiliate.getAffiliateRankings()));
        rankingsDialogModel.fireTableDataChanged();
    }

}




