/*
 Address.java
 Entity for the Address
 Author: Felecia Zweni (218330189)
 Date: 10 June 2021
 */


package za.ac.cput.ADP3LabBookingSystem.Entity;

public class Address {

    private String street, suburb, city;
    private int zipCode;
    public Address (){

    }

    public Address(Builder builder){

        this.street = builder.street;
        this.suburb = builder.suburb;
        this.city = builder.city;
        this.zipCode = builder.zipCode;

    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", suburb='" + suburb + '\'' +
                ", city='" + city + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }

    public static class Builder {

        private String street, suburb, city;
        private int zipCode;

        public Builder setStreet(String street) {
            this.street = street;

            return this;
        }

        public Builder setSuburb(String suburb) {
            this.suburb = suburb;

            return this;
        }

        public Builder setCity(String city) {
            this.city = city;

            return this;
        }

        public Builder setZipCode(int zipCode) {
            this.zipCode = zipCode;

            return this;
        }

        public Address build() {

            return new Address(this);
        }


        public Builder copy(Address address) {
            this.street = address.street;
            this.suburb = address.suburb;
            this.city = address.city;
            this.zipCode = address.zipCode;

            return this;

        }
    }
    }
