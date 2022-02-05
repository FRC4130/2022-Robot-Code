package frc.robot.Robots;

import com.ctre.phoenix.schedulers.ConcurrentScheduler;

import frc.robot.Loops.DriveTele;

public class Loops {
    public static void sTeleop(ConcurrentScheduler teleop){
        teleop.add(new DriveTele());
    }
}
