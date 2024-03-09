// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.ManualArm;
import frc.robot.commands.ManualDrive;
import frc.robot.commands.OuttakeCommand;
import frc.robot.commands.RunArm;
import frc.robot.commands.RunClimb;
import frc.robot.commands.RunIndexer;
import frc.robot.commands.RunIntake;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Climb;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public static Drive drive;
  public static Intake intake;
  public static Indexer indexer;
  public static Arm arm;
  public static Climb climb;

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController = new CommandXboxController(OperatorConstants.kDriverControllerPort);
  private final CommandXboxController m_manipulatorController = new CommandXboxController(OperatorConstants.kManipulatorControllerPort);

  public static DigitalInput limitSwitch1 = new DigitalInput(Constants.LimitSwitch1);
  public static DigitalInput limitSwitch2 = new DigitalInput(Constants.LimitSwitch2);
  public static DutyCycleEncoder dcEncoder = new DutyCycleEncoder(new DigitalInput(Constants.ThroughboreEncoder));
  public static Servo servoLeft = new Servo(0);
  public static Servo servoRight = new Servo(1);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    drive = new Drive();
    intake = new Intake();
    indexer = new Indexer();
    arm = new Arm();
    climb = new Climb();
    drive.setDefaultCommand(new ManualDrive());
    arm.resetEncoder();
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    //new Trigger(m_exampleSubsystem::exampleCondition)
    //    .onTrue();

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    // m_driverController.a().onTrue(new ExampleCommand(OneMotor, 3.0, -0.001));
    // m_driverController.x().onTrue(new ExampleCommand(OneMotor, 3.0, 0.0));
    // m_driverController.y().onTrue(new Hold(OneMotor));
    // m_manipulatorController.leftTrigger().whileTrue(new IntakeCommand(intake, arm, indexer));
    // m_manipulatorController.rightTrigger().whileTrue(new OuttakeCommand(intake, arm, indexer));
    m_manipulatorController.leftTrigger().whileTrue(new RunIntake(-1, Constants.IntakeSpeed));
    m_manipulatorController.rightTrigger().whileTrue(new RunIntake(1, Constants.IntakeSpeed*2));
    m_manipulatorController.leftBumper().whileTrue(new RunIndexer(-1));
    m_manipulatorController.rightBumper().whileTrue(new RunIndexer(1));
    m_manipulatorController.a().whileTrue(new RunArm(Constants.ArmSpeed, Constants.ArmMidExtent, 1));
    m_manipulatorController.b().whileTrue(new RunArm(Constants.ArmSpeed, Constants.ArmMaxExtent, 1));
    m_driverController.x().whileTrue(new RunClimb(1));
    m_driverController.y().whileTrue(new RunClimb(-1));
    m_manipulatorController.povDown().whileTrue(new RunIntake(1, Constants.AmpOuttakeSpeed));
    m_manipulatorController.povLeft().whileTrue(new ManualArm(Constants.ArmSpeed, 0.0, 1));
    m_manipulatorController.povRight().whileTrue(new ManualArm(Constants.ArmSpeed, 1.0, -1));

  }

  //TODO - run arm backwards until limitswitch 3 is pressed
  public void resetArmPosition() {
    
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  // public Command getAutonomousCommand() {
  //  // An example command will be run in autonomous
  
  // }

}
