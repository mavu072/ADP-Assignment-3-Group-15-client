/*
  AddressFactory.java
  Factory for the Address
  Author: Felecia Zweni(218330189)
  Date: 10 June 2021
 */

package za.ac.cput.ADP3LabBookingSystem.Factory;

import za.ac.cput.ADP3LabBookingSystem.Entity.Address;

public class AddressFactory {

    public static Address createAddress(String street, String city, String suburb,int zipCode){

        Address address = new Address.Builder()
                .setStreet(street)
                .setCity(city)
                .setSuburb(suburb)
                .setZipCode(zipCode)
                .build();

        return address;


    }

}
