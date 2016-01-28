package org.usfirst.frc.team3243.robot;


/*
 * The robot will create a mental image of the field and then pathfind to a certain point relative to itself 
 * This will be possible using the A* algorithm 
 * If you have any questions feel free to ask Riley
 */
public class AStarPathfinding {
	int l;
	int w;
	
	int[][] feild = new int[54][26];
	
	public void feildsetup(){
		for(int x = 1 ; x < 55 ; x++){
			for(int w = 1; w < 26; w++){
				feild[l][w] = 1;
			}
		}
	}
}
