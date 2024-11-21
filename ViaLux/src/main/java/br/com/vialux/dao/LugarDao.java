package br.com.vialux.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import br.com.vialux.model.Lugar;

public class LugarDao {
	private Connection conexao;
	
	public LugarDao() {
		conexao = ConnectionFactory.conectar();
	}
	
	
	public void inserir(Lugar lugar) {
	String sql = "INSERT INTO lugares (nome, descricao, preco, pais, idioma, moeda)" + "VALUES (?, ?, ?, ?, ?, ?)";
	PreparedStatement smtp; // Camada a mais de segurança
	try {
		smtp = conexao.prepareStatement(sql);
		
		smtp.setString(1, lugar.getNome());
		smtp.setString(2, lugar.getDescricao());
		smtp.setDouble(3, lugar.getPreco());
		smtp.setString(4, lugar.getPais());
		smtp.setString(5, lugar.getIdioma());
		smtp.setString(6, lugar.getMoeda());
		
		smtp.execute();
		smtp.close();
		conexao.close();
		
		
	} catch (Exception e) {
		System.out.println("Deu erro: " + e.getMessage());
	}
	}
	
	
	public List<Lugar> listar(){
		String sql = "SELECT * FROM lugares";
		PreparedStatement smtp;
		List<Lugar> lugares = new ArrayList<Lugar>();
		
		try {
			smtp = conexao.prepareStatement(sql);
			ResultSet resultado = smtp.executeQuery();
			while (resultado.next()) {
				Lugar lu = new Lugar();
				
				lu.setId(resultado.getLong("id"));
				lu.setNome(resultado.getString("nome"));
				lu.setPreco(resultado.getDouble("preco"));
				lu.setDescricao(resultado.getString("descricao"));
				lu.setPais(resultado.getString("pais"));
				lu.setIdioma(resultado.getString("idioma"));
				lu.setMoeda(resultado.getString("moeda"));
				lugares.add(lu);
			}
			resultado.close();
			smtp.close();
			conexao.close();
			return lugares;
					
		} catch (Exception e) {
			throw new RuntimeException();
		}
		
	}
	
	public Lugar buscar(Long id) {
		String sql = "SELECT * FROM lugares WHERE id = ?";
		PreparedStatement smtp;
		try {
			smtp = conexao.prepareStatement(sql);
			smtp.setLong(1, id);
			ResultSet resultado = smtp.executeQuery();
			Lugar l = null;
			
			while (resultado.next()) {
				l = new Lugar();
				l.setId(resultado.getLong("id"));
				l.setNome(resultado.getString("nome"));
				l.setPreco(resultado.getDouble("preco"));
				l.setDescricao(resultado.getString("descricao"));
				l.setPais(resultado.getString("pais"));
				l.setIdioma(resultado.getString("idioma"));
				l.setMoeda(resultado.getString("moeda"));
			}
			smtp.close();
			resultado.close();
			conexao.close();
			return l;
			
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	public void excluir(Long id) {
		String sql = "DELETE FROM lugares WHERE id = ?";
		PreparedStatement smtp;
		try {
			smtp = conexao.prepareStatement(sql);
			smtp.setLong(1, id);
			smtp.execute();
			smtp.close();
			conexao.close();
			
		} catch (Exception e) {
			throw new RuntimeException();
		}
	
	}
	
	public void atualizar(Lugar lugar, Long id) {
		String sql = "UPDATE lugares SET nome = ?, descricao = ?, preco = ?, pais = ?, idioma = ?, moeda = ? WHERE id = ?"; 
		PreparedStatement smtp;
		
		
		try {
			smtp = conexao.prepareStatement(sql);
			smtp.setString(1, lugar.getNome());
			smtp.setString(2, lugar.getDescricao());
			smtp.setDouble(3, lugar.getPreco());
			smtp.setString(4, lugar.getPais());
			smtp.setString(5, lugar.getIdioma());
			smtp.setString(6, lugar.getMoeda());
			smtp.setLong(7, id);
			
			smtp.execute();
			smtp.close();
			conexao.close();
			
			
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	
	
	
}
