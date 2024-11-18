package ModeloDAO;


import Interfaces.TipoDocumentoInterface;
import ModeloDTO.TipoDocumentoDTO;
import java.util.ArrayList;
import config.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TipoDocumentoDAO implements TipoDocumentoInterface{
    conexion con = new conexion();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    TipoDocumentoDTO td;
    
    
    @Override
    public boolean insertar(TipoDocumentoDTO c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizar(TipoDocumentoDTO c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(Integer codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public TipoDocumentoDTO listarUno(Integer codigo) {
        TipoDocumentoDTO td = null;
        try {
            String sql = "select * from tipodocumento where id = ?";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            while(rs.next()){
                td = new TipoDocumentoDTO();
                td.setCodigo(rs.getInt("id"));
                td.setNombre(rs.getString("nombre"));
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(TipoDocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return td;
    }

    @Override
    public TipoDocumentoDTO listarUnoNom(String nom) {
        TipoDocumentoDTO td = null;
        try {
            String sql = "select * from tipodocumento where nombre = ?";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, nom);
            rs = ps.executeQuery();
            while(rs.next()){
                td = new TipoDocumentoDTO();
                td.setCodigo(rs.getInt("id"));
                td.setNombre(rs.getString("nombre"));
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(TipoDocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return td;
    }

    @Override
    public ArrayList<TipoDocumentoDTO> listarTodo() {
        ArrayList<TipoDocumentoDTO> vc = new ArrayList<>();
        try {
            String sql = "select * from tipodocumento";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                td = new TipoDocumentoDTO();
                td.setCodigo(rs.getInt("id"));
                td.setNombre(rs.getString("nombre"));
                
                vc.add(td);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(TipoDocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vc;
    }
    
}
