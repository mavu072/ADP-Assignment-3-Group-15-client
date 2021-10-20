/*      Author: Nabeel Meyers
        Student Number: 218328702
        StudentFactory.java
        Assignment 3
        2021

        description:
        -The complex configuration supports:
        -Names with letters only
        -Emails following format: hello@example.com
        -Phone Numbers consisting of numbers only
        -Phone Numbers with the length of 10 characters
         */
package za.ac.cput.ADP3LabBookingSystem.Factory;

import za.ac.cput.ADP3LabBookingSystem.Entity.Student;


public class StudentFactory {


    public static Student build(String firstName, String lastName, String email, String phoneNumber){


        if(firstName.isEmpty() || !firstName.matches("[A-Za-z]+") || !lastName.matches("[A-Za-z]+")|| lastName.isEmpty() || !email.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
          + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$") || !phoneNumber.matches("^[0-9]+") || phoneNumber.isEmpty() || phoneNumber.length() != 10)
            return null;


        int random = (int)(Math.random()*(300000000-200000000)+200000000);
        String studentNumber =""+ random;
        //req data structure to check if exists already.

        return new Student.Builder()
                .setStudentNumber(studentNumber).setFirstName(firstName).setLastName(lastName).setEmail(email).setPhoneNumber(phoneNumber).build();
    }
}
