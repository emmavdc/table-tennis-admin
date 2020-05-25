package controllerPackage;


import businessPackage.EquipmentManager;
import exceptionPackage.EquipmentAccessException;
import modelPackage.Equipment;

import java.util.ArrayList;

public class EquipmentController  {

    private EquipmentManager equipmentManager;

    public EquipmentController(){

        this.equipmentManager = new EquipmentManager();
    }
    public ArrayList<Equipment> getAllEquipments() throws EquipmentAccessException {

        return equipmentManager.getAllEquipments();
    }


}
