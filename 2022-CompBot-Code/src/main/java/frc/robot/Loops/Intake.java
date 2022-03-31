package frc.robot.Loops;

import com.ctre.phoenix.ILoopable;

import frc.robot.Robots.Subsystems;
import frc.robot.Subsystems.Index;
import frc.robot.Subsystems.IntakePosition;

public class Intake implements ILoopable {
	private Index _index;
	private IntakePosition _position;
	private double durriationMs = 1500;
	private double endTimeMs = 0;
	
	public Intake() {
		_index = Subsystems.index;
		_position = Subsystems.intakePosition;
	}
	
	public Intake(double durriationMs) {
		_index = Subsystems.index;
		_position = Subsystems.intakePosition;
		this.durriationMs = durriationMs;
	}

	@Override
	public void onStart() {
		System.out.print("[Info] Started Intaking for ");
		System.out.print(durriationMs);
		endTimeMs = System.currentTimeMillis() + durriationMs;
	}

	@Override
	public void onLoop() {
		_position.set(_position.Sucking);
		_index.runIndex();
	}

	@Override
	public boolean isDone() {
		if ( System.currentTimeMillis() >= endTimeMs) {
			_index.generalIndexControl(0);
			_position.set(_position.Stored);
			return true;
		}
		return false;
	}

	@Override
	public void onStop() {
		System.out.println("[WARNING] Stopped Intaking");
	}

}
