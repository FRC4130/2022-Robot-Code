package frc.robot.Loops;

import com.ctre.phoenix.ILoopable;

import frc.robot.Robots.Subsystems;
import frc.robot.Subsystems.Index;

//public class Intake implements ILoopable {
	/*
	private Index _index;
	private double durriationMs = 500;
	private double endTimeMs = 0;
	
	public Intake() {
		_index = Subsystems.index;
	}
	
	public Intake(double durriationMS) {
		_index = Subsystems.index;
		durriationMs = durriationMS;
	}

	@Override
	public void onStart() {
		System.out.print("[Info] Started Intaking for ");
		System.out.print(durriationMs);
		endTimeMs = System.currentTimeMillis() + durriationMs;
	}

	@Override
	public void onLoop() {
		_index.runIndex();
	}

	@Override
	public boolean isDone() {
		if ( System.currentTimeMillis() >= endTimeMs) {
			_index.generalIndexControl(0);
			return true;
		}
		return false;
	}

	@Override
	public void onStop() {
		System.out.println("[WARNING] Stopped Intaking");
	}
	*/

//}
