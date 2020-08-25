package utils;

import controllerPackage.ApplicationController;
import exceptionPackage.CloseApplicationException;
import viewPackage.ExceptionDialog;

public class ExceptionHandler {

    public static void exitAfterUnhandledException(Exception e) {
        // information for programmer
        e.printStackTrace();

        // information from dialog box for user
        ExceptionDialog exceptionDialog = new ExceptionDialog();
        exceptionDialog.setVisible(true);

        ApplicationController applicationController = new ApplicationController();
        try {
            applicationController.closingApplication();
        } catch (CloseApplicationException exception) {
            exception.printStackTrace();
        }
        System.exit(0);
    }


}
