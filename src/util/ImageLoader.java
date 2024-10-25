package util;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;

public class ImageLoader {
    public static void setImageToLabelFromResources(JLabel label, String resourcePath) {
        URL resourceUrl = ImageLoader.class.getResource(resourcePath);
        if (resourceUrl != null) {
            try {
                BufferedImage img = ImageIO.read(resourceUrl);
                if (img != null) {
                    Image scaledImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon icon = new ImageIcon(scaledImg);
                    label.setIcon(icon);
                    return;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } 
    }

    public static void listResources(String path) {
        try {
            URL resourceUrl = ImageLoader.class.getResource(path);
            if (resourceUrl != null) {
                System.out.println("Contenido del directorio " + path + ":");
                // Aquí podrías listar el contenido si es un directorio,
                // pero esto requiere acceso al sistema de archivos que puede no estar disponible
                System.out.println("  " + resourceUrl);
            } else {
                System.out.println("No se pudo acceder al directorio: " + path);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}