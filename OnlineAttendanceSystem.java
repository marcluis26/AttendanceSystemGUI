package AttendanceSystemGUI;

//Define a subclass for online attendance systems
public class OnlineAttendanceSystem extends AttendanceSystem {

 // Define a constructor for the online attendance system
 public OnlineAttendanceSystem() {
     super();
 }

 // Define the reset method for the online attendance system
 public void reset() {
     // Reset the list of logged in students for the online attendance system
     loggedInStudents.clear();
 }
}