package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase {

    CANSparkMax arm;
    RelativeEncoder encoder;
  /** Creates a new ExampleSubsystem. */

    public Arm() {
        arm = new CANSparkMax(Constants.ArmMotor, CANSparkLowLevel.MotorType.kBrushless);
        arm.restoreFactoryDefaults();
        encoder = arm.getEncoder();
    }

    public void moveArm(Double speed, Double armPosition) {
        double pos = encoder.getPosition();
        if (speed >= 0 && pos < armPosition) {
            arm.set(speed);
        } else if (speed < 0 && pos > 0) {
            arm.set(speed);
        } else {
            arm.set(0);
        }
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