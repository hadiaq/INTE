import java.util.ArrayList;

public class Character {
	
	private String name;
	private String appearance;
	private int ptsTotal;
	
	//Lista �ver advantages som �r aktiva hos denna karakt�r
	private ArrayList<Advantage> charAdvantages = new ArrayList<Advantage>();
	private ArrayList<Equipment> charEquipment = new ArrayList<Equipment>();
	private int ptsUnspent;
	private int st;
	private int dx;
	private int iq;
	private int ht;

	// Lista av karaktärens föremål
	private ArrayList<Equipment.Item> items = new ArrayList<Equipment.Item>();
	
	public Character(String name, int points) {
		this.name = name;
		this.ptsTotal = points;
		this.ptsUnspent = points;
		this.st = 10;
		this.dx = 10;
		this.iq = 10;
		this.ht = 10;
	}
	
	// Equippar ett item hos karaktären
	public void equip(Equipment.Item item) {
		if (items.contains(item)) {
			throw new IllegalArgumentException("Item already equipped"); // Itemet finns redan equippat => fel
		} else {
			items.add(item);
		}
	}

	// Returnerar en *kopia* av listan av alla equippade items
	public ArrayList<Equipment.Item> getEquippedItemsList() {
		return new ArrayList<Equipment.Item>(items);
	}
	
	//H�mtar advantage ur den gemensamma listan i GURPSmain oh l�gger till i karakt�rens egna lista
	public void addAdvantage(String name) {
		for (Advantage adv : GURPSmain.advantages) {
			if (adv.getName().equals(name)) {
				ptsUnspent -= adv.getPointCost();
				charAdvantages.add(adv);
			}
		}
	}
	
	// Denna metod �r till f�r att justera po�ng i f�rh�llande till vad attributet kostar
	private void setAttribute(int level) {
		int pointCost = 0;
		if (level >= 1 && level <= 7) {
			pointCost = -90 + level*10;
		}
		else if (level == 8) {
			pointCost = -15;
		}
		else if (level == 9) {
			pointCost = -10;
		}
		else if (level >= 11 && level <= 13) {
			pointCost = (level-10)*10;
		}
		else if (level == 14) {
			pointCost = 45;
		}
		else if (level == 15) {
			pointCost = 60;
		}
		else if (level == 16) {
			pointCost = 80;
		}
		else if (level >= 17) {
			pointCost = 100 + ((level-17)* 25);
		}
		
		ptsUnspent -= pointCost;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getPointsTotal(){
		return this.ptsTotal;
	}
	
	public int getPointsUnspent() {
		return this.ptsUnspent;
	}
	
	public int getStrength(){
		return this.st;
	}
	
	public int getDexterity(){
		return this.dx;
	}
	
	public int getIntelligence(){
		return this.iq;
	}
	
	public int getHealth(){
		return this.ht;
	}
	
	public void setStrength(int st){
		setAttribute(st);
		this.st = st;
	}
	
	public void setDexterity(int dx){
		setAttribute(dx);
		this.dx = dx;
	}
	
	public void setIntelligence(int iq){
		setAttribute(iq);
		this.iq = iq;
	}
	
	public void setHealth(int ht){
		setAttribute(ht);
		this.ht = ht;
	}
	
	public String toString() {
		return "Name : " +name
				+"\nPoint Total " + ptsTotal
				+"\nUnspent Points " + ptsUnspent
				+"\nST : " +st
				+"\nDX : " +dx
				+"\nIQ : " +iq
				+"\nHT : " +ht
				+"\nAdvantages : " +charAdvantages;
	}
}
