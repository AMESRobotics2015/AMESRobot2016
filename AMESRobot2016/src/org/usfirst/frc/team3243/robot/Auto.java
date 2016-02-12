package org.usfirst.frc.team3243.robot;

public class Auto {

	DriveSystem D;
	Gyro G;
	RobotMap r;
	double[] rotate = new double[4];
	double angleRotate;
	int step = 0;
	public Auto(DriveSystem d, Gyro g){
		D = d;
		G = g;
		r = new RobotMap();
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
		//System.out.println(angleRotate);
		System.out.println(update());
		double a = angleRotate + 1;
		double b = angleRotate - 1;

		if(update()<a && update()>b){
		step++;
		//System.out.println("Here");
		}

		System.out.println(step);
		return step;
	}
	
	public double[] Step(){
		switch(step){
		case(0):
			angleRotate = 20; break;
		case(1):
			angleRotate = -20; break;
		case(2):
			angleRotate = 50; break;
		}
		rotateInterface(angleRotate);
		return rotate;
	}
	
	void rotateInterface(double angle){
		angle = angle-update();
		if(angle>0){
			rotate[0]=-r.autoSpeed;
			rotate[1]=r.autoSpeed;
		}else if(angle<0){
			rotate[0]=r.autoSpeed;
			rotate[1]=-r.autoSpeed;
		}
	}
}
