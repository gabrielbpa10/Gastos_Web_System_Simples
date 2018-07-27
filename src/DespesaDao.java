import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DespesaDao {
	public List<Despesa> getDespesas(){
		List<Despesa> despesa = new ArrayList<>();
		try {
			Connection connection = ConnectionFactory.getConnection();
			String sql = "select * from despesa.gasto";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet resultSet = ps.executeQuery();
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String nome = resultSet.getString("nome");
				double valor = resultSet.getInt("valor");
				Date data_dia = resultSet.getDate("data_dia");
				Despesa a = new Despesa();
				a.setId(id);
				a.setNome(nome);
				a.setValor(valor);
				a.setData_dia((java.sql.Date) data_dia);
				despesa.add(a);
			}
			connection.close();
		} catch (Exception e) {
			throw new IllegalArgumentException("Erro ao pegar a lista de Alunos!");
		}
		
		return despesa;
	}
	
	public List<Despesa> getDespesas2(String parametro){
		List<Despesa> despesa = new ArrayList<>();
		try {
			Connection connection = ConnectionFactory.getConnection();
			String sql = "Select * from gasto where nome like '%"+parametro+"%'";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet resultSet = ps.executeQuery();
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String nome = resultSet.getString("nome");
				double valor = resultSet.getInt("valor");
				Date data_dia = resultSet.getDate("data_dia");
				Despesa a = new Despesa();
				a.setId(id);
				a.setNome(nome);
				a.setValor(valor);
				a.setData_dia((java.sql.Date) data_dia);
				despesa.add(a);
			}
			connection.close();
		} catch (Exception e) {
			throw new IllegalArgumentException("Erro ao pegar a lista de Alunos!");
		}
		
		return despesa;
	}
	
	
	public void salvar(Despesa a) {
		Connection connection = ConnectionFactory.getConnection();
		String sql = "insert into despesa.gasto (nome,valor) values (?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, a.getNome());
			ps.setDouble(2, a.getValor());
			ps.executeUpdate();
			ps.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IllegalArgumentException("Erro ao salvar o Aluno!");
		}
	}
	
	public void editar(Despesa a) {
		Connection connection = ConnectionFactory.getConnection();
		String sql = "update despesa.gasto set nome=?,valor=? where id=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(3, a.getId());
			ps.setString(1, a.getNome());
			ps.setDouble(2, a.getValor());
			ps.executeUpdate();
			ps.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IllegalArgumentException("Erro ao salvar o Aluno!");
		}
	}
	
	public void remover(Integer id) {
		Connection connection = ConnectionFactory.getConnection();
		String sql = "delete from despesa.gasto where id=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IllegalArgumentException("Erro ao remover o Aluno!");
		}
	}
}
