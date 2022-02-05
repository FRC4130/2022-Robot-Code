package frc.robot.Robots;

import frc.robot.Subsystems.DriveTrain;
import frc.robot.Subsystems.Index;

public class Subsystems {
    public static DriveTrain driveTrain;
    public static Index index;

    public static void Init(){
        driveTrain = new DriveTrain();
        index = new Index();
    }
}
