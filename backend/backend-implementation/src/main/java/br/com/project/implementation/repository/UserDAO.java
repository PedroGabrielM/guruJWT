package br.com.project.implementation.repository;

import br.com.project.domain.UserModel;
import br.com.project.implementation.repository.connection.ConnectionFactory;
import br.com.project.usecases.port.UserRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserDAO implements UserRepository {
    @Override
    public int create(UserModel userModel) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "INSERT INTO usuario(email, senha, tipo, criado_em) ";
        sql += " VALUES(?, ?, ?, ?); ";

        try {
            connection = ConnectionFactory.getConnection();
            connection.setAutoCommit(false);

            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, userModel.getPassword());
            preparedStatement.setString(2, userModel.getEmail());
            preparedStatement.setString(3, UserModel.Type.CLIENT.toString());
            preparedStatement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));

            preparedStatement.execute();

            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                final int id = resultSet.getInt(1);
                userModel.setId(id);
            }

            connection.commit();

            resultSet.close();
            preparedStatement.close();

            return userModel.getId();
        } catch (Exception e) {

            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }

            throw new RuntimeException(e);
        }
    }

    @Override
    public UserModel findById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM usuario WHERE id = ? ;";

        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                final UserModel user = new UserModel();
                user.setId(resultSet.getInt("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("senha"));
                final String type = resultSet.getString("tipo");
                user.setType(UserModel.Type.valueOf(type));

                return user;
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public List<UserModel> findAll() {

        final List<UserModel> users = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        final String sql = "SELECT * FROM usuario;";

        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                final UserModel userModel = new UserModel();
                userModel.setId(resultSet.getInt("id"));
                userModel.setEmail(resultSet.getString("email"));
                userModel.setPassword(resultSet.getString("senha"));

                users.add(userModel);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public List<UserModel> findByCriteria(Map<String, String> criteria) {
        return null;
    }

    @Override
    public boolean update(UserModel userModel) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE usuario SET email = ? ";
        sql += " WHERE id = ? ;";

        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, userModel.getEmail());
            preparedStatement.setInt(2, userModel.getId());

            preparedStatement.execute();

            preparedStatement.close();

            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updatePassword(int id, UserModel userModel) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE usuario SET senha = ? ";
        sql += " WHERE id = ? ;";

        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, userModel.getPassword());
            preparedStatement.setInt(2, id);

            preparedStatement.execute();

            preparedStatement.close();

            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
