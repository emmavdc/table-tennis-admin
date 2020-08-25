package controllerPackage;

import businessPackage.ApplicationManager;
import exceptionPackage.CloseApplicationException;

public class ApplicationController {

    private ApplicationManager applicationManager;

    public ApplicationController(){
        applicationManager = new ApplicationManager();
    }

    public void closingApplication() throws CloseApplicationException {
        applicationManager.closingApplication();
    }
}
