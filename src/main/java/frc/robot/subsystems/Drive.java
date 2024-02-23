// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants;

import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.Drive;

public class Drive extends SubsystemBase {
  CANSparkMax leftfront;
  CANSparkMax rightfront;
  CANSparkMax leftback;
  CANSparkMax rightback;
  DifferentialDrive drive;

  /** Creates a new ExampleSubsystem. */
  public Drive() {
    
    leftfront = new CANSparkMax(Constants.LF, CANSparkLowLevel.MotorType.kBrushless);
    leftback = new CANSparkMax(Constants.LB, CANSparkLowLevel.MotorType.kBrushless);
    rightfront = new CANSparkMax(Constants.RF, CANSparkLowLevel.MotorType.kBrushless);
    rightback = new CANSparkMax(Constants.RB, CANSparkLowLevel.MotorType.kBrushless);

    leftfront.setSmartCurrentLimit(40);
    leftback.setSmartCurrentLimit(40);
    rightfront.setSmartCurrentLimit(40);
    rightback.setSmartCurrentLimit(40);

    leftback.follow(leftfront);
    rightback.follow(rightfront);

    drive = new DifferentialDrive(leftfront, rightfront);
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

   public void drive(double l, double r) {

    drive.tankDrive(-l, r);
   }
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
