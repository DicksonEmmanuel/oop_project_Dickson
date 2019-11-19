package org.iuea.oop.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MainView extends JFrame {

	//declaration of components we're going to use in the system
	private JPanel contentPane;
	private JFrame frame;
	private JTable table;
	private JTextField firstnamef;
	private JTextField lastnamef;
	private JTextField course;
	private JTextField Reference;
	private JTextField regnof;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	//creating the constructor that will containt all our components
	public MainView() {
		this.setTitle("Dickson 2019");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 800, 600);
		
		//creation of the menubar that holds our menus
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		//creation of menus and submenus in the system with shortcuts for some of them
		JMenu mnNewMenu = new JMenu("Action");
		mnNewMenu.setSize(100, 30);
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("New");
		mnNewMenu.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Order", KeyEvent.VK_M);
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JSeparator separator_3 = new JSeparator();
		mnNewMenu_1.add(separator_3);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Page");
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JSeparator separator_4 = new JSeparator();
		mnNewMenu_1.add(separator_4);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("User Account");
		mnNewMenu_1.add(mntmNewMenuItem);
		
		//the printing item has an action to print the table we have in the system
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Print", KeyEvent.VK_P);
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg) {
				try
				{
					table.print();
				}catch(java.awt.print.PrinterException e) {
					System.err.format("No Printer found", e.getMessage());
				}
			}
		});
			
		mnNewMenu.add(mntmNewMenuItem_8);
		//JSepatator is used in the menus to separate between menu items
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		//logout menuitem to allow users logout in the system
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Logout", KeyEvent.VK_L);
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (JOptionPane.showConfirmDialog(frame, "Are you sure you want to logout?","GhiFat 2019",
						JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
					
					setVisible(false);
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								LoginView frame2 = new LoginView();
								
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
				
			}
		});
			
		mnNewMenu.add(mntmNewMenuItem_5);
		
		JSeparator separator_2 = new JSeparator();
		mnNewMenu.add(separator_2);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Close");
		mnNewMenu.add(mntmNewMenuItem_6);
		
		//close all item has an action to shutdown all the system
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Close All", KeyEvent.VK_C);
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_7);
		
		JMenu mnNewMenu_2 = new JMenu("Help");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("About the system");
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		JSeparator separator_1 = new JSeparator();
		mnNewMenu_2.add(separator_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("More info");
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		//creation of the content pane, this is the panel that covers all the frame
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//creation of the first panel, this panel is found on top of the content pane, it is the container of all the other panels
		JPanel panel = new JPanel();
		panel.setBackground(new Color(238, 232, 170));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(0, 0, 784, 540);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
	//creation of the panel_7, this is the container of our table and add, edit and delete buttons, it is called when the student button is pressed
				JPanel panel_7 = new JPanel();
				panel_7.setBorder(new LineBorder(new Color(0, 0, 0), 2));
				panel_7.setBackground(new Color(238, 232, 170));
				panel_7.setBounds(167, 0, 617, 470);
				panel.add(panel_7);
				panel_7.setLayout(null);
				panel_7.setVisible(false);
				
				//creation the the scrollpane,this is the container of our table, it is found in the panel_7
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(0, 92, 607, 378);
				panel_7.add(scrollPane);
				
				//creation of the table, setting its model and objects
				table = new JTable();
				table.setModel(new DefaultTableModel(
					new Object[][] {
						{"2020","Dickson", "Dickson","male","Bit","19/454/Bit-j"},
						{"2021","Dalton", "Cirhuza","male","BSSE","18/0045/BSSE-j"},
						{"2022","Angela", "Kembabazi","female","BSCS","19/454/BSCS-s"},
						{"2022","Styve", "Mutabazi","male","BIT-j","18/101/BIT-j"},
						
						
						
					},
					new String[] {
						"#", "First Name", "Last Name", "Sex", "Course", "Registration #"
					}
				));
				scrollPane.setViewportView(table);
				
				
				//panel_register: container of our registration form, it is called when the add button or the edit button is pressed in the panel_7
				JPanel panel_register=new JPanel();
				panel_register.setBorder(new LineBorder(new Color(0, 0, 0), 2));
				panel_register.setBackground(new Color(238, 232, 170));
				panel_register.setBounds(167, 0, 617, 470);
				panel.add(panel_register);
				panel_register.setLayout(null);


		//beginning of the Panel_register's components

		JLabel lblNewLabel_1 = new JLabel("First Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(65, 82, 132, 56);
		panel_register.add(lblNewLabel_1);

		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLastName.setBounds(65, 135, 118, 56);
		panel_register.add(lblLastName);

		JLabel lblSex = new JLabel("Sex:");
		lblSex.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSex.setBounds(65, 191, 132, 56);
		panel_register.add(lblSex);

		JLabel lblDateOfBirth = new JLabel("Course");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDateOfBirth.setBounds(65, 246, 143, 56);
		panel_register.add(lblDateOfBirth);

		firstnamef = new JTextField();
		firstnamef.setFont(new Font("Tahoma", Font.BOLD, 20));
		firstnamef.setBounds(229, 93, 325, 42);
		panel_register.add(firstnamef);
		firstnamef.setColumns(10);

		lastnamef = new JTextField();
		lastnamef.setFont(new Font("Tahoma", Font.BOLD, 20));
		lastnamef.setColumns(10);
		lastnamef.setBounds(229, 146, 325, 42);
		panel_register.add(lastnamef);

		JComboBox sexcomb = new JComboBox();
		sexcomb.setFont(new Font("Tahoma", Font.BOLD, 20));
		sexcomb.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		sexcomb.setBounds(229, 198, 325, 42);
		panel_register.add(sexcomb);

		course = new JTextField();
		course.setFont(new Font("Tahoma", Font.BOLD, 20));
		course.setColumns(10);
		course.setBounds(229, 257, 325, 42);
		panel_register.add(course);

		JLabel lblReferenceNo = new JLabel("Reference No:");
		lblReferenceNo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblReferenceNo.setBounds(65, 29, 161, 56);
		panel_register.add(lblReferenceNo);

		Reference = new JTextField();
		Reference.setFont(new Font("Tahoma", Font.BOLD, 20));
		Reference.setColumns(10);
		Reference.setBounds(229, 39, 325, 42);
		panel_register.add(Reference);

		JLabel lblRegNo = new JLabel("Reg No");
		lblRegNo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRegNo.setBounds(65, 307, 143, 56);
		panel_register.add(lblRegNo);

		regnof = new JTextField();
		regnof.setFont(new Font("Tahoma", Font.BOLD, 20));
		regnof.setColumns(10);
		regnof.setBounds(229, 318, 325, 42);
		panel_register.add(regnof);
		panel_register.setVisible(false);
				
		
				//declaration of the edit button found in the panel_7, this button make it possible to edit a record in the table
				JButton btnEdit = new JButton("Edit");
				btnEdit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DefaultTableModel model=(DefaultTableModel) table.getModel();
						
						
						 if(table.getSelectedRow()==-1) {
							 if(table.getRowCount()==0) {
								 
							 }else {
								 JOptionPane.showMessageDialog(null, "Please select a row to edit","Dickson 2019",JOptionPane.OK_OPTION);
							 }
						 }else {
							 int i=table.getSelectedRow();
								Reference.setText(model.getValueAt(i,0).toString());
								firstnamef.setText(model.getValueAt(i,1).toString());
								lastnamef.setText(model.getValueAt(i,3).toString());
								sexcomb.setSelectedItem(model.getValueAt(i,4).toString());
								course.setText(model.getValueAt(i,5).toString());
								regnof.setText(model.getValueAt(i,0).toString());
								
								
							 model.removeRow(table.getSelectedRow());
							 panel_register.setVisible(true);
						     panel_7.setVisible(false);
						 }	
					}
				});
				btnEdit.setFont(new Font("Tahoma", Font.BOLD, 20));
				btnEdit.setBackground(new Color(255, 140, 0));
				btnEdit.setBounds(230, 11, 136, 46);
				panel_7.add(btnEdit);
				
				//creation of the delete button, this one helps delete a record in the table
				JButton btnDelete = new JButton("Delete");
				btnDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DefaultTableModel model=(DefaultTableModel) table.getModel();
						 if(table.getSelectedRow()==-1) {
							 if(table.getRowCount()==0) {
								 
							 }else {
								 JOptionPane.showMessageDialog(null, "Select a row to delete","Dickson 2019",JOptionPane.OK_OPTION);
							 }
						 }else {
							 model.removeRow(table.getSelectedRow());
						 }
						
					}
				});
				btnDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
				btnDelete.setBackground(new Color(220, 20, 60));
				btnDelete.setBounds(442, 11, 136, 46);
				panel_7.add(btnDelete);
				
				//creation of the add button from the panel_7, this button open the registration form to enter a new record
				JButton btnNewButton_1 = new JButton("Add");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						Reference.setText(null);
						firstnamef.setText(null);
						lastnamef.setText(null);
						sexcomb.setSelectedItem(null);
						course.setText(null);
						regnof.setText(null);
						
						panel_register.setVisible(true);
						panel_7.setVisible(false);
						btnNewButton_1.setVisible(false);
						btnEdit.setVisible(false);
						btnDelete.setVisible(false);
						
					}
				});
				btnNewButton_1.setBackground(Color.BLUE);
				btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
				btnNewButton_1.setBounds(20, 11, 136, 46);
				panel_7.add(btnNewButton_1);
	
			
		//submit button of register panel, it task is to add new records from the registration form in the table
		JButton Submit = new JButton("Submit");
		Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				model.addRow(new Object [] {
						Reference.getText(),
						firstnamef.getText(),
						lastnamef.getText(),
						sexcomb.getSelectedItem(),
						course.getText(),
						regnof.getText(),
				});
				
				if(table.getSelectedRow()==1) {
					if(table.getRowCount()==0) {
						JOptionPane.showConfirmDialog(null, "Membership Update confirmed","Dickson 2019",
								JOptionPane.OK_OPTION);
					}
				}
				panel_register.setVisible(false);
				panel_7.setVisible(true);
				btnNewButton_1.setVisible(true);
				btnEdit.setVisible(true);
				btnDelete.setVisible(true);
			}
		});	
		Submit.setForeground(new Color(255, 255, 255));
		Submit.setBackground(new Color(0, 100, 0));
		Submit.setFont(new Font("Tahoma", Font.BOLD, 20));
		Submit.setBounds(89, 391, 137, 56);
		panel_register.add(Submit);

		
		//cancel button of the registrer panel, once clicked it aborts the process of entering a new record
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_register.setVisible(false);
				panel_7.setVisible(true);
				btnNewButton_1.setVisible(true);
				btnEdit.setVisible(true);
				btnDelete.setVisible(true);
			}
		});
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCancel.setBackground(new Color(220, 20, 60));
		btnCancel.setBounds(408, 391, 137, 56);
		panel_register.add(btnCancel);
				
		//declaration of panel_left, it is the container of the buttons we have in the left side of the frame: the student, lecturer,...
		JPanel panel_left = new JPanel();
		panel_left.setBackground(new Color(238, 232, 170));
		panel_left.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_left.setBounds(0, 0, 169, 470);
		panel.add(panel_left);
		panel_left.setLayout(null);
		
		//creation of the lecturer button 
		JButton btnLecturers = new JButton("Lecturers");
		btnLecturers.setBounds(0, 231, 169, 78);
		panel_left.add(btnLecturers);
		btnLecturers.setBackground(new Color(238, 232, 170));
		btnLecturers.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		//creation of the course unit button
		JButton btnCourseUnits = new JButton("Course Units");
		btnCourseUnits.setBounds(0, 154, 169, 78);
		panel_left.add(btnCourseUnits);
		btnCourseUnits.setBackground(new Color(238, 232, 170));
		btnCourseUnits.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		//course button
		JButton btnCourse = new JButton("Course");
		btnCourse.setBounds(0, 77, 169, 78);
		panel_left.add(btnCourse);
		btnCourse.setBackground(new Color(238, 232, 170));
		btnCourse.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		//student button, this is the only operating button in the left panel for now, it is also the opener of panel_7 in the left right side
		JButton btnNewButton = new JButton("Students");
		btnNewButton.setBounds(0, 0, 169, 78);
		panel_left.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_7.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(238, 232, 170));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
				//
		//creation of the bottom panel, it contains a label that has the copyright statement 
				JPanel bottom_panel = new JPanel();
				bottom_panel.setBackground(new Color(238, 232, 170));
				bottom_panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
				bottom_panel.setBounds(-121, 469, 905, 71);
				panel.add(bottom_panel);
				bottom_panel.setLayout(null);
				
				JLabel lblNewLabel = new JLabel("Copy right Dickson 2019");
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblNewLabel.setBounds(396, 11, 282, 41);
				bottom_panel.add(lblNewLabel);
		
		
		//
		
		
		
		
	}
}
