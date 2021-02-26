package Presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.BinaryFileIO;
import data.TextFileIO;

import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class SearchGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchGUI frame = new SearchGUI();
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
	public SearchGUI() {
		final ButtonGroup buttonGroup = new ButtonGroup();
		
		setTitle("SMS Search");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtareaSearch = new JTextArea();
		txtareaSearch.setBounds(28, 92, 375, 158);
		contentPane.add(txtareaSearch);
		
		JRadioButton rdName = new JRadioButton("Name");
		rdName.setSelected(true);
		rdName.setBounds(28, 18, 58, 23);
		contentPane.add(rdName);
		buttonGroup.add(rdName);
		
		JRadioButton rdGender = new JRadioButton("Gender");
		rdGender.setBounds(88, 18, 67, 23);
		contentPane.add(rdGender);
		buttonGroup.add(rdGender);
		
		JRadioButton rdCourse = new JRadioButton("Course");
		rdCourse.setBounds(163, 18, 67, 23);
		contentPane.add(rdCourse);
		buttonGroup.add(rdCourse);
		
		JRadioButton rdSemester = new JRadioButton("Semester");
		rdSemester.setBounds(232, 18, 78, 23);
		contentPane.add(rdSemester);
		buttonGroup.add(rdSemester);
		
		JRadioButton rbAll = new JRadioButton("All");
		rbAll.setBounds(347, 18, 109, 23);
		contentPane.add(rbAll);
		buttonGroup.add(rbAll);
		
		JLabel lblNewLabel = new JLabel("Seacrh String");
		lblNewLabel.setBounds(38, 48, 78, 14);
		contentPane.add(lblNewLabel);
		
		txtSearch = new JTextField();
		txtSearch.setHorizontalAlignment(SwingConstants.RIGHT);
		txtSearch.setBounds(128, 45, 127, 20);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String findStr = txtSearch.getText();
				txtareaSearch.setText("");
				
				Object[] sList = null;
				
				try {
					sList = TextFileIO.readStudents();
				} catch (IOException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Find All", JOptionPane.ERROR_MESSAGE);
				}
				
				if (rbAll.isSelected()) {
					for	(Object s : sList) {
						txtareaSearch.append(s.toString());
						txtareaSearch.append("\n");
					}
				} else {
					if ((Validator.isPresent(txtSearch, "Search String"))) {
						if (rdName.isSelected()) {
							for	(Object s : sList) {
								String str = (String)s;
								String[] splitArr = str.split(",");
								if(splitArr[0].contains(findStr)) {
									txtareaSearch.append(str + "\n");
								}
							}
						} else if (rdGender.isSelected()) {
							for	(Object s : sList) {
								String str = (String)s;
								String[] splitArr = str.split(",");
								if(splitArr[1].contains(findStr)) {
									txtareaSearch.append(str + "\n");
								}
							}
						} else if (rdCourse.isSelected()) {
							for	(Object s : sList) {
								String str = (String)s;
								String[] splitArr = str.split(",");
								if(splitArr[2].contains(findStr)) {
									txtareaSearch.append(str + "\n");
								}
							}
						} else if (rdSemester.isSelected()) {
							for	(Object s : sList) {
								String str = (String)s;
								String[] splitArr = str.split(",");
								if(splitArr[3].contains(findStr)) {
									txtareaSearch.append(str + "\n");
								}
							}
						}
					}
				}
			}
		});
		btnFind.setBounds(265, 44, 89, 23);
		contentPane.add(btnFind);
		

	}
}
