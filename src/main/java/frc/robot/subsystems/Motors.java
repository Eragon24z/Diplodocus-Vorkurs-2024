// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;

public class Motors extends SubsystemBase {
  public TalonFX masterRight;
  public TalonFX masterLeft;
  private TalonFX followerRight;
  private TalonFX followerLeft;

  /** Creates a new ExampleSubsystem. */

  public Motors() {
    masterRight = new TalonFX(Constants.Drive.Motors.FRONTRIGHT);
    masterLeft = new TalonFX(Constants.Drive.Motors.FRONTLEFT);
    followerRight = new TalonFX(Constants.Drive.Motors.BACKRIGHT);
    followerLeft = new TalonFX(Constants.Drive.Motors.BACKLEFT);

    followerRight.setControl(new Follower(masterRight.getDeviceID(), false));
    followerLeft.setControl(new Follower(masterLeft.getDeviceID(), false));

  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a
   * digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
