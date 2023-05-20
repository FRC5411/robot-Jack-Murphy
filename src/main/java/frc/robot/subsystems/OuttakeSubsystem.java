
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class OuttakeSubsystem extends SubsystemBase {

    private Servo outtakeMotor;

    public OuttakeSubsystem() {
        outtakeMotor = new Servo(0);

        outtakeMotor.setPosition(0);
        outtakeMotor.setBounds(2.7, 0, 0, 0, 1);        
    }

    public OuttakeSubsystem(int channel) {
        outtakeMotor = new Servo(channel);

        outtakeMotor.setPosition(0);
        outtakeMotor.setBounds(2.7, 0, 0, 0, 1);
    }

    public void outtakeOut() {
        outtakeMotor.setAngle(180);
    }

    public void outtakeIn() {
        outtakeMotor.setAngle(10);
    }

    public void noOuttake() {
        outtakeMotor.setDisabled();;
    }

    public double getOuttakePosition() {
        return outtakeMotor.getPosition();
    }
    
    @Override
    public void periodic() {}
}
