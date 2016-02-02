package org.usfirst.frc.team3243.robot;
import java.util.*;


public class AStarPathfinding {
	public static final int Cost_Diagonal = 14;
	public static final int Cost_VH = 10;
	static class Cell{
		int heuristicCost = 0;
		int finalCost = 0;
		int i, j;
		Cell parent;
	
		Cell(int i, int j){
			this.i = i;
			this.j = j;
		}
		
		public String toString(){
			return "["+this.i+", "+this.j+"]";
		}
	}
	
	static Cell[][] field = new Cell[5][5];
	static PriorityQueue<Cell> open;
	static boolean closed[][];
	static int starti, startj;
	static int endi, endj;
	
	public static void setBlocked(int i, int j){
		field[i][j] = null;
	}
	
	public static void setStart(int i, int j){
		starti = i;
		startj = j;
	}
	
	public static void setEnd(int i, int j){
		endi = i;
		endj = j;
	}
	
	static void CheckandUpdateCost(Cell current, Cell t, int cost){
		if(t == null || closed[t.i][t.j])return;
		int t_final_cost = t.heuristicCost+cost;
		
		boolean inOpen = open.contains(t);
		if(!inOpen || t_final_cost<t.finalCost){
			t.finalCost = t_final_cost;
			t.parent = current;
			if(!inOpen)open.add(t);
		}
	}
	
	public static void AStar(){
		
		open.add(field[starti][startj]);
		Cell current;
		
		while(true){
			current = open.poll();
			if(current == null)break;
			closed[current.i][current.j] = true;
			
			if(current.equals(field[endi][endj])){
				return;
			}
			
			Cell t;
			if(current.i - 1 >= 0){
				t = field[current.i - 1][current.j];
				CheckandUpdateCost(current, t, current.finalCost + Cost_VH);
				
				if(current.j - 1 < field[0].length){
					t = field[current.i - 1][current.j - 1];
					CheckandUpdateCost(current, t, current.finalCost + Cost_Diagonal);
				}
				
				if(current.j + 1 < field[0].length){
					t = field[current.i - 1][current.j + 1];
					CheckandUpdateCost(current, t, current.finalCost + Cost_Diagonal);
				}
			}
			
			if(current.j-1>=0){
                t = field[current.i][current.j-1];
                CheckandUpdateCost(current, t, current.finalCost + Cost_VH); 
            }

            if(current.j+1<field[0].length){
                t = field[current.i][current.j+1];
                CheckandUpdateCost(current, t, current.finalCost + Cost_VH); 
            }

            if(current.i+1<field.length){
                t = field[current.i+1][current.j];
                CheckandUpdateCost(current, t, current.finalCost + Cost_VH); 

                if(current.j-1>=0){
                    t = field[current.i+1][current.j-1];
                    CheckandUpdateCost(current, t, current.finalCost + Cost_Diagonal); 
                }
                
                if(current.j+1<field[0].length){
                   t = field[current.i+1][current.j+1];
                   CheckandUpdateCost(current, t, current.finalCost + Cost_Diagonal); 
                }  
		}
		
	}
}
	
	public static void start(){
		field = new Cell[30][26];
		closed = new boolean [30][26];
		open = new PriorityQueue(16, new Comparator() {
			
			public int compare(Cell c1, Cell c2) {
			return c1.finalCost < c2.finalCost ? -1:
			c1.finalCost > c2.finalCost ? 1 : 0;
			}

			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				return 0;
			}
			});
		
		setStart(24, 2);
		setEnd(3, 9);
		
		for(int i = 0; i < 30; i++){
			for(int j = 0; j < 26; j++){
				field[i][j] = new Cell(i, j);
                field[i][j].heuristicCost = Math.abs(i-endi) + Math.abs(j-endj);
			}
		}
		
		field[24][2].finalCost = 0;
		
		
		for (int i = 17; i < 24; i++){
			for (int j = 5; j < 26; j++){
				setBlocked(i, j);
			}
		}
		for (int i = 1; i < 25; i++){
			for (int j = 23; j < 27; j++){
				setBlocked(i, j);
			}
		}
		
		System.out.println("Field: ");
        for(int i = 0; i < 30; i++){
            for(int j = 0; j < 26; j++){
               if(i == 24 && j == 2) System.out.print("ST  "); //Start
               else if(i == 3 && j == 9) System.out.print("ED  ");  //End
               else if(field[i][j]!=null)System.out.printf("%-3d ", 0);
               else System.out.print("BL  "); 
            }
            System.out.println();
        } 
        System.out.println();
        
        AStar();
        System.out.println("\nScores for cells: ");
        for(int i = 0; i < 30; ++i){
            for(int j = 0; j < 30; ++j){
                if(field[i][j]!=null)System.out.printf("%-3d ", field[i][j].finalCost);
                else System.out.print("BL  ");
            }
            System.out.println();
        }
        System.out.println();
         
        if(closed[endi][endj]){
            //Trace back the path 
             System.out.println("Path: ");
             Cell current = field[endi][endj];
             System.out.print(current);
             while(current.parent!=null){
                 System.out.print(" -> " + current.parent);
                 current = current.parent;
             } 
             System.out.println();
        }else System.out.println("No possible path");
 }
	}
