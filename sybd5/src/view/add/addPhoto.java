package view.add;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.FindAll;
import model.Working;

public class AddPhoto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField1;
	private JTextField textField2;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public AddPhoto() {
		setBounds(100, 100, 381, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		this.setTitle("add photo");
		
		JLabel lbl2 = new JLabel("date_photo");
		lbl2.setBounds(25, 66, 106, 14);
		contentPanel.add(lbl2);
		
		textField1 = new JTextField();
		textField1.setBounds(176, 60, 162, 20);
		contentPanel.add(textField1);
		textField1.setColumns(10);
		
		JLabel lbl3 = new JLabel("name");
		lbl3.setBounds(25, 105, 106, 14);
		contentPanel.add(lbl3);
		
		textField2 = new JTextField();
		textField2.setBounds(176, 99, 162, 20);
		contentPanel.add(textField2);
		textField2.setColumns(10);
		
		JLabel lbl1 = new JLabel("working_id");
		lbl1.setBounds(25, 27, 106, 14);
		contentPanel.add(lbl1);
		
		controller.FindAll fa = new FindAll();
		List<Working> listWorking = fa.getWorking();
		
		
		JComboBox comboBox = new JComboBox(listWorking.toArray());
		comboBox.setBounds(176, 24, 162, 20);
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
						add.addPhoto(comboBox.getSelectedItem().toString() ,textField1.getText(), textField2.getText());
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
