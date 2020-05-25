package viewPackage;

import exceptionPackage.*;
import modelPackage.Affiliate;
import viewPackage.Affiliate.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    private Container frameContainer;
    private WelcomePanel welcomePanel;
    private AffiliateForm affiliateForm;
    private HeaderPanel headerPanel;
    private AffiliateSelectionPanel affiliateSelectionPanel;
    private AffiliateListPanel affiliateListPanel;
    private AffiliateButtonsListPanel affiliateButtonsListPanel;
    private TrainingGroupSelectionPanel trainingGroupSelectionPanel;
    private TrainingGroupDateSelectionPanel trainingGroupDateSelectionPanel;
    private AvailableWeekPanel availableWeekPanel;
    private AbsenteeismRatePanel absenteeismRatePanel;

    private JMenuBar menuBar;
    private JMenu affiliateMenu, helpMenu, affiliateSearchesMenu;
    private JMenuItem affiliateNew, affiliateUpdate, affiliateDelete,
            affiliateExit, helpAbout, affiliateList, search1, search2, search3, absenteeismRate;
    private AboutDialog aboutDialog;
    private AffiliateFormMode affiliateFormMode;


    public MainWindow() throws EquipmentAccessException, AffiliateAccessException, TrainingAccessException {
        //Configure
        super("Table Tennis Club Administration");
        setSize(1024, 768);
        setLocationRelativeTo(null); //null=center
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close when click the x

        //Screen parts
        headerPanel = new HeaderPanel();
        headerPanel.setBackground(new Color(54,90,168));
        welcomePanel = new WelcomePanel();
        frameContainer = this.getContentPane();
        frameContainer.setLayout(new BorderLayout());
        frameContainer.add(headerPanel, BorderLayout.NORTH);
        frameContainer.add(welcomePanel, BorderLayout.CENTER);

        affiliateForm = new AffiliateForm(this);
        affiliateSelectionPanel = new AffiliateSelectionPanel(this);
        affiliateButtonsListPanel = new AffiliateButtonsListPanel(this);
        trainingGroupSelectionPanel = new TrainingGroupSelectionPanel(this);
        trainingGroupDateSelectionPanel = new TrainingGroupDateSelectionPanel(this);
        availableWeekPanel = new AvailableWeekPanel(this);
        absenteeismRatePanel = new AbsenteeismRatePanel(this);

        //Menu
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        //Menu:viewPackage.Affiliate
        affiliateMenu = new JMenu("Affiliate");
        affiliateMenu.setMnemonic('A');
        menuBar.add(affiliateMenu);
        affiliateNew = new JMenuItem("New");
        affiliateNew.setMnemonic('N');
        affiliateNew.addActionListener(new AffiliateActionListener(AffiliateFormMode.NEW));
        affiliateMenu.add(affiliateNew);
        affiliateUpdate = new JMenuItem("Update");
        affiliateUpdate.setMnemonic('U');
        affiliateUpdate.addActionListener(new AffiliateActionListener(AffiliateFormMode.UPDATE));
        affiliateMenu.add(affiliateUpdate);
        affiliateDelete = new JMenuItem("Delete");
        affiliateDelete.setMnemonic('D');
        affiliateDelete.addActionListener(new AffiliateActionListener(AffiliateFormMode.DELETE));
        affiliateMenu.add(affiliateDelete);
        affiliateMenu.addSeparator();
        affiliateList = new JMenuItem("List");
        affiliateList.setMnemonic('L');
        affiliateList.addActionListener(new ListListener());
        affiliateMenu.add(affiliateList);
        affiliateMenu.addSeparator();
        affiliateSearchesMenu = new JMenu("Searches");
        affiliateSearchesMenu.setMnemonic('S');
        affiliateMenu.add(affiliateSearchesMenu);
        affiliateMenu.addSeparator();


        search1 = new JMenuItem("Affiliates according a training group");
        affiliateSearchesMenu.add(search1);
        search1.addActionListener(new Search1Listener());
        search2 = new JMenuItem("Available affiliates of a ranking for a week competition");
        affiliateSearchesMenu.add(search2);
        search2.addActionListener(new Search2Listener());
        search3 = new JMenuItem("Affiliates of an age group according a training group");
        affiliateSearchesMenu.add(search3);
        search3.addActionListener(new Search3Listener());


        absenteeismRate = new JMenuItem("Absenteeism rate");
        absenteeismRate.setMnemonic('A');
        absenteeismRate.addActionListener(new AbsenteeismListener());
        affiliateMenu.add(absenteeismRate);
        affiliateMenu.addSeparator();


        affiliateExit = new JMenuItem("Exit");
        affiliateExit.setMnemonic('X');
        affiliateExit.addActionListener(new ExitListener());
        affiliateMenu.add(affiliateExit);


        //Menu:Help
        helpMenu = new JMenu("Help");
        helpMenu.setMnemonic('H');
        menuBar.add(helpMenu);
        helpAbout = new JMenuItem("About");
        helpAbout.setMnemonic('A');
        helpAbout.addActionListener(new AboutListener());
        helpMenu.add(helpAbout);
    }

    public static void main(String[] args) {
        try {
            MainWindow mainWindow = new MainWindow();
            mainWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
            mainWindow.setVisible(true);
        }
        catch (EquipmentAccessException e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
        } catch (AffiliateAccessException affiliateAccessException) {
            affiliateAccessException.printStackTrace();
        }  catch (TrainingAccessException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
        }


    }

    public void closeCurrentForm() {

        frameContainer.removeAll();
        frameContainer.validate();
        frameContainer.setLayout(new BorderLayout());
        frameContainer.add(headerPanel, BorderLayout.NORTH);
        frameContainer.add(welcomePanel, BorderLayout.CENTER);
        frameContainer.revalidate();
        frameContainer.repaint();

    }


    public void setAffiliate(Affiliate affiliate) throws AffiliateAccessException, RankingAccessException, AbsenceAccessException {
        affiliateForm.reset();
        affiliateForm.setAffiliate(affiliate);
        affiliateForm.setMode(affiliateFormMode);
        frameContainer.removeAll();
        frameContainer.validate();
        frameContainer.setLayout(new BorderLayout());
        frameContainer.add(headerPanel, BorderLayout.NORTH);
        frameContainer.add(affiliateForm, BorderLayout.CENTER);
        frameContainer.revalidate();
        frameContainer.repaint();
    }



    private class ExitListener implements ActionListener {
        public void actionPerformed (ActionEvent event)
        {
            System.exit(0);
        }
    }

    private class AffiliateActionListener implements ActionListener {

        private AffiliateFormMode mode;
        public AffiliateActionListener(AffiliateFormMode mode) {
            this.mode = mode;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            affiliateFormMode = mode;
            switch (mode) {
                case NEW:
                    affiliateForm.reset();
                    affiliateForm.setMode(mode);
                    frameContainer.removeAll();
                    frameContainer.validate();
                    frameContainer.setLayout(new BorderLayout());
                    frameContainer.add(headerPanel, BorderLayout.NORTH);
                    frameContainer.add(affiliateForm, BorderLayout.CENTER);
                    frameContainer.revalidate();
                    frameContainer.repaint();
                    break;
                case UPDATE:
                    affiliateSelectionPanel.loadAffiliates();
                    affiliateSelectionPanel.setMode(mode);
                    frameContainer.removeAll();
                    frameContainer.validate();
                    frameContainer.setLayout(new BorderLayout());
                    frameContainer.add(headerPanel, BorderLayout.NORTH);
                    frameContainer.add(affiliateSelectionPanel, BorderLayout.CENTER);
                    frameContainer.revalidate();
                    frameContainer.repaint();
                    break;
                case DELETE:
                    affiliateSelectionPanel.loadAffiliates();
                    affiliateSelectionPanel.setMode(mode);
                    frameContainer.removeAll();
                    frameContainer.validate();
                    frameContainer.setLayout(new BorderLayout());
                    frameContainer.add(headerPanel, BorderLayout.NORTH);
                    frameContainer.add(affiliateSelectionPanel, BorderLayout.CENTER);
                    frameContainer.revalidate();
                    frameContainer.repaint();
                    break;
            }
        }
    }

    private class AboutListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            aboutDialog = new AboutDialog();
            aboutDialog.setVisible(true);
        }
    }

    private class ListListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            affiliateListPanel = new AffiliateListPanel();
            frameContainer.removeAll();
            frameContainer.validate();
            frameContainer.setLayout(new BorderLayout());
            frameContainer.add(headerPanel, BorderLayout.NORTH);
            frameContainer.add(affiliateListPanel,BorderLayout.CENTER);
            frameContainer.add(affiliateButtonsListPanel, BorderLayout.SOUTH);

            frameContainer.revalidate();
            frameContainer.repaint();
        }
    }

    private class Search1Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            frameContainer.removeAll();
            frameContainer.validate();
            frameContainer.setLayout(new BorderLayout());
            frameContainer.add(headerPanel, BorderLayout.NORTH);
            trainingGroupSelectionPanel.reset();
            frameContainer.add(trainingGroupSelectionPanel);
            frameContainer.revalidate();
            frameContainer.repaint();
        }
    }

    private class Search2Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            frameContainer.removeAll();
            frameContainer.validate();
            frameContainer.setLayout(new BorderLayout());
            frameContainer.add(headerPanel, BorderLayout.NORTH);
            availableWeekPanel.reset();
            frameContainer.add(availableWeekPanel, BorderLayout.CENTER);
            frameContainer.revalidate();
            frameContainer.repaint();
        }
    }

    private class Search3Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            frameContainer.removeAll();
            frameContainer.validate();
            frameContainer.setLayout(new BorderLayout());
            frameContainer.add(headerPanel, BorderLayout.NORTH);
            trainingGroupDateSelectionPanel.reset();
            frameContainer.add(trainingGroupDateSelectionPanel, BorderLayout.CENTER);
            frameContainer.revalidate();
            frameContainer.repaint();
        }
    }

    private class AbsenteeismListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            frameContainer.removeAll();
            frameContainer.validate();
            frameContainer.setLayout(new BorderLayout());
            frameContainer.add(headerPanel, BorderLayout.NORTH);
            absenteeismRatePanel.reset();
            frameContainer.add(absenteeismRatePanel, BorderLayout.CENTER);
            frameContainer.revalidate();
            frameContainer.repaint();
        }
    }
}
