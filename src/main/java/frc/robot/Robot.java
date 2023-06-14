// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;


/**
 * This is a demo program showing the use of the DifferentialDrive class, specifically it contains
 * the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  private DifferentialDrive m_myRobot;
  private Joystick driveControll;
  public  double stick_r;
  public double stick_l;

  private final WPI_TalonSRX m_leftMotor_1 = new WPI_TalonSRX(1);
  private final WPI_TalonSRX m_leftMotor_2 = new WPI_TalonSRX(2);

  private final WPI_TalonSRX m_rightMotor_1 = new WPI_TalonSRX(9);
  private final WPI_TalonSRX m_rightMotor_2 = new WPI_TalonSRX(10);

  

  @Override
  public void robotInit() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
   m_leftMotor_2.follow(m_leftMotor_1);
    m_rightMotor_2.follow(m_rightMotor_1);

     m_rightMotor_1.setInverted(false);

    m_myRobot = new DifferentialDrive(m_leftMotor_1, m_rightMotor_1);
    driveControll = new Joystick(1);
  
  }

  @Override
  public void teleopPeriodic() {
    stick_r = driveControll.getRawAxis(5) * -1;
    stick_l = driveControll.getRawAxis(1);
    m_myRobot.tankDrive(stick_r, stick_l);
    
  }
}
