// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.OperatorConstants;
import frc.robot.RobotContainer;

public class ManualArm extends Command {
  private CommandXboxController m_manipulatorController;
  private Double speed;
  private Double target;
  private Integer mode;

  /** Creates a new ManualArm. */
  public ManualArm(Double speed, Double target, Integer mode) {
    // Use addRequirements() here to declare subsystem dependencies.
            m_manipulatorController = new CommandXboxController(OperatorConstants.kManipulatorControllerPort);
        this.speed = speed;
        this.target = target;
        this.mode = mode;
        addRequirements(RobotContainer.arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.arm.moveArm(speed * mode);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.arm.moveArm(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
