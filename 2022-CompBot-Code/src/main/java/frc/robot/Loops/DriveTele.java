package frc.robot.Loops;

import com.ctre.phoenix.ILoopable;
import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.PS4Controller;
import frc.robot.Robots.Subsystems;
import frc.robot.Subsystems.DriveTrain;

public class DriveTele implements ILoopable{

    DriveTrain _drive;
    PS4Controller _controller;

    public DriveTele(){
        _drive = Subsystems.driveTrain;
    }

    public void onStart(){
        _drive.setNeutralMode(NeutralMode.Brake);
    }

    public void onLoop(){
        _drive.RobotMovement(_controller.getLeftY(), _controller.getRightY());
    }

    public boolean isDone(){
        return false;
    }

    public void onStop(){
        _drive.RobotMovement(0, 0);
    }
}
