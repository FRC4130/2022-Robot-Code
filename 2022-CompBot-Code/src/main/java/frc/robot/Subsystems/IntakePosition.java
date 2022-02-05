package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.Robots.RobotMap;

public class IntakePosition {
    public DoubleSolenoid intakePos;
    public final Value Stored = Value.kReverse;
    public final Value Sucking = Value.kForward;

    public IntakePosition(){
        intakePos = RobotMap.intakeLift;
        intakePos.set(Stored);
    }

    public void set(Value v1){
        intakePos.set(v1);
    }

    public void disable(){
        intakePos.set(Value.kOff);
    }
}
