import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Printer
{
	@SuppressWarnings("rawtypes")
	static BinaryHeap heap;
	
	public static void main(String[] args)
	{
		popHeap();
		
		while(!heap.isEmpty())
		{
			System.out.println(heap.findMin().toString());
			heap.deleteMin();
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void popHeap()
	{
		BufferedReader readbuffer;
		String strRead;
		List<PrintJob> jobsTemp = new ArrayList<PrintJob>();
		
		try
		{
			readbuffer = new BufferedReader(new FileReader("input.txt"));
			
			while ((strRead = readbuffer.readLine()) != null)
			{
				String splitarray[] = strRead.split("\t");
				
				String name = splitarray[0];
				int userPriority = Integer.parseInt(splitarray[1]);
				int numPages = Integer.parseInt(splitarray[2]);
				char inOut = splitarray[3].charAt(0);
				
				if (inOut == 'O' || inOut == 'o')
					jobsTemp.add(new OutsidePrintJob(name, userPriority, numPages));
				else
					jobsTemp.add(new PrintJob(name, userPriority, numPages));
			}
			
			PrintJob[] jobs = new PrintJob[jobsTemp.size()];
			
			heap = new BinaryHeap(jobsTemp.toArray(jobs));
			
			System.out.println(heap.isEmpty());
			
			readbuffer.close();
		} 
		
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}
}
