package frc.robot.Robots;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.PS4Controller;

public class RobotMap {
    //DT Motors
    public static TalonFX leftDrive;
    public static TalonFX leftDrive2;
    public static TalonFX rightDrive;
    public static TalonFX rightDrive2;

   // public static CANSpark

    public static void Init() {

        //DriveTrain Motors
        leftDrive = new TalonFX(1);
        leftDrive2 = new TalonFX(2);
        rightDrive = new TalonFX(3);
        rightDrive2 = new TalonFX(4);
    }
    
}
