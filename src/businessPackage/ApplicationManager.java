package businessPackage;

import dataAccessPackage.SingletonConnection;
import exceptionPackage.CloseApplicationException;

public class ApplicationManager {
    private  SingletonConnection uniqueConnection;

    public ApplicationManager(){
        uniqueConnection = new SingletonConnection();
    }

    public void closingApplication() throws CloseApplicationException {
        uniqueConnection.closeConnection();
    }
}
