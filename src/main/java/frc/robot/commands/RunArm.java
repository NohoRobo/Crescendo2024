package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.Constants.OperatorConstants;
import frc.robot.Robot;


/**
 * A simple command that grabs a hatch with the {@link HatchSubsystem}. Written explicitly for
 * pedagogical purposes. Actual code should inline a command this simple with {@link
 * edu.wpi.first.wpilibj2.command.InstantCommand}.
 */
public class RunArm extends Command {
    // The subsystem the command runs on

    private final double tolerance = 1.0f;

    private CommandXboxController m_manipulatorController;
    private double speed;
    private int mode;
    private double target;
    

    public RunArm(Double speed, Double target, Integer mode) {
        m_manipulatorController = new CommandXboxController(OperatorConstants.kManipulatorControllerPort);
        this.speed = speed;
        this.target = target;
        this.mode = mode;
        addRequirements(RobotContainer.arm);
    }


    @Override
    public void initialize() {


    }
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        if (mode == 1) {
            RobotContainer.arm.moveArm(speed * mode);
        }
        else {
            RobotContainer.arm.moveArm(-0.02);
        }


        // if (RobotContainer.arm.getRotations() < target) {
        //     RobotContainer.arm.moveArm(Constants.ArmSpeed);
        // }
        // if (RobotContainer.arm.getRotations() > target) {
        //     RobotContainer.arm.moveArm((-1) * Constants.ArmSpeed);
        // }

    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        RobotContainer.arm.moveArm(0.08);
    
    }

    @Override
    public boolean isFinished() {
        // double distanceDifference = RobotContainer.arm.getRotations() - target;
        // return Math.abs(distanceDifference) < tolerance;
        return false;       
    }
}