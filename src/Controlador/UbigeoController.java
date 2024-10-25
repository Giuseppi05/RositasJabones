package Controlador;

import ModeloDAO.DepartamentoDAO;
import ModeloDAO.DistritoDAO;
import ModeloDAO.ProvinciaDAO;
import ModeloDTO.DepartamentoDTO;
import ModeloDTO.DistritoDTO;
import ModeloDTO.ProvinciaDTO;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class UbigeoController {
    static DepartamentoDAO dd = new DepartamentoDAO();
    static ProvinciaDAO pd = new ProvinciaDAO();
    static DistritoDAO disd = new DistritoDAO();
    
    static ArrayList<DepartamentoDTO> listaDepartamentos = new ArrayList<>();
    static ArrayList<ProvinciaDTO> listaProvincias = new ArrayList<>();
    static ArrayList<DistritoDTO> listaDistritos = new ArrayList<>();
    
    public static void mostrarDepartamentos(JComboBox c){
        c.removeAllItems();
        listaDepartamentos = dd.listarTodo();
        for (int i = 0; i < listaDepartamentos.size(); i++) {
            c.addItem(listaDepartamentos.get(i).getNombre());
        }
    }
    
    public static void mostrarProvincias(String Departamento, JComboBox c){
        c.removeAllItems();
        DepartamentoDTO d = dd.listarUnoNom(Departamento);
        listaProvincias = pd.listarPorDepartamento(d.getCodigo());
        for (int i = 0; i < listaProvincias.size(); i++) {
            c.addItem(listaProvincias.get(i).getNombre());
        }
    }
    
    public static void mostrarDistritos(String Provincia, JComboBox c){
        c.removeAllItems();
        ProvinciaDTO p = pd.listarUnoNom(Provincia);
        listaDistritos = disd.listarProvincia(p.getCodigo());
        for (int i = 0; i < listaDistritos.size(); i++) {
            c.addItem(listaDistritos.get(i).getNombre());
        }
    }
}
