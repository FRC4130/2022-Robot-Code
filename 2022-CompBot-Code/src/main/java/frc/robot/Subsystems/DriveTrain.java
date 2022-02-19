package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robots.RobotMap;

public class DriveTrain {
    public static TalonFX leftDrive;
    public static TalonFX leftDrive2;
    public static TalonFX rightDrive;
    public static TalonFX rightDrive2;

    public static PigeonIMU pigeon;

    private final int kTimeoutMs = 10;

    public DriveTrain(){
        leftDrive = RobotMap.leftDrive;
        leftDrive2 = RobotMap.leftDrive2;
        rightDrive = RobotMap.rightDrive;
        rightDrive2 = RobotMap.rightDrive2;

        leftDrive2.follow(leftDrive);
        rightDrive2.follow(rightDrive);

        leftDrive.set(ControlMode.PercentOutput, 0);
        rightDrive.set(ControlMode.PercentOutput, 0);

        leftDrive.setInverted(true);
        leftDrive2.setInverted(InvertType.FollowMaster);
    }

    public void setNeutralMode(NeutralMode nm){
        leftDrive.setNeutralMode(nm);
        rightDrive.setNeutralMode(nm);
    }
    public void RobotMovement(double leftThrottle, double rightThrottle){
        leftDrive.set(ControlMode.PercentOutput, leftThrottle);
        rightDrive.set(ControlMode.PercentOutput, rightThrottle);
        //NOTE: SmartDashboard cannot use vars outside of the method and cannot be used outside of a method
        SmartDashboard.putNumber("Left Throttle", leftThrottle);
        SmartDashboard.putNumber("Right Throttle", rightThrottle);
    }

    public void arcade(double throttle, double turn) {
		
		RobotMovement(throttle+turn, throttle-turn);
		
	}

    public void setPos(double nativeUnits){
        leftDrive.set(ControlMode.MotionMagic, nativeUnits);
        rightDrive.set(ControlMode.MotionMagic, nativeUnits);
    }

    public double distanceToRotations(double inches) {
		
		return ( ( (2048*25) * inches ) / 92 )*(51.25/17);
		
	}

    public double getLeftPos(){
        return leftDrive.getSelectedSensorPosition();
    }

    public double getRightPos(){
        return rightDrive.getSelectedSensorPosition();
    }

    public void setMagic(int cruiseVelocity, int acceleration) {
		
		leftDrive.configMotionCruiseVelocity(cruiseVelocity, kTimeoutMs);
		leftDrive.configMotionAcceleration(acceleration, kTimeoutMs);
		
		rightDrive.configMotionCruiseVelocity(cruiseVelocity, kTimeoutMs);
		rightDrive.configMotionAcceleration(acceleration, kTimeoutMs);
    }

    public void resetSensors(){
        leftDrive.setSelectedSensorPosition(0);
        rightDrive.setSelectedSensorPosition(0);
    }

    public double getHeading(){
        return pigeon.getCompassHeading();
    }
}
