
package frc.robot.subsystems;

//import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class OuttakeSubsystem extends SubsystemBase {

    //private PWM outtakeMotor;

    private Servo outtakeMotor;

    public OuttakeSubsystem() {
        //outtakeMotor = new PWM(0);
        //outtakeMotor.setBounds(0, 0, 0, 0, 0);

        outtakeMotor = new Servo(0);
    }

    public void rotateOuttake(double angle) {
        //double outtakeSpeed = speed;
        //outtakeMotor.setSpeed(outtakeSpeed);

        outtakeMotor.set(angle);
    }
    
    @Override
    public void periodic() {
        System.out.println(outtakeMotor.getAngle());
    }
}
