package Presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.TextFileIO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

public class StudentManagementGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtStudentName;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentManagementGUI frame = new StudentManagementGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StudentManagementGUI() {
		setResizable(false);
		setTitle("SMS Management");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 352, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Name");
		lblNewLabel.setBounds(21, 32, 86, 14);
		contentPane.add(lblNewLabel);
		
		txtStudentName = new JTextField();
		txtStudentName.setBounds(117, 29, 108, 20);
		contentPane.add(txtStudentName);
		txtStudentName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Gender");
		lblNewLabel_1.setBounds(21, 92, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setSelected(true);
		rdbtnMale.setBounds(117, 88, 55, 23);
		contentPane.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setBounds(174, 88, 109, 23);
		contentPane.add(rdbtnFemale);
		
		JLabel lblNewLabel_2 = new JLabel("Courses");
		lblNewLabel_2.setBounds(21, 199, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JCheckBox chckbxJava = new JCheckBox("Java");
		chckbxJava.setBounds(117, 195, 97, 23);
		contentPane.add(chckbxJava);
		
		JCheckBox chckbxDb = new JCheckBox("DB");
		chckbxDb.setBounds(117, 221, 97, 23);
		contentPane.add(chckbxDb);
		
		JCheckBox chckbxWebProgramming = new JCheckBox("Web Programming");
		chckbxWebProgramming.setBounds(117, 247, 122, 23);
		contentPane.add(chckbxWebProgramming);
		
		JLabel lblNewLabel_1_1 = new JLabel("Semester");
		lblNewLabel_1_1.setBounds(21, 143, 86, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JSpinner spSem = new JSpinner();
		spSem.setModel(new SpinnerNumberModel(1, 1, 4, 1));
		spSem.setBounds(117, 140, 55, 20);
		contentPane.add(spSem);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String studentName = txtStudentName.getText();
				
				String gender = "Male";
				if (rdbtnFemale.isSelected()) {
					gender = "Female";
				}
				
				String courses = "";
				if(chckbxJava.isSelected()) {
					courses += "Java ";
				}
				if(chckbxDb.isSelected()) {
					courses += "DB ";
				}
				if(chckbxWebProgramming.isSelected()) {
					courses += "Web Programming";
				}
				
				int semester = (int) spSem.getValue();
				
				try {
					String entry = studentName + "," + gender + "," + courses + "," + Integer.toString(semester);
					TextFileIO.writeStudent(entry);

					JOptionPane.showMessageDialog(null, "Data is saved");
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Error! " + e1.getMessage());
				}
				
				JOptionPane.showMessageDialog(null, "Name: " + studentName + "\nGender: " + gender + "\nCourses: " + courses + "\nSemester: " + semester);
				
				
				
			}
		});
		btnSave.setBounds(247, 247, 89, 23);
		contentPane.add(btnSave);
		
		
		
		
	}
}
