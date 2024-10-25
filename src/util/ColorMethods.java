
package util;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JPanel;

public class ColorMethods {
    public static void Entered(JPanel panel){
        panel.setBackground(new Color(227, 34, 167));
        panel.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    
    public static void Entered(JPanel panel, Color color){
        panel.setBackground(color);
        panel.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    
    public static void Exited(JPanel panel){
        panel.setBackground(new Color(189,29,139));
    }
    
    public static void Exited(JPanel panel, Color color){
        panel.setBackground(color);
    }
}
