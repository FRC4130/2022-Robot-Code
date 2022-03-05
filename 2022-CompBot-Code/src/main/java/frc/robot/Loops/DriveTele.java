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
        //20% Speed
        if (_controller.getL1Button()){
            _drive.RobotMovement(_controller.getLeftY()*0.20, _controller.getRightY()*0.20);
        }
        //100% Speed
        else if(_controller.getR1Button()){
            _drive.RobotMovement(_controller.getLeftY(), _controller.getRightY());
        }
        //60% Speed, Default
        else{
            _drive.RobotMovement(_controller.getLeftY()*0.60, _controller.getRightY()*0.60);
        }
        _drive.smartDashboard();  
     }

    public boolean isDone(){
        return false;
    }

    public void onStop(){
        _drive.RobotMovement(0, 0);
    }
}
