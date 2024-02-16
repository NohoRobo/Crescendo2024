// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.Constants.OperatorConstants;

public class ManualDrive extends Command {

  private final CommandXboxController m_driverController;
  //private final Drive m_drive;

  /** Creates a new ManualDrive. */
  public ManualDrive() {
    m_driverController = new CommandXboxController(OperatorConstants.kDriverControllerPort);
    //m_drive = drive;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Double l = m_driverController.getLeftY();
    Double r = m_driverController.getRightY();

    RobotContainer.drive.drive((l*l*l) * Constants.SpeedScale, (r*r*r) * Constants.SpeedScale);
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
}
