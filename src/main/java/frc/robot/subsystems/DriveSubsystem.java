
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Globals.DriveState;

public class DriveSubsystem extends SubsystemBase{

    private PWMVictorSPX leftFrontMotor;
    private PWMVictorSPX leftBackMotor;
    private PWMVictorSPX rightFrontMotor;
    private PWMVictorSPX rightBackMotor;

    private MotorControllerGroup leftMotors;
    private MotorControllerGroup rightMotors;

    private DifferentialDrive robotDrive;
    
    public DriveSubsystem() {
        leftFrontMotor = new PWMVictorSPX(4);
        leftBackMotor = new PWMVictorSPX(2);
        rightFrontMotor = new PWMVictorSPX(1);
        rightBackMotor = new PWMVictorSPX(3);

        leftMotors = new MotorControllerGroup(leftFrontMotor, leftBackMotor);
        rightMotors = new MotorControllerGroup(rightFrontMotor, rightBackMotor);

        rightMotors.setInverted(true);

        robotDrive = new DifferentialDrive(leftMotors, rightMotors);
    }

    public void arcadeDrive(double speed, double rotation) {
        // Rotation Reduction
        double driveRotation = (rotation > 0) ? rotation * -rotation : rotation * rotation;

        // If Sniper
        double driveSpeed = (DriveState.isSniper) ? speed * 0.5 : speed;
        driveRotation = (DriveState.isSniper) ? driveRotation * 0.5 : driveRotation;

        robotDrive.arcadeDrive(driveSpeed, driveRotation);
    }

    @Override
    public void periodic() {}
}
