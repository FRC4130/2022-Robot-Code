package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.PS4Controller;

public class RobotMap {

    //DriveTrain
    public static TalonFX leftDrive;
    public static TalonFX leftDrive2;
    public static TalonFX rightDrive;
    public static TalonFX rightDrive2;

    public static PS4Controller driveController;

    public static void Init(){

        leftDrive = new TalonFX(1);
        leftDrive2 = new TalonFX(2);
        rightDrive = new TalonFX(3);
        rightDrive2 = new TalonFX(4);

        driveController = new PS4Controller(0);
    }
}
