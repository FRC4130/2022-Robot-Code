package frc.robot.Robots;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.sensors.Pigeon2;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxLimitSwitch;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
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
    public static TalonFX leftClimbAdjust;
    public static TalonFX rightClimb;
    public static TalonFX rightClimbAdjust;

    //Index & Intake Neo
    public static CANSparkMax index1;
    public static CANSparkMax index2;
    public static CANSparkMax intake;
    public static TalonFX shooter;

    //Pigeon
    public static Pigeon2 pigeon;

    //Controllers
    public static PS4Controller controller;
    public static PS4Controller opController;

    //Solenoids
    public static DoubleSolenoid intakeLift;

    //Sensors 
    public static SparkMaxLimitSwitch sensor; //lower index sensor
    public static SparkMaxLimitSwitch sensor2; // higher index sensor
    public static DigitalInput leftClimbSensor;
    public static DigitalInput rightClimbSensor; 

    public static void Init() {
        //DriveTrain Motors
        //Serial for Canivore 30C395F03353385320202034100E03FF
        leftDrive = new TalonFX(1, "CTR Chain");
        leftDrive2 = new TalonFX(2, "CTR Chain");
        rightDrive = new TalonFX(3, "CTR Chain");
        rightDrive2 = new TalonFX(4, "CTR Chain");

        //Climb Motors
        leftClimb = new TalonFX(5, "CTR Chain");
        rightClimb = new TalonFX(6, "CTR Chain");
        leftClimbAdjust = new TalonFX(7, "CTR Chain");
        rightClimbAdjust = new TalonFX(8, "CTR Chain");
        
        //Controllers
        controller = new PS4Controller(0);
        opController = new PS4Controller(1);

        //index and intake
        intake = new CANSparkMax(9, MotorType.kBrushless);
        index1 = new CANSparkMax(10, MotorType.kBrushless);
        index2 = new CANSparkMax(11, MotorType.kBrushless);
        shooter = new TalonFX(12, "CTR Chain");

        //Pigeon
        pigeon = new Pigeon2(0);
        
        //Solenoids
        intakeLift = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 1, 2);

        //Sensors
        sensor = index1.getReverseLimitSwitch(SparkMaxLimitSwitch.Type.kNormallyClosed);
        sensor2 = index2.getReverseLimitSwitch(SparkMaxLimitSwitch.Type.kNormallyClosed);
        leftClimbSensor = new DigitalInput(0);
        rightClimbSensor = new DigitalInput(0);
    }
}
