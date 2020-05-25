package viewPackage.Affiliate;


import viewPackage.MainWindow;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AffiliateButtonsListPanel extends JPanel {

    private JButton close;
    private MainWindow parent;

    public AffiliateButtonsListPanel(MainWindow parent){

       this.parent = parent;
        close = new JButton("Close");
        close.addActionListener(new CloseListener());
        add(close);
    }
    private class CloseListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
                parent.closeCurrentForm();
        }
    }
}
