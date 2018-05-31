//Shortest remaining time first == pre-emptive SJF(Shortest Job First)

import java.util.*;

public class SRTF {
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int n;
		System.out.println("Enter number of processes: ");
		n = scan.nextInt();
		
		int[] pid = new int[n+1];
		int[] at = new int[n+1];
		int[] bt = new int[n+1];
		int[] bt_copy = new int[n+1];
		int[] flag = new int[n+1];
		int[] ct = new int[n+1];
		int[] tat = new int[n+1];
		int[] wt = new int[n+1];
		
		int tot = 0, st = 0;
		float avgwt = 0, avgtat = 0;
		
		for(int i=0; i<n; i++)
		{
			pid[i] = i+1;
			System.out.print("Arrival time of P"+(i+1)+" : ");
			at[i] = scan.nextInt();
			System.out.print("Burst time of P"+(i+1)+" : ");
			bt[i] = scan.nextInt();
			bt_copy[i] = bt[i];
			flag[i] = 0;
		}
		
		while(true)
		{
			int min=99, c=0;
			
			if(tot==n)
				break;
			
			for(int i=0; i<n; i++)
			{
				if((at[i]<=st)&&(flag[i]==0)&&(bt[i]<min))
				{
					min = bt[i];
					c=i;
				}
			}
			
			if(c==n)
				st++;
			else
			{
				bt[c]--;
				st++;
				if(bt[c]==0)
				{
					ct[c] = st;
					flag[c] = 1;
					tot++;
				}
			}
		}
		
		for(int i = 0; i<n; i++)
		{
			tat[i] = ct[i] - at[i];
			wt[i] = tat[i] - bt_copy[i];
			avgtat += tat[i];
			avgwt += wt[i];
		}
		avgtat = avgtat/n;
		avgwt = avgwt/n;
		
		System.out.println("\nPID	 Arrival  Burst	 CT	 TAT  WT");
		for(int i=0; i<n; i++)
			System.out.println(pid[i]+" \t"+at[i]+" \t"+bt_copy[i]+" \t"+ct[i]+" \t"+tat[i]+" \t"+wt[i]);
		
		System.out.println("Average waiting time: "+avgwt);
		System.out.println("Average turnaround time: "+avgtat);
		
		scan.close();
	}

}

/* OUTPUT: 
Enter number of processes: 
4
Arrival time of P1 : 0
Burst time of P1 : 8
Arrival time of P2 : 1
Burst time of P2 : 4
Arrival time of P3 : 2
Burst time of P3 : 9
Arrival time of P4 : 3
Burst time of P4 : 5

PID	 Arrival  Burst	 CT	 TAT  WT
1 	0 	8 	17 	17 	9
2 	1 	4 	5 	4 	0
3 	2 	9 	26 	24 	15
4 	3 	5 	10 	7 	2
Average waiting time: 6.5
Average turnaround time: 13.0
*/
















