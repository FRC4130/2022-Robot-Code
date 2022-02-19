package frc.robot.Loops;

import com.ctre.phoenix.ILoopable;
import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.PS4Controller;
import frc.robot.Robots.RobotMap;
import frc.robot.Robots.Subsystems;
import frc.robot.Subsystems.DriveTrain;

public class DriveTele implements ILoopable{

    DriveTrain _drive;
    PS4Controller _controller;

    public DriveTele(){
        _drive = Subsystems.driveTrain;
        _controller = RobotMap.controller;
    }

    public void onStart(){
        _drive.setNeutralMode(NeutralMode.Brake);
    }

    public void onLoop(){
        _drive.RobotMovement(_controller.getLeftY(), _controller.getRightY());
        if (_controller.getPSButton()){
            _drive.resetEncoders();
        }
        if (_controller.getCircleButton()){
            _drive.setPOS(300000);
           // _drive.setPOS(-200000);
        }
        else {
            _drive.stop();
        }
    }

    public boolean isDone(){
        return false;
    }

    public void onStop(){
        _drive.RobotMovement(0, 0);
    }
}
