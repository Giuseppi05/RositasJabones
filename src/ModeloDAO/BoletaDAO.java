package ModeloDAO;

import Interfaces.BoletaInterface;
import ModeloDTO.BoletaDTO;
import ModeloDTO.ClienteDTO;
import ModeloDTO.UsuarioDTO;
import config.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Timestamp;

public class BoletaDAO implements BoletaInterface{
    conexion con = new conexion();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    
    BoletaDTO b;
    
    ClienteDTO c;
    ClienteDAO cd = new ClienteDAO();
    
    UsuarioDTO u;
    UsuarioDAO ud = new UsuarioDAO();

    @Override
    public boolean insertar(BoletaDTO b) {
        try {
            String sql = "INSERT INTO boleta (idcli, tolbol, fecbol, idusu) VALUES (?, ?, ?, ?)";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, b.getCliente().getCodigo());
            ps.setFloat(2, b.getTotal());
            ps.setTimestamp(3, Timestamp.valueOf(b.getFecha()));
            ps.setInt(4, b.getUsuario().getCodigo());
            ps.executeUpdate();
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BoletaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public String obtenerUltimoIdBol() {
        String idBol = null;
        String sql = "SELECT idbol FROM boleta ORDER BY idbol DESC LIMIT 1"; 

        try {
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                idBol = rs.getString("idbol"); 
            }

            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(BoletaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return idBol;
    }


    @Override
    public boolean actualizar(BoletaDTO c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(Integer codigo) {
        try {
            String sql = "delete from boleta where idbol = ?";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql); 
            ps.setInt(1, codigo);
            ps.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(BoletaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean eliminar(String codigo) {
        try {
            String sql = "delete from boleta where idbol = ?";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql); 
            ps.setString(1, codigo);
            ps.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(BoletaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    @Override
    public BoletaDTO listarUno(Integer codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public BoletaDTO listarUno(String codigo) {
        BoletaDTO b = null;
        try {
            String sql = "select * from boleta where idbol = ?";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            while(rs.next()){
                b = new BoletaDTO();
                b.setCodigo(rs.getString("idbol"));
                b.setFecha(rs.getTimestamp("fecbol").toLocalDateTime());
                b.setTotal(rs.getFloat("tolbol"));
                
                c = new ClienteDTO();
                c = cd.listarUno(rs.getInt("idcli"));
                b.setCliente(c);
                
                u = new UsuarioDTO();
                u = ud.listarUno(rs.getInt("idusu"));
                b.setUsuario(u);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
    }

    @Override
    public BoletaDTO listarUnoNom(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<BoletaDTO> listarTodo() {
         ArrayList<BoletaDTO> vb = new ArrayList<>();
        try {
            String sql = "select * from boleta";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                b = new BoletaDTO();
                b.setCodigo(rs.getString("idbol"));
                b.setFecha(rs.getTimestamp("fecbol").toLocalDateTime());
                b.setTotal(rs.getFloat("tolbol"));
                
                c = new ClienteDTO();
                c = cd.listarUno(rs.getInt("idcli"));
                b.setCliente(c);
                
                u = new UsuarioDTO();
                u = ud.listarUno(rs.getInt("idusu"));
                b.setUsuario(u);
                
                vb.add(b);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vb;
    }
}
