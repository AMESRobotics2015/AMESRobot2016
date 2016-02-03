package org.usfirst.frc.team3243.robot;

import edu.wpi.first.wpilibj.Victor;

public class GameArm {

	Victor arm = new Victor(5);
	
	public void moveArm(double armIn){
		arm.set(armIn);
	}
	
}
