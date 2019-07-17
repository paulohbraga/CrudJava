package CrudJava;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


@SuppressWarnings("serial")
public class JanelaTab extends JFrame {

	private JPanel contentPane;
	private JTextField nome;
	private JTextField sobrenome;
	private JTextField email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaTab frame = new JanelaTab();
					frame.setTitle("CRUD - MYSQL JDBC");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public JanelaTab() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		contentPane.add(tabbedPane);
		// CREATE PANEL TAB
		JPanel create = new JPanel();
		tabbedPane.addTab("Create", null, create, null);
		
		// READ PANEL TAB
		
		JPanel read = new JPanel();
		tabbedPane.addTab("Read", null, read, null);

		JTable table=new JTable();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 557, 243);
		read.add(scrollPane);
		scrollPane.setViewportView(table);
		
		
		JButton btnNewButton = new JButton("Read");
		btnNewButton.setBounds(247, 261, 75, 29);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ContatoInterface contatoInterface = new ContatoDAO();
					ResultSet t  = contatoInterface.listar();
					table.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(t));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		read.setLayout(null);
		read.add(btnNewButton);

		JPanel update = new JPanel();
		tabbedPane.addTab("Update", null, update, null);
		JPanel delete = new JPanel();
		tabbedPane.addTab("Delete", null, delete, null);
		create.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(68, 48, 440, 78);
		create.add(panel);
		panel.setLayout(new GridLayout(3, 3, 0, 0));
		
		JLabel lblName = new JLabel("First name");
		panel.add(lblName);
		
		nome = new JTextField();
		nome.setColumns(10);
		panel.add(nome);
		
		JLabel lblLastName = new JLabel("Last name");
		panel.add(lblLastName);
		
		sobrenome = new JTextField();
		sobrenome.setColumns(10);
		panel.add(sobrenome);
		
		JLabel label_2 = new JLabel("E-mail");
		panel.add(label_2);
		
		email = new JTextField();
		email.setColumns(10);
		panel.add(email);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(229, 241, 119, 71);
		create.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel sucess = new JLabel("Waiting...");
		sucess.setHorizontalAlignment(SwingConstants.CENTER);
		sucess.setBounds(229, 184, 119, 45);
		create.add(sucess);

		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					ContatoInterface contatoInterface = new ContatoDAO();
					Contato contato = new Contato(nome.getText(), sobrenome.getText(), email.getText(), "2019");
					
					if(contatoInterface.cadastra(contato)){
						sucess.setText("Saved!");
						System.out.println(contatoInterface.isSalvo());
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCreate.setBounds(0, 1, 119, 23);
		panel_1.add(btnCreate);
		
	}
}
