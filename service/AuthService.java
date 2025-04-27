package service;

import dao.UserDAO;
import model.User;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.SQLException;

public class AuthService {
    private final UserDAO userDAO;

    public AuthService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    // Хэрэглэгчийг бүртгэх функц
    public boolean signup(String username, String password, String email) throws SQLException {
        // Хэрэглэгчийн нэр давхардахыг шалгана
        if (userDAO.findUserByUsername(username) != null) {
            return false; // Хэрэв өмнө нь бүртгүүлсэн бол
        }
        // Нууц үгийг BCrypt ашиглан шифрлэнэ
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
        User user = new User(username, hashed, email);
        return userDAO.createUser(user);
    }

    // Хэрэглэгч нэвтрэх функц
    public boolean login(String username, String password) throws SQLException {
        User user = userDAO.findUserByUsername(username);
        if (user == null) {
            return false; // Олдоогүй бол
        }
        // Хэрэглэгчийн нууц үг зөв эсэхийг шалгана
        return BCrypt.checkpw(password, user.getPasswordHash());
    }
}
