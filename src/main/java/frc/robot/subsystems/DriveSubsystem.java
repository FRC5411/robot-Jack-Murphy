
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase{

    private PWMVictorSPX leftFrontMotor;
    private PWMVictorSPX leftBackMotor;
    private PWMVictorSPX rightFrontMotor;
    private PWMVictorSPX rightBackMotor;

    private DifferentialDrive robotDrive;
    
    public DriveSubsystem() {
        leftFrontMotor = new PWMVictorSPX(2);
        leftBackMotor = new PWMVictorSPX(3);
        rightFrontMotor = new PWMVictorSPX(0);
        rightBackMotor = new PWMVictorSPX(1);

        leftFrontMotor.addFollower(leftBackMotor);
        rightFrontMotor.addFollower(rightBackMotor);

        rightFrontMotor.setInverted(true);
        rightBackMotor.setInverted(true);

        robotDrive = new DifferentialDrive(leftFrontMotor, rightBackMotor);
    }

    public void arcadeDrive(double speed, double rotation) {
        robotDrive.arcadeDrive(speed, rotation);
    }

    @Override
    public void periodic() {}
}
