package CrudJava;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContatoDAO implements ContatoInterface {
	
	private Connection connection;
	private boolean salvo;
	
	public ContatoDAO() throws SQLException{
		this.connection = ConexaoMysql.getConnection();
	}

	/* (non-Javadoc)
	 * @see ConexaoBanco.ContatoInterface#isSalvo()
	 */
	@Override
	public boolean isSalvo() {
		System.out.println("Salvo");
		return salvo;
	}
	
	
	
	/* (non-Javadoc)
	 * @see ConexaoBanco.ContatoInterface#setSalvo(boolean)
	 */
	@Override
	public void setSalvo(boolean salvo) {
		this.salvo = salvo;
	}

	
	/* (non-Javadoc)
	 * @see ConexaoBanco.ContatoInterface#cadastra(ConexaoBanco.Contato)
	 */
	@Override
	public boolean cadastra(Contato contato) throws SQLException {
		
		PreparedStatement statement = this.connection.prepareStatement("insert into Contatos (firstname, lastname, email, reg_date)" + "values(?,?,?,?)");
		statement.setString(1, contato.getNome());
		statement.setString(2, contato.getSobrenome());
		statement.setString(3, contato.getEmail());
		statement.setString(4, contato.getDate());
		if (statement.execute()) {	
			this.setSalvo(true);
			
		}
		statement.close();
		return true;
	}
	
	/* (non-Javadoc)
	 * @see ConexaoBanco.ContatoInterface#listar()
	 */
	@Override
	public ResultSet listar() throws SQLException{
		PreparedStatement statement = this.connection.prepareStatement("select firstname, lastname, email from Contatos");
		ResultSet rst = statement.executeQuery();
		return rst;
	}

	/* (non-Javadoc)
	 * @see ConexaoBanco.ContatoInterface#delete(int)
	 */
	@Override
	public void delete(int id) throws SQLException {
		PreparedStatement statement = this.connection.prepareStatement("delete from Contatos where id = " + id);
		if (statement.execute() ==true) {	
			System.out.println("Deletado");
			
		}else if(statement.execute() == false) {
			System.out.println("Não modificado");
		}
		
	}



}
