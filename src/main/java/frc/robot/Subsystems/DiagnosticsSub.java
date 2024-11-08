package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.EncoderConstants;
import frc.robot.Constants.OutConstants;

//A subsystem that returns diagnostics about the robot.  
//This is entirely trinkets and non-necessary, but you may find it helpful
public class DiagnosticsSub extends SubsystemBase {
    
    /**
     * The accelerometer in the roborio.
     */
    BuiltInAccelerometer accel = new BuiltInAccelerometer();

    /*
     * The two encoders
     */

     /**
      * Encoder for the left side of the drivetrain
      */
    Encoder leftEncoder = new Encoder(EncoderConstants.kLEncoder1, EncoderConstants.kLEncoder2);

    /**
     * Encoder for the right side of the drivetrain
     */
    Encoder rightEncoder = new Encoder(EncoderConstants.kREncoder1, EncoderConstants.kREncoder2);

    //Initializes the subsystem
    public DiagnosticsSub() {
      //Sets the distance per pulse for each encoder in inches.
      leftEncoder.setDistancePerPulse(EncoderConstants.distancePerPulseIn);
      rightEncoder.setDistancePerPulse(EncoderConstants.distancePerPulseIn);
    }

    /*
     * The following are acceleration calculations
     * Note that the roborio returns it in g.  I'm multiplying by g in order to return it as a normal number.
     */

     /**
      * An acceleration value.
      * @return The x-value in ms^-2
      */
     public double xaccel() {
        return accel.getX() * OutConstants.grav;
     }

     /**
      * An acceleration value.
      * @return The y-value in ms^-2
      */
     public double yaccel() {
        return accel.getY() * OutConstants.grav;
     }

     /**
      * An acceleration value.
      * @return The z-value in ms^-2
      */
     public double zaccel() {
        return accel.getZ() * OutConstants.grav;
     }

     /**
      * Get the time
      * @return The match time from the FMS in seconds.
      */
     public double fgaTime() {
        return DriverStation.getMatchTime();
     }

    //Runs periodically while the robot is running
    public void periodic() {
        //Puts each acceleration value on the dashboard
        SmartDashboard.putNumber("X Acceleration", xaccel());
        SmartDashboard.putNumber("Y Acceleration", yaccel());
        SmartDashboard.putNumber("Z Acceleration", zaccel());
        //Puts the FMS Time on the dashboard
        SmartDashboard.putNumber("FMS Time", fgaTime());
    }
}
