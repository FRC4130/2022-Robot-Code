package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robots.RobotMap;

public class Climb {

    TalonFX leftClimb;
    TalonFX rightClimb;    
    TalonFX leftClimbAdjust;
    TalonFX rightClimbAdjust;
    PS4Controller controller;

    DigitalInput leftClimbSensor;
    DigitalInput rightClimbSensor;

    public Climb() {

        leftClimb = RobotMap.leftClimb;
        rightClimb = RobotMap.rightClimb;

        leftClimbAdjust = RobotMap.leftClimbAdjust;
        rightClimbAdjust = RobotMap.rightClimbAdjust;

        leftClimbSensor = RobotMap.leftClimbSensor;
        rightClimbSensor = RobotMap.rightClimbSensor;

        controller = RobotMap.controller;

        leftClimb.set(ControlMode.PercentOutput, 0);
        rightClimb.set(ControlMode.PercentOutput, 0);

        leftClimbAdjust.set(ControlMode.PercentOutput, 0);
        rightClimbAdjust.set(ControlMode.PercentOutput, 0);

        rightClimbAdjust.follow(leftClimbAdjust);

        leftClimb.setInverted(false);
        rightClimb.setInverted(true);

        leftClimbAdjust.setInverted(true);
        rightClimbAdjust.setInverted(InvertType.OpposeMaster);

        leftClimb.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, 0, 5);
        rightClimb.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, 0, 5);
    }

    public void setNeutralModeClimb(NeutralMode nm){
        leftClimb.setNeutralMode(nm);
        rightClimb.setNeutralMode(nm);

    }

    public void setNeutralModeAdjust(NeutralMode nm){
        leftClimbAdjust.setNeutralMode(nm);
        rightClimbAdjust.setNeutralMode(nm);
    }

    public void ClimbMovement(double climberThrottle){

        if (!leftClimbSensor.get()){
            leftClimb.set(ControlMode.PercentOutput, climberThrottle);
        }
        else{
            leftClimb.set(ControlMode.PercentOutput, 0);
            leftClimb.setSelectedSensorPosition(0);
        }

        if (!rightClimbSensor.get()){
            rightClimb.set(ControlMode.PercentOutput, climberThrottle);
        }
        else{
            rightClimb.set(ControlMode.PercentOutput, 0);
            rightClimb.setSelectedSensorPosition(0);
        }

        if(controller.getPSButton()){
            leftClimb.set(ControlMode.PercentOutput, climberThrottle);
            rightClimb.set(ControlMode.PercentOutput, climberThrottle);
        }

    }

    public void ClimbAdjust(double adjustThrottle) {
        leftClimbAdjust.set(ControlMode.PercentOutput, adjustThrottle);
    }

    public void smartDashboard(){
        SmartDashboard.putNumber("Climber Left Velocity", leftClimb.getSelectedSensorVelocity());
        SmartDashboard.putBoolean("Climber Left Sensor", leftClimbSensor.get());

        SmartDashboard.putNumber("Climber Right Velocity", rightClimb.getSelectedSensorVelocity());
        SmartDashboard.putBoolean("Climber Right Sensor", rightClimbSensor.get());

        SmartDashboard.putNumber("ClimberAdjust Velocity", leftClimbAdjust.getSelectedSensorVelocity());
    }
}