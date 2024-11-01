// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.Drive;
import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class DriveCommand extends Command {
  private final Drive drive;

  Joystick joystick = new Joystick(Constants.Drive.Joystick.PORT);
  private double deadzone = Constants.Drive.Joystick.DeadzoneDefault; 
  private double sensitivity = Constants.Drive.Joystick.SensitivityDefault;
  /**
   * Creates a new ExampleCommand.
   *
   * @param drive The subsystem used by this command.
   */
  public DriveCommand(Drive drive) {
    addRequirements(drive);
    this.drive = drive;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double y = joystick.getY();
    double x = joystick.getX();
    if (Math.abs(x) > deadzone || Math.abs(y) > deadzone) {
      drive.drive(x*sensitivity, y*sensitivity);
    }
    else{
      drive.drive(0, 0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
  @Override
  public void initSendable(SendableBuilder builder) {
    builder.addDoubleProperty("Sensitivity", ()->sensitivity,(newSensitivityValue)->sensitivity=newSensitivityValue);
    builder.addDoubleProperty("Deadzone", ()->deadzone, (newDeadzoneValue)->deadzone=newDeadzoneValue);
      super.initSendable(builder);
  }
}
