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

import controller.Connecting;
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

		Connecting connectingClass = new Connecting();

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

		JLabel LabelHost = new JLabel("Host");
		LabelHost.setBounds(43, 29, 103, 14);
		login_.add(LabelHost);

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

		JTextField textFieldHost = new JTextField();
		textFieldHost.setText("localhost");
		textFieldHost.setBounds(156, 23, 163, 20);
		login_.add(textFieldHost);
		textFieldHost.setColumns(10);

		JTextField textFieldPort = new JTextField();
		textFieldPort.setText("5432");
		textFieldPort.setColumns(10);
		textFieldPort.setBounds(156, 51, 163, 20);
		login_.add(textFieldPort);

		JTextField textFieldDbName = new JTextField();
		textFieldDbName.setText("photo");
		textFieldDbName.setColumns(10);
		textFieldDbName.setBounds(156, 79, 163, 20);
		login_.add(textFieldDbName);

		JTextField textFieldUser = new JTextField();
		textFieldUser.setText("postgres");
		textFieldUser.setColumns(10);
		textFieldUser.setBounds(156, 107, 163, 20);
		login_.add(textFieldUser);

		JTextField textFieldPassword = new JTextField();
		textFieldPassword.setText("1");
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(156, 135, 163, 20);
		login_.add(textFieldPassword);

		JLabel labelStatus = new JLabel("Disconnect");
		labelStatus.setHorizontalAlignment(SwingConstants.RIGHT);
		labelStatus.setBounds(240, 11, 184, 14);
		labelStatus.setForeground(Color.RED);
		menuPanel.add(labelStatus);

		JMenuBar menuBarTable = new JMenuBar();

		JButton btnLog = new JButton("login");
		btnLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				labelStatus.setForeground(Color.YELLOW);
				labelStatus.setText("Connecting...");
				if (connectingClass.connect(textFieldHost.getText(), textFieldPort.getText(),
						textFieldDbName.getText(), textFieldUser.getText(), textFieldPassword.getText())) {
					labelStatus.setForeground(Color.GREEN);
					labelStatus.setText("Connected");
					frame.getContentPane().remove(login_);
					frame.getContentPane().add(loginPanel);
					menuPanel.add(menuBarTable);

					frame.repaint();
				} else {
					labelStatus.setForeground(Color.RED);
					labelStatus.setText("Connecting problem");
					// JOptionPane.showMessageDialog(frame, "Error");
				}

			}
		});
		btnLog.setBounds(230, 166, 89, 23);
		login_.add(btnLog);

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

		JMenuItem mntmNewMenuItem2 = new JMenuItem("Connect");
		mntmNewMenuItem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.getContentPane().remove(loginPanel);
				frame.getContentPane().add(login_);

				frame.repaint();

			}
		});
		mnNewMenu.add(mntmNewMenuItem2);

		JMenuItem mntmNewMenuItem1 = new JMenuItem("Disconnect");
		mntmNewMenuItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				labelStatus.setForeground(Color.RED);
				labelStatus.setText("Disconnect");
				connectingClass.disconnect();
				frame.getContentPane().remove(login_);
				frame.getContentPane().add(loginPanel);

				menuPanel.remove(menuBarTable);
				frame.repaint();
			}
		});
		mnNewMenu.add(mntmNewMenuItem1);

		JMenuItem mntmNewMenuItem = new JMenuItem("Exit");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				connectingClass.disconnect();
				frame.dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);

		menuBarTable.setBounds(68, 0, 58, 30);

		JMenu mnNewMenu1 = new JMenu(" Tables ");
		menuBarTable.add(mnNewMenu1);

		JMenuItem mntmNewMenuItem4 = new JMenuItem("Room");
		mntmNewMenuItem4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableForm tf = new TableForm("room");
				tf.show();
			}
		});
		mnNewMenu1.add(mntmNewMenuItem4);

		JMenuItem mntmWorker = new JMenuItem("Worker");
		mntmWorker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableForm tf = new TableForm("worker");
				tf.show();
			}
		});
		mnNewMenu1.add(mntmWorker);

		JMenuItem mntmNewMenuItem5 = new JMenuItem("Function");
		mntmNewMenuItem5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableForm tf = new TableForm("function");
				tf.show();
			}
		});
		mnNewMenu1.add(mntmNewMenuItem5);

		JMenuItem mntmWorking = new JMenuItem("Working");
		mntmWorking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableForm tf = new TableForm("working");
				tf.show();
			}
		});
		mnNewMenu1.add(mntmWorking);

		JMenuItem mntmNewMenuItem6 = new JMenuItem("Photographer");
		mntmNewMenuItem6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableForm tf = new TableForm("photographer");
				tf.show();
			}
		});
		mnNewMenu1.add(mntmNewMenuItem6);

		JMenuItem mntmPhotography = new JMenuItem("Photo");
		mntmPhotography.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableForm tf = new TableForm("photo");
				tf.show();
			}
		});
		mnNewMenu1.add(mntmPhotography);

	}

}
