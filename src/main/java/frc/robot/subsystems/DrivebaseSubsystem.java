package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.DriveConstants;

public class DrivebaseSubsystem extends SubsystemBase{
    private static CANSparkMax frontLeft;
    private static CANSparkMax frontRight;
    private static CANSparkMax backLeft;
    private static CANSparkMax backRight;
    private static DifferentialDrive m_Drive;

    public DrivebaseSubsystem(){
        frontLeft = new CANSparkMax(Constants.DriveConstants.FRONTLEFT_ID, MotorType.kBrushed);
        frontRight = new CANSparkMax(Constants.DriveConstants.FRONTRIGHT_ID, MotorType.kBrushed);
        backLeft = new CANSparkMax(Constants.DriveConstants.BACKLEFT_ID, MotorType.kBrushed);
        backRight = new CANSparkMax(Constants.DriveConstants.BACKRIGHT_ID, MotorType.kBrushed);

        frontLeft.restoreFactoryDefaults();
        frontRight.restoreFactoryDefaults();
        backLeft.restoreFactoryDefaults();
        backRight.restoreFactoryDefaults();

        frontRight.setInverted(true);
        backLeft.follow(frontLeft);
        backRight.follow(frontRight);
        
        configureMotors(frontLeft);
        configureMotors(frontRight);
        configureMotors(backLeft);
        configureMotors(backRight);

        m_Drive = new DifferentialDrive(frontLeft, frontRight);
    }

    public static void configureMotors(CANSparkMax motor){
        motor.setSmartCurrentLimit(Constants.DriveConstants.DRIVE_CURRENT_LIMIT);
        motor.setIdleMode(IdleMode.kBrake);
        motor.clearFaults();
        motor.burnFlash();
    }

    public void arcadeCmd(double speed, double rotation){
        m_Drive.arcadeDrive(speed,rotation);
    }
}
