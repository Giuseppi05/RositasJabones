/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import Interfaces.ProvinciaInterface;
import ModeloDTO.DepartamentoDTO;
import ModeloDTO.ProvinciaDTO;
import config.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProvinciaDAO implements ProvinciaInterface{
    conexion con = new conexion();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    ProvinciaDTO p;
    DepartamentoDAO dd = new DepartamentoDAO();
    DepartamentoDTO d;
    
    @Override
    public boolean insertar(ProvinciaDTO c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizar(ProvinciaDTO c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(Integer codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ProvinciaDTO listarUno(String codigo) {
        ProvinciaDTO p = null;
        try {
            String sql = "select * from ubigeo_peru_provinces where id = ?";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            while(rs.next()){
                p = new ProvinciaDTO();
                p.setCodigo(rs.getString("id"));
                p.setNombre(rs.getString("name"));
                d = new DepartamentoDTO();
                d = dd.listarUno(rs.getString("department_id"));
                p.setDepartamento(d);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public ProvinciaDTO listarUnoNom(String nom) {
        ProvinciaDTO p = null;
        try {
            String sql = "select * from ubigeo_peru_provinces where name = ?";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, nom);
            rs = ps.executeQuery();
            while(rs.next()){
                p = new ProvinciaDTO();
                p.setCodigo(rs.getString("id"));
                p.setNombre(rs.getString("name"));
                d = new DepartamentoDTO();
                d = dd.listarUno(rs.getString("department_id"));
                p.setDepartamento(d);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public ArrayList<ProvinciaDTO> listarTodo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public ArrayList<ProvinciaDTO> listarPorDepartamento(String nombre) {
        ArrayList<ProvinciaDTO> vp = new ArrayList<>();
        try {
            String sql = "select * from ubigeo_peru_provinces where department_id = ?";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            while(rs.next()){
                p = new ProvinciaDTO();
                p.setCodigo(rs.getString("id"));
                p.setNombre(rs.getString("name"));
                d = new DepartamentoDTO();
                d = dd.listarUno(rs.getString("department_id"));
                vp.add(p);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProvinciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vp;
    }

    @Override
    public ProvinciaDTO listarUno(Integer codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
