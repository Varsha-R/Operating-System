import java.util.*;

public class LRU {
	
	public static int min(int[] counter, int f)
	{
		int min=counter[0];
		int pos=0;
		for(int i=1; i<f;i++)
		{
			if(min>counter[i])
			{
				min=counter[i];
				pos=i;
			}
		}
		return pos;
	}
	
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
		int[] counter = new int[n_frames+1];
		int pagefault=0, flag=0, recent=0;
		
		for(int i=0; i<n_frames; i++)
		{
			frame[i] = -1;
			counter[i] = 0 ;
		}
		
		for(int i=0; i<n; i++)
		{
			flag=0;
			for(int j=0; j<n_frames;j++)
			{
				if(frame[j]==pagestring[i])
				{
					counter[j]=recent++;
					flag=1;
					break;
				}
				
			}
			if(flag==0)
			{
				for(int j=0; j<n_frames; j++)
				{
					if(frame[j]==-1)
					{
						frame[j]=pagestring[i];
						pagefault++;
						counter[j]=recent++;
						flag=1;
						break;
					}
				}
			}
			if(flag==0)
			{
				int pos=min(counter, n_frames);
				frame[pos]=pagestring[i];
				pagefault++;
				counter[pos]=recent++;
			}
			for(int x=0;x<n_frames;x++)
				System.out.print(frame[x]+"  ");
			System.out.println("\n");
		}
		System.out.println("Number of pagefaults: "+pagefault);
		
		scan.close();
	}

}
