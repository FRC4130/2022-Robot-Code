package frc.robot;

import com.ctre.phoenix.schedulers.ConcurrentScheduler;
import com.ctre.phoenix.schedulers.SequentialScheduler;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Loops.DriveDistance;
import frc.robot.Loops.Shoot;
import frc.robot.Loops.Intake;
import frc.robot.Robots.Loops;
import frc.robot.Robots.RobotMap;
import frc.robot.Robots.Subsystems;


public class Robot extends TimedRobot {

  ConcurrentScheduler teleop;

  SequentialScheduler red;
  SequentialScheduler blue;
  Alliance side;

  String[] pos = {"HZ 1 Ball Long", "HZ 2 Ball", "TA-Robot Faces Wall"};

  int posi = 2;
  
  @Override
  public void robotInit() {
    RobotMap.Init();
    Subsystems.Init();
    CameraServer.startAutomaticCapture();
  }

  @Override
  public void robotPeriodic() {
    SmartDashboard.putString("Auton", pos[posi]);
  }

  @Override
  public void autonomousInit() {
    red = new SequentialScheduler(0);
    blue = new SequentialScheduler(0);
    SmartDashboard.putString("Alliance", side.toString());

    if(side == Alliance.Red){
      switch(posi){
        case 0:
          Loops.autonRed(red, pos[posi]);
          SmartDashboard.putString("Working", "Yes");
          break;
        case 1:
          Loops.autonRed(red, pos[posi]);
          SmartDashboard.putString("Working", "Yes");
          break;
        case 2:
          red.add(new Shoot());
          red.add(new DriveDistance(50));
          red.add(new Intake());
          red.add(new DriveDistance(-50));
          red.add(new Shoot());
          red.add(new DriveDistance(70));
          break;
      }
        red.start();
    }
    else{
      switch(posi){
        case 0:
          Loops.autonBlue(blue, pos[posi]);
          break;
        case 1:
          Loops.autonBlue(blue, pos[posi]);
          break;
        case 2:
          blue.add(new Shoot());
          blue.add(new DriveDistance(50));
          blue.add(new Intake());
          blue.add(new DriveDistance(-50));
          blue.add(new Shoot());
          blue.add(new DriveDistance(65));
        break;
      }
      blue.start();
    }

  }

  @Override
  public void autonomousPeriodic() {
    if(side == Alliance.Red){
      red.process();
    }
    else{
      blue.process();
    }
  }

  @Override
  public void teleopInit() {
    teleop = new ConcurrentScheduler();
    Loops.sTeleop(teleop);
    teleop.startAll();
  }

  @Override
  public void teleopPeriodic() {
    teleop.process();

  }

  @Override
  public void disabledInit() {
    side = DriverStation.getAlliance();
  }

  @Override
  public void disabledPeriodic() {
    if(RobotMap.controller.getL3ButtonPressed()){
      posi++;
    }
  }

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}
}
