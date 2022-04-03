package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxLimitSwitch;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robots.RobotMap;

public class Index {
    CANSparkMax index1;
    CANSparkMax index2;
    CANSparkMax index3;
    CANSparkMax intake;

    PS4Controller controller;
    TalonFX shooter;
    TalonFX shooter2;

    SparkMaxLimitSwitch sensor;
    SparkMaxLimitSwitch sensor2;

    public Index() {
        controller = RobotMap.opController;
        intake = RobotMap.intake;
        index1 = RobotMap.index1;
        index2 = RobotMap.index2;
        index3 = RobotMap.index3;

        shooter = RobotMap.shooter;
        shooter2 = RobotMap.shooter2;

        sensor = RobotMap.sensor;
        sensor2 = RobotMap.sensor2;
        index1.setInverted(true);
        index2.setInverted(true);

        shooter2.follow(shooter);
        shooter2.setInverted(InvertType.OpposeMaster);

        //index3.setInverted(false);
    }

    public void generalIndexControl(double pow) {
        index1.set(pow);
        index2.set(pow);
        intake.set(pow);
    }

    public void shooterControl(double pow) {
        shooter.set(ControlMode.PercentOutput, pow);
        index3.set(pow);
    }

    public void setNeutralMode(IdleMode nm) {
        index1.setIdleMode(nm);
        index2.setIdleMode(nm);
        index3.setIdleMode(nm);
        intake.setIdleMode(nm);
    }

    public void runIndex() {
        if (!sensor.isPressed()) {
            if (!sensor2.isPressed()){
                index1.set(0);
                index2.set(0);
                intake.set(0);
            }
        }
        else if (!sensor2.isPressed()){
            index2.set(0);
            index1.set(0.80);
            intake.set(0.80);
        }
        else {
            generalIndexControl(.80);
        }
    }

    public void shootHighIndex(){
        shooter.set(ControlMode.PercentOutput, 0.465);
        index3.set(.40);
        while(shooter.getMotorOutputPercent() > .435 && controller.getTriangleButton()){
            index1.set(.43);
            index2.set(.40);
        }
    }

    public void shootLowIndex(){
        shooter.set(ControlMode.PercentOutput, 0.22);
        index3.set(.80);
        while(shooter.getMotorOutputPercent() > .18 && controller.getCrossButton()){
            index1.set(.55);
            index2.set(.80);
        }
    }

    public void shootHanger(){
        shooter.set(ControlMode.PercentOutput, 0.59);
        index3.set(.55);
        while(shooter.getMotorOutputPercent() > .55 && controller.getSquareButton()){
            index1.set(.50);
            index2.set(.50);
        }
    }

    public void SmartDashboard(){
        SmartDashboard.putBoolean("Index 1 Sensor", sensor.isPressed());
        SmartDashboard.putBoolean("Index 2 Sensor", sensor2.isPressed());

    }

}
