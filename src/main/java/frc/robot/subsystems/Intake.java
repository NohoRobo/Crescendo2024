package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
    CANSparkMax I1;
    CANSparkMax I2;
  /** Creates a new ExampleSubsystem. */

    public Intake() {
        I1 = new CANSparkMax(Constants.IntakeTop, CANSparkLowLevel.MotorType.kBrushless);
        I2 = new CANSparkMax(Constants.IntakeBottom, CANSparkLowLevel.MotorType.kBrushless);
        I1.setSmartCurrentLimit(40);
        I2.setSmartCurrentLimit(40);
        I1.restoreFactoryDefaults();
        I2.restoreFactoryDefaults();
    }

    public void intake(Double speed, int mode) {
        I1.set(mode * speed);
        I2.set(-mode * speed);
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
