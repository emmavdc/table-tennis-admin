package dataAccessPackage;

import exceptionPackage.TrainingAccessException;
import modelPackage.*;

import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;

public class TrainingDBAccess implements TrainingDataAccess {
    @Override
    public ArrayList<TrainingGroup> getAllTrainingGroups() throws TrainingAccessException {

        try{

            Connection connection = SingletonConnection.getInstance();

            String sqlInstruction = "select * from " +
                    " training_group tg, trainer t, room r" +
                    " where tg.trainer_id = t.trainer_id" +
                    " and tg.room_id = r.number" +
                    " order by training_group_id";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);

            ResultSet data = preparedStatement.executeQuery();

            ArrayList<TrainingGroup>allTrainingGroups = new ArrayList<>();

            while(data.next()){

                allTrainingGroups.add(mapTrainingGroupRowToModel(data));

            }
            return allTrainingGroups;

        }
        catch(SQLException e){
            throw new TrainingAccessException();
        }
    }

    @Override
    public ArrayList<Training> getTrainingsByAffiliateId(Integer affiliateId) throws TrainingAccessException {

        Connection connection = null;
        ArrayList<Training> trainings = null;

        try {
            connection = SingletonConnection.getInstance();
            String sqlInstruction = "select * from training where affiliate_id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);
            preparedStatement.setInt(1, affiliateId);
            ResultSet data = preparedStatement.executeQuery();
            trainings = mapTrainingGroupsToTrainings(data);
;           return trainings;

        } catch (SQLException e) {
            throw new TrainingAccessException();
        }


    }

    private ArrayList<Training> mapTrainingGroupsToTrainings(ResultSet data) throws SQLException {
        ArrayList<Training> trainings = new ArrayList<Training>();
        while (data.next()) {
            trainings.add(new Training(data.getInt("training_group_id"), data.getInt("affiliate_id")));
        }
        return trainings;
    }

    @Override
    public void saveTrainings(ArrayList<Training> trainings, int affiliateId) throws TrainingAccessException {

            Connection connection;

            try {
                connection = SingletonConnection.getInstance();
                String sqlInstruction = "delete from training where affiliate_id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);
                preparedStatement.setInt(1, affiliateId);
                preparedStatement.executeUpdate();

                for (Training training : trainings) {
                    sqlInstruction = "insert into training (training_group_id, affiliate_id) values (?,?)";
                    preparedStatement = connection.prepareStatement(sqlInstruction);
                    preparedStatement.setInt(1, training.getTrainingGroupId());
                    preparedStatement.setInt(2, training.getAffiliateId());
                    preparedStatement.executeUpdate();
                }

            } catch (SQLException e) {
                throw new TrainingAccessException();
            }

    }

    private TrainingGroup mapTrainingGroupRowToModel(ResultSet data) throws SQLException {

        TrainingGroup trainingGroup;
        LocalTime timeStart;
        LocalTime timeEnd;
        Time sqlTimeStart;
        Time sqlTimeEnd;
        sqlTimeStart = data.getTime("time_start");
        sqlTimeEnd = data.getTime("time_end");

        timeStart = sqlTimeStart.toLocalTime();
        timeEnd = sqlTimeEnd.toLocalTime();

        trainingGroup = new TrainingGroup(data.getInt("training_group_id"),
                timeStart,timeEnd, data.getInt("day"),
                data.getInt("trainer_id"), data.getInt("room_id"));

        Room room = new Room(data.getInt("number"), data.getString("street_name"),
                data.getString("street_number"), data.getInt("postal_code"),
                data.getString("locality"));

        Trainer trainer = new Trainer(data.getInt("trainer_id"), data.getString("first_name"),
                data.getString("last_name"));

        trainingGroup.setTrainer(trainer);
        trainingGroup.setRoom(room);

        return trainingGroup;
    }
}
