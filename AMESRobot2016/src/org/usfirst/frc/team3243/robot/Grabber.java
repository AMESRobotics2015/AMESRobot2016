package org.usfirst.frc.team3243.robot;

import edu.wpi.first.wpilibj.Victor;

public class Grabber {
	Victor cimBall;
	Grabber(){
		Victor cimBall = new Victor(4);
	}
	
void pushIn(int buttonCount){//Move this to grabber class.
		if (buttonCount % 2 == 1)
		{
		cimBall.set(0.2);
		}
		else cimBall.set(0);
	}
	void ballCarrier(int direction){//Move this to grabber class.
		
	}

}
