package businessPackage;

import dataAccessPackage.EquipmentDBAccess;
import dataAccessPackage.EquipmentDataAccess;
import exceptionPackage.EquipmentAccessException;
import modelPackage.Equipment;

import java.util.ArrayList;

public class EquipmentManager {
    private EquipmentDataAccess equipmentDAO;

    public EquipmentManager(){
        equipmentDAO = new EquipmentDBAccess();
    }

    public ArrayList<Equipment> getAllEquipments() throws EquipmentAccessException {

        return equipmentDAO.getAllEquipments();

    }
}
