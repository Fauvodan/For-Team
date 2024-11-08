// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Commands.Auto.Backward2Sec;
import frc.robot.Commands.Auto.Forward2Sec;
import frc.robot.Commands.Teleop.JoystickDrive;
import frc.robot.Constants.OperatorConstants;
import frc.robot.Subsystems.DrivetrainSub;

public class RobotContainer {

  //Delcare your subsystems and commands here.  This is where you create the new instances.
  //Also triggers!

  //Subsystems

  /**
   * The subsystem for the drivetrain
   */
  private final DrivetrainSub drivetrainSub = new DrivetrainSub();

  //Commands
  //Each command needs a subsystem as a field

  /**
   * The command used to control the robot during Teleop period
   */
  private final JoystickDrive joystickDrive = new JoystickDrive(drivetrainSub);

  //We'll be using these commands in autonomous, so no triggers need to be assigned.
  /**
   * Command used to drive the robot forward for 2 seconds.
   */
  private final Forward2Sec forward2Sec = new Forward2Sec(drivetrainSub);

  /**
   * Command used to drive the robot backward for 2 seconds.
   */
  private final Backward2Sec backward2Sec = new Backward2Sec(drivetrainSub);

  //Triggers
  //Triggers should be self-explanatory.  They're how you trigger an action.

  /**
   * The trigger that changes the robot to coast mode
   */
  private final Trigger coastTrigger = new Trigger(joy.button(5));

  /**
   * The trigger that changes the robot to brake mode
   */
  private final Trigger braketrigger = new Trigger(joy.button(6));

  //The above triggers were not used in previous matches, but they waste little to no resources

  /**
   * The joystick used to control the robot.  Can be replaced with CommandXboxController or CommandPS4Controller.
   */
  public static CommandJoystick joy = new CommandJoystick(OperatorConstants.kDriverCPort);

  /**
   * Chooser used to choose auto commands.  Will be stored in a switch statement.
   */
  SendableChooser<Command> chooser = new SendableChooser<>();

  public RobotContainer() {
    configureBindings();
    //Sets the default chooser option to forward for 2 seconds
    chooser.setDefaultOption("Forward", forward2Sec);

    //Adds the backwards for 2 seconds option to the chooser
    chooser.addOption("Back", backward2Sec);

    //Puts the chooser on the dashboard
    SmartDashboard.putData(chooser);
  }

  private void configureBindings() {

    /*
     * The brake and coast triggers defined here
     * onTrue means that it will run once when the trigger is true, i.e., activated
     */
    braketrigger.onTrue(drivetrainSub.setToBrake());
    coastTrigger.onTrue(drivetrainSub.setToCoast());
  }

  //Returns the autonomous command.  Here, it's whatever you selected.
  public Command getAutonomousCommand() {
    return chooser.getSelected();
  }
}
