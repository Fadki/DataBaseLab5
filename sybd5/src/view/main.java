package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import controller.connecting;
import javax.swing.SwingConstants;;

public class main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		connecting connectingClass = new connecting();

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 396);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel menuPanel = new JPanel();
		JPanel loginPanel = new JPanel();
		loginPanel.setBounds(0, 29, 434, 328);
		frame.getContentPane().add(loginPanel);
		loginPanel.setLayout(null);

		JPanel login_ = new JPanel();
		login_.setLayout(null);

		JLabel Label_host = new JLabel("Host");
		Label_host.setBounds(43, 29, 103, 14);
		login_.add(Label_host);

		JLabel lblPort = new JLabel("Port");
		lblPort.setBounds(43, 57, 103, 14);
		login_.add(lblPort);

		JLabel lblNameDb = new JLabel("Name DB");
		lblNameDb.setBounds(43, 85, 103, 14);
		login_.add(lblNameDb);

		JLabel lblUser = new JLabel("User");
		lblUser.setBounds(43, 113, 103, 14);
		login_.add(lblUser);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(43, 141, 103, 14);
		login_.add(lblPassword);

		JTextField textField_host = new JTextField();
		textField_host.setText("localhost");
		textField_host.setBounds(156, 23, 163, 20);
		login_.add(textField_host);
		textField_host.setColumns(10);

		JTextField textField_port = new JTextField();
		textField_port.setText("5432");
		textField_port.setColumns(10);
		textField_port.setBounds(156, 51, 163, 20);
		login_.add(textField_port);

		JTextField textField_dbName = new JTextField();
		textField_dbName.setText("photo");
		textField_dbName.setColumns(10);
		textField_dbName.setBounds(156, 79, 163, 20);
		login_.add(textField_dbName);

		JTextField textField_user = new JTextField();
		textField_user.setText("postgres");
		textField_user.setColumns(10);
		textField_user.setBounds(156, 107, 163, 20);
		login_.add(textField_user);

		JTextField textField_password = new JTextField();
		textField_password.setText("1");
		textField_password.setColumns(10);
		textField_password.setBounds(156, 135, 163, 20);
		login_.add(textField_password);

		JLabel label_status = new JLabel("Disconnect");
		label_status.setHorizontalAlignment(SwingConstants.RIGHT);
		label_status.setBounds(240, 11, 184, 14);
		label_status.setForeground(Color.RED);
		menuPanel.add(label_status);

		JMenuBar menuBarTable = new JMenuBar();

		JButton btn_log = new JButton("login");
		btn_log.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				label_status.setForeground(Color.YELLOW);
				label_status.setText("Connecting...");
				if (connectingClass.connect(textField_host.getText(), textField_port.getText(),
						textField_dbName.getText(), textField_user.getText(), textField_password.getText())) {
					label_status.setForeground(Color.GREEN);
					label_status.setText("Connected");
					frame.getContentPane().remove(login_);
					frame.getContentPane().add(loginPanel);
					menuPanel.add(menuBarTable);

					frame.repaint();
				} else {
					label_status.setForeground(Color.RED);
					label_status.setText("Connecting problem");
					// JOptionPane.showMessageDialog(frame, "Error");
				}

			}
		});
		btn_log.setBounds(230, 166, 89, 23);
		login_.add(btn_log);

		login_.setBounds(0, 29, 434, 328);

		menuPanel.setBounds(0, 0, 434, 30);
		frame.getContentPane().add(menuPanel);
		menuPanel.setLayout(null);

		JMenuBar menuBarDB = new JMenuBar();
		menuBarDB.setBounds(0, 0, 58, 30);
		menuPanel.add(menuBarDB);

		JMenu mnNewMenu = new JMenu("     DB     ");
		menuBarDB.add(mnNewMenu);

		// frame.getContentPane().add(login_);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Connect");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.getContentPane().remove(loginPanel);
				frame.getContentPane().add(login_);

				frame.repaint();

			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Disconnect");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				label_status.setForeground(Color.RED);
				label_status.setText("Disconnect");
				connectingClass.disconnect();
				frame.getContentPane().remove(login_);
				frame.getContentPane().add(loginPanel);

				menuPanel.remove(menuBarTable);
				frame.repaint();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem = new JMenuItem("Exit");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				connectingClass.disconnect();
				frame.dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);

		menuBarTable.setBounds(68, 0, 58, 30);

		JMenu mnNewMenu_1 = new JMenu(" Tables ");
		menuBarTable.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Room");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableForm tf = new tableForm("room");
				tf.show();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_4);

		JMenuItem mntmWorker = new JMenuItem("Worker");
		mntmWorker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableForm tf = new tableForm("worker");
				tf.show();
			}
		});
		mnNewMenu_1.add(mntmWorker);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Function");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableForm tf = new tableForm("function");
				tf.show();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_5);

		JMenuItem mntmWorking = new JMenuItem("Working");
		mntmWorking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableForm tf = new tableForm("working");
				tf.show();
			}
		});
		mnNewMenu_1.add(mntmWorking);

		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Photographer");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableForm tf = new tableForm("photographer");
				tf.show();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_6);

		JMenuItem mntmPhotography = new JMenuItem("Photo");
		mntmPhotography.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableForm tf = new tableForm("photo");
				tf.show();
			}
		});
		mnNewMenu_1.add(mntmPhotography);

	}

}
