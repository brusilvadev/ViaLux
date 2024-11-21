package br.com.vialux.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.vialux.model.Funcionario;

public class FuncionarioDao {
    private Connection conexao;

    public FuncionarioDao() {
        conexao = ConnectionFactory.conectar();
    }

    public void inserir(Funcionario funcionario) {
        String sql = "INSERT INTO funcionarios (nome, departamento, cargo, idade)" + "VALUES (?, ?, ?, ?)";
        PreparedStatement stmt;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getDepartamento());
            stmt.setString(3, funcionario.getCargo());
            stmt.setInt(4, funcionario.getIdade());

            stmt.execute();
            stmt.close();
            conexao.close();

        } catch (Exception e) {
            System.out.println("Deu erro: " + e.getMessage());
        }
    }

    public List<Funcionario> listar() {
        String sql = "SELECT * FROM funcionarios";
        PreparedStatement stmt;
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();

        try {
            stmt = conexao.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Funcionario fu = new Funcionario();
                fu.setId(resultado.getLong("id"));
                fu.setNome(resultado.getString("nome"));
                fu.setDepartamento(resultado.getString("departamento"));
                fu.setCargo(resultado.getString("cargo"));
                fu.setIdade(resultado.getInt("idade"));
                funcionarios.add(fu);
            }

            resultado.close();
            stmt.close();
            conexao.close();
            return funcionarios;

        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar funcionários: " + e.getMessage());
        }
    }

    public Funcionario buscar(Long id) {
        String sql = "SELECT * FROM funcionarios WHERE id = ?";
        PreparedStatement stmt;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet resultado = stmt.executeQuery();
            Funcionario f = null;

            while (resultado.next()) {
                f = new Funcionario();
                f.setId(resultado.getLong("id"));
                f.setNome(resultado.getString("nome"));
                f.setDepartamento(resultado.getString("departamento"));
                f.setCargo(resultado.getString("cargo"));
                f.setIdade(resultado.getInt("idade"));
            }
            stmt.close();
            resultado.close();
            conexao.close();
            return f;

        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar funcionário: " + e.getMessage());
        }
    }

    public void excluir2(Long id) {
        String sql = "DELETE FROM funcionarios WHERE id = ?";
        PreparedStatement stmt;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setLong(1, id);
            stmt.execute();
            stmt.close();
            conexao.close();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao excluir funcionário: " + e.getMessage());
        }     
    }

    public void atualizar(Funcionario funcionario, Long id) {
        String sql = "UPDATE funcionarios SET nome = ?, departamento = ?, cargo = ?, idade = ? WHERE id = ?";
        PreparedStatement stmt;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getDepartamento());
            stmt.setString(3, funcionario.getCargo());
            stmt.setInt(4, funcionario.getIdade());
            stmt.setLong(5, id);

            stmt.executeUpdate();
            stmt.close();
            conexao.close();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar funcionário: " + e.getMessage());
        }
    }
}
