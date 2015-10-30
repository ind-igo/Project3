
public class PrintJob implements Comparable<PrintJob>
{
	private String name;
	private int userPriority;
	private int numPages;
	private Integer jobPriority;
	
	public PrintJob(String name, int userPriority, int numPages)
	{
		setName(name);
		setUserPriority(userPriority);
		setNumPages(numPages);
		setJobPriority(getUserPriority() * getNumPages());
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Integer getUserPriority()
	{
		return userPriority;
	}

	public void setUserPriority(int priority)
	{
		this.userPriority = priority;
	}

	public Integer getNumPages()
	{
		return numPages;
	}

	public void setNumPages(int numPages)
	{
		this.numPages = numPages;
	}

	public Integer getJobPriority()
	{
		return jobPriority;
	}

	public void setJobPriority(int jobPriority)
	{
		this.jobPriority = jobPriority;
	}

	@Override
	public int compareTo(PrintJob x)
	{
		if (this.getJobPriority() < x.getJobPriority())
			return -1;
		else if (this.getJobPriority() > x.getJobPriority())
			return 1;
		else
			return 0;
	}
	
	@Override
	public String toString()
	{
		return "Name: " + getName() + ", User Priority: " + getUserPriority() + ", Number of Pages: " + getNumPages() + ", Job Priority: " + getJobPriority();
	}
}
