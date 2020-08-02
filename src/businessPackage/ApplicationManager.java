package businessPackage;

import dataAccessPackage.SingletonConnection;
import exceptionPackage.CloseApplicationException;

public class ApplicationManager {

    public ApplicationManager(){}

    public void closingApplication() throws CloseApplicationException {
        SingletonConnection.closeConnection();
    }
}
