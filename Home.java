package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {

    public Home() {
        setTitle("Home - Airline Management System");
        setLayout(null);

        // Load Background Image
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/front.jpg"));
        JLabel image = new JLabel(il);
        image.setBounds(0, 0, 1600, 800);
        add(image);

        // Heading
        JLabel heading = new JLabel("AIR INDIA WELCOMES YOU");
        heading.setBounds(500, 40, 1000, 40);
        heading.setForeground(Color.BLUE);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 36));
        image.add(heading);

        // Menu Bar
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);

        // Details Menu
        JMenu details = new JMenu("Details");
        menubar.add(details);

        JMenuItem flightDetails = new JMenuItem("Flight Details");
        flightDetails.addActionListener(this);
        details.add(flightDetails);

        JMenuItem customerDetails = new JMenuItem("Add Customer Details");
        customerDetails.addActionListener(this);
        details.add(customerDetails);

        JMenuItem bookFlight = new JMenuItem("Book Flight");
        bookFlight.addActionListener(this);
        details.add(bookFlight);

        JMenuItem journeyDetails = new JMenuItem("Journey Details");
        journeyDetails.addActionListener(this);
        details.add(journeyDetails);

        JMenuItem ticketCancellation = new JMenuItem("Cancel Ticket");
        details.add(ticketCancellation);
        ticketCancellation.addActionListener(this);

        // Ticket Menu
        JMenu ticket = new JMenu("Ticket");
        menubar.add(ticket);

        JMenuItem boardingPass = new JMenuItem("Boarding Pass");
        ticket.add(boardingPass);

        // Frame settings
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        // Future buttons/actions
        String text = ae.getActionCommand();
        
        if(text.equals("Add Customer Details")){
            new AddCustomer();
        }else if(text.equals("Flight Details")){
            new FlightInfo();
        }else if(text.equals("Book Flight")){
            new BookFlight();
        }else if(text.equals("Journey Details")){
            new journeyDetails();
        }else if(text.equals("Cancel Ticket")){
            new Cancel();
        }
        
    }

    public static void main(String[] args) {
        new Home();
    }
}

    