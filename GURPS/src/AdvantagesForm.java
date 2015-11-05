import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AdvantagesForm extends JPanel {
	
	private String name;
	private int cost;
	Map<String, Advantage> advantages = new HashMap<String, Advantage>();
	ListModel advantagesDataModel = new ListModel();
	JList<String> advantageList = new JList<String>(advantagesDataModel);
	JLabel costLabel = new JLabel("Cost : 0");
	JTextArea description = new JTextArea();
	MouseListener mouseList = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			String newDesc = "";
			String newCost = "";
			
			for (Map.Entry<String, Advantage> entry : advantages.entrySet()) {
				if (entry.getKey().equals(advantageList.getSelectedValue())) {
					Advantage adv = advantages.get(advantageList.getSelectedValue());
					name = adv.getName();
					cost = adv.getPointCost();
					newDesc = adv.getDescription();
					newCost = Integer.toString(adv.getPointCost());
				}
			}
			costLabel.setText("Cost : " +newCost);
			description.setText(newDesc);
		}
	};
	
	AdvantagesForm (Map<String, Advantage> adv) {
		this.advantages = adv;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(340, 400));
		advantageList.setFixedCellWidth(100);
		advantageList.setVisibleRowCount(10);
		advantageList.setPreferredSize(new Dimension(280, 200));
		advantageList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		advantageList.addMouseListener(mouseList);
		add(new JLabel("Available advantages:"));
		add(new JScrollPane(advantageList));
		description.setSize(300, 300);
		description.setEditable(false);
		description.setLineWrap(true);
		description.setWrapStyleWord(true);
		add(costLabel);
		add(description);
		
		for (Map.Entry<String, Advantage> entry : advantages.entrySet()) {
			advantagesDataModel.addSorted(entry.getKey());
		}
	}
	
	class ListModel extends DefaultListModel<String>{
		
		public void addSorted(String addNew){
			int pos = 0;
			while (pos < size() && get(pos).compareTo(addNew) < 0)
			    pos++;
			add(pos, addNew);
	    }

		public void remove(String delete) {
			int pos = 0;
			while (pos < size() && !get(pos).equals(delete))
				pos++;
			remove(pos);
		}

	}
	
	public String getName() {
		return this.name;
	}
	
	public int getCost() {
		return this.cost;
	}
	
}
