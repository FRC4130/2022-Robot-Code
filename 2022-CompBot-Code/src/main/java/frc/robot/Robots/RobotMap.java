package frc.robot.Robots;

import com.ctre.phoenix.motorcontrol.can.TalonFX;

public class RobotMap {
    public static TalonFX leftDrive;
    public static TalonFX leftDrive2;
    public static TalonFX rightDrive;
    public static TalonFX rightDrive2;

    //public static CANSparkMax neo;

    public static void Init(){
        leftDrive = new TalonFX(1);
        leftDrive2 = new TalonFX(2);
        rightDrive = new TalonFX(3);
        rightDrive2 = new TalonFX(4);
    }
}
