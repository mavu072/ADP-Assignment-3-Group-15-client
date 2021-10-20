package za.ac.cput.ADP3LabBookingSystem.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComputerLabView implements ActionListener {
    private JFrame frame;

    // JPanel
    private JPanel pnlCenter, pnlNorth, pnlSouth, pnlEast, pnlWest;

    // Jlabel
    private JLabel lblTop, lblLabId, lblLabAvailability, lblLabCapacity, lblBuildingId;

    // JTextfield
    private JTextField txtLabId,txtLabAvailablity,txtLabCapacity, txtBuildingId;

    // JButton
    private JButton btnCreateComputerLab, btnViewComputerLab, btnUpdateComputerLab, btnDeleteComputerLab, btnClose;


    public ComputerLabView() {

        frame = new JFrame("Computer Labs");
        pnlNorth = new JPanel();
        pnlSouth = new JPanel();
        pnlEast = new JPanel();
        pnlWest = new JPanel();
        pnlCenter = new JPanel();

        pnlNorth.setBackground(Color.LIGHT_GRAY);
        pnlEast.setBackground(Color.LIGHT_GRAY);
        pnlSouth.setBackground(Color.LIGHT_GRAY);
        pnlWest.setBackground(Color.LIGHT_GRAY);
        pnlCenter.setBackground(Color.LIGHT_GRAY);

        lblTop = new JLabel("Computer Labs", JLabel.CENTER);


        btnViewComputerLab = new JButton("View");
        btnCreateComputerLab = new JButton("Create");
        btnUpdateComputerLab = new JButton("Update");
        btnDeleteComputerLab = new JButton("Delete");
        btnClose = new JButton("Close");
    }

    public void setGUI() {
        pnlNorth.setLayout(new GridLayout(2, 1));
        pnlEast.setLayout(new GridLayout(5, 1));
        pnlSouth.setLayout(new GridLayout(1, 3));
        pnlWest.setLayout(new GridLayout(5, 1));
        pnlCenter.setLayout(new GridLayout(7, 1));

        pnlNorth.add(lblTop);

        pnlCenter.add(btnCreateComputerLab);
        pnlCenter.add(btnViewComputerLab);
        pnlCenter.add(btnUpdateComputerLab);
        pnlCenter.add(btnDeleteComputerLab);

        pnlSouth.add(btnClose);

        frame.add(pnlNorth, BorderLayout.NORTH);
        frame.add(pnlSouth, BorderLayout.SOUTH);
        frame.add(pnlEast, BorderLayout.EAST);
        frame.add(pnlCenter, BorderLayout.CENTER);
        frame.add(pnlWest, BorderLayout.WEST);

        btnCreateComputerLab.addActionListener(this);
        btnViewComputerLab.addActionListener(this);
        btnUpdateComputerLab.addActionListener(this);
        btnDeleteComputerLab.addActionListener(this);
        btnClose.addActionListener(this);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("Clos")){
            frame.dispose();
        }
    }

}
