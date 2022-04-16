package frc.robot.Loops;

import com.ctre.phoenix.ILoopable;

import edu.wpi.first.wpilibj.PS4Controller;
import frc.robot.Robots.RobotMap;
import frc.robot.Robots.Subsystems;
import frc.robot.Subsystems.LED;

public class LedLoops implements ILoopable{
    
    LED _ledLoops;
    PS4Controller _controller;

    DriveTele _driveTele;
    IndexTele _index;

    public LedLoops(){
        _ledLoops = Subsystems.led;
        _controller = RobotMap.controller;
        _driveTele = new DriveTele();
        _index = new IndexTele();

    }

    public void onStart(){
        _ledLoops.Idle();
    }

    public void onLoop(){
        _ledLoops.Idle();
        _ledLoops.fillIndex();
        if(_controller.getR1Button()){
            _ledLoops.RainbowParty();
        }
        else if(!_index.sensor.isPressed() && !_index.sensor2.isPressed()){
            _ledLoops.fullIndex();
        }
        else if(_controller.getL1Button()){
            _ledLoops.flames();
        }
    }

    public boolean isDone(){
        return false;
    }

    public void onStop(){
        _ledLoops.Idle();
    }

}
