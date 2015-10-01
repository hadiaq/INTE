
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
}
