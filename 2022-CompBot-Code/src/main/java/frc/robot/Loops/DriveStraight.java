package frc.robot.Loops;

import com.ctre.phoenix.ILoopable;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.sensors.Pigeon2;

import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robots.RobotMap;

public class DriveStraight implements ILoopable {

    Pigeon2 _pidgey;
    TalonSRX _pidgeyTalon;

    TalonFX leftDrive;
    TalonFX rightDrive;

    PS4Controller _controller;

    double kPgain = 0.04;     //percent throttle per degree of error
    double kDgain = 0.0004;     //percent throttle per angular velocity dps
    double kMaxCorrectionRatio = 0.30;     //cap corrective turning throttle to 30 percent of forward throttle
    double targetAngle = 0;     //holds the current angle to servo to

    final int kTimeoutMs = 30;

    public void onStart() {

        _pidgey = RobotMap.pigeon;
        final int kTimeoutMs = 30;
        _pidgey.setYaw(0.0, kTimeoutMs);
        _controller = RobotMap.controller;

        leftDrive = RobotMap.leftDrive;
        rightDrive = RobotMap.rightDrive;

    }

    public void onLoop() {

        //PigeonIMU.GeneralStatus genStatus = new PigeonIMU.GeneralStatus();
        //PigeonIMU.FusionStatus fusionStatus = new PigeonIMU.FusionStatus();
        double yaw = _pidgey.getYaw();
        //double [] xyz_dps = new double [3];
        //_pidgey.getGeneralStatus(genStatus);
        //_pidgey.getRawGyro(xyz_dps);
        //_pidgey.getFusedHeading(fusionStatus);
        double currentAngle = yaw;
        //boolean angleIsGood = (_pidgey.getState() == PigeonIMU.PigeonState.Ready) ? true : false;
        //double currentAngularRate = xyz_dps[1];     //Array to fill with x[0], y[0] and z[2] data in degrees per second
        SmartDashboard.putNumber("Battery Voltage", RobotController.getBatteryVoltage());
        SmartDashboard.putNumber("Pigeon Yaw", _pidgey.getYaw());
        SmartDashboard.putNumber("Pigeon Device ID", _pidgey.getDeviceID());
        //SmartDashboard.putNumber("Current Angle", currentAngle);
        //SmartDashboard.putBoolean("Angle Good?", angleIsGood);
        //SmartDashboard.putNumber("Current Anglular Rate", currentAngularRate);

        //button 2 will zero pigeon
        if (_controller.getPSButton()) {
            //Zero yaw, this has to be done using the pigeon, not the motor controller
            _pidgey.setYaw(0, kTimeoutMs);
            _pidgey.setAccumZAngle(0, kTimeoutMs);

            System.out.println("=============================");
            System.out.println("Yaw and accumulated Z zero'ed");
            System.out.println("=============================");
            System.out.println();
        }

        if(_controller.getSquareButton()) {

            double forwardThrottle = ((_controller.getRawAxis(1) + _controller.getRawAxis(5))/2);
            double turnThrottle = (targetAngle - currentAngle) * kPgain * kDgain;
            double left = forwardThrottle - turnThrottle;
            double right = forwardThrottle + turnThrottle;
            leftDrive.set(ControlMode.PercentOutput, left * -1);
            rightDrive.set(ControlMode.PercentOutput, right * -1);
            SmartDashboard.putNumber("Turn Throttle", turnThrottle);
            SmartDashboard.putNumber("Forward Throttle", forwardThrottle);
            SmartDashboard.putNumber("Target Angle", targetAngle);
            
        }

    }

    public boolean isDone() {
        return false;
    }

    public void onStop() {

    }

}