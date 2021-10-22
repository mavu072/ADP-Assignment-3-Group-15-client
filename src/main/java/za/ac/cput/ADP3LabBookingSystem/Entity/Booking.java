/*
 Booking.java
 Booking Entity 
 Author: AJ Mitchell 219024979
 Date: 9 June
 */

package za.ac.cput.ADP3LabBookingSystem.Entity;

import java.util.Date;
import java.sql.*;

import javax.swing.JOptionPane;

public class Booking{
    //instance vars
    private String bookingid;
    private String studentnr;
    private Date bookingdate;
    private String starttime; //of Time type
    private String endtime;     //of Time type
    private String labid;
    private String seatnumber;
    
    
    public Booking(){
            bookingid = "";
            studentnr = "";
            bookingdate = new Date();
            starttime = "";
            endtime = "";
            labid = "";
            seatnumber = "";
        }
    
    
        //Builder builder
    public Booking(Builder builder){
        this.bookingid = builder.bookingid;
        this.studentnr = builder.studentnr;
        this.bookingdate = builder.bookingdate;
        this.starttime = builder.starttime;
        this.endtime = builder.endtime;
        this.labid = builder.labid;
        this.seatnumber = builder.seatnumber;
    }

    public static class Builder{

        private String bookingid;
        private String studentnr;
        private Date bookingdate;
        private String starttime;
        private String endtime;
        private String labid;
        private String seatnumber;

        private Builder(){}

        public static Builder newInstance(){
            return new Builder();
        }

        //Setters
        public Builder setBookingId(String bookingid) {
            this.bookingid = bookingid;
            return this;
        }

        public Builder setStudentNr(String studentnr) {
            this.studentnr = studentnr;
            return this;
        }

        public Builder setBookingDate(Date bookingdate) {
            this.bookingdate = bookingdate;
            return this;
        }

        public Builder setStartTime(String starttime) {
            this.starttime = starttime;
            return this;
        }

        public Builder setEndTime(String endtime) {
            this.endtime = endtime;
            return this;
        }

        public Builder setLabId(String labid) {
            this.labid = labid;
            return this;
        }

        public Builder setSeatNumber(String seatnumber) {
            this.seatnumber = seatnumber;
            return this;
        }

        public Builder copy(Booking booking){
            this.bookingid = booking.bookingid;
            this.studentnr = booking.studentnr;
            this.bookingdate = booking.bookingdate;
            this.starttime = booking.starttime;
            this.endtime = booking.endtime;
            this.labid = booking.labid;
            this.seatnumber = booking.seatnumber;
            return this;
        }

        public Booking build(){
            return new Booking(this);
        }

        //toString()
        @Override
        public String toString(){

        return "Booking{" +
            "bookingid = " + this.bookingid +
            ", studentnr = " + this.studentnr +
            ", bookingdate = " + this.bookingdate +
            ", starttime = " + this.starttime +
            ", endtime = "+ this.endtime +
            ", labid = " + this.labid +
            ", seatnumber = " + this.seatnumber +
            '}';
        }
    }//end Builder class

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


    //all queries, updates, inserts

    static String dropTableIfExist =  "DROP TABLE IF EXISTS student, covidstatus, address, building, computerLab, seat, booking; " ;

    static String createStudentTab =  "create table student(studentnumber varchar(9) NOT NULL UNIQUE PRIMARY KEY, password varchar(30) NOT NULL, firstname varchar(20) NOT NULL, lastname varchar(20) NOT NULL, email varchar(22) NOT NULL, phonenumber varchar(10) NOT NULL); " ;

