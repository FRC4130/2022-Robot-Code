package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxLimitSwitch;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robots.RobotMap;

public class Index {
    CANSparkMax index1;
    CANSparkMax index2;
    CANSparkMax intake;

    SparkMaxLimitSwitch sensor;
    SparkMaxLimitSwitch sensor2;

    public Index() {
        index1 = RobotMap.index1;
        index2 = RobotMap.index2;
        intake = RobotMap.intake;
        sensor = RobotMap.sensor;
        sensor2 = RobotMap.sensor2;
        index1.setInverted(true);
        index2.setInverted(true);
    }

    public void generalIndexControl(double pow) {
        index1.set(pow);
        index2.set(pow);
        intake.set(pow);
    }

    public void setNeutralMode(IdleMode nm) {
        index1.setIdleMode(nm);
        index2.setIdleMode(nm);
        intake.setIdleMode(nm);
    }

    public void runIndex() {
        //when index1 has no ball its true
        //when index2 has no ball its true
        if (sensor.isPressed()) {
            generalIndexControl(0.80);
        }
        else if (sensor2.isPressed()){
            generalIndexControl(0.80);
        } 
        else {
            generalIndexControl(0);
        }
    }

    public void shootIndex(){
        index1.set(.80);
        index2.set(.80);
    }

    public void SmartDashboard(){
        SmartDashboard.putBoolean("Index 1 Sensor", sensor.isPressed());
        SmartDashboard.putBoolean("Index 2 Sensor", sensor2.isPressed());

    }

}
