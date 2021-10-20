package za.ac.cput.ADP3LabBookingSystem.View.studentGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentMainGui implements ActionListener {

    private JFrame MenuFrame;
    private JPanel panelNorth, panelSouth, panelEast, panelWest, panelCenter;
    private JLabel lblHeading;
    private JButton btnCreateStudent,  btnViewStudent, btnUpdateStudent, btnDeleteStudent, btnClose;
    private JLabel spc, spc2, spc3, spc4, spc5;
    private Font headingFont;
    Color btnColor = Color.WHITE;

    public StudentMainGui(){

        //Font
        headingFont = new Font("Times new roman", Font.BOLD, 30);

        MenuFrame = new JFrame("Add Student");
        panelNorth = new JPanel();
        panelSouth = new JPanel();
        panelEast = new JPanel();
        panelWest = new JPanel();
        panelCenter = new JPanel();
        panelNorth.setBackground(Color.LIGHT_GRAY);
        panelEast.setBackground(Color.LIGHT_GRAY);
        panelSouth.setBackground(Color.LIGHT_GRAY);
        panelWest.setBackground(Color.LIGHT_GRAY);
        panelCenter.setBackground(Color.LIGHT_GRAY);

        //Heading
        lblHeading = new JLabel("Add Student",JLabel.CENTER);

        //Fillers:
        spc = new JLabel("=====");
        spc.setForeground(Color.LIGHT_GRAY);
        spc2 = new JLabel("=====");
        spc2.setForeground(Color.LIGHT_GRAY);
        spc3 = new JLabel("================================");
        spc3.setForeground(Color.LIGHT_GRAY);
        spc4 = new JLabel("================================");
        spc4.setForeground(Color.LIGHT_GRAY);
        spc5 = new JLabel("================================");
        spc5.setForeground(Color.LIGHT_GRAY);

        //Buttons:
        btnCreateStudent = new JButton("Add new  Student");
        btnCreateStudent.setBackground(btnColor);
        btnViewStudent = new JButton("View Existing Student");
        btnViewStudent.setBackground(btnColor);
        btnUpdateStudent = new JButton("Edit Student");
        btnUpdateStudent.setBackground(btnColor);
        btnDeleteStudent = new JButton("Remove Student");
        btnDeleteStudent.setBackground(btnColor);

        btnClose = new JButton("Close");
        btnClose.setBackground(btnColor);
    }

    public void setGUI() {
        panelNorth.setLayout(new GridLayout(2, 1));
        panelEast.setLayout(new GridLayout(5, 1));
        panelSouth.setLayout(new GridLayout(1, 3));
        panelWest.setLayout(new GridLayout(5, 1));
        panelCenter.setLayout(new GridLayout(7, 1));

        //Adding the components to the panels:
        //Panel North:
        panelNorth.add(spc5);
        panelNorth.add(lblHeading);

        //Panel West:
        panelWest.add(spc);

        //Panel Center:
        panelCenter.add(spc3);
        panelCenter.add(btnCreateStudent);
        panelCenter.add(btnViewStudent);
        panelCenter.add(btnUpdateStudent);
        panelCenter.add(btnDeleteStudent);
        panelCenter.add(spc4);

        //Panel East
        panelEast.add(spc2);

        //Panel South:
        panelSouth.add(btnClose);

        //Heading
        lblHeading.setFont(headingFont);

        //Adding panels to Customer Frame:
        MenuFrame.add(panelNorth, BorderLayout.NORTH);
        MenuFrame.add(panelSouth, BorderLayout.SOUTH);
        MenuFrame.add(panelEast, BorderLayout.EAST);
        MenuFrame.add(panelCenter, BorderLayout.CENTER);
        MenuFrame.add(panelWest, BorderLayout.WEST);

        //Telling compiler to listen for actions from the buttons:
        btnCreateStudent.addActionListener(this);
        btnViewStudent.addActionListener(this);
        btnUpdateStudent.addActionListener(this);
        btnDeleteStudent.addActionListener(this);
        btnClose.addActionListener(this);

        //Set GUI:
        MenuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        MenuFrame.pack();
        MenuFrame.setSize(400, 400);
        MenuFrame.setLocationRelativeTo(null);
        MenuFrame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Add new  Student")){
            CreateStudent createStudent = new CreateStudent();
            createStudent.setGUI();
        }
        if(e.getActionCommand().equals("View Existing Student")){
            ReadStudent readStudent = new ReadStudent();
            readStudent.setGUI();
        }
        if(e.getActionCommand().equals("Edit Student")){
            UpdateStudent updateStudent = new UpdateStudent();
            updateStudent.setGUI();
        }
        if(e.getActionCommand().equals("Remove Student")){
            DeleteStudent deleteAddress = new DeleteStudent();
            deleteAddress.setGUI();
        }

        if(e.getActionCommand().equals("Close")){
            MenuFrame.dispose();
        }
    }
}
