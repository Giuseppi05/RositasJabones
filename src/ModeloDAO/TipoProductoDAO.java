/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import Interfaces.TipoProductoInterface;
import ModeloDTO.TipoProductoDTO;
import config.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TipoProductoDAO implements TipoProductoInterface{
    conexion con = new conexion();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    TipoProductoDTO tp;
    
    @Override
    public boolean insertar(TipoProductoDTO c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizar(TipoProductoDTO c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(Integer codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public TipoProductoDTO listarUno(Integer codigo) {
        TipoProductoDTO td = null;
        try {
            String sql = "select * from tipoproducto where id = ?";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            while(rs.next()){
                td = new TipoProductoDTO();
                td.setCodigo(rs.getInt("id"));
                td.setNombre(rs.getString("nombre"));
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(TipoProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return td;
    }

    @Override
    public TipoProductoDTO listarUnoNom(String nom) {
        TipoProductoDTO td = null;
        try {
            String sql = "select * from tipoproducto where nombre = ?";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, nom);
            rs = ps.executeQuery();
            while(rs.next()){
                td = new TipoProductoDTO();
                td.setCodigo(rs.getInt("id"));
                td.setNombre(rs.getString("nombre"));
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(TipoProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return td;
    }

    @Override
    public ArrayList<TipoProductoDTO> listarTodo() {
        ArrayList<TipoProductoDTO> vc = new ArrayList<>();
        try {
            String sql = "select * from tipoproducto";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                tp = new TipoProductoDTO();
                tp.setCodigo(rs.getInt("id"));
                tp.setNombre(rs.getString("nombre"));
                
                vc.add(tp);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(TipoProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vc;
    }
    
}
