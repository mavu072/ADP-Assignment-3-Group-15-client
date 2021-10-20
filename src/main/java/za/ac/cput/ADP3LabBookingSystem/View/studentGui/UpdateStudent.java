package za.ac.cput.ADP3LabBookingSystem.View.studentGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateStudent implements ActionListener {
    private JFrame MenuFrame;
    private JPanel panelNorth, panelSouth, panelEast, panelWest, panelCenter;
    private JLabel lblHeading,lblFN, lblLN, lblEmail, lblPN;
    private JButton btnCreate;
    private JLabel spc, spc2, spc3, spc4, spc5;
    private Font headingFont;
    private JTextField txtFN,  txtLN,txtEmail, txtPN;


    Color btnColor = Color.WHITE;


    public UpdateStudent(){
        //Font
        headingFont = new Font("Times new roman", Font.BOLD, 30);

        MenuFrame = new JFrame("Edit Student ");
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
        lblHeading = new JLabel("Make Changes to Student: ",JLabel.CENTER);
        lblFN = new JLabel("First Name", JLabel.CENTER);
        lblLN = new JLabel("Last Name ", JLabel.CENTER);
        lblEmail = new JLabel("Email ", JLabel.CENTER);
        lblPN = new JLabel("Phone Number", JLabel.CENTER);
        //text fields
        txtFN = new JTextField(" ", JTextField.CENTER);
        txtLN = new JTextField(" ", JTextField.CENTER);
        txtEmail = new JTextField(" ", JTextField.CENTER);
        txtPN = new JTextField(" ", JTextField.CENTER);


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

        btnCreate = new JButton("Edit");
        btnCreate.setBackground(btnColor);
    }

    public void setGUI() {
        panelNorth.setLayout(new GridLayout(2, 1));
        panelEast.setLayout(new GridLayout(5, 1));
        panelSouth.setLayout(new GridLayout(1, 3));
        panelWest.setLayout(new GridLayout(5, 1));
        panelCenter.setLayout(new GridLayout(10, 1));

        //Add components to panels
        //Panel North:
        panelNorth.add(spc5);
        panelNorth.add(lblHeading);

        //Panel West:
        panelWest.add(spc);

        //Panel Center:
        panelCenter.add(spc3);
        //houseNumber
        panelCenter.add(lblFN);
        panelCenter.add(txtFN);
        //street name
        panelCenter.add(lblLN);
        panelCenter.add(txtLN);
        //city
        panelCenter.add(lblEmail);
        panelCenter.add(txtEmail);
        //zipCode
        panelCenter.add(lblPN);
        panelCenter.add(txtPN);

        //Panel East
        panelEast.add(spc2);

        //Panel South:
        panelSouth.add(btnCreate);

        //Heading
        lblHeading.setFont(headingFont);

        //Adding panels to Customer Frame:
        MenuFrame.add(panelNorth, BorderLayout.NORTH);
        MenuFrame.add(panelSouth, BorderLayout.SOUTH);
        MenuFrame.add(panelEast, BorderLayout.EAST);
        MenuFrame.add(panelCenter, BorderLayout.CENTER);
        MenuFrame.add(panelWest, BorderLayout.WEST);

        //Telling compiler to listen for actions from the buttons:
        btnCreate.addActionListener(this);

        //Set GUI:
        MenuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        MenuFrame.pack();
        MenuFrame.setSize(400, 400);
        MenuFrame.setLocationRelativeTo(null);
        MenuFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Edit")){

        }
    }
}
