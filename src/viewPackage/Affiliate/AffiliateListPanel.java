package viewPackage.Affiliate;

import controllerPackage.AffiliateController;
import exceptionPackage.AffiliateAccessException;
import modelPackage.AllAffiliatesModel;
import utils.ExceptionHandler;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;

public class AffiliateListPanel extends JPanel {


    private AffiliateController affiliateController;
    private AllAffiliatesModel model;
    private JTable table;
    private JScrollPane scrollPane;



    public AffiliateListPanel(){

        affiliateController = new AffiliateController();
        this.setLayout(new BorderLayout());

        try{
            model = new AllAffiliatesModel(affiliateController.getAllAffiliates());
            table = new JTable(model);
            TableColumn LastNameColumn = table.getColumnModel( ).getColumn(2);
            LastNameColumn.setPreferredWidth(120);
            TableColumn PhoneColumn = table.getColumnModel( ).getColumn(5);
            PhoneColumn.setPreferredWidth(120);
            TableColumn EmailColumn = table.getColumnModel( ).getColumn(6);
            EmailColumn.setPreferredWidth(210);
            TableColumn PlayCompetitionColumn = table.getColumnModel( ).getColumn(7);
            PlayCompetitionColumn.setPreferredWidth(100);
            scrollPane = new JScrollPane(table);
            add(scrollPane);

        }
        catch (AffiliateAccessException e){
            ExceptionHandler.exitAfterUnhandledException(e);
        }

    }
}
