package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

//Extend every subsystem class with SubsystemBase
public class DrivetrainSub extends SubsystemBase {
    
    //Initializing the SparkMax motor controllers as objects
    //The system goes as such:
    //... = new CANSparkMax(deviceID, MotorType)
    /*
     * deviceID can be anywhere from 0 to 63 inclusive, but no two devices of the same type can share an ID
     * You'll set this ID in another software
     * MotorType includes kBrushed and kBrushless.  This should be self-explanatory.
     */
    public static CANSparkMax fLeft = new CANSparkMax(0, MotorType.kBrushed);
    public static CANSparkMax fRight = new CANSparkMax(1, MotorType.kBrushed);
    public static CANSparkMax bLeft = new CANSparkMax(2, MotorType.kBrushed);
    public static CANSparkMax bRight = new CANSparkMax(3, MotorType.kBrushed);

    //Initializing a drivetrain.  This code is assuming you're using a tank drivebase
    /*
     * Note that we only use the front motors in the field
     * This is becausea the DifferentialDrive class can only handle two motors
     * We will deal with this limitation later
     */
    public static DifferentialDrive roboDrive = new DifferentialDrive(fLeft, fRight);

    

    //Here we initialize the subsystem
    //For any methods, I'll be using JavaDoc comments to indicate their use when hovered over
    /**
     * The subsystem for the Drivetrain
     */
    public DrivetrainSub() {
        /*
         * We use the follow method to ensure that the front and back are doing the same thign
         */
        bLeft.follow(fLeft);
        bRight.follow(fRight);
        /*
         * You may want to invert one side or another
         * In this scenario, the left side is inverted
         * For this to happen, you have to invert both motors.  Follow does NOT copy settings.
         */
        bLeft.setInverted(true);
        fLeft.setInverted(true);
    }

    /*
     * This is the method we will use to control the robot
     */
    /**
     * Method for driving the robot using a joystick or controller
     * @param omega The rotational velocity of the robot.  Try to follow convention.  CCW is positive, so when the robot receives a positive input, it should turn CCW.
     * @param v The translational velocity of the robot.  Positive is forward.
     */
    public void arcadeDrive(double omega, double v) {
        /*The arcadeDrive method takes two inputs: speed and rotation 
         * In this code, as the speed has a direction, I will be calling it velocity
         * The velocity is the translational velocity, while the rotation is the rotational velocity
        */
        roboDrive.arcadeDrive(v, omega);
}

    /*
     * The following methods are not really necessary, per se, but you lose nothing through adding them
     * They're of type command for simplicity when activated
     * runOnce runs the command once
     */
    /**
     * Change the motor controllers to Brake Mode.  Once they stop receiving an input, they will stop moving.
     */
    public Command setToBrake() {
        return runOnce(() -> {
            fLeft.setIdleMode(IdleMode.kBrake);
            fRight.setIdleMode(IdleMode.kBrake);
            bLeft.setIdleMode(IdleMode.kBrake);
            bRight.setIdleMode(IdleMode.kBrake);
        });
    }

    /**
     * Change the motor controllers to Coast Mode.  Once they stop receiving an input, they will slowly come to a stop.
     */
    public Command setToCoast() {
        return runOnce(() -> {
            fLeft.setIdleMode(IdleMode.kCoast);
            fRight.setIdleMode(IdleMode.kCoast);
            bLeft.setIdleMode(IdleMode.kCoast);
            bRight.setIdleMode(IdleMode.kCoast);
        });
    }
}