package util;

import Vistas.Login;
import config.UserSession;
import java.awt.Component;
import javax.swing.*;
import java.awt.event.*;

public class InactividadUtil {

    private static Timer timerInactividad;
    private static final int TIEMPO_INACTIVIDAD = 300000; 

    public static void activarTemporizador(JFrame frame) {
        if (timerInactividad != null) {
            timerInactividad.stop();
        }

        timerInactividad = new Timer(TIEMPO_INACTIVIDAD, e -> cerrarVentana(frame));
        timerInactividad.setRepeats(false);
        
        agregarListeners(frame);

        timerInactividad.start();
    }
    
    public static void detenerTemporizador() {
        if (timerInactividad != null) {
            timerInactividad.stop();
            timerInactividad = null;
        }
    }

    // Método para cerrar la ventana
    private static void cerrarVentana(JFrame frame) {
        JOptionPane.showMessageDialog(frame, "Cerrando por inactividad...");
        UserSession session = new UserSession();

        // Guardar la referencia del último JFrame antes de ocultarlo
        session.setLastFrame(frame);
        frame.setVisible(false);

        // Abrir la ventana de Login
        Login loginWindow = new Login();
        loginWindow.setVisible(true);
    }


    // Método para reiniciar el temporizador
    private static void reiniciarTemporizador() {
        if (timerInactividad != null && timerInactividad.isRunning()) {
            timerInactividad.restart();
        }
    }

    // Agregar listeners a la ventana para detectar interacción
    private static void agregarListeners(JFrame frame) {
        // Listener para clics del mouse
        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                reiniciarTemporizador();
            }
        });

        // Listener para movimiento del mouse
        frame.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                reiniciarTemporizador();
            }
        });

        // Listener para teclas presionadas
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                reiniciarTemporizador();
            }
        });

        // Listener global para componentes dentro del JFrame
        for (Component component : frame.getContentPane().getComponents()) {
            agregarListenersComponentes(component);
        }
    }

    // Método para agregar listeners a componentes internos
    private static void agregarListenersComponentes(Component component) {
        // Listener para clics del mouse en componentes internos
        component.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                reiniciarTemporizador();
            }
        });

        // Listener para movimiento del mouse en componentes internos
        component.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                reiniciarTemporizador();
            }
        });

        // Listener para teclas presionadas en componentes internos
        if (component instanceof JComponent) {
            ((JComponent) component).addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    reiniciarTemporizador();
                }
            });
        }
    }
}
