package frc.robot.Loops;

import com.ctre.phoenix.ILoopable;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.PS4Controller;
import frc.robot.Robots.RobotMap;
import frc.robot.Robots.Subsystems;
import frc.robot.Subsystems.Index;
import frc.robot.Subsystems.IntakePosition;

public class IndexTele implements ILoopable {
    CANSparkMax index1;
    CANSparkMax index2;
    CANSparkMax intake;
    PS4Controller controller;
    IntakePosition _IntakePosition;


    Index _index;

    public IndexTele(){
        index1 = RobotMap.index1;
        index2 = RobotMap.index2;
        intake = RobotMap.intake;
        controller = RobotMap.controller;
        _IntakePosition = Subsystems.intakePosition;
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

        if(controller.getL1Button()){
            _index.runIndex();

            _IntakePosition.set(_IntakePosition.Sucking);
        }
        else {
            if (!controller.getCrossButton()){
                _index.stopIndex();
            }
            _index.stopIndex();
            _IntakePosition.set(_IntakePosition.Stored);
        }
    }

    public void updateIntakeSolenoid(){
        //if(indexMove) {
            _IntakePosition.set(_IntakePosition.Sucking);
        }
    }

    public boolean isDone(){
        return false;
    }

    public void onStop(){
        _index.stopIndex();
    }
}
