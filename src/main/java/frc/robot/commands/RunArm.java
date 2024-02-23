package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.Constants.OperatorConstants;


/**
 * A simple command that grabs a hatch with the {@link HatchSubsystem}. Written explicitly for
 * pedagogical purposes. Actual code should inline a command this simple with {@link
 * edu.wpi.first.wpilibj2.command.InstantCommand}.
 */
public class RunArm extends Command {
    // The subsystem the command runs on

    private CommandXboxController m_manipulatorController;
    private double speed;
    private Double target;

    public RunArm(Double speed, Double target) {
        m_manipulatorController = new CommandXboxController(OperatorConstants.kManipulatorControllerPort);
        this.speed = speed;
        this.target = target;
        // addRequirements(RobotContainer.arm);
    }


    @Override
    public void initialize() {


    }
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        System.out.println("arm go brr");
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return true;
    }
}