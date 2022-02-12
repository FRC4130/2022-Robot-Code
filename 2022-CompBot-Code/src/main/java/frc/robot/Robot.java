package frc.robot;

import com.ctre.phoenix.schedulers.ConcurrentScheduler;

import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.Robots.Loops;
import frc.robot.Robots.RobotMap;
import frc.robot.Robots.Subsystems;
import frc.robot.Subsystems.DriveTrain;
import frc.robot.Subsystems.Index;


public class Robot extends TimedRobot {

  ConcurrentScheduler teleop;
  DriveTrain _drive;
  Index _index;

  public Robot(){
      _drive = Subsystems.driveTrain;
      _index = Subsystems.index;
  }
  
  @Override
  public void robotInit() {
    RobotMap.Init();
    Subsystems.Init();
    _drive = Subsystems.driveTrain;
    _index = Subsystems.index;
  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

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
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}
}
