package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
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

import controller.Delete;
import controller.FindAll;
import controller.FindFK;
import model.Function;
import model.Photo;
import model.Photographer;
import model.Room;
import model.Worker;
import model.Working;
import view.add.AddFunction;
import view.add.AddPhoto;
import view.add.AddPhotographer;
import view.add.AddRoom;
import view.add.AddWorker;
import view.add.AddWorking;

public class TableForm extends JDialog {

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

	

	/**
	 * Create the dialog.
	 */
	public TableForm(String nameTable) {
		
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
					addDialog = new AddFunction();
					
					break;
				case "photo":
					addDialog= new AddPhoto();
					
					break;
				case "photographer":
					addDialog = new AddPhotographer();
					break;
				case "room":
					addDialog = new AddRoom();
					break;
				case "worker":
					addDialog = new AddWorker();
					break;
				case "working":
					addDialog = new AddWorking();
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

		JButton btnNewButton1 = new JButton("change");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int result = JOptionPane.showConfirmDialog(TableForm.this, "Do you want change this?", "message",
						JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					controller.Update up = new controller.Update();
					String nameColumn = Tmodel.getColumnName(table.getSelectedColumn());
					int id = (int) Tmodel.getValueAt(table.getSelectedRow(), 0);

					up.update(nameTable, nameColumn, id, textField.getText());
					setModel(nameTable);
					table.setModel(Tmodel);
				
				}
			}
		});
		btnNewButton1.setBounds(554, 80, 89, 23);
		workPanel.add(btnNewButton1);

		JButton btnNewButton2 = new JButton("delete");
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int result = JOptionPane.showConfirmDialog(TableForm.this, "Do you want delete this?", "message",
						JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					Delete del = new Delete();
					int id = (int) Tmodel.getValueAt(table.getSelectedRow(), 0);

					del.delete(nameTable, id);
					setModel(nameTable);
					table.setModel(Tmodel);
				
				}
			}
		});
		btnNewButton2.setBounds(554, 139, 89, 23);
		workPanel.add(btnNewButton2);

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
			List<Function> list = fa.getFunction();
			Tmodel.setColumnIdentifiers(new String[] { "id", "function", "pay" });

			for (model.Function f : list) {
				Object[] o = new Object[3];
				o[0] = f.getId();
				o[1] = f.getFunction();
				o[2] = f.getPay();
				Tmodel.addRow(o);
			}

		} else if (nameTable.equals("photo")) {
			setTitle("photo");
			List<Photo> list = fa.getPhoto();
			Tmodel.setColumnIdentifiers(new String[] { "id", "working_id", "date_photo", "name" });

			for (model.Photo f : list) {
				Object[] o = new Object[4];
				o[0] = f.getId();
				o[1] = f.getWorkingId();
				o[2] = f.getDatePhoto();
				o[3] = f.getName();
				Tmodel.addRow(o);
			}

		} else if (nameTable.equals("photographer")) {
			setTitle("photographer");
			List<Photographer> list = fa.getPhotographer();
			Tmodel.setColumnIdentifiers(new String[] { "id", "name", "fename", "middle_name", "date_birth" });

			for (model.Photographer f : list) {
				Object[] o = new Object[5];
				o[0] = f.getId();
				o[1] = f.getName();
				o[2] = f.getFename();
				o[3] = f.getMiddleName();
				o[4] = f.getDateBirth();
				Tmodel.addRow(o);
			}

		} else if (nameTable.equals("room")) {
			setTitle("room");
			List<Room> list = fa.getRoom();
			Tmodel.setColumnIdentifiers(new String[] { "id", "floor", "worker" });

			for (model.Room f : list) {
				Object[] o = new Object[3];
				o[0] = f.getId();
				o[1] = f.getFloor();
				o[2] = ffk.getFK("worker", "fename", f.getWorker());
				//o[2] = f.getWorker();
				Tmodel.addRow(o);
			}

		} else if (nameTable.equals("worker")) {
			setTitle("worker");
			List<Worker> list = fa.getWorker();
			Tmodel.setColumnIdentifiers(
					new String[] { "id", "name", "fename", "middle_name", "date_birth", "function" });

			for (model.Worker f : list) {
				Object[] o = new Object[6];
				o[0] = f.getId();
				o[1] = f.getName();
				o[2] = f.getFename();
				o[3] = f.getMiddleName();
				o[4] = f.getDateBirth();
				o[5] = ffk.getFK("function", "function", f.getFunction());
				//o[5] = f.getFunction();
				Tmodel.addRow(o);
			}

		} else if (nameTable.equals("working")) {
			setTitle("working");
			List<Working> list = fa.getWorking();
			Tmodel.setColumnIdentifiers(new String[] { "id", "date_working", "subject", "photographer", "room" });

			for (model.Working f : list) {
				Object[] o = new Object[5];
				o[0] = f.getId();
				o[1] = f.getDateWorking();
				o[2] = f.getSubject();
				o[3] = ffk.getFK("photographer", "name", f.getPhotographer());
				//o[3] = f.getPhotographer();
				o[4] = f.getRoom();
				Tmodel.addRow(o);
			}

		}
	}
	

}
