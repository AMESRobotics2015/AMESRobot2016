package org.usfirst.frc.team3243.robot;

import edu.wpi.first.wpilibj.Victor;

public class MotorControl {
	Victor cim1 = new Victor(0);
	Victor cim2 = new Victor(1);
	Victor cim3 = new Victor(2);
	Victor cim4 = new Victor (3);
	
	void drive(double[] drv){
		cim1.set(drv[1]);
		cim2.set(drv[1]);
		cim3.set(drv[0]);
		cim4.set(drv[0]);
	}
}
