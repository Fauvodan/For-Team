// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Commands.Auto.Forward2Sec;
import frc.robot.Commands.Teleop.JoystickDrive;
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

  //We'll be using this command in autonomous, so no triggers need to be assigned.
  /**
   * Command used to drive the robot forward for 2 seconds.
   */
  private final Forward2Sec forward2Sec = new Forward2Sec(drivetrainSub);

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
  public static CommandJoystick joy = new CommandJoystick(0);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {

    /*
     * The brake and coast triggers defined here
     * onTrue means that it will run once when the trigger is true, i.e., activated
     */
    braketrigger.onTrue(drivetrainSub.setToBrake());
    coastTrigger.onTrue(drivetrainSub.setToCoast());
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
