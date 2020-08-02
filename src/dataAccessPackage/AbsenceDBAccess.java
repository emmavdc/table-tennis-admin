package dataAccessPackage;

import exceptionPackage.AbsenceAccessException;
import exceptionPackage.CloseApplicationException;
import modelPackage.Absence;

import java.sql.*;
import java.util.ArrayList;

public class AbsenceDBAccess implements AbsenceDataAccess{

    @Override
    public ArrayList<Absence> getAllAbsences() throws AbsenceAccessException {
        try {
            Connection connection = SingletonConnection.getInstance();

            String sqlInstruction = "select * from absence";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);

            ResultSet data = preparedStatement.executeQuery();


            ArrayList<Absence>allAbsences = new ArrayList<>();

            while(data.next()){

                allAbsences.add(mapAbsenceRowToModel(data));

            }
            return allAbsences;


        }

        catch(SQLException e){

            throw new AbsenceAccessException();
        }
    }
    @Override
    public ArrayList<Absence> getAbsencesByAffiliateId(int affiliateId) throws AbsenceAccessException{
        try {
            Connection connection = SingletonConnection.getInstance();

            String sqlInstruction = "select * from absence where affiliate_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);
            preparedStatement.setInt(1, affiliateId);
            ResultSet data = preparedStatement.executeQuery();

            ArrayList<Absence>allAbsences = new ArrayList<>();
            while(data.next()){

                allAbsences.add(mapAbsenceRowToModel(data));

            }
            return allAbsences;
        }
        catch(SQLException e){

            throw new AbsenceAccessException();
        }
    }

    private Absence mapAbsenceRowToModel(ResultSet data) throws SQLException {
        Absence absence;

        absence = new Absence(data.getInt("absence_id"), data.getInt("week_number"),
                data.getString("description"), data.getInt("affiliate_id"));

        return absence;
    }

    public void insertAbsences(ArrayList<Absence> absences) throws AbsenceAccessException{
        try{
            Connection connection = SingletonConnection.getInstance();

            String sqlInstruction;
            PreparedStatement preparedStatement;

            for(Absence absence : absences){
                sqlInstruction = "insert into absence(week_number, description, affiliate_id) values (?,?,?)";
                preparedStatement = connection.prepareStatement(sqlInstruction);
                preparedStatement.setInt(1, absence.getWeekNumber());
                preparedStatement.setString(2, absence.getDescription());
                preparedStatement.setInt(3, absence.getAffiliateID());
                preparedStatement.executeUpdate();
            }
        }
        catch(SQLException e){

            throw new AbsenceAccessException();
        }
    }

    @Override
    public void deleteAffiliateAbsences(int affiliateId) throws AbsenceAccessException{
        try {

            Connection connection = SingletonConnection.getInstance();

            String sqlInstruction ="delete from absence where affiliate_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);
            preparedStatement.setInt(1, affiliateId);

            preparedStatement.executeUpdate();
        }
        catch(SQLException e){

            throw new AbsenceAccessException();
        }
    }


}
