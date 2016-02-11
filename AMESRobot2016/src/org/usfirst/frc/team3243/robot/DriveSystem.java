package org.usfirst.frc.team3243.robot;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;

/**
 * This class works all the motors for the siege bot.
 * @author markvandermerwe
 *
 */
public class DriveSystem {
	Victor cim1;
	Victor cim2;
	Victor cim3;
	Victor cim4;
	Talon cim1a;
	Talon cim2a;
	Talon cim3a;
	Talon cim4a;
	EncoderWheel ew;
	EncoderWheel ewa;
	DriveSystem(EncoderWheel encoderwheela, EncoderWheel encoderwheelb, boolean quickbot){
		ew = encoderwheela;
		ewa = encoderwheelb;
		if(quickbot){
			cim1a = new Talon(0);
			cim2a = new Talon(1);
			cim3a = new Talon(2);
			cim4a = new Talon(3);
		}else{
			cim1 = new Victor(0);
			cim2 = new Victor(1);
			cim3 = new Victor(2);
			cim4 = new Victor(3);
		}
	}
	
	/**
	 * Our drive thing - sends the inputs we want to use into the various motors.
	 * @param drv
	 */
	void drive(double[] drv){
		cim1.set(drv[1]);
		cim2.set(drv[1]);//-drv[0]);
		cim3.set(-drv[0]);//drv[1]);
		cim4.set(-drv[0]);
	}
	
	void quickdrive(double[] drv){
		cim1a.set(-drv[0]);
		cim2a.set(-drv[0]);
		cim3a.set(drv[1]);
		cim4a.set(drv[1]);
	}
	
	void stop(){
		cim1a.set(0);
		cim2a.set(0);
		cim3a.set(0);
		cim4a.set(0);
	}
	
	void moveDistance(double distance, double speed){
		
	}
	
	void rotate(double rotation){
		
	}
	
	boolean portDriving;
	double portSpeed=0.1,portDistance=2,portArmSpeed=0.3;
	double portCompDistance;//completed distance
	void startPortDrive(){
		portDriving = true;
		portCompDistance = 0;
	}
	
	boolean isPortDriving() {
		return portDriving;
	}
	
	void updatePortDrive(GameArm arm) {
		double portDistSegment = 0.1;
		if (portDriving) {
			this.moveDistance(portDistSegment, portSpeed);
			arm.moveArm(portArmSpeed);
			portCompDistance += portDistSegment;
			if (portCompDistance >= portDistance) {
				portDriving = false;
			}
		}
	}
}
