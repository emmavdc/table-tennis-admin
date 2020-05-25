package controllerPackage;

import exceptionPackage.EquipmentAccessException;
import modelPackage.Equipment;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


class EquipmentControllerTest {

    @Test
    void getAllEquipments() throws EquipmentAccessException {

        EquipmentController equipmentController;
        equipmentController = new EquipmentController();

        ArrayList<Equipment> allEquipments = equipmentController.getAllEquipments();

        for(Equipment equipment : allEquipments){

            System.out.println(equipment.toString());
        }
    }
}