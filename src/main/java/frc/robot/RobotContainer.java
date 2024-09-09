// In Java We Trust

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Globals.DriveState;
import frc.robot.commands.ArcadeCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.OuttakeSubsystem;

public class RobotContainer {

  private DriveSubsystem robotDrive;
  private OuttakeSubsystem robotOuttake;

  private CommandXboxController controller;
  private CommandJoystick joystick;

  public RobotContainer() {
    robotDrive = new DriveSubsystem();

    controller = new CommandXboxController(0);
    joystick = new CommandJoystick(0);

    robotDrive.setDefaultCommand(new ArcadeCommand( 
      //() -> controller.getLeftY(),
      //() -> controller.getRightX(),
      () -> applyDeadband(controller.getLeftY()),
      () -> applyDeadband(controller.getRightX()),
      robotDrive
    ));

    configureBindings();
  }

  private double applyDeadband(double val){
    if(val > 0.4){
      return val;
    }

    return 0;
  }

  private void configureBindings() {
    // Rotate out
    controller.y()
    .whileTrue(new InstantCommand( () -> {
      robotOuttake.outtakeOut();
    }))
    .whileFalse(new InstantCommand( () -> {
      robotOuttake.noOuttake();
    }));

    // Rotate in
    controller.a()
    .whileTrue(new InstantCommand( () -> {
      robotOuttake.outtakeIn();
    }))
    .whileFalse(new InstantCommand( () -> { 
      robotOuttake.noOuttake();
    }));


    // A
    joystick.button(1)
    .whileTrue(new InstantCommand( () -> {
      robotOuttake.outtakeOut();
    }))
    .whileFalse(new InstantCommand( () -> {
      robotOuttake.noOuttake();
    }));

    // B
    joystick.button(2)
    .whileTrue(new InstantCommand( () -> {
      robotOuttake.outtakeIn();
    }))
    .whileFalse(new InstantCommand( () -> { 
      robotOuttake.noOuttake();
    }));

    // X
    joystick.button(3)
    .onTrue(new InstantCommand( () -> {
      DriveState.isSniper = true;
    }))
    .onFalse(new InstantCommand( () -> {}));

    // Y
    joystick.button(4)
    .onTrue(new InstantCommand( () -> {
      DriveState.isSniper = false;
    }))
    .onFalse(new InstantCommand( () -> {}));
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
