import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;

public class Character {
	
	private String name;
	private String appearance;
	private int ptsTotal;
	
	//Lista �ver advantages som �r aktiva hos denna karakt�r
	private Map<String, Advantage> advantages = new HashMap<String, Advantage>();
	public ArrayList<Advantage> charAdvantages = new ArrayList<Advantage>();
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
		advantages.put(name, GURPSmain.advMap.get(name));

	}
	
	public void removeAdvantage(String name) {
		advantages.remove(name);

	}
	
	public Map<String, Advantage> getAdvantages() {
		return advantages;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPointsTotal(){
		return this.ptsTotal;
	}
	
	public void setPointsTotal(int pts) {
		this.ptsTotal = pts;
	}
	
	public int getPointsUnspent() {
		return this.ptsUnspent;
	}
	
	public void setPointsUnspent(int pts) {
		this.ptsUnspent = pts;
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
		this.st = st;
	}
	
	public void setDexterity(int dx){
		this.dx = dx;
	}
	
	public void setIntelligence(int iq){
		this.iq = iq;
	}
	
	public void setHealth(int ht){
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
				+"\nAdvantages : " +advantages;
	}
}
