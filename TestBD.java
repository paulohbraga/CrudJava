package CrudJava;

import java.sql.SQLException;

// Test Class

public class TestBD {
	
	public static void main(String[] args) throws SQLException {
		Contato novo = new Contato("Bob", "Rogers", "bob@td.org", "2019-06-15");
		Contato novo2 = new Contato("Mary", "Ross", "maryss@gmail.com", "2019-06-16");
		ContatoInterface contatoDAO = new ContatoDAO();
		contatoDAO.cadastra(novo);
		contatoDAO.isSalvo();
		contatoDAO.cadastra(novo2);
		
		
		contatoDAO.listar();
		for (int i = 0; i < 3000; i++) {
		//	contatoDAO.delete(i);
		}

		
	}

}
