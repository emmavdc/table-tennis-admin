package viewPackage;

import controllerPackage.ApplicationController;
import exceptionPackage.CloseApplicationException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ExceptionDialog extends JDialog {


    public ExceptionDialog(){


        setLayout(new BorderLayout());

        JLabel exceptionLabel = new JLabel(
                "<html>\n" +
                        "    <head>\n" +
                        "        <meta charset=\"UTF-8\"/>\n" +
                        "        <style>\n" +
                        "            h1 {text-align: center; font-size: 200%; color : white; background-color: rgb(209, 42, 42)}\n" +
                        "            p {text-align: center; font-size: 150%; font-weight: bold;}\n" +
                        "            .contact {color :rgb(209, 42, 42)}\n" +
                        "        </style>\n" +
                        "    </head>\n" +
                        "    <body>\n" +
                        "        <h1>Error !</h1>\n" +
                        "        <p>A problem has occured, app is going to close. Please restart after app closing !</p>\n" +
                        "        </br>\n" +
                        "        <p>if the problem persists, you should contact the technician at this address : </p>\n" +
                        "        <p class = \"contact\">etu40268@henallux.be</p>\n" +
                        "    </body>\n" +
                        "</html>");


        add(exceptionLabel, BorderLayout.CENTER);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setModal(true);
        setSize(900, 400);
        setLocationRelativeTo(null); //null=center
        setTitle("Error");
    }

}
