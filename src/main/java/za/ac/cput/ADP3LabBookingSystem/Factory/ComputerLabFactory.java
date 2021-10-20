/*
 * ComputerLabFactory.java
 * Factory for the ComputerLab.
 * Author: Avuyile Mgxotshwa (219132488)
 * Date: 10 June 2021
 * */
package za.ac.cput.ADP3LabBookingSystem.Factory;

import za.ac.cput.ADP3LabBookingSystem.Entity.ComputerLab;

public class ComputerLabFactory {

    public static ComputerLab createComputerLab(String labId, String buildingId, int capacity, boolean availability) {

        ComputerLab computerLab = new ComputerLab.Builder()
                .setLabId(labId)
                .setBuildingId(buildingId)
                .setCapacity(capacity)
                .setAvailability(availability)
                .build();

        return computerLab;
    }

}
