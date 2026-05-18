package utils;

import models.Usuario;

public class Sesion {
	
	private static Usuario currentUser;

    public static void login(Usuario usuario) {
        currentUser = usuario;
    }

    public static Usuario getCurrentUser() {
        return currentUser;
    }

    public static void logout() {
        currentUser = null;
    }

    public static boolean isLoggedIn() {
        return currentUser != null;
    }

    public static String getRole() {
        return currentUser.getRol();
    }

}
