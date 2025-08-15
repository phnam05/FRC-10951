// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.util.sendable.SendableRegistry;
import edu.wpi.first.wpilibj.PS5Controller;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;

/**
 * The methods in this class are called automatically corresponding to each mode, as described in
 * the TimedRobot documentation. If you change the name of this class or the package after creating
 * this project, you must also update the manifest file in the resource directory.
 */
public class Robot extends TimedRobot {
  private final double START = 5;
  private final WPI_TalonSRX m_leftDrive = new WPI_TalonSRX(10);
  private final WPI_TalonSRX m_rightDrive = new WPI_TalonSRX(2);
  // private final PWMSparkMax m_leftDrive = new PWMSparkMax(10);
  // private final PWMSparkMax m_rightDrive = new PWMSparkMax(2);
  // private final WPI_TalonSRX m_leftLeader = new WPI_TalonSRX(10);
 //private final WPI_VictorSPX m_leftDrive = new WPI_VictorSPX(7);
  // private final WPI_VictorSPX m_leftFollower = new WPI_VictorSPX(7);
  // private final WPI_TalonSRX m_rightLeader = new WPI_TalonSRX(2);
  // private final WPI_VictorSPX m_rightFollower = new WPI_VictorSPX(3);
  //private final WPI_VictorSPX m_rightDrive = new WPI_VictorSPX(2);

  private final DifferentialDrive m_robotDrive =
      new DifferentialDrive(m_leftDrive::set, m_rightDrive::set);

  private final PS5Controller m_controller = new PS5Controller(0);
  private final Timer m_timer = new Timer();

  /** Called once at the beginning of the robot program. */
  public Robot() {
    SendableRegistry.addChild(m_robotDrive, m_leftDrive);
    SendableRegistry.addChild(m_robotDrive, m_rightDrive);

    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
    m_rightDrive.setInverted(true);
  }

  /** This function is run once each time the robot enters autonomous mode. */
  @Override
  public void autonomousInit() {
    m_timer.restart();
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    

    //Drive for 3 seconds
    if (m_timer.get() < START) {
      // Drive forwards half speed, make sure to turn input squaring off
      m_robotDrive.arcadeDrive(0.35, 0.0, false);
    }
    else  if (m_timer.get() < START + 0.7) {
      // Drive forwards half speed, make sure to turn input squaring off
      m_robotDrive.arcadeDrive(0.0, 0.5, false);
    }
    else  if (m_timer.get() < 6.7) {
      // Drive forwards half speed, make sure to turn input squaring off
      m_robotDrive.arcadeDrive(0.35, 0.0, false);
    }
    else  if (m_timer.get() < 7.4) {
      // Drive forwards half speed, make sure to turn input squaring off
      m_robotDrive.arcadeDrive(0.0, 0.5, false);
    }
    else  if (m_timer.get() < 10.4) {
      // Drive forwards half speed, make sure to turn input squaring off
      m_robotDrive.arcadeDrive(0.35, 0.0, false);
    }
    else  if (m_timer.get() < 11.1) {
      // Drive forwards half speed, make sure to turn input squaring off
      m_robotDrive.arcadeDrive(0.0, 0.5, false);
    }
    else{
      m_robotDrive.stopMotor();
    }
    System.out.println(m_timer.get());
  }

  /** This function is called once each time the robot enters teleoperated mode. */
  @Override
  public void teleopInit() {}

  /** This function is called periodically during teleoperated mode. */
  @Override
  public void teleopPeriodic() {
    m_robotDrive.arcadeDrive(-m_controller.getLeftY(), -m_controller.getRightX());
  }

  /** This function is called once each time the robot enters test mode. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  
}
