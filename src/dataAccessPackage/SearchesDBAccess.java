package dataAccessPackage;

import exceptionPackage.SearchAccessException;
import modelPackage.AffiliateAvailableWeek;
import modelPackage.AffiliateInTraining;
import modelPackage.AffiliateInTrainingBirthDate;

import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class SearchesDBAccess implements  SearchesDataAccess{


    @Override
    public ArrayList<AffiliateInTraining> getAllAffiliatesInTraining(int trainingGroupId, int currentSeason) throws SearchAccessException{
        try{

            Connection connection = SingletonConnection.getInstance();

            String sqlInstruction = "SELECT affiliate.first_name, affiliate.last_name, ranking.name, affiliate.phone\n" +
                    "FROM affiliate JOIN training ON \n" +
                    "affiliate.affiliate_id = training.affiliate_id\n" +
                    "JOIN training_group \n" +
                    "ON training_group.training_group_id = training.training_group_id\n" +
                    "JOIN affiliate_ranking \n" +
                    "ON affiliate_ranking.affiliate_id = affiliate.affiliate_id\n" +
                    "JOIN ranking\n" +
                    "ON ranking.ranking_id = affiliate_ranking.ranking_id\n" +
                    "WHERE training_group.training_group_id = ?\n" +
                    "AND affiliate_ranking.season = ?\n"+
                    "AND affiliate_ranking.gender = 'M'";


            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);
            preparedStatement.setInt(1, trainingGroupId);
            preparedStatement.setInt(2, currentSeason);
            ResultSet data = preparedStatement.executeQuery();

            ArrayList<AffiliateInTraining>allAffiliateInTraining = new ArrayList<>();

            while(data.next()){

                allAffiliateInTraining.add(mapAffiliateInTrainingRowToModel(data));

            }
            return allAffiliateInTraining;

        }
        catch(SQLException e){
            throw new SearchAccessException ();
        }
    }

    private AffiliateInTraining mapAffiliateInTrainingRowToModel(ResultSet data) throws SQLException{
        AffiliateInTraining affiliateInTraining;
        String phone;

        affiliateInTraining = new AffiliateInTraining(data.getString("first_name"),
                data.getString("last_name"), data.getString("name"));

        phone = data.getString("phone");
        if (!data.wasNull()) affiliateInTraining.setPhone(phone);

        return affiliateInTraining;
    }

    @Override
    public ArrayList<AffiliateInTrainingBirthDate> getAllAffiliatesInTrainingAccordingBirthDate(int trainingGroupId, int currentSeason, String startDate, String endDate) throws SearchAccessException {
        try{

            Connection connection = SingletonConnection.getInstance();

            String sqlInstruction = "SELECT affiliate.first_name, affiliate.last_name, ranking.name, affiliate.phone, affiliate.play_competition, affiliate.birth_date\n" +
                    "FROM affiliate JOIN training ON \n" +
                    "affiliate.affiliate_id = training.affiliate_id\n" +
                    "JOIN training_group \n" +
                    "ON training_group.training_group_id = training.training_group_id\n" +
                    "JOIN affiliate_ranking \n" +
                    "ON affiliate_ranking.affiliate_id = affiliate.affiliate_id\n" +
                    "JOIN ranking\n" +
                    "ON ranking.ranking_id = affiliate_ranking.ranking_id\n" +
                    "WHERE training_group.training_group_id = ? " +
                    "AND affiliate_ranking.season = ? " +
                    "AND affiliate.birth_date BETWEEN Str_to_date(?, '%d/%m/%Y') AND " +
                    "Str_to_date(?, '%d/%m/%Y')\n" +
                    "AND affiliate_ranking.gender = 'M'";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);
            preparedStatement.setInt(1, trainingGroupId);
            preparedStatement.setInt(2, currentSeason);
            preparedStatement.setString(3, startDate);
            preparedStatement.setString(4, endDate);
            ResultSet data = preparedStatement.executeQuery();

            ArrayList<AffiliateInTrainingBirthDate>allAffiliateInTrainingBirthdate = new ArrayList<>();

            while(data.next()){

                allAffiliateInTrainingBirthdate.add(mapAffiliateInTrainingBirthDateRowToModel(data));

            }
            return allAffiliateInTrainingBirthdate;

        }
        catch(SQLException e){
            throw new SearchAccessException ();
        }
    }

    private AffiliateInTrainingBirthDate mapAffiliateInTrainingBirthDateRowToModel(ResultSet data) throws SQLException{

        AffiliateInTrainingBirthDate affiliateInTrainingBirthDate;
        Date sqlBirthDate;
        GregorianCalendar birthDate;
        String phone;
        sqlBirthDate = data.getDate("birth_date");
        birthDate = new GregorianCalendar();
        birthDate.setTime(sqlBirthDate);

        affiliateInTrainingBirthDate = new AffiliateInTrainingBirthDate(data.getString("first_name"),
                data.getString("last_name"), birthDate, data.getBoolean("play_competition"),
                data.getString("name"));

        phone = data.getString("phone");
        if (!data.wasNull()) affiliateInTrainingBirthDate.setPhone(phone);

        return affiliateInTrainingBirthDate;

    }

    @Override
    public ArrayList<AffiliateAvailableWeek> getAllAffiliatesAvailableWeek(int weekNumber, String rankingName, int season) throws SearchAccessException{
        try{

            Connection connection = SingletonConnection.getInstance();

            String sqlInstruction = "SELECT affiliate.first_name, affiliate.last_name, affiliate.phone\n" +
                                    "FROM affiliate\n" +
                                    "JOIN affiliate_ranking\n" +
                                    "ON affiliate_ranking.affiliate_id = affiliate.affiliate_id\n" +
                                    "JOIN ranking\n" +
                                    "ON ranking.ranking_id = affiliate_ranking.ranking_id\n" +
                                    "WHERE  NOT EXISTS (\n" +
                                    "SELECT * \n" +
                                    "FROM absence\n" +
                                    "WHERE absence.week_number = ?\n" +
                                    "AND absence.affiliate_id = affiliate.affiliate_id\n" +
                                    ")\n" +
                                    "AND ranking.name in (?)\n" +
                                    "AND affiliate_ranking.season = ?\n" +
                                    "AND affiliate_ranking.gender = 'M';";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);
            preparedStatement.setInt(1, weekNumber);
            preparedStatement.setString(2, rankingName);
            preparedStatement.setInt(3, season);

            ResultSet data = preparedStatement.executeQuery();

            ArrayList<AffiliateAvailableWeek>affiliateAvailableWeek = new ArrayList<>();

            while(data.next()){
                affiliateAvailableWeek.add(mapAffiliateAvailableWeekRowToModel(data));
            }
            return affiliateAvailableWeek;

        }
        catch(SQLException e){
            throw new SearchAccessException ();
        }


    }

    private AffiliateAvailableWeek mapAffiliateAvailableWeekRowToModel(ResultSet data) throws SQLException{
        AffiliateAvailableWeek affiliate;
        String phone;

        affiliate = new AffiliateAvailableWeek(data.getString("first_name"), data.getString("last_name"));

        phone = data.getString("phone");
        if (!data.wasNull()) affiliate.setPhone(phone);

        return affiliate;
    }
}