    static String createCovidTab =  "CREATE TABLE Covidstatus (studentnumber varchar(9) NOT NULL PRIMARY KEY, temperature varchar(50) NOT NULL, symptoms varchar(100) NOT NULL, FOREIGN KEY (studentnumber) REFERENCES student(studentnumber)); " ;
    static String createAddressTab = "CREATE TABLE Address (addressid varchar(10) NOT NULL PRIMARY KEY, street varchar(50) NOT NULL, suburb varchar(50) NOT NULL, city varchar(50) NOT NULL, zipcode int NOT NULL); " ;
    static String createBuildingTab ="CREATE TABLE Building (buildingid varchar(10) NOT NULL PRIMARY KEY, addressid varchar(10) NOT NULL, INDEX (addressid), FOREIGN KEY (addressid) REFERENCES address(addressid));" ;
    static String createCompLabTab ="CREATE TABLE Computerlab (labid varchar(10) NOT NULL PRIMARY KEY, buildingid varchar(10) NOT NULL, capacity int NOT NULL, availability varchar(1) NOT NULL, roomnr varchar(20) , FOREIGN KEY (buildingid) REFERENCES building(buildingid)); " ;
    static String createSeatTab ="CREATE TABLE Seat (seatnumber varchar(10) NOT NULL PRIMARY KEY, labid varchar(10) NOT NULL, seatavailability varchar(1) NOT NULL, FOREIGN KEY (labid) REFERENCES computerlab(labid)); " ;
    static String createBookingTab ="CREATE TABLE Booking (bookingid varchar(6) NOT NULL PRIMARY KEY, studentnumber varchar(9), bookingdate varchar(30) NOT NULL, starttime varchar(30) NOT NULL, endtime varchar(30) NOT NULL, labid varchar(10), seatnumber varchar(10), INDEX (studentnumber), FOREIGN KEY (studentnumber) REFERENCES student(studentnumber), INDEX (labid), FOREIGN KEY (labid) REFERENCES computerlab(labid), INDEX (seatnumber), FOREIGN KEY (seatnumber) REFERENCES seat(seatnumber)); ";

    static String insertIntoStud = "INSERT INTO student (studentnumber, password, firstname, lastname, email, phonenumber) VALUES ('219132488', 'admin', 'Avuyile', 'Mgxotshwa', '219132488@mycput.ac.za', '0823967958'); ";
    static String insertIntoStud2 ="INSERT INTO student (studentnumber, password, firstname, lastname, email, phonenumber) VALUES ('217222943', 'admin', 'Grant', 'Metcalf', '217222943@mycput.ac.za', '0847486325'); " ;
    static String insertIntoStud3 = "INSERT INTO student (studentnumber, password, firstname, lastname, email, phonenumber) VALUES ('218330189', 'admin', 'Felecia', 'Zweni', '218330189@mycput.ac.za', '0876253021'); " ;
    static String insertIntoStud4 ="INSERT INTO student (studentnumber, password, firstname, lastname, email, phonenumber) VALUES ('218268017', 'admin', 'Xola', 'Mngeni', '218268017@mycput.ac.za', '0740214525'); " ;
    static String insertIntoStud5 = "INSERT INTO student (studentnumber, password, firstname, lastname, email, phonenumber) VALUES ('219024979', 'admin', 'Amy', 'Mitchell', '219024979@mycput.ac.za', '0642014325'); " ;
    static String insertIntoStud6 = "INSERT INTO student (studentnumber, password, firstname, lastname, email, phonenumber) VALUES ('214236714', 'admin', 'Nikiwe', 'Mkontshwana', '214236714@mycput.ac.za', '0115496065'); " ;
    static String insertIntoStud7 = "INSERT INTO student (studentnumber, password, firstname, lastname, email, phonenumber) VALUES ('218328702', 'admin', 'Mogamad Nabeel', 'Meyers', '218328702@mycput.ac.za', '0851598520'); ";

    static String insertIntoAdd ="INSERT INTO address (addressid, street, suburb, city, zipcode) VALUES ('D6', 'Corner of Hanover and Tennant Street', 'Zonnebloem', 'Cape Town', 7925); " ;
    static String insertIntoAdd2 ="INSERT INTO address (addressid, street, suburb, city, zipcode) VALUES ('BELLV', 'Symphony Way (off Robert Sobukwe Road)', 'Bellville', 'Cape Town', 7535); " ;
    static String insertIntoAdd3 = "INSERT INTO address (addressid, street, suburb, city, zipcode) VALUES ('MOWB', 'Highbury Road', 'Mowbray', 'Cape Town', 7700); " ;

    static String insertIntoBuild ="INSERT INTO building (buildingid, addressid) VALUES ('D6Engin', 'D6'); " ;
    static String insertIntoBuild2 = "INSERT INTO building (buildingid, addressid) VALUES ('D6Bus', 'D6'); " ;
    static String insertIntoBuild3 = "INSERT INTO building (buildingid, addressid) VALUES ('D6AppSci', 'D6'); " ;

