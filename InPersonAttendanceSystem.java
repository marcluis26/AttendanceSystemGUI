package AttendanceSystemGUI;

public class InPersonAttendanceSystem extends AttendanceSystem {

	 // Define a constructor for the online attendance system
	 public InPersonAttendanceSystem() {
	     super();
	 }

	 // Define the reset method for the online attendance system
	 public void reset() {
	     // Reset the list of logged in students for the online attendance system
	     loggedInStudents.clear();
	 }
	}
