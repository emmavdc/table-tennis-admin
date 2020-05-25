package viewPackage;

import javax.swing.*;

public class AboutDialog extends JDialog {

    public AboutDialog() {
        JLabel label = new JLabel("<html>" + "<head>\n" +
                "\t<meta charset=\"utf-8\">\n" +
                "\t<style type=\"text/css\">\n" +
                "\t\th1 { text-align: center; font-size: 125%; color: #FFFFFF; background-color: #365AA8}\n" +
                "\t\th2 { text-align:center; font-size: 100%; color: #365AA8; padding-top: 2px;\n" +
                "</head>" +
                "<body>" +
                "\t<h1>Created by Emma Vandecasteele & Vicky Zagorski</h1>" +
                "\t<h2>Contacts : etu40268@henallux.be | etu41165@henallux.be" +
                "</body>");
        add(label);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setModal(true);
        setSize(450, 200);
        setLocationRelativeTo(null); //null=center
        setTitle("About");
    }
}
