package frc.robot;

import com.ctre.phoenix.schedulers.ConcurrentScheduler;
import com.ctre.phoenix.schedulers.SequentialScheduler;

import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.Robots.Loops;
import frc.robot.Robots.RobotMap;
import frc.robot.Robots.Subsystems;


public class Robot extends TimedRobot {

  ConcurrentScheduler teleop;

  SequentialScheduler red;
  SequentialScheduler blue;

  String[] target = {"HZ 1 Ball Long", "HZ 2 Ball", "TA-robot faces wall"};
  //ArrayList<String> target = new ArrayList<>();

  int targeti = 0;

  int posi = 0;
  
  @Override
  public void robotInit() {
    RobotMap.Init();
    Subsystems.Init();


    //_drive = Subsystems.driveTrain;
    //_index = Subsystems.index;
  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {

    red = new SequentialScheduler(0);
    blue = new SequentialScheduler(0);

    switch (posi) {
      case 0:
        Loops.autonRed(red, target[targeti]);
    }
  }

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
