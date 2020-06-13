import java.util.List;

class User {
    String username;
    String password;
    String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}

public class SILab2 {

    public boolean function(User user, List<String> allUsers) {
        String specialCharacters = "!#$%&'()*+,-./:;<=>?@[]^_`{|}";
        if (user == null) { // 1
            throw new RuntimeException("The user is not instantiated"); // 2
        }
        if (user.getUsername() == null || user.getPassword() == null) // 3
            throw new RuntimeException("The user is missing some mandatory information"); // 4
        String password = user.getPassword();
        String passwordLower = password.toLowerCase();
        if (passwordLower.contains(user.getUsername().toLowerCase())) { // 5
            return false; // 6
        } else if (passwordLower.length() < 8) // 7
            return false; // 8
        else {
            boolean digit = false, upper = false, special = false;

            for (int i = 0; // 9.1
                 i < password.length(); // 9.2
                 i++) { // 9.3
                if (Character.isDigit(password.charAt(i))) // 10
                    digit = true; // 11
                if (Character.isUpperCase(password.charAt(i))) // 12
                    upper = true; // 13
                if (specialCharacters.contains(String.valueOf(password.charAt(i)))) // 14
                    special = true; // 15
            } // 16
            if (!digit || !upper || !special) // 17
                return false; // 18
        }
        return true; // 19
    } // 20
}
