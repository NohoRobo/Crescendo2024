// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import frc.robot.Constants;

public class Indexer extends SubsystemBase {
  /** Creates a new Indexer. */
  CANSparkMax indexerMotor;
  public Indexer() {
    indexerMotor = new CANSparkMax(Constants.IndexerMotor, CANSparkLowLevel.MotorType.kBrushless);
    indexerMotor.setSmartCurrentLimit(20);
    indexerMotor.restoreFactoryDefaults();
  }

  public void index(Double speed, Integer mode) {
    indexerMotor.set(mode * speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
