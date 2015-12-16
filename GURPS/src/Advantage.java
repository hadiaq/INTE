public class Advantage {
	private String name;
	private String description;
	private int pointCost;

	static final Advantage2 absoluteDirection = new Advantage2("Absolute Direction",
		"You always know which way is north, and you can always " +
		"re-trace a path you have followed within the past month, " +
		"no matter how faint it may be. This ability does not " +
		"work in environments such as interstellar space or the " +
		"limbo of the astral plane, but it does work underground, " +
		"underwater, and on other planets. Also gives a +3 bonus " +
		"on your Navigation skill.", 5);

	static final Advantage2 resistantRoPoison = new Advantage2("Resistant to Poison", "Poison affects you less; +3 " +
		"to HT to resist its effects.", 5);

	static final Advantage2 doubleJointed = new Advantage2("Double-Jointed", "Your body is unusually flexible. " +
		"You get a +3 on any Climbing roll, on any roll to escape from " +
		"ropes, handcuffs or other restraints, or on any Mechanic roll " +
		"(to reach into an engine, of course)", 10);

	public Advantage2(String name, String description, int pointCost) {
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