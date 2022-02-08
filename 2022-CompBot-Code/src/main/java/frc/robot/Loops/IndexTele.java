package frc.robot.Loops;

import com.ctre.phoenix.ILoopable;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;

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
    Ultrasonic sensor2;

    IntakePosition _IntakePosition;
    Index _index;

    public IndexTele(){
        index1 = RobotMap.index1;
        index2 = RobotMap.index2;
        intake = RobotMap.intake;
        controller = RobotMap.controller;
        sensor = RobotMap.sensor;
        sensor2 = RobotMap.sensor2;
        _IntakePosition = Subsystems.intakePosition;
        _index = Subsystems.index;
    }

    public void onStart(){
        _index.setNeutralMode(IdleMode.kBrake);
        _index.indexControl(0);
    }

    public void onLoop(){
        //Index will lockdown if 2 balls are detected
        if (sensor2.getRangeInches() > 2){
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
            _IntakePosition.set(_IntakePosition.Stored);
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
