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

    public boolean function (User user, List<String> allUsers) {
        String specialCharacters="!#$%&'()*+,-./:;<=>?@[]^_`{|}";
        if (user==null) { // A
            throw new RuntimeException("The user is not instantiated"); // B
        }
        if (user.getUsername()==null || user.getPassword()==null) // C
            throw new RuntimeException("The user is missing some mandatory information"); // D
        String password = user.getPassword();
        String passwordLower = password.toLowerCase();
        if (passwordLower.contains(user.getUsername().toLowerCase())) { // E
            return false; // F
        }
        else if (passwordLower.length()<8) // G
            return false; // H
        else {
            boolean digit = false, upper = false, special = false;

            for (int i=0; // I
                 i<password.length(); // J
                 i++) { // K
                if (Character.isDigit(password.charAt(i))) // L
                    digit = true; // M
                if (Character.isUpperCase(password.charAt(i))) // N
                    upper = true; // O
                if (specialCharacters.contains(String.valueOf(password.charAt(i)))) // P
                    special = true; // Q
            }
            if (!digit || !upper || !special) // R
                return false; // S
        }
        return true; // T
    }
}
