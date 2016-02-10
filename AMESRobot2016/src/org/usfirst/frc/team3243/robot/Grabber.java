package org.usfirst.frc.team3243.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;

public class Grabber {
	Victor cimBall = new Victor(4);
	//DigitalInput limitswitch;
	Grabber(){
		
		//DigitalInput limitswitch = new DigitalInput(1/*whatever port it will use*/);
	}
	
void pullIn(InputManager IM){
	if(IM.game.getRawButton(2)){
		cimBall.set(0.3);
	}else if(IM.game.getRawButton(3)){
		cimBall.set(-1);
	}else{
		cimBall.set(0);
	}
		
	}

	/*void pushOut(boolean buttonPush){
		if(buttonPush){
			cimBall.set(-1);
		}else cimBall.set(0);
	}*/
	
	public void doGrab (int grabSpeed) {
		//limitswitch.get();
		cimBall.set(grabSpeed);
	}

}
