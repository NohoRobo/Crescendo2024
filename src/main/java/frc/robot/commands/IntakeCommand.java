package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Intake;
import frc.robot.Constants;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Indexer;
import frc.robot.RobotContainer;


public class IntakeCommand extends SequentialCommandGroup {

    
    public IntakeCommand(Intake intake, Arm arm, Indexer indexer) {
        addCommands(
            new ParallelDeadlineGroup(           
                new RunIntake(-1).until(RobotContainer.limitSwitch1::get)
                // new RunArm(Constants.ArmSpeed, Constants.ArmMaxExtent, -1)      
            )
        );

        // addCommands(new RunIndexer(-1).until(RobotContainer.limitSwitch2::get));
    }
}
