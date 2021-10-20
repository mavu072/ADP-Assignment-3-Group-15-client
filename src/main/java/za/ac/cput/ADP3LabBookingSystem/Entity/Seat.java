/*
 * Seat.java
 * Entity for the Seat.
 * Author: Nikiwe Mkontshwana. (2142367141)
 * Due Date: 11 June 2021...
 * */

package za.ac.cput.ADP3LabBookingSystem.Entity;


public class Seat {
    //private variables
    private String seatNumber, labId;
    private boolean seatAvailability;

    //Builder builder
    private Seat(Builder builder) {
        this.seatNumber = builder.seatNumber;
        this.labId = builder.labId;
        this.seatAvailability = builder.seatAvailability;

    }

    //toString
    @Override
    public String toString() {
        return "Seat{" +
                "seatNumber='" + seatNumber + '\'' +
                ", seatAvailability='" + seatAvailability + '\'' +
                ", labId=" + labId+'\'' +
                '}';
    }

    //Builder class
    public static class Builder {
        //private variables
        private String seatNumber, labId;
        private boolean seatAvailability;

        //setters
        public Builder setSeatNumber(String seatNumber) {
            this.seatNumber = seatNumber;

            return this;
        }
        public Builder setLabId(String labId) {
            this.labId = labId;

            return this;

        }
        public Builder setSeatAvailability(boolean seatAvailability) {
            this.seatAvailability = seatAvailability;

            return this;
        }


        //build
        public Seat build() {
            return new Seat (Builder.this);
        }

        //copy
        public Builder copy(Seat seat){
            this.seatNumber = seat.seatNumber;
            this.labId = seat.labId;
            this.seatAvailability = seat.seatAvailability;

            return this;
        }


    }
}

