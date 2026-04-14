package src;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DAO {
	public String inserir(Pessoa person) {
		String sql = "Insert into pessoa(codigo, nome, dtNascimento) values(?,?,?)";
		try (Connection conn = Conexao.conectar();PreparedStatement stmt = conn.prepareStatement(sql)){ 
			
			stmt.setInt(1, person.getcodigo());
			stmt.setString(2, person.getNome());
			stmt.setDate(3, java.sql.Date.valueOf(person.getDataNascimento()));
			stmt.executeUpdate();
			
			
			return "Inserido com sucesso!";
		}catch(Exception erro) {
			return erro + "\n\nERRO!!!!";
		}
	}//fim do inserir
	
	
}//DATA ACCESS OBJECT
