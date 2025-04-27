package model;
// User.java
// Энэ класс нь хэрэглэгчийн өгөгдлийг хадгалах зориулалттай.

public class User {
    private int id; // Хэрэглэгчийн ID
    private String username; // Хэрэглэгчийн нэр
    private String passwordHash; // Шифрлэсэн нууц үг
    private String email; // Хэрэглэгчийн имэйл

    // Constructor
    public User(String username, String passwordHash, String email) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.email = email;
    }

    // Getter, Setter функцууд
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
