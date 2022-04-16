package frc.robot;

import com.ctre.phoenix.schedulers.ConcurrentScheduler;
import com.ctre.phoenix.schedulers.SequentialScheduler;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Loops.DriveAndIntake;
import frc.robot.Loops.DriveAndIntakeWithoutIndex;
import frc.robot.Loops.DriveDistance;
import frc.robot.Loops.DriveRotate;
import frc.robot.Loops.LimelightAuton;
import frc.robot.Loops.Shoot;
import frc.robot.Robots.Loops;
import frc.robot.Robots.RobotMap;
import frc.robot.Robots.Subsystems;


public class Robot extends TimedRobot {

  ConcurrentScheduler teleop;

  SequentialScheduler red;
  SequentialScheduler blue;
  Alliance side;

  String[] pos = {"2 Ball", "4 Ball Wall", "4 Ball Straight", "Drive Rotate"};

  int posi = 0;

  @Override
  public void robotInit() {
    RobotMap.Init();
    Subsystems.Init();
    teleop = new ConcurrentScheduler();
    Loops.sTeleop(teleop);
    teleop.startAll();

    CameraServer.getInstance().startAutomaticCapture();
  }

  @Override
  public void robotPeriodic() {
    SmartDashboard.putString("Auton", pos[posi]);
    SmartDashboard.putNumber("Match Time", DriverStation.getMatchTime());

  }

  @Override
  public void autonomousInit() {
    red = new SequentialScheduler(0);
    blue = new SequentialScheduler(0);
    SmartDashboard.putString("Alliance", side.toString());

    if(side == Alliance.Red){
      switch(posi){
        //Two Ball Setup
        case 0:
          red.add(new DriveAndIntake(48));
          red.add(new LimelightAuton());
          red.add(new Shoot(0));
          red.add(new DriveDistance(20));
          break;
        //Three and Four ball set up wall-facing
        case 1:
          red.add(new DriveAndIntake(48));
          red.add(new Shoot(0));
          red.add(new DriveRotate(-81));
          red.add(new DriveAndIntake(215.5, 4250));
          red.add(new DriveRotate(22));
          red.add(new DriveDistance(-153));
          red.add(new Shoot(0));
          break;
        //Three and Four ball set up facing human player
        case 2:
          //red.add(new DriveAndIntake(58));
          red.add(new DriveAndIntakeWithoutIndex(58));
          red.add(new DriveRotate(5));
          red.add(new Shoot(3));
          red.add(new DriveRotate(-15));
          red.add(new DriveAndIntake(150, 4250));
          red.add(new DriveDistance(-150));
          red.add(new DriveRotate(22));
          red.add(new LimelightAuton());
          red.add(new Shoot(0));
          break;
        case 3:
          red.add(new DriveRotate(-90));
          break;
      }
        red.start();
    }
    else{
      switch(posi){
        //Two Ball Setup
        case 0:
          blue.add(new DriveAndIntake(48));
          blue.add(new LimelightAuton());
          blue.add(new Shoot(0));
          blue.add(new DriveDistance(20));
          break;
        //Three and Four ball set up wall-facing
        case 1:
          blue.add(new DriveAndIntake(48));
          blue.add(new Shoot(0));
          blue.add(new DriveRotate(-81));
          blue.add(new DriveAndIntake(215.5, 4250));
          blue.add(new DriveRotate(22));
          blue.add(new DriveDistance(-153));
          blue.add(new Shoot(0));
          break;
        //Three and Four ball set up facing human player
        case 2:
          blue.add(new DriveAndIntake(58));
          blue.add(new DriveRotate(5));
          blue.add(new Shoot(3));
          blue.add(new DriveRotate(-15));
          blue.add(new DriveAndIntake(150, 4250));
          blue.add(new DriveDistance(-150));
          blue.add(new DriveRotate(22));
          blue.add(new LimelightAuton());
          blue.add(new Shoot(0));
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
    //teleop = new ConcurrentScheduler();
    //Loops.sTeleop(teleop);
    //teleop.startAll();
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
