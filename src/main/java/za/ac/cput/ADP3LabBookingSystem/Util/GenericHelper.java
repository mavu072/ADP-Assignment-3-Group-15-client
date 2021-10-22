/*
 * GenericHelper.java
 * GenericHelper Class.
 * Author: Avuyile Mgxotshwa (219132488)
 * Date: 10 June 2021
 * */
package za.ac.cput.ADP3LabBookingSystem.Util;

import java.util.UUID;

public class GenericHelper {

    //generatedId
    public static String generateId() {

        return UUID.randomUUID().toString();
    }

    public static String getAlphaNumericString(int n)
    {
        //create random 6 letter string for bookingid
        // choose a random character from this string
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        //
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

}
