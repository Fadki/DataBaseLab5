package view.add;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.FindAll;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class addWorking extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField1;
	private JTextField textField2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			addWorking dialog = new addWorking();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public addWorking() {
		setBounds(100, 100, 381, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		this.setTitle("add working");
		
		JLabel lbl2 = new JLabel("subject");
		lbl2.setBounds(25, 66, 106, 14);
		contentPanel.add(lbl2);
		
		textField1 = new JTextField();
		textField1.setBounds(176, 27, 162, 20);
		contentPanel.add(textField1);
		textField1.setColumns(10);
		
		JLabel lbl3 = new JLabel("id photographer");
		lbl3.setBounds(25, 105, 106, 14);
		contentPanel.add(lbl3);
		
		textField2 = new JTextField();
		textField2.setBounds(176, 63, 162, 20);
		contentPanel.add(textField2);
		textField2.setColumns(10);
		
		JLabel lbl1 = new JLabel("date working");
		lbl1.setBounds(25, 27, 106, 14);
		contentPanel.add(lbl1);
		
		controller.FindAll fa = new FindAll();
		fa.get("photographer");
		fa.get("room");
		
		JComboBox comboBox = new JComboBox(model.DB.listPhotographer.toArray());
		comboBox.setBounds(176, 102, 162, 20);
		contentPanel.add(comboBox);
		
		JLabel label4 = new JLabel("id room");
		label4.setBounds(25, 141, 106, 14);
		contentPanel.add(label4);
		
		JComboBox comboBox_1 = new JComboBox(model.DB.listRoom.toArray());
		comboBox_1.setBounds(176, 138, 162, 20);
		contentPanel.add(comboBox_1);
		
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controller.add add = new controller.add();
						add.addWorking(textField1.getText(), textField2.getText(), comboBox.getSelectedItem().toString(), comboBox_1.getSelectedItem().toString());
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
