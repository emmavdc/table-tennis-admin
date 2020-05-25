package viewPackage.Affiliate;

import exceptionPackage.RankingAccessException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AffiliateButtonsPanel extends JPanel {

    private JButton save,  close, manRanking, womanRanking, absence, delete;
    private AffiliateForm parent;

    public AffiliateButtonsPanel(AffiliateForm parent) {
        this.parent = parent;
        setLayout(new FlowLayout());

    }

    public void setMode(AffiliateFormMode mode) {
        switch (mode) {
            case NEW:
                removeAll();
                save = new JButton("Save");
                save.addActionListener(new SaveListener());
                add(save);
                close = new JButton("Close");
                close.addActionListener(new CloseListener());
                add(close);
                break;
            case UPDATE:
                removeAll();
                save = new JButton("Save");
                save.addActionListener(new SaveListener());
                add(save);
                manRanking = new JButton("Man Ranking");
                manRanking.addActionListener(new RankingListener());
                add(manRanking);

                womanRanking = new JButton("Woman Ranking");
                womanRanking.addActionListener(new RankingListener());
                add(womanRanking);
                if (parent.getCurrentAffiliate().getGender().equalsIgnoreCase("m")) {
                    womanRanking.setVisible(false);
                }
                
                absence = new JButton("Absence");
                absence.addActionListener(new AbsenceListener());
                add(absence);
                close = new JButton("Close");
                close.addActionListener(new CloseListener());
                add(close);
                break;
            case DELETE:
                removeAll();
                delete = new JButton("Confirm deletion");
                delete.addActionListener(new DeleteListener());
                add(delete);
                close = new JButton("Close");
                close.addActionListener(new CloseListener());
                add(close);


        }
    }

    private class SaveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            parent.save();
        }
    }

    private class CloseListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            parent.cancel();
        }
    }

    private class RankingListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            String gender;

            if (e.getSource() == manRanking) {
                gender = "M";
            } else {
                gender = "W";
            }

            try {
                parent.showRankingDialog(gender);
            } catch (RankingAccessException rankingAccessException) {
                rankingAccessException.printStackTrace();
            }
        }
    }

    private class AbsenceListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            parent.showAbsenceDialog();
        }
    }

    private class DeleteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            parent.delete();
        }
    }


}
