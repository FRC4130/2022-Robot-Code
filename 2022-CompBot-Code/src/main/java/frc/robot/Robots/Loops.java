package frc.robot.Robots;

import com.ctre.phoenix.schedulers.ConcurrentScheduler;
import com.ctre.phoenix.schedulers.SequentialScheduler;

import frc.robot.Loops.ClimbTele;
import frc.robot.Loops.DriveDistance;
import frc.robot.Loops.DriveRotate;
import frc.robot.Loops.DriveStraight;
import frc.robot.Loops.DriveTele;
import frc.robot.Loops.IndexTele;
import frc.robot.Loops.Intake;
import frc.robot.Loops.Shoot;

public class Loops {
    
    public static void sTeleop(ConcurrentScheduler teleop){
        teleop.add(new DriveTele());
        teleop.add(new IndexTele());
        teleop.add(new ClimbTele());
        //teleop.add(new DriveStraight());
    }

    public static void autonRed(SequentialScheduler auton, String target){

        switch (target){
            case "HZ 1 Ball Long":
                auton.add(new DriveDistance(240));
                auton.add(new Intake());
                auton.add(new DriveDistance(-240));
                auton.add(new DriveRotate(-45));
                auton.add(new DriveDistance(-130));
                auton.add(new Shoot(0));
                break;

            case "HZ 2 Ball":
                auton.add(new DriveDistance(120));
                //auton.add(new Intake());
                auton.add(new DriveDistance(-260));
                //auton.add(new Shoot());
                auton.add(new DriveDistance(130));
                auton.add(new DriveRotate(45));
                auton.add(new DriveDistance(170));
                //auton.add(new Intake());
                auton.add(new DriveDistance(-170));
                auton.add(new DriveRotate(-45));
                auton.add(new DriveDistance(-130));
                //auton.add(new Shoot());
                break;

            case "Red TA-robot faces wall":
                //auton.add(new Shoot());
                auton.add(new DriveDistance(50));
                auton.add(new Intake());
                auton.add(new DriveDistance(-50));
                //auton.add(new DriveRotate(45));
                //auton.add(new DriveDistance(-50));
                auton.add(new Shoot(0));
                //auton.add(new DriveRotate(45));
                //auton.add(new DriveDistance(160));
                //auton.add(new Intake());
                //auton.add(new DriveDistance(-160));
                //auton.add(new Shoot());
                break;
            }   
        }
        public static void autonBlue(SequentialScheduler auton, String target){
            switch (target) {
                case "HZ 1 Ball Long":
                auton.add(new DriveDistance(240));
                //auton.add(new Intake());
                auton.add(new DriveDistance(-240));
                auton.add(new DriveRotate(-45));
                auton.add(new DriveDistance(-130));
                //auton.add(new Shoot());
                break;

            case "HZ 2 Ball":
                auton.add(new DriveDistance(120));
                //auton.add(new Intake());
                auton.add(new DriveDistance(-260));
                //auton.add(new Shoot());
                auton.add(new DriveDistance(130));
                auton.add(new DriveRotate(45));
                auton.add(new DriveDistance(170));
                //auton.add(new Intake());
                auton.add(new DriveDistance(-170));
                auton.add(new DriveRotate(-45));
                auton.add(new DriveDistance(-130));
                //auton.add(new Shoot());
                break;

            case "TA-robot faces wall":
                auton.add(new DriveDistance(90));
                //auton.add(new Intake());
                auton.add(new DriveDistance(-50));
                auton.add(new DriveRotate(45));
                auton.add(new DriveDistance(-50));
                //auton.add(new Shoot());
                auton.add(new DriveRotate(45));
                auton.add(new DriveDistance(160));
                //auton.add(new Intake());
                auton.add(new DriveDistance(-160));
                //auton.add(new Shoot());
                break;

            }
        }
}
