
package ModeloDAO;

import Interfaces.RolInterface;
import ModeloDTO.RolDTO;
import config.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RolDAO implements RolInterface{
    conexion con = new conexion();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    RolDTO r;
    
    @Override
    public boolean insertar(RolDTO r) {
        try {
            String sql = "insert into rol (nomrol) values (?)";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, r.getNombre());
            ps.executeUpdate();
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean actualizar(RolDTO r) {
        try {
            String sql = "update rol set nomrol=? where idrol = "+r.getCodigo();
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, r.getNombre());
            ps.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean eliminar(Integer codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public RolDTO listarUno(Integer codigo) {
        RolDTO r = null;
        try {
            String sql = "select * from rol where idrol = ?";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            while(rs.next()){
                r = new RolDTO();
                r.setCodigo(rs.getInt("idrol"));
                r.setNombre(rs.getString("nomrol"));
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    @Override
    public RolDTO listarUnoNom(String nom) {
        RolDTO r = null;
        try {
            String sql = "select * from rol where nomrol = ?";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, nom);
            rs = ps.executeQuery();
            while(rs.next()){
                r = new RolDTO();
                r.setCodigo(rs.getInt("idrol"));
                r.setNombre(rs.getString("nomrol"));
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    @Override
    public ArrayList<RolDTO> listarTodo() {
        ArrayList<RolDTO> vr = new ArrayList<>();
        try {
            String sql = "select * from rol";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                r = new RolDTO();
                r.setCodigo(rs.getInt("idrol"));
                r.setNombre(rs.getString("nomrol"));
                vr.add(r);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vr;
    }
  
}