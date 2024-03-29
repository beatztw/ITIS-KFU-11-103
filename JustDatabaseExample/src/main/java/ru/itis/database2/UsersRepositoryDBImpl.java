package ru.itis.database2;

import ru.itis.database3.CrudRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// DATA ACCESS OBJECT
public class UsersRepositoryDBImpl implements UsersRepository {

    private final Connection connection;

    private final static String SQL_SELECT_ALL = "select * from users;";
    private final static String SQL_INSERT = "insert into users (first_name, last_name, course_name, age) VALUES (?, ?, ?, ?);";
    private final static String SQL_SELECT_BY_ID = "select * from users where id = ?;";
    private final static String SQL_UPDATE = "UPDATE users SET first_name=?, last_name=?, course_name= ?, age=? WHERE id=?";
    private final static String SQL_DELETE_BY_ID = "DELETE FROM users WHERE id = ?;";

    public UsersRepositoryDBImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<User> findById(Integer id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next() == false) {
                return Optional.empty();
            }

            User user = User.builder()
                    .id(resultSet.getInt("id"))
                    .firstName(resultSet.getString("first_name"))
                    .lastName(resultSet.getString("last_name"))
                    .courseName(resultSet.getString("course_name"))
                    .age(resultSet.getInt("age"))
                    .build();
            return Optional.of(user);
        } catch (SQLException throwable) {
            System.out.println("SQL Exception: " + throwable.getLocalizedMessage());
        }

        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<User> result = new ArrayList<>();
            while(resultSet.next()) {
                User user = User.builder()
                        .id(resultSet.getInt("id"))
                        .firstName(resultSet.getString("first_name"))
                        .lastName(resultSet.getString("last_name"))
                        .courseName(resultSet.getString("course_name"))
                        .age(resultSet.getInt("age"))
                        .build();
                result.add(user);
            }
            return result;
        } catch (SQLException throwable) {
            System.out.println("SQL Exception: " + throwable.getLocalizedMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public User save(User item) throws SQLException {
        if (item.getId() == null) {
            try {
                PreparedStatement statement = connection.prepareStatement(
                        SQL_INSERT, new String[]{"id"}
                );
                statement.setString(1, item.getFirstName());
                statement.setString(2, item.getLastName());
                statement.setInt(3, item.getAge());

                int affectedRows = statement.executeUpdate();
                System.out.println(affectedRows + " rows affected");
                ResultSet generatedKeys = statement.getGeneratedKeys();
                generatedKeys.next();
                item.setId(generatedKeys.getInt(1));
                return item;
            } catch (SQLException throwable) {
                System.out.println("SQL Exception: " + throwable.getLocalizedMessage());
            }
            return item;
        } else {
            // TODO: - реализовать обновление
            PreparedStatement statement = connection.prepareStatement(
                    SQL_UPDATE, new String[]{"id"}
            );
            {

                statement.setString(1, item.getFirstName());
                statement.setString(2, item.getLastName());
                statement.setInt(3,item.getAge());
                statement.setString(4, item.getCourseName());

                int affectedRows = statement.executeUpdate();
                if (affectedRows != 1) {
                    throw new SQLException("Не удалось обновить пользователя");
                }
            return null;
        }
    }
}
    @Override
    public void delete(Integer id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                SQL_DELETE_BY_ID, new String[]{"id"}
        );
        {
            statement.setLong(1, id);

            int affectedRows = statement.executeUpdate();
            if (affectedRows != 1) {
                throw new SQLException("Не удалось удалить пользователя");
            }
        }
    }
}
