package frc.robot.Commands.Auto;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.DrivetrainSub;

//Should drive the robot forward for 2 seconds, assuming other  parameters are set up properly
//See JoystickDrive.java for more in-depth explanations of command file structure
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
        timer.restart();
        /*
         * I like to have the debug message at the end of the method
         * The computer "reads" the code top to bottom, so if the timer does not start, you won't see the message
         * You can also place it on the dashboard, but talk to me about that
         */
        System.out.println("Forward 2s");
    }

    @Override
    public void execute() {
        //Should drive forward at half-speed
        //Remember, positive is forward
        drivetrainSub.arcadeDrive(0, 0.5);
    }

    //Stops the command when the timer is greater than 2.0 seconds
    @Override
    public boolean isFinished() {
        return timer.get() > 2.0;
    }

    //When the command ends, stops motors
    @Override
    public void end(boolean interrupted) {
        drivetrainSub.stopMotors();
    }

}
