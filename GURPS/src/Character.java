
public class Character {
	
	private int pts;
	private int st;
	private int dx;
	private int iq;
	private int ht;
	
	public Character(int p){
		this.pts = p;
		this.st = 10;
		this.dx = 10;
		this.iq = 10;
		this.ht = 10;
	}
	
	public int getPoints(){
		return this.pts;
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
}
