package frc.robot.Robots;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.PS4Controller;

public class RobotMap {
    public static TalonFX leftDrive;
    public static TalonFX leftDrive2;
    public static TalonFX rightDrive;
    public static TalonFX rightDrive2;

    public static CANSparkMax index1;
    public static CANSparkMax index2;
    public static CANSparkMax intake;

    public static PS4Controller controller;

    public static void Init() {
        leftDrive = new TalonFX(1);
        leftDrive2 = new TalonFX(2);
        rightDrive = new TalonFX(3);
        rightDrive2 = new TalonFX(4);
        
        controller = new PS4Controller(1);
    }
    
}
