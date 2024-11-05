package frc.robot;

//It's good practice to keep all your constants in one file for easy access.
//See what I've used as constants for an example.  Also check the old code on Github for how I used encoders.
public class Constants {
    
    //This is where you would put the controller ports.  Check the driver station for the number.
    public static class OperatorConstants {

        /**
         * The port for the driver controller, regardless of what controller.
         */
        public static final int kDriverCPort = 0;
    }

    //This is where you would put the drivetrain motor CAN IDs
    public static class DriveMotorConstants {
        /**
         * The CAN ID for the front left motor
         */
        public static final int fl = 0;

        /**
         * The CAN ID for the front right motor
         */
        public static final int fr = 1;

        /**
         * The CAN ID for the back left motor
         */
        public static final int bl = 2;

        /**
         * The CAN ID for the back right motor
         */
        public static final int br = 3;
    }
}
