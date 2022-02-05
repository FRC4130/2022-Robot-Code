package frc.robot.Loops;

import com.ctre.phoenix.ILoopable;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.PS4Controller;
import frc.robot.Robots.RobotMap;
import frc.robot.Subsystems.Index;

public class IndexTele implements ILoopable {
    CANSparkMax index1;
    CANSparkMax index2;
    CANSparkMax intake;
    PS4Controller controller;


    Index _index;

    public IndexTele(){
        index1 = RobotMap.index1;
        index2 = RobotMap.index2;
        intake = RobotMap.intake;
        controller = RobotMap.controller;
    }

    public void onStart(){
        _index.stopIndex();
    }

    public void onLoop(){
        if (controller.getCrossButton()){
            _index.runIndex();
        }
        else {
            _index.stopIndex();
        }
    }

    public boolean isDone(){
        return false;
    }

    public void onStop(){
        _index.stopIndex();
    }
}
