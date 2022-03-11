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

    PS4Controller opController;
    SparkMaxLimitSwitch sensor;
    SparkMaxLimitSwitch sensor2;

    IntakePosition _IntakePosition;
    Index _index;

    public IndexTele() {
        index1 = RobotMap.index1;
        index2 = RobotMap.index2;
        intake = RobotMap.intake;
        opController = RobotMap.opController;
        sensor = RobotMap.sensor;
        sensor2 = RobotMap.sensor2;
        _IntakePosition = Subsystems.intakePosition;
        _index = Subsystems.index;
    }

    public void onStart() {
        _index.setNeutralMode(IdleMode.kCoast);
        _index.generalIndexControl(0);
        _index.shooterControl(0);
    }

    public void onLoop() {
        if (opController.getCircleButton()){
            _index.runIndex();
            _IntakePosition.set(_IntakePosition.Sucking);
        }
        else{
            _index.generalIndexControl(0);
            _IntakePosition.set(_IntakePosition.Stored);
        }

        if (opController.getTriangleButton()){
            _index.shootHighIndex();
        }
        
        else if (opController.getCrossButton()){
            _index.shootLowIndex();
        }

        else{
            _index.shooterControl(0);
        }
        
        _index.SmartDashboard();
    }

    public boolean isDone() {
        return false;
    }

    public void onStop() {
        _index.generalIndexControl(0);
    }
}
