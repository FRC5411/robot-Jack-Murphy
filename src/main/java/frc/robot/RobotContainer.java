// In Java We Trust

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.ArcadeCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.OuttakeSubsystem;

public class RobotContainer {

  private DriveSubsystem robotDrive;
  private OuttakeSubsystem robotOuttake;

  private CommandXboxController controller;

  public RobotContainer() {
    robotDrive = new DriveSubsystem();
    robotOuttake = new OuttakeSubsystem();

    controller = new CommandXboxController(0);

    robotDrive.setDefaultCommand(new ArcadeCommand( 
      () -> controller.getLeftY(),
      () -> controller.getRightX(),
      robotDrive
    ));

    configureBindings();
  }

  private void configureBindings() {
    // Rotate out
    controller.y().whileTrue(new InstantCommand( () -> {
      robotOuttake.rotateOuttake(0.5);
    }));

    // Rotate in
    controller.a().whileTrue(new InstantCommand( () -> {
      robotOuttake.rotateOuttake(0.0);
    }));
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
