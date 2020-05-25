package dataAccessPackage;

import exceptionPackage.AbsenceAccessException;
import exceptionPackage.AffiliateAccessException;
import exceptionPackage.RankingAccessException;
import modelPackage.Affiliate;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Rollback;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;
class AffiliateDBAccessTest {

    @BeforeAll
    public static void DisableAutoCommit() {
        try {
            Connection con = null;
            con = SingletonConnection.getInstance();
            con.setAutoCommit(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Test
    void getAllAffiliates() throws AffiliateAccessException {

        AffiliateDBAccess affiliateDao = new AffiliateDBAccess();
        ArrayList<Affiliate> allAffiliates;
        allAffiliates = affiliateDao.getAllAffiliates();
        assertTrue(allAffiliates != null);
        assertTrue(allAffiliates.size() > 0);

        Affiliate affiliate = allAffiliates.stream().filter((a)-> a.getAffiliateID() == 141736).findFirst().orElse(null);

        assertNotNull(affiliate);
        assertEquals(affiliate.getFirstName(),"Emma");
        assertEquals(affiliate.getLastName(),"Vandecasteele");
        assertEquals(affiliate.getGender(),"F");
        assertEquals(affiliate.getBirthDate().get(Calendar.YEAR), 2000);
        assertEquals(affiliate.getBirthDate().get(Calendar.MONTH), 10);
        assertEquals(affiliate.getBirthDate().get(Calendar.DAY_OF_MONTH), 19);
        assertEquals(affiliate.getPhone(),"32495636059");
        assertEquals(affiliate.getEmail(),"emma.vandecasteele@domain.be");
        assertEquals(affiliate.getEquipment(),2);
        assertEquals(affiliate.getPlayCompetition(),true);

    }

    @Test
    void getAffiliate() throws AffiliateAccessException, RankingAccessException, AbsenceAccessException {
        AffiliateDBAccess affiliateDao = new AffiliateDBAccess();
            Affiliate affiliate = affiliateDao.getAffiliate(141735);
            System.out.println(affiliate.getAffiliateID() + " : " + affiliate.getBirthDate());
            assertNotNull(affiliate);
    }

    @Test
    @Rollback(true)
    void insertAffiliate() throws AffiliateAccessException{

        AffiliateDBAccess affiliateDao = new AffiliateDBAccess();

        Affiliate affiliate = new Affiliate(141718, "Lili", "VDC",
                "M", new GregorianCalendar(2000, 0, 1), false, 1 );

        affiliate.setEmail("lulu@hotmail.com");


        affiliateDao.insertAffiliate(affiliate);

    }


    @Test
    @Rollback(true)
    void updateAffiliate() throws AffiliateAccessException {

        AffiliateDBAccess affiliateDao = new AffiliateDBAccess();

        Affiliate affiliate = new Affiliate(141735, "Li", "V",
                "M", new GregorianCalendar(2000, 0, 1), false, 1 );

        affiliateDao.updateAffiliate(affiliate);

    }


    @Test
    @Rollback(true)
    void deleteAffiliate() throws AffiliateAccessException {

        AffiliateDBAccess affiliateDao = new AffiliateDBAccess();
        affiliateDao.deleteAffiliate(141737);


    }
}