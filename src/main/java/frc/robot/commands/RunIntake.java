package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.OperatorConstants;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class RunIntake extends Command {

    private final CommandXboxController m_manipulatorController;
    private int mode;

    public RunIntake(Integer mode) {
        m_manipulatorController = new CommandXboxController(OperatorConstants.kManipulatorControllerPort);
        this.mode = mode;
        addRequirements(RobotContainer.intake);
    }

    @Override
    public void initialize() {

    }
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        RobotContainer.intake.intake(Constants.IntakeSpeed, mode);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        RobotContainer.intake.intake(0.0, 0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}
