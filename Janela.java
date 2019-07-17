package CrudJava;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class Janela extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTextField nome;
	private JLabel lblNewLabel_1;
	private JTextField sobrenome;
	private JPanel panel_1;
	private JButton btnNewButton;
	private JLabel lblNewLabel_2;
	private JTextField email;
	private JLabel sucess;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela frame = new Janela();
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
	public Janela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(3, 3, 0, 0));
		
		lblNewLabel = new JLabel("Nome");
		panel.add(lblNewLabel);
		
		nome = new JTextField();
		panel.add(nome);
		nome.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Sobrenome");
		panel.add(lblNewLabel_1);
		
		sobrenome = new JTextField();
		panel.add(sobrenome);
		sobrenome.setColumns(10);
		
		lblNewLabel_2 = new JLabel("E-mail");
		panel.add(lblNewLabel_2);
		
		email = new JTextField();
		panel.add(email);
		email.setColumns(10);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(3, 3, 0, 0));
		
		sucess = new JLabel("Aguardando...");
		sucess.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(sucess, BorderLayout.CENTER);

		btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ContatoInterface contatoInterface = new ContatoDAO();
					Contato contato = new Contato(nome.getText(), sobrenome.getText(), email.getText(), "2019");
					
					if(contatoInterface.cadastra(contato)){
						sucess.setText("Salvo com sucesso");
						System.out.println(contatoInterface.isSalvo());
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel_1.add(btnNewButton);
		
	}

}
