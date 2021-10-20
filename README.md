# Java Client application

A client application for the Computer Lab E-Management Application (LEMA).

To see the Server application, see [https://github.com/mavu072/ADP-Assignment-3-Group-15.git].

### How to use app:

Computer Preconditions (before running the app):

1.) IntelliJ with mysql 0.4.0 extension enabled

2.) Java dev. kit extension

3.) Have a mySQl installed and set up with a connection called localhost; Account-> Username: root; Password: admin

4.) If IntelliJ can't connect to localhost
    - open MySQL Installer
      MySQL Server Reconfigure -> Authentication Method -> Use Legacy Authentication Method

    OR
    - in a sql script run 
      ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'password'
      
5.) Set up a DB called ComputerLabBookingSystem (lowercase)

6.) Be connected to DB before running app.


### Project information
Project is created with the following:
* Maven
* JDK version 16
* JUnit5 version 5.7.1
