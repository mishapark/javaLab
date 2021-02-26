package Presentation;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


import javax.swing.*;

public class MainWindow extends JFrame {
	
	private JMenuBar mb;
	private JMenu mnuFile, mnuHelp, mnuStudent;
	private JMenuItem mnuItemExit, mnuItemStudentMgmt, mnuItemSearch;
	
	private JLabel lblCaption;
	private JButton butOK;
	
	public MainWindow() {
		initialize();
	}
	
	private void initialize() {
		this.setTitle("Week 3 - Application");
		this.setBounds(100, 100, 500, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		//this.setLayout(null);
		this.setLayout(new BorderLayout());
		//this.setLayout(new GridLayout(5,2));
		
		mb = new JMenuBar();
		this.setJMenuBar(mb);
		
		mnuFile = new JMenu("File");
		mnuFile.setMnemonic(KeyEvent.VK_F);
		mb.add(mnuFile);
		
		
		mnuStudent = new JMenu("Student");
		mnuStudent.setMnemonic(KeyEvent.VK_S);
		mb.add(mnuStudent);
		
		mnuItemStudentMgmt = new JMenuItem("Manage");
		mnuStudent.add(mnuItemStudentMgmt);
		mnuItemStudentMgmt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentManagementGUI smg = new StudentManagementGUI();
				smg.setVisible(true);
			}
		});
		
		mnuItemSearch = new JMenuItem("Search");
		mnuStudent.add(mnuItemSearch);
		mnuItemSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchGUI search = new SearchGUI();
				search.setVisible(true);
			}
		});
		
		mnuHelp = new JMenu("Help");
		mb.add(mnuHelp);
		
		mnuItemExit = new JMenuItem("Exit");
		mnuFile.add(mnuItemExit);
		mnuItemExit.setMnemonic(KeyEvent.VK_X);
		
		lblCaption = new JLabel("SMS Application", SwingConstants.CENTER);
		//lblCaption.setText();
		//lblCaption.setBounds(100, 100, 100, 40);
		
		this.add(lblCaption);
		
		//Click event handling
		mnuItemExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		butOK = new JButton("OK");
		this.add(butOK, BorderLayout.SOUTH);
		
		//Click event Handling anonymous inner class
		butOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "You pressed OK button");
			}
		});
		
	}
}
