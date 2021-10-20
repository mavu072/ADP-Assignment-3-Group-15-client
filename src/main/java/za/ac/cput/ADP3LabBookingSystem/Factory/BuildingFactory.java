/**
 * Building Factory
 * Author: Xola Mngeni 218268017
 */


package za.ac.cput.ADP3LabBookingSystem.Factory;

import za.ac.cput.ADP3LabBookingSystem.Entity.Building;
import za.ac.cput.ADP3LabBookingSystem.Util.GenericHelper;

public class BuildingFactory {
    public static Building createBuilding(String engineering){
        String buildingId = GenericHelper.generateId();

        Building building = new Building.Builder()
                .setBuildingId(buildingId)
                .build();
        return building;

    }
}
