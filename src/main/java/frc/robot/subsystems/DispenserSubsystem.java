package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkBase.SoftLimitDirection;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.CandyDispenser;

public class DispenserSubsystem extends SubsystemBase {
    private CANSparkMax dispenserMotor;
    private RelativeEncoder dispenserEncoder;

    public DispenserSubsystem(){
        dispenserMotor = new CANSparkMax(CandyDispenser.DISPENSER_ID, MotorType.kBrushless);
        dispenserEncoder = dispenserMotor.getEncoder();

        dispenserMotor.setIdleMode(IdleMode.kBrake);
        dispenserMotor.setSmartCurrentLimit(CandyDispenser.DISPENSER_CURRENT_LIMIT);
        // Set softlimit later
        dispenserMotor.setSoftLimit(SoftLimitDirection.kForward, 1);
        dispenserMotor.setSoftLimit(SoftLimitDirection.kReverse, 1);
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
}
