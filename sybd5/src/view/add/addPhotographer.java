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

public class AddPhotographer extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField4;
	private JTextField textField3;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public AddPhotographer() {
		setBounds(100, 100, 381, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		this.setTitle("add photographer");
		
		JLabel lbl1 = new JLabel("name");
		lbl1.setBounds(28, 33, 118, 14);
		contentPanel.add(lbl1);
		
		textField1 = new JTextField();
		textField1.setBounds(181, 27, 162, 20);
		contentPanel.add(textField1);
		textField1.setColumns(10);
		
		JLabel lbl2 = new JLabel("fename");
		lbl2.setBounds(28, 64, 118, 14);
		contentPanel.add(lbl2);
		
		textField2 = new JTextField();
		textField2.setBounds(181, 58, 162, 20);
		contentPanel.add(textField2);
		textField2.setColumns(10);
		
		textField4 = new JTextField();
		textField4.setColumns(10);
		textField4.setBounds(181, 120, 162, 20);
		contentPanel.add(textField4);
		
		JLabel label4 = new JLabel("date birth");
		label4.setBounds(28, 126, 118, 14);
		contentPanel.add(label4);
		
		JLabel lbl3 = new JLabel("middle name");
		lbl3.setBounds(28, 95, 118, 14);
		contentPanel.add(lbl3);
		
		textField3 = new JTextField();
		textField3.setColumns(10);
		textField3.setBounds(181, 89, 162, 20);
		contentPanel.add(textField3);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controller.Add add = new controller.Add();
						add.addPhotographer(textField1.getText(), textField2.getText(), textField3.getText(), textField4.getText());
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
