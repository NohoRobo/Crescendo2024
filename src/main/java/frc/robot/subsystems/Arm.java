package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class Arm extends SubsystemBase {
    
    CANSparkMax arm;
    public RelativeEncoder encoder;
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
        double pos = encoder.getPosition();
        if (Math.abs(pos - Constants.ArmZeroTolerance) < 2) {
            pos = 0;
        }
        if (pos != 0) {
            return -pos;
        } else {
            return 0;
        }
    }

    public void resetEncoder() {
        encoder.setPosition(0);
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