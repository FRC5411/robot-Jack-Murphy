package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DrivebaseSubsystem extends SubsystemBase{
    private static PWMVictorSPX frontLeft;
    private static PWMVictorSPX frontRight;
    private static PWMVictorSPX backLeft;
    private static PWMVictorSPX backRight;

    public DrivebaseSubsystem(){
        frontLeft = new PWMVictorSPX(2);
        frontRight = new PWMVictorSPX(3);
        backLeft = new PWMVictorSPX(4);
        backRight = new PWMVictorSPX(1);

        //restoring factory defaults removes and changes such as inverts and follows so this should alwways be applied before hand

        backLeft.addFollower(frontLeft);
        backRight.addFollower(frontRight);

        frontRight.setInverted(true);
        backRight.setInverted(true);
        
        // configureMotors(frontLeft);
        // configureMotors(frontRight);
        // configureMotors(backLeft);
        // configureMotors(backRight);
    }

    // public static void configureMotors(PWMVictorSPX motor){
    //     motor.se(Constants.DRIVE_CURRENT_LIMIT);
    //     motor.setIdleMode(IdleMode.kBrake);
    //     motor.clearFaults();
    //     motor.burnFlash();
    // }

    public void tankDrive(double leftSpeed, double rightSpeed){
        frontLeft.set(leftSpeed);
        frontRight.set(rightSpeed);
    }
}
