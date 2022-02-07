package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
//import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMax.IdleMode;

import frc.robot.Robots.RobotMap;

public class Index {
    CANSparkMax index1;
    CANSparkMax index2;
    CANSparkMax intake;

    public Index(){
        index1 = RobotMap.index1;
        index2 = RobotMap.index2;
        intake = RobotMap.intake;
    }

    public void indexControl(double pow){
        index1.set(pow);
        index2.set(pow);
        intake.set(pow);
    }

    public void setNeutralMode(IdleMode nm){
        index1.setIdleMode(nm);
        index2.setIdleMode(nm);
        intake.setIdleMode(nm);
    }
    
}
