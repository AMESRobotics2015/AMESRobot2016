package org.usfirst.frc.team3243.robot;

import edu.wpi.first.wpilibj.Encoder;

/**
 * Robotmap is a class where we can store variables that won't change.
 * @author markvandermerwe
 *
 */
public class RobotMap {
	public static final int Cost_Diagonal = 14;
	public static final int Cost_VH = 10;
	public final double circ = 0;
	public static final int CARRY_IN=-1,CARRY_STOP=0,CARRY_OUT=1;
	public double ballSpeed = 0.5;
	static Encoder rotations;
	static double rotationFactor = 1;
	double x = 0;
	
}
