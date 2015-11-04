import javax.swing.*;

public class CharacterForm extends JPanel{
	private JTextField nameField;
	private JTextField pointField;
	
	CharacterForm(){
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel line1 = new JPanel();
		add(line1);
		line1.add(new JLabel("Name :"));
		nameField = new JTextField(15);
		line1.add(nameField);
		
		JPanel line2 = new JPanel();
		add(line2);
		line2.add(new JLabel("Points :"));
		pointField = new JTextField(10);
		line2.add(pointField);
	}
	
	public String getName(){
		return nameField.getText();
	}
	
	public String getPoints(){
		return pointField.getText();
	}
}