package org.usfirst.frc.team3243.robot;

public class Auto {

	DriveSystem D;
	Gyro G;
	public Auto(DriveSystem d, Gyro g){
		D = d;
		G = g;
	}
	
	public double update(){
		System.out.println(G.gyroFeed(false));
		return G.gyroFeed(false);
	}
	
	//orient is current orientation
	void autoDrive(double[] path) {
			boolean running = true;
			int i = 0;
			double degree = 0;
			double move = 0;
			while(i<path.length){
				if(path[i] == 0){
					degree = -45;
					move = Math.sqrt(2);
				}else if(path[i] == 1){
					degree = 0;
					move = 1;
				}else if(path[i] == 2){
					degree = 45;
					move = Math.sqrt(2);
				}else if(path[i] == 3){
					degree = 90;
					move = 1;
				}
				i++;
			}
			
		}
	
}
