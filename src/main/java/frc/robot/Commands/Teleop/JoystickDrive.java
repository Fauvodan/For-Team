package frc.robot.Commands.Teleop;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.Subsystems.DrivetrainSub;

//Extend every command class with Command
public class JoystickDrive extends Command {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

    //Don't create a new instance of DrivetrainSub.  Just declare it.
    private final DrivetrainSub drivetrainSub;

    /*
     * Here we delcare the command.  
     * Follow the same structure I did for simplicity, just change the subsystem name.
     */
    public JoystickDrive(DrivetrainSub drivetrainSub) {
        this.drivetrainSub = drivetrainSub;
        addRequirements(drivetrainSub);
    }

    //Each method from here on out will be prefixed with @Override

    /*
     * Runs every time the command starts.  This is a default command, so it should run once whenever the subsystem is free.
     * Even if I don't need anything in the initialize method, I like to add a println() command
     * It helps with debugging!
     */
    @Override
    public void initialize() {
        System.out.println("Driving");
    }

    /*
     * The actual command.  Runs while the command is being executed
     */

    @Override
    public void execute() {
        /*
         * Here we declare the translational and rotational velocity of the arcade drive
         * Then we plug them into the method from the DrivetrainSub subsystem
         * 
         */
        double transV = RobotContainer.joy.getY();
        double rotV = RobotContainer.joy.getZ();
        drivetrainSub.arcadeDrive(rotV, transV);
    }
}
