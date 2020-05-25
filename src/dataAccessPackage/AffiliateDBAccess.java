package dataAccessPackage;

import exceptionPackage.*;
import modelPackage.Affiliate;
import java.util.ArrayList;
import java.sql.*;
import java.util.GregorianCalendar;



public class AffiliateDBAccess implements AffiliateDataAccess {

    @Override
    public ArrayList<Affiliate> getAllAffiliates() throws AffiliateAccessException {

        try{
            Connection connection = SingletonConnection.getInstance();

            String sqlInstruction = "select * from affiliate ";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);
            ResultSet data = preparedStatement.executeQuery();

            ArrayList<Affiliate>allAffiliates = new ArrayList<>();

            while(data.next()){

                allAffiliates.add(mapAffiliateRowToModel(data));
            }
            return allAffiliates;
        }
        catch(SQLException e){
            throw new AffiliateAccessException();
        }
    }

    private Affiliate mapAffiliateRowToModel(ResultSet data) throws SQLException {
        Date sqlBirthDate;
        GregorianCalendar birthDate;
        Affiliate affiliate;
        String email;
        String phone;
        sqlBirthDate = data.getDate("birth_date");
        birthDate = new GregorianCalendar();
        birthDate.setTime(sqlBirthDate);

        affiliate = new Affiliate(data.getInt("affiliate_id"), data.getString("first_name"),
                    data.getString("last_name"), data.getString("gender"), birthDate,
                    data.getBoolean("play_competition"),data.getInt("equipment_id"));

        email = data.getString("email");
        if (!data.wasNull()) affiliate.setEmail(email);
        phone = data.getString("phone");
        if (!data.wasNull()) affiliate.setPhone(phone);
        return affiliate;
    }

    @Override
    public Affiliate getAffiliate(int id) throws AffiliateAccessException, RankingAccessException, AbsenceAccessException {

        try {

            Connection connection = SingletonConnection.getInstance();

            String sqlInstruction = "select * from affiliate where affiliate_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);
            preparedStatement.setInt(1, id);
            ResultSet data = preparedStatement.executeQuery();
            data.next();
            Affiliate affiliate = mapAffiliateRowToModel(data);

            //retrieve the training groups
            TrainingDBAccess trainingDao = new TrainingDBAccess();
            affiliate.setTrainings(trainingDao.getTrainingsByAffiliateId(affiliate.getAffiliateID()));

            //retrieve the affiliate rakings
            RankingDBAccess rankingDao = new RankingDBAccess();
            affiliate.setAffiliateRankings(rankingDao.getRankingsByAffiliateId(affiliate.getAffiliateID()));

            // retrieve the affiliate absence
            AbsenceDBAccess absenceDao = new AbsenceDBAccess();
            affiliate.setAffiliateAbsences(absenceDao.getAbsencesByAffiliateId(affiliate.getAffiliateID()));

            return affiliate;
        }
        catch(SQLException e){

            throw new AffiliateAccessException();

        } catch (TrainingAccessException e) {
            throw new AffiliateAccessException();
        } catch (AbsenceAccessException e) {
            throw new AffiliateAccessException();
        }
    }

    @Override
    public void insertAffiliate(Affiliate affiliate) throws AffiliateAccessException {

        try{
            Connection connection = SingletonConnection.getInstance();

            String sqlInstruction = "insert into affiliate(affiliate_id, first_name,last_name, gender, birth_date, phone, email, equipment_id, play_competition) values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);
            java.sql.Date sqlDate = new java.sql.Date(affiliate.getBirthDate().getTimeInMillis());

            preparedStatement.setInt(1, affiliate.getAffiliateID());
            preparedStatement.setString(2, affiliate.getFirstName());
            preparedStatement.setString(3, affiliate.getLastName());
            preparedStatement.setString(4, affiliate.getGender());
            preparedStatement.setDate(5, sqlDate);

            if (affiliate.getPhone() == null) preparedStatement.setNull(6, Types.VARCHAR);
            else preparedStatement.setString(6, affiliate.getPhone());

            if (affiliate.getEmail() == null) preparedStatement.setNull(7, Types.VARCHAR);
            else preparedStatement.setString(7, affiliate.getEmail());

            preparedStatement.setInt(8, affiliate.getEquipment());
            preparedStatement.setBoolean(9, affiliate.getPlayCompetition());

            preparedStatement.executeUpdate();

            if (affiliate.getTrainings().size() > 0) {
                TrainingDBAccess trainingDao = new TrainingDBAccess();
                trainingDao.saveTrainings(affiliate.getTrainings(), affiliate.getAffiliateID());
            }

        }
        catch(SQLException e){
            throw new AffiliateAccessException();
        } catch (TrainingAccessException e) {
            throw new AffiliateAccessException();
        }
    }

    @Override
    public void updateAffiliate(Affiliate affiliate) throws AffiliateAccessException {

        try {

            Connection connection = SingletonConnection.getInstance();

            String sqlInstruction ="update affiliate set first_name = ?,last_name = ?, gender = ?, birth_date = ?," +
                    "phone = ?, email = ?, equipment_id = ?, play_competition = ? where affiliate_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);
            preparedStatement.setInt(9, affiliate.getAffiliateID());

            preparedStatement.setString(1, affiliate.getFirstName());
            preparedStatement.setString(2, affiliate.getLastName());
            preparedStatement.setString(3, affiliate.getGender());
            java.sql.Date sqlDate = new java.sql.Date(affiliate.getBirthDate().getTimeInMillis());
            preparedStatement.setDate(4, sqlDate);

            if (affiliate.getPhone() == null) preparedStatement.setNull(5, Types.VARCHAR);
            else preparedStatement.setString(5, affiliate.getPhone());

            if (affiliate.getEmail() == null) preparedStatement.setNull(6, Types.VARCHAR);
            else preparedStatement.setString(6, affiliate.getEmail());

            preparedStatement.setInt(7, affiliate.getEquipment());
            preparedStatement.setBoolean(8, affiliate.getPlayCompetition());

            preparedStatement.executeUpdate();

            TrainingDBAccess trainingDao = new TrainingDBAccess();
            trainingDao.saveTrainings(affiliate.getTrainings(), affiliate.getAffiliateID());
        }
        catch (SQLException e){

            throw new AffiliateAccessException();
        } catch (TrainingAccessException e) {
            throw new AffiliateAccessException();
        }
    }

    @Override
    public void deleteAffiliate(int id) throws AffiliateAccessException {

        try{
            Connection connection = SingletonConnection.getInstance();

            String sqlInstruction ="delete from affiliate where affiliate_id = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

        }
        catch (SQLException e){
            throw new AffiliateAccessException();
        }
    }

    @Override
    public boolean existAffiliate(int id) throws AffiliateAccessException {

        try{
            Connection connection = SingletonConnection.getInstance();

            String sqlInstruction ="select count(*) as count from affiliate where affiliate_id = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);
            preparedStatement.setInt(1, id);

            ResultSet data = preparedStatement.executeQuery();
            data.next();
            if (data.getInt("count") == 0) {
                return false;
            }
            else {
                return true;
            }
        }
        catch (SQLException e){
            throw new AffiliateAccessException();

        }
    }


}
