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
        controller = RobotMap.opController;
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
        if (controller.getCircleButton()){
            _index.runIndex();
            _IntakePosition.set(_IntakePosition.Sucking);
        }
        else{
            _index.generalIndexControl(0);
            _IntakePosition.set(_IntakePosition.Stored);
        }
        _index.SmartDashboard();

        if (controller.getCrossButton()){
            _index.shootIndex();
        }
    }

    public boolean isDone() {
        return false;
    }

    public void onStop() {
        _index.generalIndexControl(0);
    }
}
