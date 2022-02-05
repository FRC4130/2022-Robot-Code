package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import frc.robot.Robots.RobotMap;

public class DriveTrain {
    public static TalonFX leftDrive;
    public static TalonFX leftDrive2;

    public static TalonFX rightDrive;
    public static TalonFX rightDrive2;

    public DriveTrain(){
        leftDrive = RobotMap.leftDrive
        leftDrive2 = RobotMap.leftDrive2;
        rightDrive = RobotMap.rightDrive;
        rightDrive2 = RobotMap.rightDrive2;
    }

    public void setNeutralMode(NeutralMode nm){
        leftDrive.setNeutralMode(nm);
        leftDrive2.setNeutralMode(nm);
        rightDrive.setNeutralMode(nm);
        rightDrive2.setNeutralMode(nm);
    }
}
