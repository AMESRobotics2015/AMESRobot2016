package org.usfirst.frc.team3243.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class contains our methods/functions relating to the Input of information from our user.
 * @author markvandermerwe
 * 
 */
public class InputManager {
Joystick move = new Joystick(0);
Joystick game = new Joystick(1);
double[] in = new double[2];
int suckIn = 0, frontOrBack = 0;

/**
* Method that will return the final drive array to be sent to the motor control class.
* @return
*/
double[] input() {
	in[0] = ramp(deadZone(move.getRawAxis(1)));
	in[1] = ramp(deadZone(move.getRawAxis(3)));
	System.out.println(in[0]);
	System.out.println(in[1]);
	return in;
}

/**
* This method deadzones the user's inputs- it makes sure that if the controller isn't being pushed, the bot doesn't start moving because of arbitrary joystick movements.
* @param input - input value from the user.
* @return returns the value as it was unless it is too small to be considered.
*/
double deadZone(double input) {
double deadRange = 0.01;
if (Math.abs(input)<deadRange) {
input = 0;
}
return input;
}

/**
* This method ramps the inputs from the user so that it feels smoother to the driver.
* @param input - input value from the user after it was deadzoned
* @return returns a ramped value.
*/

double ramp(double input) {
input = Math.pow(input, 3);
return input;
}

/**
* Read game controller joystick to move the arm up and down.
*/
public double armInput(){
double armIn = 0.3 * game.getRawAxis(1);
return armIn;
}


}

