package AttendanceSystemGUI;

import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;


public class MainGUI {

    private JFrame frame;
    private JLabel welcomeLabel, nameLabel, idLabel;
    private JTextField nameTextField, idTextField;
    private JButton loginButton, logoutButton, resetButton, saveButton;
    private JTextArea attendanceTextArea;
    private JScrollPane scrollPane;
    private AttendanceSystem attendanceSystem;

    public MainGUI() {
    	

        // Create the frame and set its properties
        frame = new JFrame("Attendance System");
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the welcome label and add it to the frame
        welcomeLabel = new JLabel("Welcome to Attendance System");
        welcomeLabel.setBounds(120, 20, 300, 30);
        frame.add(welcomeLabel);

        // Create the name label and text field and add them to the frame
        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(100, 60, 100, 30);
        frame.add(nameLabel);
        nameTextField = new JTextField();
        nameTextField.setBounds(200, 60, 150, 30);
        frame.add(nameTextField);

        // Create the ID label and text field and add them to the frame
        idLabel = new JLabel("Student Number:");
        idLabel.setBounds(100, 100, 100, 30);
        frame.add(idLabel);
        idTextField = new JTextField();
        idTextField.setBounds(200, 100, 150, 30);
        frame.add(idTextField);

     // Create the login button, add an ActionListener to it, and add it to the frame
        loginButton = new JButton("Login");
        loginButton.setBounds(50, 150, 100, 30);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText().trim(); // Trim leading/trailing spaces
                String id = idTextField.getText().trim(); // Trim leading/trailing spaces

                if (name.isEmpty() || id.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter both name and ID.");
                    return;
                }

                // Validate ID (numbers and symbols only)
                if (!id.matches("[0-9\\p{Punct}]+")) {
                    JOptionPane.showMessageDialog(frame, "Invalid ID. Please enter Student numbers only.");
                    return;
                }

                attendanceSystem.logIn(name, id);
                attendanceTextArea.append("Logged in: " + name + ", " + id + "\n");
            }
        });
        frame.add(loginButton);

        // Create the logout button, add an ActionListener to it, and add it to the frame
        logoutButton = new JButton("Logout");
        logoutButton.setBounds(250, 150, 100, 30);
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                String id = idTextField.getText();
                attendanceSystem.logOut(name, id);
                attendanceTextArea.append("Logged out: " + name + ", " + id + "\n");
            }
        });
        frame.add(logoutButton);

        // Create the attendance text area, add it to a scroll pane, and add the scroll pane to the frame
        attendanceTextArea = new JTextArea();
        scrollPane = new JScrollPane(attendanceTextArea);
        scrollPane.setBounds(50, 200, 300, 200);
        frame.add(scrollPane);

        // Create an instance of OnlineAttendanceSystem and assign it to the attendanceSystem field
        attendanceSystem = new OnlineAttendanceSystem();

        // Create a reset button, add an ActionListener to it, and add it to the frame
        resetButton = new JButton("Reset");
        resetButton.setBounds(50, 420, 100, 30);
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                attendanceSystem.reset();
                attendanceTextArea.setText("");
            }
        });
        frame.add(resetButton);

     // Create a save button, add an ActionListener to it, and add it to the frame
     saveButton = new JButton("Save");
     saveButton.setBounds(250, 420, 100, 30);
     saveButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             JFileChooser fileChooser = new JFileChooser();
             int choice = fileChooser.showSaveDialog(frame);
             if (choice == JFileChooser.APPROVE_OPTION) {
                 try {
                     BufferedWriter writer = new BufferedWriter(new FileWriter(fileChooser.getSelectedFile()));
                     writer.write(attendanceTextArea.getText()); // Write the contents of the attendanceTextArea
                     writer.close();
                 } catch (IOException ex) {
                     JOptionPane.showMessageDialog(frame, "Error saving file.");
                 }
             }
         }
     });
     frame.add(saveButton);

        // Make the frame visible
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        MainGUI gui = new MainGUI();
    }
    
}

