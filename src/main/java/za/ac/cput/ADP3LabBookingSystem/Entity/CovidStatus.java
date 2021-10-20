/*
 * CovidStatus.java
 * CovidStatus entity
 * Author: Grant Metcalf (217222943)
 * Date: 10 June 2021
 * */
package za.ac.cput.ADP3LabBookingSystem.Entity;

public class CovidStatus {

    private String studentNumber, temperature;
    private boolean symptoms;

    private CovidStatus(Builder builder){
        this.studentNumber = builder.studentNumber;
        this.temperature = builder.temperature;
        this.symptoms = builder.symptoms;
    }

    @Override
    public String toString() {
        return "CovidStatus{" +
                "studentNumber='" + studentNumber + '\'' +
                ", temperature='" + temperature + '\'' +
                ", symptoms=" + symptoms +
                '}';
    }

    public static class Builder {

        private String studentNumber, temperature;
        private boolean symptoms;

        public Builder setStudentNumber(String studentNumber) {
            this.studentNumber = studentNumber;
            return this;
        }

        public Builder setTemperature(String temperature) {
            this.temperature = temperature;
            return this;
        }

        public Builder setSymptoms(boolean symptoms) {
            this.symptoms = symptoms;
            return this;
        }


        public Builder copy(CovidStatus covidStatus) {
            this.studentNumber = covidStatus.studentNumber;
            this.temperature = covidStatus.temperature;
            this.symptoms = covidStatus.symptoms;
            return this;
        }

        public CovidStatus build(){return new CovidStatus(this);}

    }
}

