package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class DrivebaseSubsystem extends SubsystemBase{
    private static PWMVictorSPX frontLeft;
    private static PWMVictorSPX frontRight;
    private static PWMVictorSPX backLeft;
    private static PWMVictorSPX backRight;
    private static DifferentialDrive m_Drive;

    public DrivebaseSubsystem(){
        frontLeft = new PWMVictorSPX(2);
        frontRight = new PWMVictorSPX(3);
        backLeft = new PWMVictorSPX(4);
        backRight = new PWMVictorSPX(1);

        //restoring factory defaults removes and changes such as inverts and follows so this should alwways be applied before hand
        backLeft.addFollower(frontLeft);
        backRight.addFollower(frontRight);

        frontRight.setInverted(true);
        
        // configureMotors(frontLeft);
        // configureMotors(frontRight);
        // configureMotors(backLeft);
        // configureMotors(backRight);

        m_Drive = new DifferentialDrive(frontLeft, frontRight);
    }

    // public static void configureMotors(PWMVictorSPX motor){
    //     motor.se(Constants.DRIVE_CURRENT_LIMIT);
    //     motor.setIdleMode(IdleMode.kBrake);
    //     motor.clearFaults();
    //     motor.burnFlash();
    // }

    public void arcadeCmd(double speed, double rotation){
        m_Drive.arcadeDrive(speed,rotation);
    }
}
