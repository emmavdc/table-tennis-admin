package controllerPackage;

import businessPackage.AbsenceManager;
import exceptionPackage.AbsenceAccessException;
import exceptionPackage.AffiliateAccessException;
import modelPackage.Absence;

import java.util.ArrayList;

public class AbsenceController {

    private AbsenceManager absenceManager;

    public AbsenceController(){
        absenceManager = new AbsenceManager();
    }

    public ArrayList<Absence> getAbsencesByAffiliateId(int affiliateId) throws AbsenceAccessException{
        return absenceManager.getAbsencesByAffiliateId(affiliateId);
    }

    public void insertAbsences(ArrayList<Absence> absences, int affiliateID) throws AbsenceAccessException{
        absenceManager.insertAbsences(absences, affiliateID);
    }

    public double [] absenteeismRateWeek() throws AbsenceAccessException, AffiliateAccessException{
        return absenceManager.absenteeismRateWeek();
    }

    public double averageAbsenteeismRate() throws AbsenceAccessException, AffiliateAccessException{
        return absenceManager.averageAbsenteeismRate();
    }

}
