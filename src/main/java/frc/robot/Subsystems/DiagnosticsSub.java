package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OutConstants;

//A subsystem that returns diagnostics about the robot.  
//This is entirely trinkets and non-necessary, but you may find it helpful
public class DiagnosticsSub extends SubsystemBase {
    
    /**
     * The accelerometer in the roborio.
     */
    BuiltInAccelerometer accel = new BuiltInAccelerometer();

    //Initializes the subsystem
    public DiagnosticsSub() {}

    /*
     * The following are acceleration calculations
     * Note that the roborio returns it in g.  I'm multiplying by g in order to return it as a normal number.
     */

     public double xaccel() {
        return accel.getX() * OutConstants.grav;
     }

    //Runs periodically while the robot is running
    public void periodic() {}
}
