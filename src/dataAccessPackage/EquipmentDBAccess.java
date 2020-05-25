package dataAccessPackage;

import exceptionPackage.EquipmentAccessException;
import modelPackage.Equipment;
import java.sql.*;
import java.util.ArrayList;

public class EquipmentDBAccess implements EquipmentDataAccess{
    @Override
    public ArrayList<Equipment> getAllEquipments() throws EquipmentAccessException {
        try{

            Connection connection = SingletonConnection.getInstance();

            String sqlInstruction = "select * from equipment";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);

            ResultSet data = preparedStatement.executeQuery();

            ArrayList<Equipment>allEquipments = new ArrayList<>();

            while(data.next()){

                allEquipments.add(mapEquipmentRowToModel(data));

            }
            return allEquipments;

        }
        catch(SQLException e){

            throw new EquipmentAccessException();

        }
    }

    private Equipment mapEquipmentRowToModel(ResultSet data) throws SQLException {

        Equipment equipment;

        equipment = new Equipment(data.getInt("reference"), data.getString("description"));
        return equipment;
    }

}
