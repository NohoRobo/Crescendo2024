// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climb extends SubsystemBase {
  /** Creates a new Climb. */
  CANSparkMax leftClimb;
  CANSparkMax rightClimb;

  public Climb() {
    leftClimb = new CANSparkMax(Constants.LC, CANSparkLowLevel.MotorType.kBrushless);
    rightClimb = new CANSparkMax(Constants.RC, CANSparkLowLevel.MotorType.kBrushless);

    leftClimb.setSmartCurrentLimit(40);
    rightClimb.setSmartCurrentLimit(40);

    leftClimb.restoreFactoryDefaults();
    rightClimb.restoreFactoryDefaults();
  }

  

  public void extend(Double speed) {
    leftClimb.set(speed);
    rightClimb.set(speed);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
