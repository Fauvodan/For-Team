package frc.robot.Commands.Auto;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.DrivetrainSub;

//Should drive the robot forward for 2 seconds, assuming other  parameters are set up properly
public class Forward2Sec extends Command {
    
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

    //Drivetrain subsystem declared
    private final DrivetrainSub drivetrainSub;

    //Initializes a timer
    Timer timer = new Timer();

    //See JoystickDrive.java
    public Forward2Sec(DrivetrainSub drivetrainSub) {
        this.drivetrainSub = drivetrainSub;
    }

    @Override
    public void initialize() {
        //Starts the timer
    }

}
