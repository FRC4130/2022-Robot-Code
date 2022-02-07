package frc.robot.Loops;

import com.ctre.phoenix.ILoopable;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.Ultrasonic;
import frc.robot.Robots.RobotMap;
import frc.robot.Robots.Subsystems;
import frc.robot.Subsystems.Index;
import frc.robot.Subsystems.IntakePosition;

public class IndexTele implements ILoopable {
    CANSparkMax index1;
    CANSparkMax index2;
    CANSparkMax intake;

    PS4Controller controller;
    Ultrasonic sensor;

    IntakePosition _IntakePosition;
    Index _index;

    public IndexTele(){
        index1 = RobotMap.index1;
        index2 = RobotMap.index2;
        intake = RobotMap.intake;
        controller = RobotMap.controller;
        sensor = RobotMap.sensor;
        _IntakePosition = Subsystems.intakePosition;
        _index = Subsystems.index;
    }

    public void onStart(){
        _index.indexControl(0);
    }

    public void onLoop(){
        // so for this example the rest of the Index program locks down if a ball is in the index.
        // probably not a good idea in practice but examples are good 
        if (sensor.getRangeInches() > 2){
            if (controller.getCrossButton()){
                _index.indexControl(0.80);
                _IntakePosition.set(_IntakePosition.Sucking);
            }
            else {
                _index.indexControl(0);
                _IntakePosition.set(_IntakePosition.Stored);
            }
        }
        else{
            _index.indexControl(0);
        }
    }

    /* public void updateIntakeSolenoid(){
        if(controller.getCircleButton()) {
            _IntakePosition.set(_IntakePosition.Sucking);
        }
        else {
            _IntakePosition.set(_IntakePosition.Stored);
        }
    }
    */

    public boolean isDone(){
        return false;
    }

    public void onStop(){
        _index.indexControl(0);
    }
}
