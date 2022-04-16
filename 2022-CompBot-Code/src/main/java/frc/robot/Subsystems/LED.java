package frc.robot.Subsystems;

import com.ctre.phoenix.led.CANdle;
import com.ctre.phoenix.led.RainbowAnimation;
import com.ctre.phoenix.led.CANdle.LEDStripType;

import frc.robot.Robots.RobotMap;
import frc.robot.Robots.Subsystems;

public class LED {
    // Instance
    private static CANdle mInstance = null;
    private DriveTrain mDrive;
    private final Climb mClimber;
    private final Index mIndexer;

    // CANdle
    private final CANdle mCANdle;

    // State
    private LEDState mState;


    public enum LEDState {
        IDLE, BALL_DETECT, AIM, PREP_CLIMB, CLIMBY_PARTY_MODE
    }

    public LED() {
        mCANdle = RobotMap.candle;
        mCANdle.configLEDType(LEDStripType.GRB);

        mDrive = Subsystems.driveTrain;
        mIndexer = Subsystems.index;
        mClimber = Subsystems.climb;

        mState = LEDState.IDLE;
    }

    public void Idle(){
        mCANdle.setLEDs(0, 0, 255);
        //mCANdle.setLEDs(0, 0, 0);

    }

    public void RainbowParty(){

        var rainbowAnim = new RainbowAnimation(1, 1, 255);

        mCANdle.animate(rainbowAnim);
    }

    public void Tracked(){
        mCANdle.setLEDs(0, 255, 0);
    }

    public void fillIndex(){
        if(!mIndexer.sensor.isPressed()){
            mCANdle.setLEDs(255, 0, 0, 0, 0, 50);
            //mCANdle.setLEDs(255, 0, 0, 0, 125, 50);
        }
    }

    public void fullIndex(){

        mCANdle.setLEDs(0, 255, 0);

    }

    public void flames(){
        mCANdle.setLEDs(255, 0, 0);
    }
}
