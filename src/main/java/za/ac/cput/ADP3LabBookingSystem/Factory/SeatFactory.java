/*
 * Seat.java
 * Entity for the Seat.
 * Author: Nikiwe Mkontshwana. (2142367141)
 * Due Date: 11 June 2021.
 * */
package za.ac.cput.ADP3LabBookingSystem.Factory;


import za.ac.cput.ADP3LabBookingSystem.Entity.Seat;
import za.ac.cput.ADP3LabBookingSystem.Util.GenericHelper;

public class SeatFactory {

    public static Seat createSeat(String seatNumber, String labId, boolean seatAvailability) {
        String seatId = GenericHelper.generateId();
        Seat seat = new Seat.Builder()
                .setSeatNumber(seatId)
                .setLabId(labId)
                .setSeatAvailability(seatAvailability)

                .build();

        return seat;
    }
}
