package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controller.FindAll;
import controller.FindFK;
import controller.delete;
import model.DB;
import view.add.addFunction;
import view.add.addPhoto;
import view.add.addPhotographer;
import view.add.addRoom;
import view.add.addWorker;
import view.add.addWorking;

public class tableForm extends JDialog {

	private Timer timer = new Timer();
	private final JPanel workPanel = new JPanel();
	private JTable table;
	private JTextField textField;
	DefaultTableModel Tmodel;
	FindAll fa = new FindAll();
	JDialog addDialog = new JDialog();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {

			tableForm dialog = new tableForm("floor");

			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public tableForm(String nameTable) {
		
		setBounds(100, 100, 669, 396);
		getContentPane().setLayout(null);
		workPanel.setBounds(0, 0, 653, 357);
		workPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(workPanel);
		workPanel.setLayout(null);

		UIManager.put("OptionPane.yesButtonText", "Yes");
		UIManager.put("OptionPane.noButtonText", "No");
		
		table = new JTable();
		table.setFillsViewportHeight(true);

		Tmodel = new DefaultTableModel();
		setModel(nameTable);
		table.setModel(Tmodel);
		

		JButton btnNewButton = new JButton("add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				switch (nameTable) {
				case "function":
					addDialog = new addFunction();
					
					break;
				case "photo":
					addDialog= new addPhoto();
					
					break;
				case "photographer":
					addDialog = new addPhotographer();
					break;
				case "room":
					addDialog = new addRoom();
					break;
				case "worker":
					addDialog = new addWorker();
					break;
				case "working":
					addDialog = new addWorking();
					break;
				default:
					break;
				}
				addDialog.show();
				timer = new Timer();
				timer.schedule(new TimerTask() {
					
					@Override
					public void run() {
						if(!addDialog.isShowing()){
							setModel(nameTable);
							table.setModel(Tmodel);
							timer.cancel();
						}
						
					}
				}, 0, 1);
			}
			
		});
		btnNewButton.setBounds(554, 25, 89, 23);
		workPanel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("change");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int result = JOptionPane.showConfirmDialog(tableForm.this, "Do you want change this?", "message",
						JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					controller.update up = new controller.update();
					String nameColumn = Tmodel.getColumnName(table.getSelectedColumn());
					int id = (int) Tmodel.getValueAt(table.getSelectedRow(), 0);

					up.update(nameTable, nameColumn, id, textField.getText());
					setModel(nameTable);
					table.setModel(Tmodel);
				
				}
			}
		});
		btnNewButton_1.setBounds(554, 80, 89, 23);
		workPanel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int result = JOptionPane.showConfirmDialog(tableForm.this, "Do you want delete this?", "message",
						JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					delete del = new delete();
					int id = (int) Tmodel.getValueAt(table.getSelectedRow(), 0);

					del.delete(nameTable, id);
					setModel(nameTable);
					table.setModel(Tmodel);
				
				}
			}
		});
		btnNewButton_2.setBounds(554, 139, 89, 23);
		workPanel.add(btnNewButton_2);

		textField = new JTextField();
		textField.setBounds(457, 81, 70, 20);
		workPanel.add(textField);
		textField.setColumns(10);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 11, 437, 232);
		workPanel.add(scrollPane);

	}

	private void setModel(String nameTable) {

		Tmodel = new DefaultTableModel(){
			@Override
	    	public boolean isCellEditable(int row, int column) {
	    		return false;
	    	}
		};

		controller.FindFK ffk = new FindFK();
		if (nameTable.equals("function")) {
			setTitle("function");
			fa.get("function");
			Tmodel.setColumnIdentifiers(new String[] { "id", "function", "pay" });

			for (model.function f : DB.listFunction) {
				Object[] o = new Object[3];
				o[0] = f.getId();
				o[1] = f.getFunction();
				o[2] = f.getPay();
				Tmodel.addRow(o);
			}

		} else if (nameTable.equals("photo")) {
			setTitle("photo");
			fa.get("photo");
			Tmodel.setColumnIdentifiers(new String[] { "id", "working_id", "date_photo", "name" });

			for (model.photo f : DB.listPhoto) {
				Object[] o = new Object[4];
				o[0] = f.getId();
				o[1] = f.getWorking_id();
				o[2] = f.getDate_photo();
				o[3] = f.getName();
				Tmodel.addRow(o);
			}

		} else if (nameTable.equals("photographer")) {
			setTitle("photographer");
			fa.get("photographer");
			Tmodel.setColumnIdentifiers(new String[] { "id", "name", "fename", "middle_name", "date_birth" });

			for (model.photographer f : DB.listPhotographer) {
				Object[] o = new Object[5];
				o[0] = f.getId();
				o[1] = f.getName();
				o[2] = f.getFename();
				o[3] = f.getMiddle_name();
				o[4] = f.getDate_birth();
				Tmodel.addRow(o);
			}

		} else if (nameTable.equals("room")) {
			setTitle("room");
			fa.get("room");
			Tmodel.setColumnIdentifiers(new String[] { "id", "floor", "worker" });

			for (model.room f : DB.listRoom) {
				Object[] o = new Object[3];
				o[0] = f.getId();
				o[1] = f.getFloor();
				o[2] = ffk.getFK("worker", "fename", f.getWorker());
				//o[2] = f.getWorker();
				Tmodel.addRow(o);
			}

		} else if (nameTable.equals("worker")) {
			setTitle("worker");
			fa.get("worker");
			Tmodel.setColumnIdentifiers(
					new String[] { "id", "name", "fename", "middle_name", "date_birth", "function" });

			for (model.worker f : DB.listWorker) {
				Object[] o = new Object[6];
				o[0] = f.getId();
				o[1] = f.getName();
				o[2] = f.getFename();
				o[3] = f.getMiddle_name();
				o[4] = f.getDate_birth();
				o[5] = ffk.getFK("function", "function", f.getFunction());
				//o[5] = f.getFunction();
				Tmodel.addRow(o);
			}

		} else if (nameTable.equals("working")) {
			setTitle("working");
			fa.get("working");
			Tmodel.setColumnIdentifiers(new String[] { "id", "date_working", "subject", "photographer", "room" });

			for (model.working f : DB.listWorking) {
				Object[] o = new Object[5];
				o[0] = f.getId();
				o[1] = f.getDate_working();
				o[2] = f.getSubject();
				o[3] = ffk.getFK("photographer", "name", f.getPhotographer());
				//o[3] = f.getPhotographer();
				o[4] = f.getRoom();
				Tmodel.addRow(o);
			}

		}
	}
	

}
