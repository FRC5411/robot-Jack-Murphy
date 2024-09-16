// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DrivebaseSubsystem;

public class DriveCommand extends Command {
  private DoubleSupplier leftSupplier;
  private DoubleSupplier rightSupplier;
  private DrivebaseSubsystem m_drive;
  public DriveCommand(DoubleSupplier leftSupplier, DoubleSupplier rightSupplier, DrivebaseSubsystem drive) {
    this.leftSupplier = leftSupplier;
    this.rightSupplier = rightSupplier;
    m_drive = drive;
    addRequirements(m_drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftSpeed = leftSupplier.getAsDouble();
    double rightSpeed = rightSupplier.getAsDouble() * 0.5;
    m_drive.tankDrive(leftSpeed, rightSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
