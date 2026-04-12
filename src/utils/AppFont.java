package utils;

import java.awt.Font;

public class AppFont {

    public static Font normal() {
        return new Font("Segoe UI", Font.PLAIN, 16);
    }

    public static Font titulo() {
        return new Font("Segoe UI", Font.BOLD, 20);
    }

    public static Font pequeno() {
        return new Font("Arial", Font.PLAIN, 12);
    }

    public static Font pequenoItalica() {
        return new Font("Arial", Font.PLAIN + Font.ITALIC, 12);
    }

    public static Font etiqueta() {
        return new Font("Segoe UI", Font.PLAIN, 18);
    }
}