package dataAccessPackage;

import exceptionPackage.EquipmentAccessException;
import modelPackage.Equipment;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EquipmentDBAccessTest {

    @Test
    void getAllEquipments() throws EquipmentAccessException {

        EquipmentDBAccess equipmentDAO;
        equipmentDAO = new EquipmentDBAccess();

        ArrayList<Equipment> allEquipments = equipmentDAO.getAllEquipments();

        for(Equipment equipment : allEquipments){

            System.out.println(equipment.getReference() + " and " + equipment.getDescription() + "\n");

        }

    }
}