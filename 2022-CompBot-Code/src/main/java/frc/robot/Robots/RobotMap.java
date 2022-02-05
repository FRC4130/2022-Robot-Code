package frc.robot.Robots;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

public class RobotMap {
    //DriveTrain Motors
    public static TalonFX leftDrive;
    public static TalonFX leftDrive2;
    public static TalonFX rightDrive;
    public static TalonFX rightDrive2;

    //Index & Intake Neo
    public static CANSparkMax index1;
    public static CANSparkMax index2;
    public static CANSparkMax intake;

    //Controllers
    public static PS4Controller controller;

    //Solenoids
    public static DoubleSolenoid intakeLift;

    public static void Init() {
        //DriveTrain Motors
        leftDrive = new TalonFX(1);
        leftDrive2 = new TalonFX(2);
        rightDrive = new TalonFX(3);
        rightDrive2 = new TalonFX(4);
        
        //Controllers
        controller = new PS4Controller(1);

        intake = new CANSparkMax(1, MotorType.kBrushless);
        index1 = new CANSparkMax(2, MotorType.kBrushless);
        index2 = new CANSparkMax(3, MotorType.kBrushless);

        //Solenoids
        intakeLift = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);
    }
    
}
