package AttendanceSystemGUI;

import java.util.ArrayList;

public class AttendanceSystem {

    // Define an ArrayList to store the currently logged in students
    protected ArrayList<String> loggedInStudents;

    // Constructor to initialize the ArrayList
    public AttendanceSystem() {
        loggedInStudents = new ArrayList<>();
    }

    // Method to log in a student with the given name and ID
    public void logIn(String studentName, String studentId) {

        // Construct a string entry for the student's name and ID
        String entry = studentName + " (" + studentId + ")";

        // Add the entry to the ArrayList of logged in students
        loggedInStudents.add(entry);
    }

    // Method to log out a student with the given name and ID
    public void logOut(String studentName, String studentId) {

        // Construct a string entry for the student's name and ID
        String entry = studentName + " (" + studentId + ")";

        // If the ArrayList contains the entry, remove it
        if (loggedInStudents.contains(entry)) {
            loggedInStudents.remove(entry);
        }
    }

    // Method to return the ArrayList of currently logged in students
    public ArrayList<String> getLoggedInStudents() {
        return loggedInStudents;
    }

	public void reset() {
		// TODO Auto-generated method stub
		
	}

	public char[] getAttendanceReport() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addStudent(String name, int id) {
		// TODO Auto-generated method stub
		
	}

	public void save() {
		// TODO Auto-generated method stub
		
	}
}
