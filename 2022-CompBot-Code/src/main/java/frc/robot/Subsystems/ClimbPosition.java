package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.Robots.RobotMap;

public class ClimbPosition {
    public DoubleSolenoid climbAdjust;
    public final Value Back = Value.kReverse;
    public final Value Forward = Value.kForward;

    public ClimbPosition(){
        climbAdjust = RobotMap.climbAdjust;
        climbAdjust.set(Forward);
    }

    public void set(Value v1){
        climbAdjust.set(v1);
    }

    public void disable(){
        climbAdjust.set(Value.kOff);
    }
}