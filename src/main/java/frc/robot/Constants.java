// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

  //Drive CAN IDs
  public static final int LF = 7;
  public static final int LB = 16;
  public static final int RF = 12;
  public static final int RB = 13;

  //Arm CAN IDs
  public static final int ArmMotor = 1;
  public static final int IntakeTop = 5;
  public static final int IntakeBottom = 3;

  //Indexer CAN ID
  public static final int IndexerMotor = 9;

  //Climb CAN IDs
  public static final int LC = 14;
  public static final int RC = 2;

  //Arm

  public static final double ArmMidExtent = 30;  

  public static final double ArmSpeed = 0.3;  
  
  public static final double ArmZeroTolerance = 0.3;


  public static final double SpeedScale = 0.85;

  public static final double IntakeSpeed = 0.45;
  public static final double OuttakeSpeed = 0.7;
  public static final double AmpOuttakeSpeed = 0.5;
  public static final double IndexSpeed = 0.2;
  public static final double ClimbSpeed = 0.3;

  public static final String LimelightName = "KakyloptekUponTheKaidu";
  //PV url http://kakyloptekuponthekaidu.local:5800/
  public static final int RollingAverageLength = 14;
  public static final double AimDivide = 5;
  public static final double AimSpeedScale = 0.3;

  public static final double AimPidP = 1.0;
  public static final double AimPidI = 0.0;
  public static final double AimPidD = 0.0;

  //Sensor Ports
  public static final int LimitSwitch1 = 0;
  public static final int LimitSwitch2 = 1;
  public static final int LimitSwitch3 = 2;
  public static final int ThroughboreEncoder = 3;






  public static class OperatorConstants {
    public static final int kDriverControllerPort = 1;
    public static final int kManipulatorControllerPort = 0;
  }
}
  