
public class Advantage {
	
	private String name;
	private String description;
	private int pointCost;
	
	public Advantage(String name, String description, int pointCost) {
		this.name = name;
		this.description = description;
		this.pointCost = pointCost;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getPointCost() {
		return pointCost;
	}
	
	public String toString(){
		return "Name : " +name+ " Pt Cost " +pointCost+"\n";
	}

}
