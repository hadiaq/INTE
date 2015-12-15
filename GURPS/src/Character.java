import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


public class Character {
	
	private String name;
	private int ptsTotal;
	
	//Lista �ver advantages som �r aktiva hos denna karakt�r
	private Map<String, Advantage> advantages = new HashMap<String, Advantage>();
	private int ptsUnspent;
	private int st;
	private int dx;
	private int iq;
	private int ht;

	// Lista av karaktärens föremål
	private ArrayList<Equipment.Item> items = new ArrayList<Equipment.Item>();
	private ArrayList<Equipment.Item> equipment = new ArrayList<Equipment.Item>();

	// Karaktärstillstånd
	public enum State {
		Passive, Attacking, Blocking, Parrying, Dodging
	}

	private State state;

	public Character(String name, int points) {
		this.name = name;
		this.ptsTotal = points;
		this.ptsUnspent = points;
		this.state = State.Passive;
		this.st = 10;
		this.dx = 10;
		this.iq = 10;
		this.ht = 10;
	}
	
	public State getState() {
		return state;
	}

	void setState(State state) {
		this.state = state;
	}

	public boolean isPassive() {
		return state == State.Passive;
	}

	public boolean isAttacking() {
		return state == State.Attacking;
	}

	public boolean isBlocking() {
		return state == State.Blocking;
	}

	public boolean isParrying() {
		return state == State.Parrying;
	}

	public boolean isDodging() {
		return state == State.Dodging;
	}

	void attack(Character victim) {
		setState(State.Attacking);
	}
	
	void parry(Character attacker) {
		setState(State.Parrying);
	}

	void dodge(Character attacker) {
		setState(State.Dodging);
	}

	void block(Character attacker) {
		setState(State.Blocking);
	}

	public void equip(Equipment.Item item) {
		if (equipment.contains(item)) {
			throw new IllegalArgumentException("Item already equipped"); // Itemet finns redan equippat => fel
		} else {
			equipment.add(item);
		}
	}
	
	public void unequip(Equipment.Item item) {
		equipment.remove(item);
	}
	
	public ArrayList<Equipment.Item> getEquippedItemsList() {
		return equipment;
	}
	
	public ArrayList<Equipment.Item> getItems() {
		return items;
	}
	
	public void addItem(Equipment.Item item) {
		items.add(item);
	}
	
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
	
	public double getMovementSpeed(){
		return (this.dx+this.ht)/4;
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
	
	public Equipment.Weapon getWeapon() {
		Equipment.Weapon wpn = null;
		for (Equipment.Item eq : equipment) {
			if (eq instanceof Equipment.Weapon) {
				wpn = (Equipment.Weapon)eq;
			}
		}
		return wpn;
	}
	
	public int getWeaponSkill() {
		return this.getDexterity()-4;
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
