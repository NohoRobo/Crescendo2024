package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class Arm extends SubsystemBase {

    CANSparkMax arm;
    RelativeEncoder encoder;
  /** Creates a new ExampleSubsystem. */

    public Arm() {
        arm = new CANSparkMax(Constants.ArmMotor, CANSparkLowLevel.MotorType.kBrushless);

        arm.setSmartCurrentLimit(40);
        arm.restoreFactoryDefaults();
        
        encoder = arm.getEncoder();
    }

    public void moveArm(Double speed) {
        arm.set(speed);
    }

    public double getRotations() {
        return encoder.getPosition();
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run during simulation
    }

}