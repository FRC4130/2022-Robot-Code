package frc.robot.Loops;

import com.ctre.phoenix.ILoopable;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.PS4Controller;
import frc.robot.Robots.RobotMap;
import frc.robot.Robots.Subsystems;
import frc.robot.Subsystems.Index;

public class Shoot implements ILoopable {
	
	Index _index;
	private double durriationMs = 2500;
	private double endTimeMs = 0;
	int selectSpeed;

	TalonFX shooter;
	PS4Controller _controller;
	CANSparkMax index1;
	CANSparkMax index2;
	CANSparkMax index3;
	
	public Shoot(int selectSpeed) {
		_index = Subsystems.index;
		shooter = RobotMap.shooter;
		_controller = RobotMap.controller;
		index1 = RobotMap.index1;
		index2 = RobotMap.index2;
		index3 = RobotMap.index3;
		this.selectSpeed = selectSpeed;
	}
	
	@Override
	public void onStart() {
		System.out.print("[Info] Outaking for ");
		System.out.println(durriationMs);
		endTimeMs = System.currentTimeMillis() + durriationMs;
	}

	@Override
	public void onLoop() {
		//_index.shootHighIndex();
		/*shooter.set(ControlMode.PercentOutput, 0.85);
        while(shooter.getMotorOutputPercent() > .82 && System.currentTimeMillis() < endTimeMs) {
            index1.set(.80);
            index2.set(.80);
		}*/
		switch(selectSpeed){
			case 0:
			shooter.set(ControlMode.PercentOutput, 0.465);
			index3.set(.40);
			while(shooter.getMotorOutputPercent() > .435 && System.currentTimeMillis() < endTimeMs){
				index1.set(.43);
				index2.set(.40);
			}
			break;

			case 1:
			shooter.set(ControlMode.PercentOutput, 0.505);
			index3.set(.49);
			while(shooter.getMotorOutputPercent() > .46 && System.currentTimeMillis() < endTimeMs){
				index1.set(.41);
				index2.set(.41);
			}
			break;
		}
	}

	@Override
	public boolean isDone() {
		if (System.currentTimeMillis() >= endTimeMs) {
			_index.generalIndexControl(0);
			index3.set(0);
			shooter.set(ControlMode.PercentOutput, 0);
			System.out.println("[Info] Finished Outtaking");
			return true;
		}
		return false;
	}

	@Override
	public void onStop() {
		_index.generalIndexControl(0);
		System.out.println("[WARNING] Stopped Outaking");
	}

}
