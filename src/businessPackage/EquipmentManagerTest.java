package businessPackage;

import exceptionPackage.EquipmentAccessException;
import modelPackage.Equipment;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;


class EquipmentManagerTest {

    @Test
    void getAllEquipments() throws EquipmentAccessException {

        EquipmentManager equipmentManager = new EquipmentManager();

        ArrayList<Equipment> allEquipments = equipmentManager.getAllEquipments();

        for(Equipment equipment : allEquipments){

            System.out.println(equipment.toString());
        }
    }
}