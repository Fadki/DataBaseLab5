package view.add;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.FindAll;
import view.tableForm;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class addFunction extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField1;
	private JTextField textField2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			addFunction dialog = new addFunction();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public addFunction() {
		setBounds(100, 100, 381, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		this.setTitle("add function");
		
		JLabel lbl1 = new JLabel("function");
		lbl1.setBounds(25, 27, 46, 14);
		contentPanel.add(lbl1);
		
		textField1 = new JTextField();
		textField1.setBounds(81, 24, 162, 20);
		contentPanel.add(textField1);
		textField1.setColumns(10);
		
		JLabel lbl2 = new JLabel("pay");
		lbl2.setBounds(25, 66, 46, 14);
		contentPanel.add(lbl2);
		
		textField2 = new JTextField();
		textField2.setBounds(81, 63, 162, 20);
		contentPanel.add(textField2);
		textField2.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controller.add add = new controller.add();
						add.addFunction(textField1.getText(), textField2.getText());
						
						
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
