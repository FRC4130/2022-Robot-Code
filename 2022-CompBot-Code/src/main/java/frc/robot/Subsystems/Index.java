package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
//import com.revrobotics.CANSparkMax.IdleMode;

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

    public void runIndex(){
        index1.set(0.80);
        index2.set(0.80);
        intake.set(0.80);
    }
    
    public void stopIndex(){
        index1.set(0);
        index2.set(0);
        intake.set(0);   
    }

    /*public void setNeutralMode(IdleMode nm){
        index1.setIdleMode(nm);
        index2.setIdleMode(nm);
        intake.setIdleMode(nm)
    }
    */
}
