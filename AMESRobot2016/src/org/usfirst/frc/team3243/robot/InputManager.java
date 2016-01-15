package org.usfirst.frc.team3243.robot;

import edu.wpi.first.wpilibj.Joystick;

public class InputManager {
	Joystick move = new Joystick(0);
	double[] in = new double[2];
	
	double[] input() {
		in[0] = ramp(deadZone(move.getRawAxis(0)));
		in[1] = ramp(deadZone(move.getRawAxis(3)));
		
		return in;
	}
	double deadZone(double input) {
		double deadRange = 0.01;
		if (Math.abs(input)<deadRange) {
			input = 0;
		}
		return input;
	}
	double ramp(double input){
		if (move.getRawButton(13)) {
			input = Math.pow(input, 3)/3;
		}
		else {
			input = Math.pow(input, 3)/6;
		}
		return input;
	}

}
