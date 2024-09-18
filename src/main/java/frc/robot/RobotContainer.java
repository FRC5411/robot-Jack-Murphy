// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.DrivebaseSubsystem;
import frc.robot.subsystems.OuttakeSubsystem;

public class RobotContainer {
  private DrivebaseSubsystem robotDrive; 
  private OuttakeSubsystem outtake;
  private CommandXboxController driveController;
    public RobotContainer() {
    robotDrive = new DrivebaseSubsystem();
    outtake = new OuttakeSubsystem();
    driveController = new CommandXboxController(0);
    

    robotDrive.setDefaultCommand(
      new DriveCommand(
        () -> -driveController.getLeftY(), 
        () -> -driveController.getRightX(), 
        robotDrive));

    configureBindings();
  
  }

  private void configureBindings() {
    driveController.leftBumper().whileTrue(new InstantCommand(outtake.outtakeIn()));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
