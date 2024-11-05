package frc.robot.Commands.Auto;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.DrivetrainSub;

//Don't forget to extend command!
public class Backward2Sec extends Command {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

    //Subsystem and timer
    private final DrivetrainSub drivetrainSub;

    Timer timer = new Timer();

    public Backward2Sec(DrivetrainSub drivetrainSub) {
        this.drivetrainSub = drivetrainSub;
    }

    @Override
    public void initialize() {
        //As always, put the debug line at the bottom
        timer.restart();
        System.out.println("Backwards");
    }

    //V is negative here, so the robot should move backwards
    @Override
    public void execute() {
        drivetrainSub.arcadeDrive(0, -0.5);
    }

    //When timer is greater than 2.0, the command stops
    @Override
    public boolean isFinished() {
        return timer.get() > 2.0;
    }

    //Stops the motors when the command ends
    @Override
    public void end(boolean interrupted) {
        drivetrainSub.stopMotors();
    }
}
