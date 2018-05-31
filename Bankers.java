//Implementation of Banker's algorithm

import java.util.Scanner;

public class Bankers {
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int n_processes, n_resources;
		System.out.println("Enter number of processes: ");
		n_processes = scan.nextInt();
		System.out.println("Enter number of resources: ");
		n_resources = scan.nextInt();
		
		int[][] alloc = new int[n_processes+1][n_resources+1];
		int[][] max = new int[n_processes+1][n_resources+1];
		int[][] need = new int[n_processes+1][n_resources+1];
		int[] avail = new int[n_processes+1];
		
		System.out.println("Allocation:");
		for(int i=0; i<n_processes; i++)
			for(int j=0; j<n_resources; j++)
				alloc[i][j] = scan.nextInt();
		
		System.out.println("Maximum:");
		for(int i=0; i<n_processes; i++)
			for(int j=0; j<n_resources; j++)
				max[i][j] = scan.nextInt();
		
		System.out.println("Available: ");
		for(int i=0; i<n_resources; i++)
			avail[i] = scan.nextInt();
		
		for(int i=0; i<n_processes; i++)
			for(int j=0; j<n_resources; j++)
				need[i][j] = max[i][j] - alloc[i][j];
		
		int count=0, count2=0;
		while(count2!=n_processes)
		{
			for(int i=0; i<n_processes; i++)
			{
				count = 0;
				for(int j=0; j<n_resources; j++)
				{
					if(need[i][j]<=avail[j])
						count++;
				}
				if(count==n_resources)
				{
					System.out.println("Process "+i+" executed.");
					for(int j=0; j<n_resources; j++)
					{
						avail[j] += alloc[i][j];
						need[i][j] = 999;
					}
				}
			}
			count2++;
		}
		
		for(int i=0; i<n_processes; i++)
			for(int j=0; j<n_resources; j++)
				if(need[i][j]!=999)
				{
					System.out.println("Unsafe Sequence");
					System.exit(0);
				}
		
		System.out.println("Safe Sequence");
		scan.close();
	}
}

/*OUTPUT 1
Enter number of processes: 
5
Enter number of resources: 
4
Allocation:
3	0	1	4
2	2	1	0
3	1	2	1
0	5	1	0
4	2	1	2
Maximum:
5	1	1	7
3	2	1	1
3	3	2	1
4	6	1	2
6	3	2	5
Available: 
0	3	0	1
Process 2 executed.
Process 1 executed.
Process 3 executed.
Unsafe Sequence
*/

/* OUTPUT 2
Enter number of processes: 
5
Enter number of resources: 
3
Allocation:
0	1	0
2	0	0
3	0	2
2	1	1
0	0	2
Maximum:
7	5	3
3	2	2
9	0	2
2	2	2
4	3	3
Available: 
3	3	2
Process 1 executed.
Process 3 executed.
Process 4 executed.
Process 0 executed.
Process 2 executed.
Safe Sequence
*/















