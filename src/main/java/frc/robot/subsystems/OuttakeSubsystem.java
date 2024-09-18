package frc.robot.subsystems;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
public class OuttakeSubsystem extends SubsystemBase {
    private Servo outtakeMotor;
    public OuttakeSubsystem() {
        outtakeMotor = new Servo(9);
        outtakeMotor.setPosition(0);
    }
    public OuttakeSubsystem(int channel) {
        outtakeMotor = new Servo(channel);
        outtakeMotor.setPosition(0);
    }
    public void outtakeOut() {
        outtakeMotor.setAngle(180);
    }
    public void outtakeIn() {
        outtakeMotor.setAngle(5);
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







