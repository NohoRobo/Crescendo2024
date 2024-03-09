package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.OperatorConstants;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class RunIntake extends Command {

    private final CommandXboxController m_manipulatorController;
    private int mode;
    private double speed;

    public RunIntake(Integer mode, Double speed) {
        m_manipulatorController = new CommandXboxController(OperatorConstants.kManipulatorControllerPort);
        this.mode = mode;
        this.speed = speed;
        addRequirements(RobotContainer.intake);
    }

    @Override
    public void initialize() {

    }
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        if (mode == -1) {
            RobotContainer.intake.intake(speed, mode);
        }
        else {
            RobotContainer.intake.intake(speed, mode);            
        }

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
