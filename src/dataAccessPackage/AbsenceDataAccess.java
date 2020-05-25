package dataAccessPackage;
import exceptionPackage.AbsenceAccessException;
import exceptionPackage.AffiliateAccessException;
import modelPackage.Absence;

import java.util.ArrayList;



public interface AbsenceDataAccess {

    public ArrayList<Absence> getAllAbsences() throws AbsenceAccessException;
    public ArrayList<Absence> getAbsencesByAffiliateId(int affiliateId) throws AbsenceAccessException;
    public void insertAbsences(ArrayList<Absence> absences) throws AbsenceAccessException;
    public void deleteAffiliateAbsences(int affiliateId) throws AbsenceAccessException;

}
