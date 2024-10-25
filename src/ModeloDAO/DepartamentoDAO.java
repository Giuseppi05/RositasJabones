/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import Interfaces.DepartamentoInterface;
import ModeloDTO.DepartamentoDTO;
import config.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DepartamentoDAO implements DepartamentoInterface{
    conexion con = new conexion();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    DepartamentoDTO d;

    @Override
    public boolean insertar(DepartamentoDTO c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizar(DepartamentoDTO c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(Integer codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public DepartamentoDTO listarUno(String codigo) {
        DepartamentoDTO d = null;
        try {
            String sql = "select * from ubigeo_peru_departments where id = ?";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            while(rs.next()){
                d = new DepartamentoDTO();
                d.setCodigo(rs.getString("id"));
                d.setNombre(rs.getString("name"));
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }

    @Override
    public DepartamentoDTO listarUnoNom(String nom) {
       DepartamentoDTO d = null;
        try {
            String sql = "select * from ubigeo_peru_departments where name = ?";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, nom);
            rs = ps.executeQuery();
            while(rs.next()){
                d = new DepartamentoDTO();
                d.setCodigo(rs.getString("id"));
                d.setNombre(rs.getString("name"));
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }

    @Override
    public ArrayList<DepartamentoDTO> listarTodo() {
        ArrayList<DepartamentoDTO> vd = new ArrayList<>();
        try {
            String sql = "select * from ubigeo_peru_departments";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                d = new DepartamentoDTO();
                d.setCodigo(rs.getString("id"));
                d.setNombre(rs.getString("name"));
                vd.add(d);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vd;
    }

    @Override
    public DepartamentoDTO listarUno(Integer codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
