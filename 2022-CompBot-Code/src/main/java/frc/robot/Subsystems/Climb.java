package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robots.RobotMap;

public class Climb {

    TalonFX leftClimb;
    TalonFX rightClimb;    

    public Climb() {

        leftClimb = RobotMap.leftClimb;
        rightClimb = RobotMap.rightClimb;

    }

    public void setNeutralMode(NeutralMode nm){
        leftClimb.setNeutralMode(nm);
        rightClimb.setNeutralMode(nm);
    }
    public void ClimbMovement(double leftThrottle, double rightThrottle){
        leftClimb.set(ControlMode.PercentOutput, leftThrottle);
        rightClimb.set(ControlMode.PercentOutput, rightThrottle*-1);
        //NOTE: SmartDashboard cannot use vars outside of the method and cannot be used outside of a method
        SmartDashboard.putNumber("Left Throttle", leftThrottle);
        SmartDashboard.putNumber("Right Throttle", rightThrottle);
    }
}
