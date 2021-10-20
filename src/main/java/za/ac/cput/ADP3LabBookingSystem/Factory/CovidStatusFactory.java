/*
 * CovidStatusFactory.java
 * Factory for CovidStatus
 * Author: Grant Metcalf (217222943)
 * Date: 10 June 2021
 * */
package za.ac.cput.ADP3LabBookingSystem.Factory;

import za.ac.cput.ADP3LabBookingSystem.Entity.CovidStatus;

public class CovidStatusFactory {

    public static CovidStatus createCovidStatus(String studentNumber, String temperature, boolean symptoms){
        CovidStatus covidStatus = new CovidStatus.Builder().setStudentNumber(studentNumber)
                .setTemperature(temperature)
                .setSymptoms(symptoms)
                .build();
        return covidStatus;
    }
}
