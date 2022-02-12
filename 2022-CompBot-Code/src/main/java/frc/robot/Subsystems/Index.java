package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxLimitSwitch;
import com.revrobotics.CANSparkMax.IdleMode;

import frc.robot.Robots.RobotMap;

public class Index {
    CANSparkMax index1;
    CANSparkMax index2;
    CANSparkMax intake;

    SparkMaxLimitSwitch sensor;
    SparkMaxLimitSwitch sensor2;

    public Index() {
        index1 = RobotMap.index1;
        index2 = RobotMap.index2;
        intake = RobotMap.intake;
        sensor = RobotMap.sensor;
        sensor2 = RobotMap.sensor2;
    }

    public void generalIndexControl(double pow) {
        index1.set(pow);
        index2.set(pow);
        intake.set(pow);
    }

    public void setNeutralMode(IdleMode nm) {
        index1.setIdleMode(nm);
        index2.setIdleMode(nm);
        intake.setIdleMode(nm);
    }

    public void runIndex() {
        // index1 checks
        if (sensor.isPressed()) {
            // check if sensor2 sees anything
            if (sensor2.isPressed()) {
                generalIndexControl(0);
            }
        } else {
            index1.set(0.80);
            index2.set(0.80);
        }
    }

}
