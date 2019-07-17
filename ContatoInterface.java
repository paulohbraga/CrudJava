package CrudJava;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ContatoInterface {

	boolean isSalvo();

	void setSalvo(boolean salvo);

	boolean cadastra(Contato contato) throws SQLException;

	ResultSet listar() throws SQLException;

	void delete(int id) throws SQLException;

}