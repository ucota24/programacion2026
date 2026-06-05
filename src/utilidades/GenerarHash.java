package utilidades;

public class GenerarHash {
	
	 public static void main(String[] args) {
	        String hash = utilidades.PasswordUtils.hashPassword("12345678");
	        System.out.println(hash);
	    }

}
