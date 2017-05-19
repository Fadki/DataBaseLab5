package view.add;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.FindAll;
import model.Room;
import model.Worker;

public class AddRoom extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField1;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public AddRoom() {
		setBounds(100, 100, 381, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		this.setTitle("add room");
		
		JLabel lbl2 = new JLabel("floor");
		lbl2.setBounds(26, 37, 106, 14);
		contentPanel.add(lbl2);
		
		textField1 = new JTextField();
		textField1.setBounds(177, 31, 162, 20);
		contentPanel.add(textField1);
		textField1.setColumns(10);
		
		JLabel lbl1 = new JLabel("worker_id");
		lbl1.setBounds(26, 65, 106, 14);
		contentPanel.add(lbl1);
		
		controller.FindAll fa = new FindAll();
		List<Room> listRoom = fa.getRoom();
		List<Worker> listW = fa.getWorker();
		List<Worker> listWorkerAll = fa.getWorker();
		List<Integer> listI = new ArrayList<Integer>();
		for(Room  w: listRoom){
			listI.add(w.getWorker());
		}
		
		for(int i : listI){
			for(Worker w : listWorkerAll)
			if(w.getId() == i){
				listW.remove(w);
				break;
			}			
		}
		
		JComboBox comboBox = new JComboBox(listW.toArray());
		comboBox.addItem("null");
		
		comboBox.setBounds(177, 62, 162, 20);
		contentPanel.add(comboBox);
		
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controller.Add add = new controller.Add();
						add.addRoom(textField1.getText(), comboBox.getSelectedItem().toString());
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
