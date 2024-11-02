// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import java.net.BindException;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.DrivebaseSubsystem;
import frc.robot.subsystems.DispenserSubsystem;

public class RobotContainer {
  private DrivebaseSubsystem robotDrive; 
  private DispenserSubsystem robotDispenser;
  private CommandXboxController driveController;
    public RobotContainer() {
    robotDrive = new DrivebaseSubsystem();
    robotDispenser = new DispenserSubsystem();
    driveController = new CommandXboxController(0);    

    robotDrive.setDefaultCommand(
      new DriveCommand(
        () -> -driveController.getLeftY(), 
        () -> -driveController.getRightX(), 
        robotDrive));


    configureButtonBindings();
  }

  private void configureButtonBindings() {
    driveController.rightTrigger().onTrue(new InstantCommand(() -> {robotDispenser.setMotor(0.05);}, robotDispenser));
    driveController.rightTrigger().onFalse(new InstantCommand(() -> {robotDispenser.setMotor(0);}, robotDispenser));

    driveController.leftTrigger().onTrue(new InstantCommand(() -> {robotDispenser.setMotor(-0.05);}, robotDispenser));
    driveController.leftTrigger().onFalse(new InstantCommand(() -> {robotDispenser.setMotor(0);}, robotDispenser));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
