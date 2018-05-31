import java.util.*;

public class FIFO{
		
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		int n;
		System.out.println("enter number of page requests: ");
		n=scan.nextInt();
		
		int[] pagestring = new int[n+1];
		System.out.println("Enter the page string: ");
		for(int i=0; i<n; i++)
			pagestring[i]=scan.nextInt();
		
		int n_frames;
		System.out.println("enter number of frames: ");
		n_frames = scan.nextInt();
		
		int[] frame = new int[n_frames+1];
		int pagefault=0, flag=0, z=0;
		
		for(int i=0; i<n_frames; i++)
		{
			frame[i] = -1;
		}
		
		for(int i=0; i<n; i++)
		{
			flag=0;
			for(int j=0; j<n_frames;j++)
			{
				if(frame[j]==pagestring[i])
				{
					flag=1;
				}
				
			}
			if(flag==0)
			{
				
				frame[z]=pagestring[i];
				pagefault++;
				z=(z+1)%n_frames;
			}
			for(int x=0;x<n_frames;x++)
				System.out.print(frame[x]+"  ");
			System.out.println("\n");
		}
		System.out.println("Number of pagefaults: "+pagefault);
		
		scan.close();
	}

}
