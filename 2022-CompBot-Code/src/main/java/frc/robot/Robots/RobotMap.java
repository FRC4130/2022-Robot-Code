package frc.robot.Robots;

import com.ctre.phoenix.led.CANdle;
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
    public static TalonFX rightClimb;

    //Index & Intake Neo
    public static CANSparkMax index1;
    public static CANSparkMax index2;
    public static CANSparkMax index3;
    public static CANSparkMax intake;

    //Shooter motors
    public static TalonFX shooter;
    public static TalonFX shooter2;

    //Pigeon
    public static Pigeon2 pigeon;

    //Controllers
    public static PS4Controller controller;
    public static PS4Controller opController;

    //Solenoids
    public static DoubleSolenoid intakeLift;
    public static DoubleSolenoid climbAdjust;

    //Sensors 
    public static SparkMaxLimitSwitch sensor; //lower index sensor
    public static SparkMaxLimitSwitch sensor2; // middle index sensor
    public static DigitalInput leftClimbSensor;
    public static DigitalInput rightClimbSensor; 

    //CANdle
    public static CANdle candle;

    public static void Init() {
        //DriveTrain Motors
        leftDrive = new TalonFX(1, "CTR Chain");
        leftDrive2 = new TalonFX(2, "CTR Chain");
        rightDrive = new TalonFX(3, "CTR Chain");
        rightDrive2 = new TalonFX(4, "CTR Chain");

        //Climb Motors
        leftClimb = new TalonFX(5, "CTR Chain");
        rightClimb = new TalonFX(6, "CTR Chain");

        //Shooter
        shooter = new TalonFX(7, "CTR Chain");
        shooter2 = new TalonFX(8, "CTR Chain");
        
        //Controllers
        controller = new PS4Controller(0);
        opController = new PS4Controller(1);

        //index and intake
        intake = new CANSparkMax(9, MotorType.kBrushless);
        index1 = new CANSparkMax(10, MotorType.kBrushless);
        index2 = new CANSparkMax(11, MotorType.kBrushless);
        index3 = new CANSparkMax(15, MotorType.kBrushless);

        //Pigeon
        pigeon = new Pigeon2(13, "CTR Chain");
        
        //Solenoids
        intakeLift = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 1, 2);
        climbAdjust = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 6, 7);

        //Sensors
        sensor = index1.getReverseLimitSwitch(SparkMaxLimitSwitch.Type.kNormallyClosed);
        sensor2 = index3.getReverseLimitSwitch(SparkMaxLimitSwitch.Type.kNormallyClosed);
        leftClimbSensor = new DigitalInput(1);
        rightClimbSensor = new DigitalInput(0);

        candle = new CANdle(0, "CTR Chain");
    }
}
