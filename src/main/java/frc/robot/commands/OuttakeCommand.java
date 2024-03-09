package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.Constants;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Intake;

public class OuttakeCommand extends ParallelCommandGroup {
    public OuttakeCommand(Intake intake, Arm arm, Indexer indexer) {
        // addCommands(
        //     new RunIntake(1),         
        //     new RunArm(Constants.ArmSpeed, Constants.ArmMidExtent, 1)
        // );
    }
}
