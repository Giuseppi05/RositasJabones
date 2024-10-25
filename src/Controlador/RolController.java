/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import ModeloDAO.RolDAO;
import ModeloDTO.RolDTO;
import ModeloDTO.UsuarioDTO;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class RolController {
    static RolDAO rd = new RolDAO();
    static ArrayList<RolDTO> listaRoles = new ArrayList<>();
    
    public static void mostrarRoles(JComboBox c){
        c.removeAllItems();
        
        listaRoles = rd.listarTodo();
        
        for (int i = 0; i < listaRoles.size(); i++) {
            c.addItem(listaRoles.get(i).getNombre());
        }
    }
    
    public static void SeleccionarRolEnCbx(JComboBox c, UsuarioDTO u){
        for(RolDTO rol : listaRoles){
            if(rol.getNombre().equals(u.getRol().getNombre())){
                c.setSelectedItem(rol.getNombre());
                break;
            }
        }
    }
}
