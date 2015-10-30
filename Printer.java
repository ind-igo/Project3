import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Printer
{
	static BinaryHeap heap;
	
	public static void main(String[] args)
	{
//		PrintJob job1 = new PrintJob("Joe", 3, 50);
//		PrintJob job2 = new PrintJob("Sue", 1, 10);
//
//		System.out.println(job1.toString());
//		System.out.println(job2.toString());
//		System.out.println(compareJobs(job1, job2));

		popHeap();
	}

	@SuppressWarnings("unchecked")
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
//			jobs = jobsTemp.toArray(jobs);
			
			heap = new BinaryHeap(jobsTemp.size());
			
			for(PrintJob x : jobsTemp)
			{
				heap.insert(x);
			}
			
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

	public static String compareJobs(PrintJob x, PrintJob y)
	{
		int result = x.getJobPriority().compareTo(y.getJobPriority());

		if (result < 0)
			return "Job 1's job priority was less than job 2's job priority.";
		else if (result == 0)
			return "The 2 jobs have equal job priorities.";
		else
			return "Job 1's job priority is greater than job 2's job priority.";
	}
}
