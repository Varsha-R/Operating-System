//Implementation of Round-Robin algorithm
//Assume- Arrival time is same for all processes

import java.util.*;

public class RoundRobin {
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int n, qs;
		System.out.println("Enter the number of processes:");
		n = scan.nextInt();
		System.out.println("Enter the quantum size: ");
		qs = scan.nextInt();
		
		int[] pid = new int[n+1];
		int[] bt = new int[n+1];
		int[] bt_copy = new int[n+1];
		int[] flag = new int[n+1];
		int[] ct = new int[n+1];
		int[] wt = new int[n+1];
		
		int tot = 0, st = 0;
		float avgwt = 0;
		
		for(int i=0; i<n; i++)
		{
			pid[i] = i+1;
			System.out.println("Burst time of P"+(i+1));
			bt[i] = scan.nextInt();
			bt_copy[i] = bt[i];
			flag[i] = 0;
		}
		
		System.out.println("Round Robin scheduling: ");	
		System.out.print("0 | ");
		while(true)
		{
			if(tot==n)
				break;
			
			for(int i=0; i<n; i++)
			{
				if((bt[i]>=qs)&&(flag[i]==0))
				{
					bt[i]-=qs;
					st+=qs;
					System.out.print("P"+(i+1)+" | "+st+" | ");
					if(bt[i]==0)
					{
						ct[i] = st;
						flag[i] = 1;
						tot++;
					}
				}
				else if((bt[i]<qs)&&(flag[i]==0))
				{
					for(int j=1; j<qs; j++)
					{
						bt[i]-=j;
						st+=j;
						System.out.print("P"+(i+1)+" | "+st+" | ");
						if(bt[i]==0)
						{
							ct[i] = st;
							flag[i] = 1;
							tot++;
							break;
						}
					}
				}
			}
		}
		
		for(int i = 0; i<n; i++)
		{
			wt[i] = ct[i] - bt_copy[i];
			avgwt += wt[i];
		}
		avgwt = avgwt/n;
		
		System.out.println("\nPID  Burst    CT    WT");
		for(int i=0; i<n; i++)
			System.out.println(pid[i]+" \t"+bt_copy[i]+" \t"+ct[i]+" \t"+wt[i]);
		
		System.out.println("Average waiting time: "+avgwt);
		scan.close();
	}

}

/*  OUTPUT:
Enter the number of processes:
5
Enter the quantum size: 
2
Burst time of P1
6
Burst time of P2
5
Burst time of P3
2
Burst time of P4
3
Burst time of P5
7
Round Robin scheduling: 
0 | P1 | 2 | P2 | 4 | P3 | 6 | P4 | 8 | P5 | 10 | P1 | 12 | P2 | 14 | P4 | 15 | P5 | 17 | P1 | 19 | P2 | 20 | P5 | 22 | P5 | 23 | 
PID  Burst    CT    WT
1 	6 	19 	13
2 	5 	20 	15
3 	2 	6 	4
4 	3 	15 	12
5 	7 	23 	16
Average waiting time: 12.0
*/