    static String insertIntoCompLab = "INSERT INTO computerlab (labid, buildingid, capacity, availability, roomnr) VALUES ('Lab A', 'D6Engin', 8, 'T', 'Rm 1.11'); " ;
    static String insertIntoCompLab2 ="INSERT INTO computerlab (labid, buildingid, capacity, availability, roomnr) VALUES ('Lab B', 'D6Engin', 8, 'T', 'Rm 1.2'); " ;
    static String insertIntoCompLab3 ="INSERT INTO computerlab (labid, buildingid, capacity, availability, roomnr) VALUES ('Lab C', 'D6Engin', 8, 'T', 'Rm 1.3'); " ;
    static String insertIntoCompLab4 = "INSERT INTO computerlab (labid, buildingid, capacity, availability, roomnr) VALUES ('Lab D', 'D6Engin', 8, 'T', 'Rm 1.5'); " ;

    static String insertIntoSeat ="INSERT INTO seat (seatNumber, labid, seatavailability) VALUES ('1a', 'Lab A', 'T'); " ;
    static String insertIntoSeat2 = "INSERT INTO seat (seatNumber, labid, seatavailability) VALUES ('2a', 'Lab A', 'T'); " ;
    static String insertIntoSeat3 = "INSERT INTO seat (seatNumber, labid, seatavailability) VALUES ('3a', 'Lab A', 'T'); " ;
    static String insertIntoSeat4 = "INSERT INTO seat (seatNumber, labid, seatavailability) VALUES ('4a', 'Lab A', 'T'); " ;
    static String insertIntoSeat5 ="INSERT INTO seat (seatNumber, labid, seatavailability) VALUES ('5a', 'Lab A', 'T'); " ;
    static String insertIntoSeat6 = "INSERT INTO seat (seatNumber, labid, seatavailability) VALUES ('6a', 'Lab A', 'T'); " ;
    static String insertIntoSeat7 ="INSERT INTO seat (seatNumber, labid, seatavailability) VALUES ('7a', 'Lab A', 'T'); " ;
    static String insertIntoSeat8 = "INSERT INTO seat (seatNumber, labid, seatavailability) VALUES ('8a', 'Lab A', 'T'); " ;

    static String insertIntoSeat9 = "INSERT INTO seat (seatNumber, labid, seatavailability) VALUES ('1b', 'Lab B', 'T'); " ;
    static String insertIntoSeat10 = "INSERT INTO seat (seatNumber, labid, seatavailability) VALUES ('2b', 'Lab B', 'T'); " ;
    static String insertIntoSeat11 = "INSERT INTO seat (seatNumber, labid, seatavailability) VALUES ('3b', 'Lab B', 'T'); " ;
    static String insertIntoSeat12 = "INSERT INTO seat (seatNumber, labid, seatavailability) VALUES ('4b', 'Lab B', 'T'); " ;
    static String insertIntoSeat13 = "INSERT INTO seat (seatNumber, labid, seatavailability) VALUES ('5b', 'Lab B', 'T'); " ;
    static String insertIntoSeat14 = "INSERT INTO seat (seatNumber, labid, seatavailability) VALUES ('6b', 'Lab B', 'T'); " ;
    static String insertIntoSeat15 = "INSERT INTO seat (seatNumber, labid, seatavailability) VALUES ('7b', 'Lab B', 'T'); " ;
    static String insertIntoSeat16 = "INSERT INTO seat (seatNumber, labid, seatavailability) VALUES ('8b', 'Lab B', 'T'); " ;

    static String insertIntoSeat17 = "INSERT INTO seat (seatNumber, labid, seatavailability) VALUES ('1c', 'Lab C', 'T'); " ;
    static String insertIntoSeat18 = "INSERT INTO seat (seatNumber, labid, seatavailability) VALUES ('2c', 'Lab C', 'T'); " ;
    static String insertIntoSeat19 = "INSERT INTO seat (seatNumber, labid, seatavailability) VALUES ('3c', 'Lab C', 'T'); " ;
    static String insertIntoSeat20 = "INSERT INTO seat (seatNumber, labid, seatavailability) VALUES ('4c', 'Lab C', 'T'); " ;
    static String insertIntoSeat21 = "INSERT INTO seat (seatNumber, labid, seatavailability) VALUES ('5c', 'Lab C', 'T'); " ;
    static String insertIntoSeat22 = "INSERT INTO seat (seatNumber, labid, seatavailability) VALUES ('6c', 'Lab C', 'T'); " ;
    static String insertIntoSeat23 = "INSERT INTO seat (seatNumber, labid, seatavailability) VALUES ('7c', 'Lab C', 'T'); " ;
    static String insertIntoSeat24 = "INSERT INTO seat (seatNumber, labid, seatavailability) VALUES ('8c', 'Lab C', 'T'); " ;

