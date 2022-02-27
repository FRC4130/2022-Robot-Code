package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robots.RobotMap;

public class Climb {

    TalonFX leftClimb;
    TalonFX rightClimb;    
    TalonFX leftClimbAdjust;
    TalonFX rightClimbAdjust;

    public Climb() {

        leftClimb = RobotMap.leftClimb;
        rightClimb = RobotMap.rightClimb;

        leftClimbAdjust = RobotMap.leftClimbAdjust;
        rightClimbAdjust = RobotMap.rightClimbAdjust;

        leftClimb.set(ControlMode.PercentOutput, 0);
        rightClimb.set(ControlMode.PercentOutput, 0);

        leftClimbAdjust.set(ControlMode.PercentOutput, 0);
        rightClimbAdjust.set(ControlMode.PercentOutput, 0);

    }

    public void setNeutralMode(NeutralMode nm){
        leftClimb.setNeutralMode(nm);
        rightClimb.setNeutralMode(nm);

        leftClimbAdjust.setNeutralMode(nm);
        rightClimbAdjust.setNeutralMode(nm);

    }

    public void ClimbMovement(double leftThrottle, double rightThrottle){
        leftClimb.set(ControlMode.PercentOutput, leftThrottle);
        rightClimb.set(ControlMode.PercentOutput, rightThrottle*-1);
        //NOTE: SmartDashboard cannot use vars outside of the method and cannot be used outside of a method
        SmartDashboard.putNumber("Left Throttle", leftThrottle);
        SmartDashboard.putNumber("Right Throttle", rightThrottle);
    }

    public void ClimbMovement2(double leftThrottle, double rightThrottle) {
        leftClimbAdjust.set(ControlMode.PercentOutput, leftThrottle);
        rightClimbAdjust.set(ControlMode.PercentOutput, rightThrottle*-1);
        //NOTE: SmartDashboard cannot use vars outside of the method and cannot be used outside of a method
        SmartDashboard.putNumber("Left Throttle", leftThrottle);
        SmartDashboard.putNumber("Right Throttle", rightThrottle);
    }
}