package frc.robot.Robots;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.sensors.Pigeon2;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxLimitSwitch;
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

    //Climb Motors
    public static TalonFX leftClimb;
    public static TalonFX rightClimb;

    //Index & Intake Neo
    public static CANSparkMax index1;
    public static CANSparkMax index2;
    public static CANSparkMax intake;

    //Pigeon
    public static Pigeon2 pigeon;

    //Controllers
    public static PS4Controller controller;
    public static PS4Controller opController;

    //Solenoids
    public static DoubleSolenoid intakeLift;

    //Sensors 
    public static SparkMaxLimitSwitch sensor; //lower sensor
    public static SparkMaxLimitSwitch sensor2; // higher sensor

    public static void Init() {
        //DriveTrain Motors
        leftDrive = new TalonFX(1);
        leftDrive2 = new TalonFX(2);
        rightDrive = new TalonFX(3);
        rightDrive2 = new TalonFX(4);

        //Climb Motors
        leftClimb = new TalonFX(5);
        rightClimb = new TalonFX(6);
        
        //Controllers
        controller = new PS4Controller(1);

        //index and intake
        intake = new CANSparkMax(2, MotorType.kBrushless);
        index1 = new CANSparkMax(3, MotorType.kBrushless);
        index2 = new CANSparkMax(4, MotorType.kBrushless);

        //Pigeon
        pigeon = new Pigeon2(0);
        
        //Solenoids
        intakeLift = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);

        //Sensors
        sensor = index1.getReverseLimitSwitch(SparkMaxLimitSwitch.Type.kNormallyClosed);
        sensor2 = index2.getReverseLimitSwitch(SparkMaxLimitSwitch.Type.kNormallyClosed);
    }
}
