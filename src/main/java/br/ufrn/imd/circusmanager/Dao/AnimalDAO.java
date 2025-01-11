package br.ufrn.imd.circusmanager.Dao;

import br.ufrn.imd.circusmanager.Model.Animais.Animal;
import br.ufrn.imd.circusmanager.Model.Animais.AnimalEnum;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalDAO implements GenericDAO<Animal> {
    private final Connection connection;

    public AnimalDAO() {
        this.connection = DatabaseConnection.connect();
    }

    @Override
    public void salvar(Animal animal) {
        String sql = "INSERT INTO Animal (id, nome, valor_manutencao, tipo) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, animal.getId());
            stmt.setString(2, animal.getNome());
            stmt.setDouble(3, animal.getValorManutencao());
            stmt.setString(4, animal.getTipo().toString());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    animal.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar o animal: " + e.getMessage(), e);
        }
    }

    @Override
    public Animal buscarPorId(int id) {
        String sql = "SELECT * FROM Animal WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return construirAnimal(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar o animal por ID: " + e.getMessage(), e);
        }
        return null;
    }

    @Override
    public List<Animal> buscarTodos() {
        String sql = "SELECT * FROM Animal";
        List<Animal> animais = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                animais.add(construirAnimal(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar todos os animais: " + e.getMessage(), e);
        }
        return animais;
    }

    @Override
    public void atualizar(Animal animal) {
        String sql = "UPDATE Animal SET nome = ?, valor_manutencao = ?, tipo = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, animal.getNome());
            stmt.setDouble(2, animal.getValorManutencao());
            stmt.setString(3, animal.getTipo().name());
            stmt.setInt(4, animal.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar o animal: " + e.getMessage(), e);
        }
    }

    @Override
    public void deletar(int id) {
        String sql = "DELETE FROM Animal WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar o animal: " + e.getMessage(), e);
        }
    }

    private Animal construirAnimal(ResultSet rs) throws SQLException {
        return new Animal(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getDouble("valor_manutencao"),
                AnimalEnum.valueOf(rs.getString("tipo"))
        );
    }
}
