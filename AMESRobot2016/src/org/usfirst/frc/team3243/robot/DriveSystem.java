package org.usfirst.frc.team3243.robot;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;

/**
 * This class works all the motors for the siege bot.
 * @author markvandermerwe
 *
 */
public class DriveSystem {
	public static final int CARRY_IN=-1,CARRY_STOP=0,CARRY_OUT=1;
	private double ballSpeed = 0.5;
	Victor cim1 = new Victor(0);
	Victor cim2 = new Victor(1);
	Victor cim3 = new Victor(2);
	Victor cim4 = new Victor(3);
	Talon cim1a = new Talon(0);
	Talon cim2a = new Talon(1);
	Talon cim3a = new Talon(2);
	Talon cim4a = new Talon(3);
	Sensors s;
	EncoderWheel ew;
	EncoderWheel ewa;
	DriveSystem(Sensors sensor, EncoderWheel encoderwheela, EncoderWheel encoderwheelb){
		s = sensor;
		ew = encoderwheela;
		ewa = encoderwheelb;
	}
	
	/**
	 * Our drive thing - sends the inputs we want to use into the various motors.
	 * @param drv
	 */
	void drive(double[] drv){
		cim1.set(-drv[0]);
		cim2.set(-drv[0]);
		cim3.set(drv[1]);
		cim4.set(drv[1]);
	}
	
	void quickdrive(double[] drv){
		cim1a.set(-drv[0]);
		cim2a.set(-drv[0]);
		cim3a.set(drv[1]);
		cim4a.set(drv[1]);
	}
	
	void moveDistance(double distance){
		
		while(true){
			cim1.set(0.3);
			cim2.set(0.3);
			cim3.set(0.3);
			cim4.set(0.3);
		}
		
	}
	
	void rotate(double rotation){
		s.gyroFeed(true);
		if(rotation<0){
			while(s.gyroFeed(false)<rotation){
				cim1.set(-0.3);
				cim2.set(-0.3);
				cim3.set(0.3);
				cim4.set(0.3);
			}
		}else if(rotation>0){
			while(s.gyroFeed(false)<rotation){
				cim1.set(0.3);
				cim2.set(0.3);
				cim3.set(-0.3);
				cim4.set(-0.3);
			}
		}
		
		
	}
	
	
	
	
}
