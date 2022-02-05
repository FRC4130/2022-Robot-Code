package frc.robot.Robots;

import frc.robot.Subsystems.DriveTrain;

public class Subsystems {
    public static DriveTrain driveTrain;

    public static void Init(){
        driveTrain = new DriveTrain();
    }
}
