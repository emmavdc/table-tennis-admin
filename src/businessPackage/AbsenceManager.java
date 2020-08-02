package businessPackage;

import dataAccessPackage.AbsenceDBAccess;
import dataAccessPackage.AbsenceDataAccess;
import dataAccessPackage.AffiliateDBAccess;
import dataAccessPackage.AffiliateDataAccess;
import exceptionPackage.AbsenceAccessException;
import exceptionPackage.AffiliateAccessException;
import modelPackage.Absence;
import modelPackage.Affiliate;

import java.util.ArrayList;

public class AbsenceManager {

    private AbsenceDataAccess absenceDao;
    private AffiliateDataAccess affiliateDao;


    public AbsenceManager(){
        absenceDao = new AbsenceDBAccess();
        affiliateDao = new AffiliateDBAccess();
    }

    public ArrayList<Absence> getAbsencesByAffiliateId(int affiliateId) throws AbsenceAccessException{
        return absenceDao.getAbsencesByAffiliateId(affiliateId);
    }

    public void insertAbsences(ArrayList<Absence> absences, int affiliateID) throws AbsenceAccessException{
        absenceDao.deleteAffiliateAbsences(affiliateID);
        absenceDao.insertAbsences(absences);
    }

    public double [] absenteeismRateWeek() throws AbsenceAccessException, AffiliateAccessException {

        return getAbsenteeismRateWeekData(absenceDao.getAllAbsences(),affiliateDao.getAllAffiliates(),22);

    }

    public double averageAbsenteeismRate() throws AbsenceAccessException, AffiliateAccessException {

        return getAverageAbsenteeismRateData(getAbsenteeismRateWeekData(absenceDao.getAllAbsences(),affiliateDao.getAllAffiliates(),22));
    }



    @VisibleForTesting
    double [] getAbsenteeismRateWeekData(ArrayList<Absence> absences, ArrayList<Affiliate> affiliates, int numberOfWeeks)  {

        int [] absencesPerWeek = new int[numberOfWeeks];
        int numberOfAffiliates =  affiliates.size();

        int iWeek = 0;
        while(iWeek < numberOfWeeks){
            absencesPerWeek[iWeek] = 0;
            for (Absence absence : absences){
                if(absence.getWeekNumber() == iWeek+1) absencesPerWeek[iWeek]++;
            }
            iWeek++;
        }

        // calcul the average
        double averageOfWeeks[] =  new double[numberOfWeeks];

        int iAverage = 0;
        while(iAverage < numberOfWeeks){
            averageOfWeeks[iAverage] =  (100*absencesPerWeek[iAverage])/numberOfAffiliates;
            iAverage++;
        }

        return averageOfWeeks;
    }

    @VisibleForTesting
    double getAverageAbsenteeismRateData(double averageOfWeeks[]){
        double averageAbsenteeismRate = 0;
        int numberOfWeeks = averageOfWeeks.length;

        for(double weekData : averageOfWeeks){
            averageAbsenteeismRate += weekData;
        }

        return averageAbsenteeismRate/numberOfWeeks;
    }







}
