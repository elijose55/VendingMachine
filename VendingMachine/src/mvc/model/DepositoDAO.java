package mvc.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DepositoDAO {
	private Connection connection = null;


	public DepositoDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost/vending_machine?useTimezone=true&serverTimezone=UTC", "root", "senha");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void adiciona(Material material) {
		String sql = "INSERT INTO deposito" + "(nome, quantidade, vendas, preco) values(?,?,?,?)";
		PreparedStatement stmt;
		 try {
			 stmt = connection.prepareStatement(sql);
			 stmt.setString(1,material.getNome());
			 stmt.setInt(2, material.getQuantidade());
			 stmt.setInt(3,0);
			 stmt.setInt(4, material.getPreco());
			 //stmt.setDate(3, new Date(tarefa.getDataFinalizacao().getTimeInMillis()));
			 stmt.execute();
			 stmt.close();
		} catch (SQLException e) {e.printStackTrace();}}
	
	public void adicionaSugestao(Material material) {
		String sql = "INSERT INTO sugestao" + "(nome) values(?)";
		PreparedStatement stmt;
		 try {
			 stmt = connection.prepareStatement(sql);
			 stmt.setString(1,material.getNome());
			 stmt.execute();
			 stmt.close();
		} catch (SQLException e) {e.printStackTrace();}}
	
	public List<Material> getListaSugestao() {
		 List<Material> materiais = new ArrayList<Material>();
		 try {PreparedStatement stmt = connection.prepareStatement("SELECT * FROM sugestao");
		 ResultSet rs = stmt.executeQuery();
		 while (rs.next()) {
		 Material material = new Material();
		 material.setId(rs.getLong("id"));
		 material.setNome(rs.getString("nome"));
		 
		 materiais.add(material);
		 }
		 rs.close();
		 stmt.close();
		 } catch(SQLException e) {System.out.println(e);}
		 return materiais;
		 }
	
	public List<Material> getLista() {
		 List<Material> materiais = new ArrayList<Material>();
		 try {PreparedStatement stmt = connection.prepareStatement("SELECT * FROM deposito");
		 ResultSet rs = stmt.executeQuery();
		 while (rs.next()) {
		 Material material = new Material();
		 material.setId(rs.getLong("id"));
		 material.setNome(rs.getString("nome"));
		 material.setQuantidade(rs.getInt("quantidade"));
		 material.setVendas(rs.getInt("vendas"));
		 material.setPreco(rs.getInt("preco"));
		 
		 materiais.add(material);
		 }
		 rs.close();
		 stmt.close();
		 } catch(SQLException e) {System.out.println(e);}
		 return materiais;
		 }
	
	public void altera(Material material) {
		 try {
			 String sql = "UPDATE Deposito SET quantidade=?, vendas=? WHERE id=?";
			 PreparedStatement stmt = connection.prepareStatement(sql);
			 stmt.setInt(1, material.getQuantidade());
			 stmt.setInt(2, material.getVendas());
			 
			 stmt.setLong(3, material.getId());
			 stmt.executeUpdate();
			 stmt.close();
		 } catch(SQLException e) {System.out.println(e);}
		 }
	
	public void remove(Material material) {
		 try {
		 PreparedStatement stmt = connection.prepareStatement("DELETE FROM Deposito WHERE id=?");
		 stmt.setLong(1, material.getId());
		 stmt.execute();
		 stmt.close();
		 } catch(SQLException e) {System.out.println(e);}
		 }
	
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
