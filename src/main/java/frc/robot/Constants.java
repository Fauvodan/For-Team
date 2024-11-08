package frc.robot;

//It's good practice to keep all your constants in one file for easy access.
//See what I've used as constants for an example.  Also check the old code on Github for how I used encoders.
//I try to keep measurements in metric, but you don't have to. Especially when everything is given to us in imperial.
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

    /**
     * Outside constants
     * These are physical constants, so if they change, something is entirely wrong
     */
    public static class OutConstants {
        public static final double grav = 9.8067;
    }

    /**
     * Constants used for the encoders.  If you don't connect the encoders, the code should still work.  The measurements just won't show up.
     */
    public static class EncoderConstants {
        /**
         * The resolution of the encoder.  This is assuming you're using the REV Throughbore encoder.
         */
        public static final double encoderResolution = 2048.0;

        /**
         * The wheel diameter in inches.
         */
        public static final double wheeldiameterIn = 6.0;

        /**
         * The wheel circumference in inches
         */
        public static final double wheelCircumferenceIn = wheeldiameterIn * Math.PI;

        /**
         * The distance per encoder pulse in inches
         */
        public static final double distancePerPulseIn = wheelCircumferenceIn / encoderResolution;

        /**
         * The first DIO port for the left encoder
         */
        public static final int kLEncoder1 = 0;

        /**
         * The second DIO port for the left encoder
         */
        public static final int kLEncoder2 = 1;

        /**
         * The first DIO port for the right encoder
         */
        public static final int kREncoder1 = 2;

        /**
         * The second DIO port for the right encoder
         */
        public static final int kREncoder2 = 3;

    }

    /**
     * A class just for formulae
     */
    public static class formulae {

        /**
         * Formula for converting inches to metres
         * @param in The value in inches
         * @return The value in metres
         */
        public double inchesToM(double in) {
            return in * 2.54 / 100;
        }

        /**
         * Formula for converting metres to inches
         * @param m The value in metres
         * @return The value in inches
         */
        public double mToInches(double m) {
            return (m * 100) / 2.54;
        }
    }
}
