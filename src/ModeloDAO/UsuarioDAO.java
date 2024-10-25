
package ModeloDAO;

import Interfaces.UsuarioInterface;
import ModeloDTO.RolDTO;
import ModeloDTO.UsuarioDTO;
import config.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO implements UsuarioInterface{
    conexion con = new conexion();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    UsuarioDTO u;
    RolDAO rd = new RolDAO();
    RolDTO r;
    
    @Override
    public boolean insertar(UsuarioDTO u) {
        try {
            String sql = "insert into usuario (nomusu, idrol, mailusu, passusu) values (?, ?, ?, ?)";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, u.getNombre());
            ps.setInt(2, u.getRol().getCodigo());
            ps.setString(3, u.getCorreo());
            ps.setString(4, u.getContraseña());
            ps.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean actualizar(UsuarioDTO u) {
        try {
            String sql = "update usuario set nomusu=?, idrol=?, mailusu=?, passusu=? where idusu = "+u.getCodigo();
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, u.getNombre());
            ps.setInt(2, u.getRol().getCodigo());
            ps.setString(3, u.getCorreo());
            ps.setString(4, u.getContraseña());
            ps.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean eliminar(Integer codigo) {
        try {
            String sql = "delete from usuario where idusu = ?";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql); 
            ps.setInt(1, codigo);
            ps.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public UsuarioDTO listarUno(Integer codigo) {
        UsuarioDTO u = null;
        try {
            String sql = "select * from usuario where idusu = ?";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            while(rs.next()){
                u = new UsuarioDTO();
                u.setCodigo(rs.getInt("idusu"));
                r = new RolDTO();
                r = rd.listarUno(rs.getInt("idrol"));
                u.setRol(r);
                u.setNombre(rs.getString("nomusu"));
                u.setCorreo(rs.getString("mailusu"));
                u.setContraseña(rs.getString("passusu"));
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }

    @Override
    public UsuarioDTO listarUnoNom(String nom) {
        UsuarioDTO u = null;
        try {
            String sql = "select * from usuario where nomusu = ?";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, nom);
            rs = ps.executeQuery();
            while(rs.next()){
                u = new UsuarioDTO();
                u.setCodigo(rs.getInt("idusu"));
                r = new RolDTO();
                r = rd.listarUno(rs.getInt("idrol"));
                u.setRol(r);
                u.setNombre(rs.getString("nomusu"));
                u.setCorreo(rs.getString("mailusu"));
                u.setContraseña(rs.getString("passusu"));
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }

    @Override
    public ArrayList<UsuarioDTO> listarTodo() {
        ArrayList<UsuarioDTO> vu = new ArrayList<>();
        try {
            String sql = "select * from usuario";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                u = new UsuarioDTO();
                u.setCodigo(rs.getInt("idusu"));
                r = new RolDTO();
                r = rd.listarUno(rs.getInt("idrol"));
                u.setRol(r);
                u.setNombre(rs.getString("nomusu"));
                u.setCorreo(rs.getString("mailusu"));
                u.setContraseña(rs.getString("passusu"));
                vu.add(u);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vu;
    }
    
}
