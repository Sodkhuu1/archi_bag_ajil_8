package dao;

import model.User;
import java.sql.*;

public class UserDAO {
    private final Connection conn;

    public UserDAO(Connection conn) {
        this.conn = conn;
    }

    // Хэрэглэгчийг өгөгдлийн санд бүртгэх
    public boolean createUser(User user) throws SQLException {
        String sql = "INSERT INTO users (username, password_hash, email) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPasswordHash());
            stmt.setString(3, user.getEmail());
            return stmt.executeUpdate() == 1;
        }
    }

    // Хэрэглэгчийн нэрээр өгөгдлийн сангаас хайж олох
    public User findUserByUsername(String username) throws SQLException {
        String sql = "SELECT * FROM users WHERE username = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new User(
                        rs.getString("username"),
                        rs.getString("password_hash"),
                        rs.getString("email")
                    );
                }
            }
        }
        return null; // Олдоогүй бол null буцаана
    }
}
