
public class OutsidePrintJob extends PrintJob
{
	private double cost;
	
	public OutsidePrintJob(String name, int userPriority, int numPages)
	{
		super(name, userPriority, numPages);
		setCost(numPages * .1);
	}

	public double getCost()
	{
		return cost;
	}

	public void setCost(double cost)
	{
		this.cost = cost;
	}
	
	@Override
	public String toString()
	{
		return super.toString() + ", Cost: " + getCost();
	}
	
}
