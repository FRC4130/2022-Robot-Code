package frc.robot.Robots;

import com.ctre.phoenix.schedulers.ConcurrentScheduler;
import com.ctre.phoenix.schedulers.SequentialScheduler;

import frc.robot.Loops.DriveDistance;
import frc.robot.Loops.DriveRotate;
import frc.robot.Loops.DriveTele;
import frc.robot.Loops.IndexTele;
import frc.robot.Loops.Intake;
import frc.robot.Loops.Shoot;

public class Loops {
    
    public static void sTeleop(ConcurrentScheduler teleop){
        teleop.add(new DriveTele());
        teleop.add(new IndexTele());
    }

    public static void HZ1Ball(SequentialScheduler auton, String target, boolean invert){

        double mInvert = invert ? -1:1;

        switch (target){
            case "Red HZ 1 Ball Long":
                auton.add(new DriveDistance(240));
                auton.add(new Intake());
                auton.add(new DriveDistance(-240));
                auton.add(new DriveRotate(-45));
                auton.add(new DriveDistance(-130));
                auton.add(new Shoot());
                break;

            case "Red HZ 2 Ball":
                auton.add(new DriveDistance(120));
                auton.add(new Intake());
                auton.add(new DriveDistance(-260));
                auton.add(new Shoot());
                auton.add(new DriveDistance(130));
                auton.add(new DriveRotate(45));
                auton.add(new DriveDistance(170));
                auton.add(new Intake());
                auton.add(new DriveDistance(-170));
                auton.add(new DriveRotate(-45));
                auton.add(new DriveDistance(-130));
                auton.add(new Shoot());
                break;

            case "Red TA-robot faces wall":
                auton.add(new DriveDistance(90));
                auton.add(new Intake());
                auton.add(new DriveDistance(-50));
                auton.add(new DriveRotate(45));
                auton.add(new DriveDistance(-50));
                auton.add(new Shoot());
                auton.add(new DriveRotate(45));
                auton.add(new DriveDistance(160));
                auton.add(new Intake());
                auton.add(new DriveDistance(-160));
                auton.add(new Shoot());
                break;
                
        }
    }

}
