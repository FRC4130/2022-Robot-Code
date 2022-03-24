package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robots.RobotMap;

public class Climb {

    TalonFX leftClimb;
    TalonFX rightClimb;    
    PS4Controller controller;

    DigitalInput leftClimbSensor;
    DigitalInput rightClimbSensor;

    public Climb() {

        leftClimb = RobotMap.leftClimb;
        rightClimb = RobotMap.rightClimb;

        leftClimbSensor = RobotMap.leftClimbSensor;
        rightClimbSensor = RobotMap.rightClimbSensor;

        controller = RobotMap.controller;

        leftClimb.set(ControlMode.PercentOutput, 0);
        rightClimb.set(ControlMode.PercentOutput, 0);

        leftClimb.setInverted(false);
        rightClimb.setInverted(true);

        leftClimb.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, 0, 5);
        rightClimb.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, 0, 5);
    }

    public void setNeutralModeClimb(NeutralMode nm){
        leftClimb.setNeutralMode(nm);
        rightClimb.setNeutralMode(nm);

    }

    public void ClimbMovement(double climberThrottle){

        /*if (!leftClimbSensor.get() && !rightClimbSensor.get()){
            leftClimb.set(ControlMode.PercentOutput, climberThrottle);
        }
        if(leftClimbSensor.get() && !rightClimbSensor.get()){
            leftClimb.setSelectedSensorPosition(0);
            leftClimb.set(ControlMode.PercentOutput, 0);
        }
        if (leftClimbSensor.get() && rightClimbSensor.get()){
            leftClimb.setSelectedSensorPosition(0);
            leftClimb.set(ControlMode.PercentOutput, 0);
        }*/

        if(leftClimb.isFwdLimitSwitchClosed() == 0){
            leftClimb.configPeakOutputReverse(0);
            leftClimb.set(ControlMode.PercentOutput, climberThrottle);
        }
        else{
            leftClimb.configPeakOutputReverse(1);
            leftClimb.set(ControlMode.PercentOutput, climberThrottle);
        }
        if(rightClimb.isRevLimitSwitchClosed() == 0){
            rightClimb.configPeakOutputForward(0);
            rightClimb.set(ControlMode.PercentOutput, climberThrottle);
        }
        else{
            rightClimb.configPeakOutputForward(1);
            rightClimb.set(ControlMode.PercentOutput, climberThrottle);
        }

        /*if (!leftClimbSensor.get() && !rightClimbSensor.get()){
            rightClimb.set(ControlMode.PercentOutput, climberThrottle);
        }
        if(!leftClimbSensor.get() && rightClimbSensor.get()){
            rightClimb.setSelectedSensorPosition(0);
            rightClimb.set(ControlMode.PercentOutput, 0);
        }
        if (leftClimbSensor.get() && rightClimbSensor.get()){
            rightClimb.setSelectedSensorPosition(0);
            rightClimb.set(ControlMode.PercentOutput, 0);
        }*/

    }

    public void smartDashboard(){
        SmartDashboard.putNumber("Climber Left Velocity", leftClimb.getSelectedSensorVelocity());
        SmartDashboard.putNumber("Climber Left Sensor", leftClimb.isFwdLimitSwitchClosed());

        SmartDashboard.putNumber("Climber Right Velocity", rightClimb.getSelectedSensorVelocity());
        SmartDashboard.putNumber("Climber Right Sensor", rightClimb.isRevLimitSwitchClosed());
    }
}