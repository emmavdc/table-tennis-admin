package businessPackage;

import dataAccessPackage.EquipmentDBAccess;
import exceptionPackage.EquipmentAccessException;
import modelPackage.Equipment;

import java.util.ArrayList;

public class EquipmentManager {
    private EquipmentDBAccess equipmentDAO;

    public EquipmentManager(){
        this.equipmentDAO = new EquipmentDBAccess();
    }

    public ArrayList<Equipment> getAllEquipments() throws EquipmentAccessException {

        return equipmentDAO.getAllEquipments();

    }
}
