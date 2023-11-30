package br.com.project.implementation.repository;

import br.com.project.domain.UserModel;
import br.com.project.implementation.repository.connection.ConnectionFactory;
import br.com.project.usecases.port.LoginRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO implements LoginRepository {
    @Override
    public UserModel login(String email, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM usuario ";
        sql += " WHERE ";
        sql += " email = ? AND senha = ? ;";

        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            resultSet = preparedStatement.executeQuery();

            final UserModel userModel;
            if (resultSet.next()) {
                userModel = new UserModel();
                userModel.setId(resultSet.getInt("id"));
                userModel.setEmail(resultSet.getString("email"));
            } else {
                userModel = null;
            }

            resultSet.close();
            preparedStatement.close();

            return userModel;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
