import dao.UserDAO;
import model.User;
import service.AuthService;
import util.DBConnection;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Connection conn = DBConnection.getConnection();
            UserDAO userDAO = new UserDAO(conn);
            AuthService authService = new AuthService(userDAO);

            Scanner scanner = new Scanner(System.in);

            System.out.println("=== Онлайн Эмнэлэг Систем ===");
            System.out.println("1. Бүртгүүлэх");
            System.out.println("2. Нэвтрэх");
            System.out.print("Сонголтоо оруулна уу: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Шулуун мөр унших

            if (choice == 1) {
                System.out.print("Хэрэглэгчийн нэр: ");
                String username = scanner.nextLine();
                System.out.print("И-мэйл: ");
                String email = scanner.nextLine();
                System.out.print("Нууц үг: ");
                String password = scanner.nextLine();

                boolean signupSuccess = authService.signup(username, password, email);
                if (signupSuccess) {
                    System.out.println("Амжилттай бүртгэгдлээ!");
                } else {
                    System.out.println("Бүртгэл амжилтгүй боллоо! Хэрэглэгчийн нэр давхардаж байна.");
                }

            } else if (choice == 2) {
                System.out.print("Хэрэглэгчийн нэр: ");
                String username = scanner.nextLine();
                System.out.print("Нууц үг: ");
                String password = scanner.nextLine();

                boolean loginSuccess = authService.login(username, password);
                if (loginSuccess) {
                    System.out.println("Амжилттай нэвтэрлээ!");
                } else {
                    System.out.println("Нэвтрэхэд алдаа гарлаа. Нууц үг эсвэл нэр буруу байна.");
                }

            } else {
                System.out.println("Буруу сонголт.");
            }

            conn.close();
            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
