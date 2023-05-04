
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class OuttakeSubsystem extends SubsystemBase {

    private Servo outtakeMotor;

    public OuttakeSubsystem() {
        outtakeMotor = new Servo(0);
    }

    public void rotateOuttake(int speed) {
        outtakeMotor.setSpeed(speed);
        outtakeMotor.setAngle(speed);
    }
    
    @Override
    public void periodic() {}
}