    static String insertIntoSeat25 = "INSERT INTO seat (seatNumber, labid, seatavailability) VALUES ('1d', 'Lab D', 'T'); " ;
    static String insertIntoSeat26 = "INSERT INTO seat (seatNumber, labid, seatavailability) VALUES ('2d', 'Lab D', 'T'); " ;
    static String insertIntoSeat27 = "INSERT INTO seat (seatNumber, labid, seatavailability) VALUES ('3d', 'Lab D', 'T'); " ;
    static String insertIntoSeat28 =  "INSERT INTO seat (seatNumber, labid, seatavailability) VALUES ('4d', 'Lab D', 'T'); " ;
    static String insertIntoSeat29 = "INSERT INTO seat (seatNumber, labid, seatavailability) VALUES ('5d', 'Lab D', 'T'); " ;
    static String insertIntoSeat30 = "INSERT INTO seat (seatNumber, labid, seatavailability) VALUES ('6d', 'Lab D', 'T'); " ;
    static String insertIntoSeat31 = "INSERT INTO seat (seatNumber, labid, seatavailability) VALUES ('7d', 'Lab D', 'T'); " ;
    static String insertIntoSeat32 = "INSERT INTO seat (seatNumber, labid, seatavailability) VALUES ('8d', 'Lab D', 'T'); " ;

    static String insertIntoBooking1 = "INSERT INTO booking (bookingid, studentnumber, bookingdate, starttime, endtime, labid, seatnumber) VALUES ('VS6MFH', '219024979', '5 July 2021', '10:05 - 11.05', '10:05 - 11.05', 'Lab A','2a'); ";
    static String insertIntoBooking2 = "INSERT INTO booking (bookingid, studentnumber, bookingdate, starttime, endtime, labid, seatnumber) VALUES ('VR5JUY', '219132488', '5 July 2021', '9.00 - 10.00', '9.00 - 10.00', 'Lab A','1a'); ";



