package frc.robot.Robots;

import frc.robot.Subsystems.DriveTrain;
import frc.robot.Subsystems.Index;
import frc.robot.Subsystems.IntakePosition;
import frc.robot.Subsystems.LED;
import frc.robot.Subsystems.Climb;
import frc.robot.Subsystems.ClimbPosition;

public class Subsystems {
    public static DriveTrain driveTrain;
    public static Index index;
    public static IntakePosition intakePosition;
    public static Climb climb;
    public static ClimbPosition climbPosition;
    public static LED led;

    public static void Init(){
        driveTrain = new DriveTrain();
        index = new Index();
        intakePosition = new IntakePosition();
        climb = new Climb();
        climbPosition = new ClimbPosition();
        led = new LED();
    }
}
