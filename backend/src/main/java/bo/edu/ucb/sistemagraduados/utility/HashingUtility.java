package bo.edu.ucb.sistemagraduados.utility;

import org.mindrot.jbcrypt.BCrypt;

public class HashingUtility {
    //Constructor
    public HashingUtility() {
    }
    // Función para hashear una cadena con salt
    public String hashPassword(String password) {
        String salt = BCrypt.gensalt();
        String hashedPassword = BCrypt.hashpw(password, salt);
        return hashedPassword;
    }

    // Función para comparar si dos hashes corresponden
    public boolean checkPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
}
