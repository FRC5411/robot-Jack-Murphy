package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile.Constraints;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.CandyDispenser;

public class DispenserSubsystem extends SubsystemBase {
    private CANSparkMax dispenserMotor;
    private RelativeEncoder dispenserEncoder;
    public ProfiledPIDController profiledPIDController;
    public Constraints trapezoidProfileConstraints;


    public DispenserSubsystem(){
        trapezoidProfileConstraints = new Constraints(Constants.CandyDispenser.kV, Constants.CandyDispenser.kA);
        profiledPIDController = new ProfiledPIDController(Constants.CandyDispenser.kP, Constants.CandyDispenser.kI, Constants.CandyDispenser.kD, trapezoidProfileConstraints);
        dispenserMotor = new CANSparkMax(CandyDispenser.DISPENSER_ID, MotorType.kBrushless);
        dispenserEncoder = dispenserMotor.getEncoder();

        dispenserMotor.restoreFactoryDefaults();
        dispenserMotor.setIdleMode(IdleMode.kBrake);
        dispenserMotor.setSmartCurrentLimit(CandyDispenser.DISPENSER_CURRENT_LIMIT);

        dispenserMotor.burnFlash();

        dispenserEncoder.setPosition(0);
    }

    @Override
    public void periodic(){
        SmartDashboard.putNumber("Dispenser Posistion", dispenserEncoder.getPosition());
    }

    // Sets the candy dispenser motor speed.
    public void setMotor(double speed){
        dispenserMotor.set(speed);
    }

    public double getRelativeEncoderRotations() {
        return dispenserEncoder.getPosition();
    }

    public double updatePIDValues(double measurement, double goal) {
        return profiledPIDController.calculate(measurement, goal);
    }

    public boolean isAtGoal() {
        return profiledPIDController.atGoal();
    }
}
