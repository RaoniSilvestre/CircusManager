package br.ufrn.imd.circusmanager.Dao;

import br.ufrn.imd.circusmanager.Model.Circus.Circus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CircoDAO implements GenericDAO<Circus> {
    private final Connection conn;

    public CircoDAO(Connection conn) {
        this.conn = conn;
    }


    @Override
    public void salvar(Circus circus) {
        String sql = "INSERT INTO circo (nome) VALUES (?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, circus.getNome());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    circus.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Circus buscarPorNome(String nome) {

    }

    @Override
    public Circus buscarPorId(int id) {
        String sql = "SELECT * FROM circo WHERE id = ?";
        Circus circo = null;

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    circo = new Circus(rs.getInt("id"), rs.getInt("contaId"), rs.getString("nome"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return circo;
    }

    @Override
    public List<Circus> buscarTodos() {
        List<Circus> circos = new ArrayList<>();
        String sql = "SELECT * FROM circo";

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Circus circo = new Circus(rs.getInt("id"), rs.getInt("contaId"), rs.getString("nome"));
                circos.add(circo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return circos;
    }

    @Override
    public void atualizar(Circus circus) {
        String sql = "UPDATE circo SET nome = ? WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, circus.getNome());
            stmt.setInt(2, circus.getCircoId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deletar(int id) {
        String sql = "DELETE FROM Circo WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
