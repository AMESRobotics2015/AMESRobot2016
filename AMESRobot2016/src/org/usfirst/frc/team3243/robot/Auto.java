package org.usfirst.frc.team3243.robot;

public class Auto {

	DriveSystem D;
	Gyro G;
	int step = 0;
	double[] rotate;
	double angleRotate;
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
	
	public int stepNum(){
		if(update()<angleRotate-5 && update()>angleRotate+5){
			step++;
		}
		return step;
	}
	
	public double[] Step(){
		switch(step){
		case(0):
			angleRotate = 20; break;
		case(1):
			angleRotate = -20; break;
		}
		rotateInterface(angleRotate);
		return rotate;
	}
	
	void rotateInterface(double angle){
		if(angle>0){
			rotate[0]=0.3;
			rotate[1]=0.3;
			rotate[2]=0.3;
			rotate[3]=0.3;
		}else if(angle<0){
			rotate[0]=-0.3;
			rotate[1]=-0.3;
			rotate[2]=-0.3;
			rotate[3]=-0.3;
		}
	}
}
