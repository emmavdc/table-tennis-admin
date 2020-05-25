package dataAccessPackage;

import exceptionPackage.EquipmentAccessException;
import modelPackage.Equipment;

import java.util.ArrayList;

public interface EquipmentDataAccess{

    public ArrayList<Equipment> getAllEquipments() throws EquipmentAccessException;

}
