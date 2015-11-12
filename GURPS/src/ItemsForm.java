import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ItemsForm extends JPanel {
	
	private Equipment.Item currentItem = null;
	private String name;
	private int value;
	private double weight;
	ArrayList<Equipment.Item> items = new ArrayList<Equipment.Item>();
	ListModel itemsDataModel = new ListModel();
	JList<String> itemList = new JList<String>(itemsDataModel);
	JLabel weightLabel = new JLabel("Weight : 0");
	JLabel valueLabel = new JLabel("Value : 0");
	JTextArea description = new JTextArea();
	MouseListener mouseList = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			String newWeight = "";
			String newValue = "";
			
			for (Equipment.Item item : items) {
				if (item.getDescription().equals(itemList.getSelectedValue())) {
					newWeight = Double.toString(item.getWeight());
					newValue = Integer.toString(item.getValue());
					currentItem = item;
				}
			}
			weightLabel.setText("Weight : " +newWeight);
			valueLabel.setText("Value : " +newValue);
		}
	};
	
	ItemsForm (ArrayList<Equipment.Item> items) {
		this.items = items;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(340, 400));
		itemList.setFixedCellWidth(100);
		itemList.setVisibleRowCount(10);
		itemList.setPreferredSize(new Dimension(280, 200));
		itemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		itemList.addMouseListener(mouseList);
		add(new JLabel("Available items:"));
		add(new JScrollPane(itemList));
		description.setSize(300, 300);
		description.setEditable(false);
		description.setLineWrap(true);
		description.setWrapStyleWord(true);
		add(weightLabel);
		add(valueLabel);
		add(description);
		
		for (Equipment.Item i : items) {
			itemsDataModel.addSorted(i.getDescription());
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
	
	public int getValue() {
		return this.value;
	}
	
	public double getWeight() {
		return this.weight;
	}
	
	public Equipment.Item getItem(){
		return currentItem;
	}
	
}
