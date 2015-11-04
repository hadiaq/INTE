
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
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String desc) {
		this.description = desc;
	}
	
	public int getPointCost() {
		return pointCost;
	}
	
	public void setPointCost(int cost) {
		this.pointCost = cost;
	}
	
	public String toString(){
		return "Name : " +name+ " Pt Cost " +pointCost+"\n";
	}

}
