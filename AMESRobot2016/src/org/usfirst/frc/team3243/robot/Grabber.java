package org.usfirst.frc.team3243.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;

public class Grabber {
	Victor cimBall;
	DigitalInput limitswitch;
	Grabber(){
		Victor cimBall = new Victor(4);
		DigitalInput limitswitch = new DigitalInput(1/*whatever port it will use*/);
	}
	
void pushIn(int buttonCount){//Move this to grabber class.
		if (buttonCount % 2 == 1)
		{
			while (limitswitch.get())
			{
		cimBall.set(0.2);
			}
		}
		else cimBall.set(0.2);
		
	}
	void ballCarrier(int direction){//Move this to grabber class.
		
	}

}
