package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

//A subsystem that returns diagnostics about the robot.  
//This is entirely trinkets and non-necessary, but you may find it helpful
public class DiagnosticsSub extends SubsystemBase {
    
    /**
     * The accelerometer in the roborio.
     */
    BuiltInAccelerometer accel = new BuiltInAccelerometer();
}
