package frc.robot.Loops;

import com.ctre.phoenix.ILoopable;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxLimitSwitch;
import com.revrobotics.CANSparkMax.IdleMode;

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
    SparkMaxLimitSwitch sensor;
    SparkMaxLimitSwitch sensor2;

    IntakePosition _IntakePosition;
    Index _index;

    public IndexTele() {
        index1 = RobotMap.index1;
        index2 = RobotMap.index2;
        intake = RobotMap.intake;
        controller = RobotMap.controller;
        sensor = RobotMap.sensor;
        sensor2 = RobotMap.sensor2;
        _IntakePosition = Subsystems.intakePosition;
        _index = Subsystems.index;
    }

    public void onStart() {
        _index.setNeutralMode(IdleMode.kBrake);
        _index.generalIndexControl(0);
    }

    public void onLoop() {
        if (controller.getCrossButton()){
            //index1 checks
            if (sensor.isPressed()){
                //check if sensor2 sees anything
                if (sensor2.isPressed()){
                    _index.generalIndexControl(0);
                }
            }
            else {
                index1.set(0.80);
                index2.set(0.80);
            }
        }
    }

    public boolean isDone() {
        return false;
    }

    public void onStop() {
        _index.generalIndexControl(0);
    }
}