    public static void createTables(){

        Connection con;

        try{
            //connect to db
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/computerlabbookingsystem", "root", "admin");
            
            //create all tables
            Statement stmt = con.createStatement();
            
            stmt.execute(dropTableIfExist);
            stmt.execute(createStudentTab);
            stmt.execute(createCovidTab);
            stmt.execute(createAddressTab);
            stmt.execute(createBuildingTab);
            stmt.execute(createCompLabTab);
            stmt.execute(createSeatTab);
            stmt.execute(createBookingTab);
            JOptionPane.showMessageDialog(null, "Tables created", "Connection created", JOptionPane.INFORMATION_MESSAGE);

            //close connection
            con.close();
            JOptionPane.showMessageDialog(null, "Connection created and closed", "Connection created", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){

            JOptionPane.showMessageDialog(null, "Booking.java line 419   " + e.getMessage(), "No Connection", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    

    public static void insertIntoStudentTab(){

        Connection con;

        try{
            //connect to db
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/computerlabbookingsystem", "root", "admin");
            
            //create all tables
            Statement stmt = con.createStatement();
            
            stmt.execute(insertIntoStud);
            stmt.execute(insertIntoStud2);
            stmt.execute(insertIntoStud3);
            stmt.execute(insertIntoStud4);
            stmt.execute(insertIntoStud5);
            stmt.execute(insertIntoStud6);
            stmt.execute(insertIntoStud7);
            
            JOptionPane.showMessageDialog(null, "Inserted into Student", "Connection created", JOptionPane.INFORMATION_MESSAGE);

            //close connection
            con.close();
            JOptionPane.showMessageDialog(null, "Connection created and closed", "Connection created", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){

            JOptionPane.showMessageDialog(null, "Booking.java line 419   " + e.getMessage(), "No Connection", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    

    public static void insertIntoAddressTab(){

        Connection con;

        try{
            //connect to db
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/computerlabbookingsystem", "root", "admin");
            
            //create all tables
            Statement stmt = con.createStatement();
            
            stmt.execute(insertIntoAdd);
            stmt.execute(insertIntoAdd2);
            stmt.execute(insertIntoAdd3);
            
            JOptionPane.showMessageDialog(null, "Inserted into Address", "Connection created", JOptionPane.INFORMATION_MESSAGE);

            //close connection
            con.close();
            JOptionPane.showMessageDialog(null, "Connection created and closed", "Connection created", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){

            JOptionPane.showMessageDialog(null, "Booking.java line 419   " + e.getMessage(), "No Connection", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void insertIntoBuildingTab(){

        Connection con;

        try{
            //connect to db
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/computerlabbookingsystem", "root", "admin");
            
            //create all tables
            Statement stmt = con.createStatement();
            
            stmt.execute(insertIntoBuild);
            stmt.execute(insertIntoBuild2);
            stmt.execute(insertIntoBuild3);
            
            JOptionPane.showMessageDialog(null, "Inserted into Building", "Connection created", JOptionPane.INFORMATION_MESSAGE);

            //close connection
            con.close();
            JOptionPane.showMessageDialog(null, "Connection created and closed", "Connection created", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){

            JOptionPane.showMessageDialog(null, "Booking.java line 419   " + e.getMessage(), "No Connection", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void insertIntoCompLabTab(){

        Connection con;

        try{
            //connect to db
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/computerlabbookingsystem", "root", "admin");
            
            //create all tables
            Statement stmt = con.createStatement();
            
            stmt.execute(insertIntoCompLab);
            stmt.execute(insertIntoCompLab2);
            stmt.execute(insertIntoCompLab3);
            stmt.execute(insertIntoCompLab4);
            
            JOptionPane.showMessageDialog(null, "Inserted into CompLab", "Connection created", JOptionPane.INFORMATION_MESSAGE);

            //close connection
            con.close();
            JOptionPane.showMessageDialog(null, "Connection created and closed", "Connection created", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){

            JOptionPane.showMessageDialog(null, "Booking.java line 419   " + e.getMessage(), "No Connection", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public static void insertIntoSeatTab(){

        Connection con;

        try{
            //connect to db
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/computerlabbookingsystem", "root", "admin");
            
            //create all tables
            Statement stmt = con.createStatement();
            
            stmt.execute(insertIntoSeat);
            stmt.execute(insertIntoSeat2);
            stmt.execute(insertIntoSeat3);
            stmt.execute(insertIntoSeat4);
            stmt.execute(insertIntoSeat5);
            stmt.execute(insertIntoSeat6);
            stmt.execute(insertIntoSeat7);
            stmt.execute(insertIntoSeat8);
            stmt.execute(insertIntoSeat9);
            stmt.execute(insertIntoSeat10);
            stmt.execute(insertIntoSeat11);
            stmt.execute(insertIntoSeat12);
            stmt.execute(insertIntoSeat13);
            stmt.execute(insertIntoSeat14);
            stmt.execute(insertIntoSeat15);
            stmt.execute(insertIntoSeat16);
            stmt.execute(insertIntoSeat17);
            stmt.execute(insertIntoSeat18);
            stmt.execute(insertIntoSeat19);
            stmt.execute(insertIntoSeat20);
            stmt.execute(insertIntoSeat21);
            stmt.execute(insertIntoSeat22);
            stmt.execute(insertIntoSeat23);
            stmt.execute(insertIntoSeat24);
            stmt.execute(insertIntoSeat25);
            stmt.execute(insertIntoSeat26);
            stmt.execute(insertIntoSeat27);
            stmt.execute(insertIntoSeat28);
            stmt.execute(insertIntoSeat29);
            stmt.execute(insertIntoSeat30);
            stmt.execute(insertIntoSeat31);
            stmt.execute(insertIntoSeat32);
            
            JOptionPane.showMessageDialog(null, "Inserted into Seat", "Connection created", JOptionPane.INFORMATION_MESSAGE);

            //close connection
            con.close();
            JOptionPane.showMessageDialog(null, "Connection created and closed", "Connection created", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){

            JOptionPane.showMessageDialog(null, "Booking.java line 393  " + e.getMessage(), "No Connection", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void insertIntoBookingTab(){

        Connection con;

        try{
            //connect to db
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/computerlabbookingsystem", "root", "admin");
            
            //create all tables
            Statement stmt = con.createStatement();
            
            stmt.execute(insertIntoBooking1);
            stmt.execute(insertIntoBooking2);
            
            JOptionPane.showMessageDialog(null, "Inserted into Booking", "Connection created", JOptionPane.INFORMATION_MESSAGE);

            //close connection
            con.close();
            JOptionPane.showMessageDialog(null, "Connection created and closed", "Connection created", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){

            JOptionPane.showMessageDialog(null, "Booking.java line 419  " + e.getMessage(), "No Connection", JOptionPane.INFORMATION_MESSAGE);
        }
    }



}