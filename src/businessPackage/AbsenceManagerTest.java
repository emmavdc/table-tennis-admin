package businessPackage;

import modelPackage.Absence;
import modelPackage.Affiliate;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.GregorianCalendar;


class AbsenceManagerTest {

    @Test
    void getAbsenteeismRateWeekData() {

        AbsenceManager absenceManager = new AbsenceManager();

        ArrayList<Absence> absences = new ArrayList<Absence>();
        ArrayList<Affiliate> affiliates = new ArrayList<Affiliate>();


        Affiliate affiliate1 =  new Affiliate(1,"a",
                "v", "f", new GregorianCalendar(1999, 1, 13),
                true, 1);

        Affiliate affiliate2 =  new Affiliate(2,"a",
                "v", "f", new GregorianCalendar(1999, 1, 13),
                true, 1);

        Affiliate affiliate3 =  new Affiliate(3,"a",
                "v", "f", new GregorianCalendar(1999, 1, 13),
                true, 1);

        Affiliate affiliate4 =  new Affiliate(4,"a",
                "v", "f", new GregorianCalendar(1999, 1, 13),
                true, 1);

        Affiliate affiliate5 =  new Affiliate(5,"a",
                "v", "f", new GregorianCalendar(1999, 1, 13),
                true, 1);


        affiliates.add(affiliate1);
        affiliates.add(affiliate2);
        affiliates.add(affiliate3);
        affiliates.add(affiliate4);
        affiliates.add(affiliate5);


        Absence a1 = new Absence(1, 1, "lala", 1);
        Absence a2 = new Absence(2, 1, "lala", 2);
        Absence a3 = new Absence(3, 1, "lala", 3);
        Absence a4 = new Absence(4, 1, "lala", 4);
        Absence a5 = new Absence(5, 1, "lala", 5);

        absences.add(a1);
        absences.add(a2);
        absences.add(a3);
        absences.add(a4);
        absences.add(a5);

        double tab[] = absenceManager.getAbsenteeismRateWeekData(absences, affiliates, 22);

        int i = 1;
        for(double test : tab){
            System.out.println(i + " " + test + " %" + "\n");
            i++;
        }
    }

    @Test
    void getAverageAbsenteeismRateData() {

        AbsenceManager absenceManager = new AbsenceManager();
        double[] tab = new double[5];

        tab[0] = 10;
        tab[1] = 20;
        tab[2] = 20;
        tab[3] = 60;
        tab[4] = 40;

        double estimateValue = absenceManager.getAverageAbsenteeismRateData(tab);

        System.out.println("1) valeur souhaitée : 30 (150/5)" + " et valeur obtenue : " + estimateValue);
    }
}