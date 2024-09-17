package frc.robot.subsystems;


import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DrivebaseSubsystem extends SubsystemBase{
    //backleft is messed up
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

        frontLeft.addFollower(backLeft);
        frontRight.addFollower(backRight);

        frontRight.setInverted(true);
        backRight.setInverted(true);
        
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
