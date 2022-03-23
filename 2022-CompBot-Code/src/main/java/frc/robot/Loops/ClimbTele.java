package frc.robot.Loops;

import com.ctre.phoenix.ILoopable;
import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.PS4Controller;
import frc.robot.Robots.RobotMap;
import frc.robot.Robots.Subsystems;
import frc.robot.Subsystems.Climb;
import frc.robot.Subsystems.ClimbPosition;

public class ClimbTele implements ILoopable{

    Climb _operateClimb;
    ClimbPosition _climbPos;
    PS4Controller _opcontroller;

    public ClimbTele(){
        _operateClimb = Subsystems.climb;
        _climbPos = Subsystems.climbPosition;
        _opcontroller = RobotMap.opController;
    }

    public void onStart(){
        _operateClimb.setNeutralModeClimb(NeutralMode.Brake);
    }

    public void onLoop(){

        if(_opcontroller.getR1Button()){
            _climbPos.set(_climbPos.Back);
        }
        else if(_opcontroller.getL1Button()){
            _climbPos.set(_climbPos.Forward);
        }
        
        _operateClimb.ClimbMovement(_opcontroller.getLeftY() * .70);

        _operateClimb.smartDashboard();
    }

    public boolean isDone(){
        return false;
    }

    public void onStop(){
        _operateClimb.ClimbMovement(0);
    }

}