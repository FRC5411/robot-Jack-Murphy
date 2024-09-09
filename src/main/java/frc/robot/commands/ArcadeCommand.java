
package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;

public class ArcadeCommand extends Command {

    private DriveSubsystem robotDrive;

    private DoubleSupplier speed;
    private DoubleSupplier rotation;

    public ArcadeCommand(DoubleSupplier speed, DoubleSupplier rotation, DriveSubsystem robotDrive) {
        this.robotDrive = robotDrive;
        this.speed = speed;
        this.rotation = rotation;

        addRequirements(robotDrive);
    }

    @Override
    public void initialize() {
        System.out.println("Command ARCADE starting");
    }
  
    @Override
    public void execute() {
        robotDrive.arcadeDrive(speed.getAsDouble(), rotation.getAsDouble());
    }
  
    @Override
    public void end(boolean interrupted) {
        System.out.println("Command ARCADE ending");
    }
  
    @Override
    public boolean isFinished() {
      return false;
    }

}
