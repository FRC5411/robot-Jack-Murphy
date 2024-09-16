// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.DrivebaseSubsystem;

public class RobotContainer {
  private DrivebaseSubsystem robotDrive; 
  private CommandXboxController driveController;
    public RobotContainer() {
    robotDrive = new DrivebaseSubsystem();
    driveController = new CommandXboxController(0);
    

    robotDrive.setDefaultCommand(
      new DriveCommand(
        () -> -driveController.getLeftY(), 
        () -> -driveController.getRightX(), 
        robotDrive));

    configureBindings();
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
