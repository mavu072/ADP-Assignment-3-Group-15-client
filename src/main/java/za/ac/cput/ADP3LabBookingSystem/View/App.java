package za.ac.cput.ADP3LabBookingSystem.View;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import za.ac.cput.ADP3LabBookingSystem.Entity.ComputerLab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Map;

public class App {

    private static OkHttpClient client = new OkHttpClient();

    private static String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().toString();
        }
    }

    public static void getAll() {
        final String URL = "http://localhost:8090/computerlab/getall";
        try {
            String responseBody = run(URL);
            JSONArray computerLabs = new JSONArray(responseBody);

            for (int i = 0; i < computerLabs.length(); i++) {
                JSONObject computerLab = computerLabs.getJSONObject(i);

                Gson g = new Gson();
                ComputerLab c =g.fromJson(computerLab.toString(), ComputerLab.class);
                System.out.println(c.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /************************************************** GUI CODE ****************************************************/
    //                                                              //
    //  Code is really long - better to just run the main.java source//

    static JFrame loginFrame;
    static JFrame bookingFrame;
    static JFrame confirmationFrame;
    static JFrame presenceFrame;
    static JLabel lblIcon;

    static final Color DARKER_BLUE = new Color(0, 107, 255);
    static final Color LIGHT_BLUE = new Color(36, 145, 255);
    static final Color VERY_LIGHT_BLUE = new Color(178, 244, 238);
    static final Color WHITE = new Color(255, 255, 255);
    static final Font FTHEADING = new Font("Belleza", Font.BOLD, 19);
    static final Font FTTEXT = new Font("Belleza", Font.BOLD, 13);
    static final Font FTTEXT3 = new Font("Belleza", Font.BOLD, 14);

    static JComboBox chCompStation;
    static JComboBox chCompLab;
    static JComboBox chTemp;
    static JComboBox chDate;
    static JComboBox chChooseTime;

    public static void closeLoginGUI() {
        loginFrame.dispose();
    }

    public static void closePresenceGUI() {
        presenceFrame.dispose();
    }

    public static void createPresenceGUI() {
        //create jframe
        presenceFrame = new JFrame("Computer Lab Booking System v.01");
        presenceFrame.setSize(600, 500);
        presenceFrame.setLocationRelativeTo(null);
        presenceFrame.setResizable(false);
        presenceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //create main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        //create other panels & Components
        JPanel panelNorth = new JPanel();
        JPanel panelContent = new JPanel();
        JPanel panelSouth = new JPanel();

        //create north components
        panelNorth.setBackground(WHITE);
        panelNorth.setLayout(new GridLayout(2, 1));
        JLabel lblHeading = new JLabel("Please enter code given by Supervisor.", SwingConstants.CENTER);
        lblHeading.setFont(FTHEADING);
        //JLabel lblEmpty1 = new JLabel(" ");
        JLabel lblIcon = new JLabel(new ImageIcon("clock.jpg"), SwingConstants.CENTER);

        //panelNorth.add(lblEmpty1);
        panelNorth.add(lblHeading);
        panelNorth.add(lblIcon);


        //create content panel components
        panelContent.setBackground(WHITE);
        panelContent.setLayout(new GridLayout(4, 3));
        JLabel lblEmpty2 = new JLabel("");
        JLabel lblEmpty3 = new JLabel("");
        JLabel lblEmpty4 = new JLabel("");
        JLabel lblBookingID = new JLabel("Booking ID:", SwingConstants.CENTER);
        lblBookingID.setFont(FTTEXT);
        JTextField txtBookingID = new JTextField(50);
        JLabel lblEmpty5 = new JLabel("");
        JLabel lblSupervisorCode = new JLabel("Supervisor Code:", SwingConstants.CENTER);
        lblSupervisorCode.setFont(FTTEXT);
        JTextField txtSupervisorCode = new JTextField(50);
        JLabel lblEmpty6 = new JLabel("");


        panelContent.add(lblEmpty2);
        panelContent.add(lblEmpty3);
        panelContent.add(lblEmpty4);
        panelContent.add(lblBookingID);
        panelContent.add(txtBookingID);
        panelContent.add(lblEmpty5);
        panelContent.add(lblSupervisorCode);
        panelContent.add(txtSupervisorCode);
        panelContent.add(lblEmpty6);

        //create south panel components
        panelSouth.setBackground(WHITE);
        panelSouth.setLayout(new GridLayout(2, 3, 5, 5));
        panelSouth.setBorder(BorderFactory.createEmptyBorder(5, 0, 20, 0));
        JLabel lblEmpty7 = new JLabel("");
        JButton btConfirmPresence = new JButton("CONFIRM PRESENCE");
        btConfirmPresence.setFont(FTTEXT);
        JLabel lblEmpty8 = new JLabel("");
        JLabel lblEmpty9 = new JLabel("");
        JButton btExit = new JButton("EXIT");
        btExit.setFont(FTTEXT);
        JLabel lblEmpty10 = new JLabel("");
        panelSouth.add(lblEmpty7);
        panelSouth.add(btConfirmPresence);
        panelSouth.add(lblEmpty8);
        panelSouth.add(lblEmpty9);
        panelSouth.add(btExit);
        panelSouth.add(lblEmpty10);

        //actionlisteners
        btConfirmPresence.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //validate user infor

                //if valid open - confirm booking was made.
                JPanel panel = new JPanel();
                JLabel lblPresenceConfirmed = new JLabel("Presence Confirmed. Booking saved.");
                panel.add(lblPresenceConfirmed);
                JOptionPane.showConfirmDialog(null, panel, "Presence Confirmed", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null);
                closePresenceGUI();
                createLoginGUI();
            }
        });

        btExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                closePresenceGUI();
                createLoginGUI();
            }
        });


        //set jframe visible
        presenceFrame.getContentPane().add(panelNorth, BorderLayout.NORTH);
        presenceFrame.getContentPane().add(panelContent);
        presenceFrame.getContentPane().add(panelSouth, BorderLayout.SOUTH);
        presenceFrame.setVisible(true);
    }

    public static void createAppPreconditionGUI() {
        //create jframe
        presenceFrame = new JFrame("Computer Lab Booking System v.01");
        presenceFrame.setSize(600, 500);
        presenceFrame.setLocationRelativeTo(null);
        presenceFrame.setResizable(false);
        presenceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //create main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        //create other panels & Components
        JPanel panelNorth = new JPanel();
        JPanel panelContent = new JPanel();
        JPanel panelSouth = new JPanel();

        //create north components
        panelNorth.setBackground(WHITE);
        panelNorth.setLayout(new GridLayout(2, 1));
        JLabel lblHeading = new JLabel("Please make sure you have the following in order to use our App:", SwingConstants.CENTER);
        lblHeading.setFont(FTHEADING);
        //JLabel lblEmpty1 = new JLabel(" ");
        JLabel lblIcon = new JLabel(new ImageIcon("lab_icon4.png"), SwingConstants.CENTER);

        //panelNorth.add(lblEmpty1);
        panelNorth.add(lblHeading);
        panelNorth.add(lblIcon);


        //create content panel components
        panelContent.setBackground(WHITE);
        panelContent.setLayout(new GridLayout(6, 2));
        JLabel lblEmpty2 = new JLabel("");
        JLabel lblEmpty3 = new JLabel("");
        JLabel lblEmpty4 = new JLabel("");

        JLabel lblBookingID = new JLabel("MySQL Installed:    ", SwingConstants.RIGHT);
        lblBookingID.setFont(FTTEXT);
        JLabel lblShowBookingID = new JLabel("localhost connection.");
        JLabel lblEmpty5 = new JLabel("");
        lblShowBookingID.setFont(FTTEXT);

        JLabel lblCompLab = new JLabel("MySQL Settings:    ", SwingConstants.RIGHT);
        lblCompLab.setFont(FTTEXT);
        JLabel lblShowCompLab = new JLabel("Username: root; Psw: admin");
        lblShowCompLab.setFont(FTTEXT);
        JLabel lblEmpty6 = new JLabel("");

        JLabel lblBookingDate = new JLabel("Connected to a local DB called:    ", SwingConstants.RIGHT);
        lblBookingDate.setFont(FTTEXT);
        JLabel lblShowBookingDate = new JLabel("ComputerLabBookingSystem");
        lblShowBookingDate.setFont(FTTEXT);
        JLabel lblEmpty7 = new JLabel("");

        JLabel lblBookingTime = new JLabel("To log into application:    ", SwingConstants.RIGHT);
        lblBookingTime.setFont(FTTEXT);
        JLabel lblShowBookingTime = new JLabel("Std Nr: Your Student Nr; Psw: admin");
        lblShowBookingTime.setFont(FTTEXT);
        JLabel lblEmpty8 = new JLabel("<booking time>");

        panelContent.add(lblEmpty2);
        panelContent.add(lblEmpty3);
        //panelContent.add(lblEmpty4);

        panelContent.add(lblBookingID);
        panelContent.add(lblShowBookingID);
        //panelContent.add(lblEmpty5);

        panelContent.add(lblCompLab);
        panelContent.add(lblShowCompLab);
        //panelContent.add(lblEmpty6);

        panelContent.add(lblBookingDate);
        panelContent.add(lblShowBookingDate);
        //panelContent.add(lblEmpty7);

        panelContent.add(lblBookingTime);
        panelContent.add(lblShowBookingTime);
        //panelContent.add(lblEmpty8);

        //create south panel components
        panelSouth.setBackground(WHITE);
        panelSouth.setLayout(new GridLayout(2, 3, 5, 5));
        panelSouth.setBorder(BorderFactory.createEmptyBorder(5, 0, 20, 0));
        JLabel lblEmpty9 = new JLabel("");
        JButton btBookAnother = new JButton("Continue to App");
        btBookAnother.setFont(FTTEXT);
        JLabel lblEmpty10 = new JLabel("");
        JLabel lblEmpty11 = new JLabel("");
        JButton btExit = new JButton("EXIT");
        btExit.setFont(FTTEXT);
        JLabel lblEmpty12 = new JLabel("");
        panelSouth.add(lblEmpty9);
        panelSouth.add(btBookAnother);
        panelSouth.add(lblEmpty10);
        panelSouth.add(lblEmpty11);
        panelSouth.add(btExit);
        panelSouth.add(lblEmpty12);

        //actionlisteners
        btBookAnother.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                presenceFrame.dispose();
                createLoginGUI();
            }
        });

        btExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                presenceFrame.dispose();
            }
        });


        //set jframe visible
        presenceFrame.getContentPane().add(panelNorth, BorderLayout.NORTH);
        presenceFrame.getContentPane().add(panelContent);
        presenceFrame.getContentPane().add(panelSouth, BorderLayout.SOUTH);
        presenceFrame.setVisible(true);
    }

    public static void createLoginGUI() {
        //create jframe
        loginFrame = new JFrame("Computer Lab Booking System v.01");
        loginFrame.setSize(600, 500);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setResizable(false);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //create main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        //create other panels & Components
        JPanel panelNorth = new JPanel();
        JPanel panelContent = new JPanel();
        JPanel panelSouth = new JPanel();

        //create north components
        panelNorth.setBackground(WHITE);
        panelNorth.setLayout(new GridLayout(2, 1));
        JLabel lblHeading = new JLabel("Computer Lab Booking System v.01", SwingConstants.CENTER);
        lblHeading.setFont(FTHEADING);
        //JLabel lblEmpty1 = new JLabel(" ");
        JLabel lblIcon = new JLabel(new ImageIcon("lab_icon4.png"), SwingConstants.CENTER);

        //panelNorth.add(lblEmpty1);
        panelNorth.add(lblHeading);
        panelNorth.add(lblIcon);


        //create content panel components
        panelContent.setBackground(WHITE);
        panelContent.setLayout(new GridLayout(4, 3));
        JLabel lblEmpty2 = new JLabel("");
        JLabel lblEmpty3 = new JLabel("");
        JLabel lblEmpty4 = new JLabel("");
        JLabel lblStudentNr = new JLabel("Student Nr.:", SwingConstants.CENTER);
        lblStudentNr.setFont(FTTEXT);
        final JTextField txtStudentNr = new JTextField(50);
        JLabel lblEmpty5 = new JLabel("");
        JLabel lblPassword = new JLabel("Password:", SwingConstants.CENTER);
        lblPassword.setFont(FTTEXT);
        final JPasswordField txtPassword = new JPasswordField(50);
        JLabel lblEmpty6 = new JLabel("");

        panelContent.add(lblEmpty2);
        panelContent.add(lblEmpty3);
        panelContent.add(lblEmpty4);
        panelContent.add(lblStudentNr);
        panelContent.add(txtStudentNr);
        panelContent.add(lblEmpty5);
        panelContent.add(lblPassword);
        panelContent.add(txtPassword);
        panelContent.add(lblEmpty6);

        //create south panel components
        panelSouth.setBackground(WHITE);
        panelSouth.setLayout(new GridLayout(2, 3, 5, 5));
        panelSouth.setBorder(BorderFactory.createEmptyBorder(5, 0, 20, 0));
        JLabel lblEmpty7 = new JLabel("");
        JButton btLogin = new JButton("LOGIN");
        btLogin.setFont(FTTEXT);
        JLabel lblEmpty8 = new JLabel("");
        JLabel lblEmpty9 = new JLabel("");
        JButton btConfirmPresence = new JButton("Confirm Presence");
        btConfirmPresence.setFont(FTTEXT);
        JLabel lblEmpty10 = new JLabel("");
        panelSouth.add(lblEmpty7);
        panelSouth.add(btLogin);
        panelSouth.add(lblEmpty8);
        panelSouth.add(lblEmpty9);
        panelSouth.add(btConfirmPresence);
        panelSouth.add(lblEmpty10);


        //actionlisteners
        btLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //check if std nr / password is empty
                if (txtStudentNr.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Student Nr: is empty.");
                    closeLoginGUI();
                    createLoginGUI();
                } else if (txtPassword.getPassword().length == 0) {
                    JOptionPane.showMessageDialog(null, "Password: is empty:");
                    closeLoginGUI();
                    createLoginGUI();
                } else {
                    //validate user information
                    //get form data
                    String stdnr = txtStudentNr.getText();
                    String psw = txtPassword.getText();

                    boolean stdExists, pswCorrect = false;

                    String sql;
                    Statement stmt;
                    ResultSet rs;
                    //search database
                    Connection con;
                    try {
                        //connect to db
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/computerlabbookingsystem", "root", "admin");

                        //check if std nr exists
                        sql = "SELECT studentnumber FROM Student WHERE studentnumber = '" + stdnr + "';";
                        stmt = con.createStatement();
                        rs = stmt.executeQuery(sql);
                        stdExists = rs.next();

                        if (stdExists) {
                            //check password
                            sql = "SELECT password FROM Student WHERE studentnumber = '" + stdnr + "';";
                            stmt = con.createStatement();
                            rs = stmt.executeQuery(sql);
                            while (rs.next()) {
                                pswCorrect = rs.getString("password").contentEquals(psw);
                            }
                            if (pswCorrect) {
                                //save stdnum to session
                                final String sessionStdNum = stdnr;
                                //allow to login
                                closeLoginGUI();
                                createBookingGUI();
                            } else {
                                JOptionPane.showMessageDialog(null, "Password Invalid");
                                txtPassword.setText("");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Student Number Invalid");
                            txtStudentNr.setText("");
                        }

                        //close connection
                        stmt.close();
                        rs.close();
                        con.close();
                    } catch (Exception a) {

                        JOptionPane.showMessageDialog(null, a.getMessage(), "Error: ", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });

        btConfirmPresence.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                closeLoginGUI();
                createPresenceGUI();
            }
        });


        //set jframe visible
        loginFrame.getContentPane().add(panelNorth, BorderLayout.NORTH);
        loginFrame.getContentPane().add(panelContent);
        loginFrame.getContentPane().add(panelSouth, BorderLayout.SOUTH);
        loginFrame.setVisible(true);
    }


    public static void closeBookingGUI() {

        bookingFrame.dispose();
    }

    public static void closeConfirmationGUI() {

        confirmationFrame.dispose();
        bookingFrame.dispose();
        createLoginGUI();
    }

    public static void createConfirmationGUI(String bookingId, String compLab, String compStation, String bookDate, String bookTime) {

        //create jframe
        confirmationFrame = new JFrame("Computer Lab Booking System v.01");
        confirmationFrame.setSize(600, 500);
        confirmationFrame.setLocationRelativeTo(null);
        confirmationFrame.setResizable(false);
        confirmationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //create main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        //create other panels & Components
        JPanel panelNorth = new JPanel();
        JPanel panelContent = new JPanel();
        JPanel panelSouth = new JPanel();

        //create north components
        panelNorth.setBackground(WHITE);
        panelNorth.setLayout(new GridLayout(2, 1));
        JLabel lblHeading = new JLabel("Booking Successfully Created!", SwingConstants.CENTER);
        lblHeading.setFont(FTHEADING);
        //JLabel lblEmpty1 = new JLabel(" ");
        JLabel lblIcon = new JLabel(new ImageIcon("tenor.gif"), SwingConstants.CENTER);

        //panelNorth.add(lblEmpty1);
        panelNorth.add(lblHeading);
        panelNorth.add(lblIcon);


        //create content panel components
        panelContent.setBackground(WHITE);
        panelContent.setLayout(new GridLayout(6, 2));
        JLabel lblEmpty2 = new JLabel("");
        JLabel lblEmpty3 = new JLabel("");
        JLabel lblEmpty4 = new JLabel("");

        JLabel lblBookingID = new JLabel("Booking ID:    ", SwingConstants.RIGHT);
        lblBookingID.setFont(FTTEXT);
        JLabel lblShowBookingID = new JLabel(bookingId);
        JLabel lblEmpty5 = new JLabel("");
        lblShowBookingID.setFont(FTTEXT);

        JLabel lblCompLab = new JLabel("Computer Lab:    ", SwingConstants.RIGHT);
        lblCompLab.setFont(FTTEXT);
        JLabel lblShowCompLab = new JLabel(compLab);
        lblShowCompLab.setFont(FTTEXT);
        JLabel lblEmpty6 = new JLabel("");

        JLabel lblCompSeat = new JLabel("Computer Seat:    ", SwingConstants.RIGHT);
        lblCompSeat.setFont(FTTEXT);
        JLabel lblShowCompSeat = new JLabel(compStation);
        lblShowCompSeat.setFont(FTTEXT);
        JLabel lblEmpty13 = new JLabel("");

        JLabel lblBookingDate = new JLabel("Booking Date:    ", SwingConstants.RIGHT);
        lblBookingDate.setFont(FTTEXT);
        JLabel lblShowBookingDate = new JLabel(bookDate);
        lblShowBookingDate.setFont(FTTEXT);
        JLabel lblEmpty7 = new JLabel("");

        JLabel lblBookingTime = new JLabel("Booking Time:    ", SwingConstants.RIGHT);
        lblBookingTime.setFont(FTTEXT);
        JLabel lblShowBookingTime = new JLabel(bookTime);
        lblShowBookingTime.setFont(FTTEXT);
        JLabel lblEmpty8 = new JLabel("");

        panelContent.add(lblEmpty3);
        panelContent.add(lblEmpty2);
        //panelContent.add(lblEmpty4);

        panelContent.add(lblBookingID);
        panelContent.add(lblShowBookingID);
        //panelContent.add(lblEmpty5);

        panelContent.add(lblCompLab);
        panelContent.add(lblShowCompLab);
        //panelContent.add(lblEmpty6);

        panelContent.add(lblBookingDate);
        panelContent.add(lblShowBookingDate);
        //panelContent.add(lblEmpty7);

        panelContent.add(lblBookingTime);
        panelContent.add(lblShowBookingTime);
        //panelContent.add(lblEmpty8);

        //create south panel components
        panelSouth.setBackground(WHITE);
        panelSouth.setLayout(new GridLayout(2, 3, 5, 5));
        panelSouth.setBorder(BorderFactory.createEmptyBorder(5, 0, 20, 0));
        JLabel lblEmpty9 = new JLabel("");
        JButton btBookAnother = new JButton("Book Another Session");
        btBookAnother.setFont(FTTEXT);
        JLabel lblEmpty10 = new JLabel("");
        JLabel lblEmpty11 = new JLabel("");
        JButton btExit = new JButton("EXIT");
        btExit.setFont(FTTEXT);
        JLabel lblEmpty12 = new JLabel("");
        panelSouth.add(lblEmpty9);
        panelSouth.add(btBookAnother);
        panelSouth.add(lblEmpty10);
        panelSouth.add(lblEmpty11);
        panelSouth.add(btExit);
        panelSouth.add(lblEmpty12);

        //actionlisteners
        btBookAnother.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                closeConfirmationGUI();
                closeBookingGUI();
                createBookingGUI();
            }
        });

        btExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                closeConfirmationGUI();
            }
        });

        //set jframe visible
        confirmationFrame.getContentPane().add(panelNorth, BorderLayout.NORTH);
        confirmationFrame.getContentPane().add(panelContent);
        confirmationFrame.getContentPane().add(panelSouth, BorderLayout.SOUTH);
        confirmationFrame.setVisible(true);
    }

    public static String getAlphaNumericString(int n) {

        // choose a random character from this string
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        //
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }


    public static void createBookingGUI() {
        //create jframe
        bookingFrame = new JFrame("Computer Lab Booking System v.01");
        bookingFrame.setSize(600, 520);
        bookingFrame.setLocationRelativeTo(null);
        bookingFrame.setResizable(false);
        bookingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //create main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        //create other panels & Components
        JPanel panelNorth = new JPanel();
        JPanel panelContent = new JPanel();
        JPanel panelSouth = new JPanel();

        //create north components
        panelNorth.setBackground(VERY_LIGHT_BLUE);
        panelNorth.setLayout(new GridLayout(3, 1, 5, 6));
        panelNorth.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 0));
        JLabel lblHeading = new JLabel("Computer Lab Booking System v.01", SwingConstants.CENTER);
        lblHeading.setFont(FTHEADING);
        //set lblHeading underline
        Font font = lblHeading.getFont();

        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        lblHeading.setFont(font.deriveFont(attributes));
        JLabel lblWelcome = new JLabel("Welcome, <Student Name>", SwingConstants.LEFT);
        lblWelcome.setFont(FTTEXT);
        JLabel lblFollowPrompt = new JLabel("To book a computer station, please follow the prompts below:", SwingConstants.LEFT);
        lblFollowPrompt.setFont(FTTEXT);

        //panelNorth.add(lblEmpty1);
        panelNorth.add(lblHeading);
        panelNorth.add(lblWelcome);
        panelNorth.add(lblFollowPrompt);


        //create content panel components
        panelContent.setBackground(WHITE);
        panelContent.setLayout(new GridLayout(9, 3, 3, 0));
        panelContent.setBorder(BorderFactory.createEmptyBorder(15, 3, 0, 3));


        //JLabel lblEmpty0a = new JLabel("");
        //JLabel lblEmpty0b = new JLabel("");
        //JLabel lblEmpty0c = new JLabel("");

        JLabel lblStudentNr = new JLabel("Student Nr.:", SwingConstants.CENTER);
        lblStudentNr.setFont(FTTEXT);
        final JTextField txtStudentNr = new JTextField(50);
        JLabel lblEmpty2 = new JLabel("");


        JLabel lblTemperature = new JLabel("Present Temperature:", SwingConstants.CENTER);
        lblTemperature.setFont(FTTEXT);
        String[] temps = {"Lower than 35.5°C", "35.5°C - 35.9°C", "36°C - 36.9°C", "37°C - 37.7°C"};
        chTemp = new JComboBox(temps);
        chTemp.setBounds(100, 100, 75, 75);
        JLabel lblEmpty3 = new JLabel("");


        JLabel lblSymptoms = new JLabel("Present Symptoms:", SwingConstants.CENTER);
        lblSymptoms.setFont(FTTEXT);
        final JTextField txtSymptoms = new JTextField(50);
        JLabel lblEmpty4 = new JLabel("");


        JLabel lblChooseLab = new JLabel("Choose a Computer Lab:", SwingConstants.CENTER);
        lblChooseLab.setFont(FTTEXT);
        String[] compLabs = {"Lab A - D6 Engin. Building. Room 1.1", "Lab B - D6 Engin. Building. Room 1.2", "Lab C - D6 Engin. Building. Room 1.3", "Lab D - D6 Engin. Building. Room 1.5"};
        chCompLab = new JComboBox(compLabs);
        JLabel lblEmpty5 = new JLabel("");


        JLabel lblChooseDate = new JLabel("Choose date:", SwingConstants.CENTER);
        lblChooseDate.setFont(FTTEXT);
        String[] labDates = {"5 July 2021", "6 July 2021", "7 July 2021", "8 July 2021", "9 July 2021", "12 July 2021", "13 July 2021", "14 July 2021", "15 July 2021", "16 July 2021", "19 July 2021", "20 July 2021", "21 July 2021", "22 July 2021", "23 July 2021", "26 July 2021", "27 July 2021", "28 July 2021", "29 July 2021", "30 July 2021"};
        chDate = new JComboBox(labDates);
        chDate.setBounds(100, 100, 75, 75);
        JLabel lblEmpty7 = new JLabel("");

        JLabel lblChooseCompStation = new JLabel("Choose a Computer Station:", SwingConstants.CENTER);
        lblChooseCompStation.setFont(FTTEXT);
        String[] compStations = {""};
        chCompStation = new JComboBox(compStations);
        //chCompStation.setBounds(100,100, 75,75);
        JLabel lblEmpty6 = new JLabel("");

        JLabel lblChooseTime = new JLabel("Choose time slot:", SwingConstants.CENTER);
        lblChooseTime.setFont(FTTEXT);
        String[] labTimes = {"9.00 - 10.00", "10.05 - 11.05", "11.10 - 12.10", "12.15 - 13.15", "13.20 - 14.20", "14.25 - 15.25", "15.30 - 16.30", "16.35 - 17.35"};
        chChooseTime = new JComboBox(labTimes);
        chChooseTime.setBounds(100, 100, 75, 75);
        JLabel lblEmpty8 = new JLabel("");


        JLabel lblEmpty9 = new JLabel("");
        JLabel lblEmpty10 = new JLabel("");
        JLabel lblEmpty11 = new JLabel("");


        JButton btClear = new JButton("Clear");
        btClear.setFont(FTTEXT);
        JButton btBook = new JButton("BOOK");
        btBook.setFont(FTTEXT);
        JButton btCancel = new JButton("Cancel");
        btCancel.setFont(FTTEXT);

        //choice box functionality chTemp, chCompLab, chCompStation, chDate, chChooseTime

        //actionlisteners
        chCompLab.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String selected = chCompLab.getSelectedItem().toString();
                if (selected.equalsIgnoreCase("Lab A - D6 Engin. Building. Room 1.1")) {
                    //connect to db and find all comp stations in lab a
                    String sql;
                    Statement stmt;
                    ResultSet rs;
                    //search database
                    Connection con;
                    try {
                        //connect to db
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/computerlabbookingsystem", "root", "admin");

                        //
                        sql = "SELECT seatnumber FROM Seat WHERE labid = 'Lab A' ;";
                        stmt = con.createStatement();
                        rs = stmt.executeQuery(sql);

                        //populate chCompStation with available comp stations
                        chCompStation.removeAllItems();
                        while (rs.next()) {
                            chCompStation.addItem(rs.getString("seatnumber"));
                        }

                        //close connection
                        stmt.close();
                        rs.close();
                        con.close();
                    } catch (Exception a) {
                        JOptionPane.showMessageDialog(null, a.getMessage(), "No Connection", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else if (selected.equalsIgnoreCase("Lab B - D6 Engin. Building. Room 1.2")) {
                    //connect to db and find all comp stations in lab b
                    String sql;
                    Statement stmt;
                    ResultSet rs;
                    //search database
                    Connection con;
                    try {
                        //connect to db
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/computerlabbookingsystem", "root", "admin");
                        //
                        sql = "SELECT seatnumber FROM Seat WHERE labid = 'Lab B' ;";
                        stmt = con.createStatement();
                        rs = stmt.executeQuery(sql);
                        //populate chCompStation with available comp stations
                        chCompStation.removeAllItems();
                        while (rs.next()) {
                            chCompStation.addItem(rs.getString("seatnumber"));
                        }
                        //close connection
                        stmt.close();
                        rs.close();
                        con.close();
                    } catch (Exception a) {
                        JOptionPane.showMessageDialog(null, a.getMessage(), "No Connection", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else if (selected.equalsIgnoreCase("Lab C - D6 Engin. Building. Room 1.3")) {
                    //connect to db and find all comp stations in lab c
                    String sql;
                    Statement stmt;
                    ResultSet rs;
                    //search database
                    Connection con;
                    try {
                        //connect to db
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/computerlabbookingsystem", "root", "admin");
                        //
                        sql = "SELECT seatnumber FROM Seat WHERE labid = 'Lab C' ;";
                        stmt = con.createStatement();
                        rs = stmt.executeQuery(sql);
                        //populate chCompStation with available comp stations
                        chCompStation.removeAllItems();
                        while (rs.next()) {
                            chCompStation.addItem(rs.getString("seatnumber"));
                        }
                        //close connection
                        stmt.close();
                        rs.close();
                        con.close();
                    } catch (Exception a) {
                        JOptionPane.showMessageDialog(null, a.getMessage(), "No Connection", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else if (selected.equalsIgnoreCase("Lab D - D6 Engin. Building. Room 1.5")) {
                    //connect to db and find all comp stations in lab d
                    String sql;
                    Statement stmt;
                    ResultSet rs;
                    //search database
                    Connection con;
                    try {
                        //connect to db
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/computerlabbookingsystem", "root", "admin");
                        //
                        sql = "SELECT seatnumber FROM Seat WHERE labid = 'Lab D' ;";
                        stmt = con.createStatement();
                        rs = stmt.executeQuery(sql);
                        //populate chCompStation with available comp stations
                        chCompStation.removeAllItems();
                        while (rs.next()) {
                            chCompStation.addItem(rs.getString("seatnumber"));
                        }
                        //close connection
                        stmt.close();
                        rs.close();
                        con.close();
                    } catch (Exception a) {
                        JOptionPane.showMessageDialog(null, "App.java Line 819" + a.getMessage(), "No Connection", JOptionPane.INFORMATION_MESSAGE);
                    }
                }

                ;
            }
        });


        chDate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //vars
                String date = (String) chDate.getSelectedItem();
                ArrayList<String> timeslots = new ArrayList<String>();
                ArrayList<String> bookedTimes = new ArrayList<String>();

                timeslots.add("9.00 - 10.00");
                timeslots.add("10.05 - 11.05");
                timeslots.add("11.10 - 12.10");
                timeslots.add("12.15 - 13.15");
                timeslots.add("13.20 - 14.20");
                timeslots.add("14.25 - 15.25");
                timeslots.add("15.30 - 16.30");
                timeslots.add("16.35 - 17.35");


                //search booking table in db for available seats on chosen date
                // the plan: select all seats that match 'date' from db  and display the seats that weren't selected - a.k.a the seats not already booked
                String sql;
                Statement stmt;
                ResultSet rs;
                //search database
                Connection con;
                try {
                    //connect to db
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/computerlabbookingsystem", "root", "admin");
                    //
                    sql = "SELECT starttime FROM Booking WHERE bookingdate = '" + date + "';";
                    stmt = con.createStatement();
                    rs = stmt.executeQuery(sql);
                    //populate chChooseTime with available time slots for that date
                    chChooseTime.removeAllItems();

                    // save result set to arr
                    while (rs.next()) {
                        bookedTimes.add(rs.getString("starttime"));
                    }

                    //bookedTimes.size == 2
                    //timeslots.size == 8
                    //search for timeslots[] for matching times in bookedTimes (when found remove from timeslots)
                    for (int i = 0; i < bookedTimes.size(); i++) {

                        for (int k = 0; k < timeslots.size(); k++) {

                            if (bookedTimes.get(i).contains(timeslots.get(k))) {
                                //JOptionPane.showMessageDialog(null, "Removed: " + bookedTimes.get(i) , "No connection", JOptionPane.INFORMATION_MESSAGE);
                                timeslots.remove(k);
                            }
                        }
                    }

                    //now populate chChooseTime with available times
                    for (int i = 0; i < timeslots.size(); i++) {
                        chChooseTime.addItem(timeslots.get(i));
                    }
                    //close connection
                    stmt.close();
                    rs.close();
                    con.close();
                } catch (Exception a) {

                    JOptionPane.showMessageDialog(null, "App.java Line 895" + a.getMessage(), "No connection", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        chChooseTime.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //vars
                String chosenLab = (String) chCompLab.getSelectedItem();
                String time = (String) chChooseTime.getSelectedItem();
                ArrayList<String> labSeats = new ArrayList<String>();
                ArrayList<String> bookedSeats = new ArrayList<String>();

                labSeats.add("1a");
                labSeats.add("2a");
                labSeats.add("3a");
                labSeats.add("4a");
                labSeats.add("5a");
                labSeats.add("6a");
                labSeats.add("7a");
                labSeats.add("8a");
                labSeats.add("1b");
                labSeats.add("2b");
                labSeats.add("3b");
                labSeats.add("4b");
                labSeats.add("5b");
                labSeats.add("6b");
                labSeats.add("7b");
                labSeats.add("8b");
                labSeats.add("1c");
                labSeats.add("2c");
                labSeats.add("3c");
                labSeats.add("4c");
                labSeats.add("5c");
                labSeats.add("6c");
                labSeats.add("7c");
                labSeats.add("8c");
                labSeats.add("1d");
                labSeats.add("2d");
                labSeats.add("3d");
                labSeats.add("4d");
                labSeats.add("5d");
                labSeats.add("6d");
                labSeats.add("7d");
                labSeats.add("8d");


                //search booking table in db for available seats on chosen timeslot
                // the plan: select all seats that match 'starttime' from db  and display the seats that weren't selected - a.k.a the seats not already booked
                String sql;
                Statement stmt;
                ResultSet rs;
                //search database
                Connection con;
                try {
                    //connect to db
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/computerlabbookingsystem", "root", "admin");
                    //
                    sql = "SELECT seatnumber FROM Booking WHERE starttime = '" + time + "';";
                    stmt = con.createStatement();
                    rs = stmt.executeQuery(sql);
                    //populate chCompStation with available seats for that timeslot
                    chCompStation.removeAllItems();


                    //get all booked seats where  bookedSeats == chChooseTime.getItem().toString()
                    // save result set to arr
                    while (rs.next()) {
                        bookedSeats.add(rs.getString("seatnumber"));
                    }

                    //bookedSeats.size == 2
                    //labseats.size == 32
                    //search for timeslots[] for matching times in bookedTimes (when found remove from timeslots)
                    for (int i = 0; i < bookedSeats.size(); i++) {

                        for (int k = 0; k < labSeats.size(); k++) {

                            if (bookedSeats.get(i).contains(labSeats.get(k))) {
                                labSeats.remove(k);
                            }
                        }
                    }


                    //now populate chCompStation with available seats
                    for (int i = 0; i < labSeats.size(); i++) {
                        //if chosen lab is __ then only populate seat numbers that contains the letter __
                        if (chosenLab.equalsIgnoreCase("Lab A - D6 Engin. Building. Room 1.1")) {

                            if (labSeats.get(i).endsWith("a")) {
                                chCompStation.addItem(labSeats.get(i));
                            }

                        } else if (chosenLab.equalsIgnoreCase("Lab B - D6 Engin. Building. Room 1.2")) {

                            if (labSeats.get(i).endsWith("b")) {
                                chCompStation.addItem(labSeats.get(i));
                            }

                        } else if (chosenLab.equalsIgnoreCase("Lab C - D6 Engin. Building. Room 1.3")) {

                            if (labSeats.get(i).endsWith("c")) {
                                chCompStation.addItem(labSeats.get(i));
                            }

                        } else if (chosenLab.equalsIgnoreCase("Lab D - D6 Engin. Building. Room 1.5")) {

                            if (labSeats.get(i).endsWith("d")) {
                                chCompStation.addItem(labSeats.get(i));
                            }
                        }
                    }
                    //close connection
                    stmt.close();
                    rs.close();
                    con.close();
                } catch (Exception a) {

                    JOptionPane.showMessageDialog(null, "App.java Line 991" + a.getMessage(), "No connection", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });


        btBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //check if std nr / password is empty
                if (txtStudentNr.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Student number: is empty.", "Empty Field", JOptionPane.WARNING_MESSAGE);
                    //closeLoginGUI();
                    //createLoginGUI();
                } else if (txtSymptoms.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Symptoms: is empty.", "Empty Field", JOptionPane.WARNING_MESSAGE);

                } else if (txtStudentNr.getText().length() < 9 || txtStudentNr.getText().length() > 9) {
                    JOptionPane.showMessageDialog(null, "Student Number is too short/long (= 9 digits).", "Empty Field", JOptionPane.WARNING_MESSAGE);

                } else {
                    //validate user information
                    //get form data
                    String stdnr = txtStudentNr.getText();
                    String temp = chTemp.getSelectedItem().toString();
                    String symptoms = txtSymptoms.getText();
                    String compLab = chCompLab.getSelectedItem().toString();

                    if (compLab.charAt(4) == 'A') {
                        compLab = "Lab A";
                    } else if (compLab.charAt(4) == 'B') {
                        compLab = "Lab B";
                    } else if (compLab.charAt(4) == 'C') {
                        compLab = "Lab C";
                    } else if (compLab.charAt(4) == 'D') {
                        compLab = "Lab D";
                    }

                    String compStation = chCompStation.getSelectedItem().toString();
                    String bookDate = chDate.getSelectedItem().toString();
                    String bookTime = chChooseTime.getSelectedItem().toString();

                    PreparedStatement createBooking;
                    Statement stmt;
                    ResultSet rs;
                    //search database

                    //set to database
                    Connection con;
                    try {
                        //connect to db
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/computerlabbookingsystem", "root", "admin");

                        //bookingid, studentnumber, bookingdate, starttime, endtime, labid, seatnumber
                        createBooking = con.prepareStatement("INSERT INTO Booking (bookingid, studentnumber, bookingdate, starttime, endtime, labid, seatnumber) VALUES (?,?,?,?,?,?,?);");

                        String bookingId = getAlphaNumericString(6);
                        createBooking.setString(1, bookingId);
                        createBooking.setString(2, stdnr);
                        createBooking.setString(3, bookDate);
                        createBooking.setString(4, bookTime); //should set start time
                        createBooking.setString(5, bookTime);  // should set end time
                        createBooking.setString(6, compLab);
                        createBooking.setString(7, compStation);
                        createBooking.executeUpdate();

                        //close connection
                        //JOptionPane.showMessageDialog(null, "Booking created", "Booking Created", JOptionPane.INFORMATION_MESSAGE);
                        createBooking.close();
                        con.close();

                        createConfirmationGUI(bookingId, compLab, compStation, bookDate, bookTime);
                    } catch (Exception a) {
                        //If student number does not exist then
                        JOptionPane.showMessageDialog(null, "Student Number does not exist", "No Connection", JOptionPane.INFORMATION_MESSAGE);
                        //and account for other errors

                    }
                }
            }
        });

        btClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                txtStudentNr.setText("");
                chTemp.setSelectedIndex(0);
                ;
                txtSymptoms.setText("");
                chCompLab.setSelectedIndex(0);
                ;
                chCompStation.setSelectedIndex(0);
                ;
                //chDate.setSelectedIndex(0);;
                //chChooseTime.setSelectedIndex(0);;
            }
        });

        btCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                bookingFrame.dispose();
                createLoginGUI();
            }
        });


        //panelContent.add(lblEmpty0a);
        //panelContent.add(lblEmpty0b);
        //panelContent.add(lblEmpty0c);
        panelContent.add(lblStudentNr);
        panelContent.add(txtStudentNr);
        panelContent.add(lblEmpty2);
        panelContent.add(lblTemperature);
        panelContent.add(chTemp);
        panelContent.add(lblEmpty3);
        panelContent.add(lblSymptoms);
        panelContent.add(txtSymptoms);
        panelContent.add(lblEmpty4);
        panelContent.add(lblChooseLab);
        panelContent.add(chCompLab);
        panelContent.add(lblEmpty5);
        panelContent.add(lblChooseDate);
        panelContent.add(chDate);
        panelContent.add(lblEmpty7);
        panelContent.add(lblChooseTime);
        panelContent.add(chChooseTime);
        panelContent.add(lblEmpty8);
        panelContent.add(lblChooseCompStation);
        panelContent.add(chCompStation);
        panelContent.add(lblEmpty6);
        panelContent.add(lblEmpty9);
        panelContent.add(lblEmpty10);
        panelContent.add(lblEmpty11);
        panelContent.add(btClear);
        panelContent.add(btBook);
        panelContent.add(btCancel);


        //create south panel components
        panelSouth.setBackground(VERY_LIGHT_BLUE);
        panelSouth.setLayout(new GridLayout(4, 1));
        panelSouth.setBorder(BorderFactory.createEmptyBorder(5, 0, 10, 0));
        JLabel lblPleaseNote = new JLabel("Please Note:");
        lblPleaseNote.setFont(FTTEXT3);
        JLabel lblConfirmPresence = new JLabel("* You have 20 minutes (from your booking start time) to sign into the system to confirm your");
        lblConfirmPresence.setFont(FTTEXT3);
        JLabel lblConfirmPresence2 = new JLabel(" arrival at the computer lab and station. Failure to do so will result in the cancellation of your ");
        lblConfirmPresence2.setFont(FTTEXT3);
        JLabel lblConfirmPresence3 = new JLabel(" booking.");
        lblConfirmPresence3.setFont(FTTEXT3);

        panelSouth.add(lblPleaseNote);
        panelSouth.add(lblConfirmPresence);
        panelSouth.add(lblConfirmPresence2);
        panelSouth.add(lblConfirmPresence3);


        //style elements

        //set jframe visible
        bookingFrame.getContentPane().add(panelNorth, BorderLayout.NORTH);
        bookingFrame.getContentPane().add(panelContent);
        bookingFrame.getContentPane().add(panelSouth, BorderLayout.SOUTH);
        bookingFrame.setVisible(true);
    }

    /***************************************************************************************************************************************************/

    public static void main(String[] args) {

        getAll();

        /* IF THIS IS THE FIRST EXEC. THEN UNCOMMENT AND RUN THE FOLLOWING */

        //JOptionPane.showMessageDialog(null, "Creating DB Tables and Data. \n Wait until welcome screen.");
        //Booking.createTables();
        //Booking.insertIntoStudentTab();
        //Booking.insertIntoAddressTab();
        //Booking.insertIntoBuildingTab();
        //Booking.insertIntoCompLabTab();
        //Booking.insertIntoSeatTab();
        //Booking.insertIntoBookingTab();

        createAppPreconditionGUI();
    }
}
