/*
   BookingFactory.java
   Booking Factory
   Author: AJ Mitchell 219024979
   Date: 10 June
*/
package za.ac.cput.ADP3LabBookingSystem.Factory;

import za.ac.cput.ADP3LabBookingSystem.Entity.Booking;

public class BookingFactory {
    
    private volatile Booking booking;

    public static String generateBookingId(int n)
    {
        //create random 6 letter string for bookingid
        String alphaNumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            int ind = (int)(alphaNumeric.length()* Math.random());

            // add chars one at a time to the end of stringbuilder
            sb.append(alphaNumeric.charAt(ind));
        }
        return sb.toString();
    }

    
    public BookingFactory(){
        
        Thread thr1 = new Thread(new Runnable(){
            @Override
            public void run(){ booking = Booking.Builder.newInstance()
                              .setBookingId(generateBookingId(6))
                              .setStudentNr("219024979")
                              //.setBookingDate(new Date())
                              //.setStartTime(new Time())
                              //.setEndTime(new Time())
                              .setLabId("Lab A")
                              .setSeatNumber("3A")
                              .build();     
            }
        });

        Thread thr2 = new Thread(new Runnable(){
            @Override
            public void run(){ booking = Booking.Builder.newInstance()
                              .setBookingId(generateBookingId(6))
                              .setStudentNr("219859979")
                             // .setBookingDate(new Date())
                              //.setStartTime(new Time())
                             // .setEndTime(new Time())
                              .setLabId("Lab B")
                              .setSeatNumber("3B")
                              .build();     
            }
        });

        thr1.start();
        thr2.start();

        
    }
    
    public Booking getBooking(){
        return booking;
    }
    
}