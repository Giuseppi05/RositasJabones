/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import Interfaces.DistrictInterface;
import ModeloDTO.DepartamentoDTO;
import ModeloDTO.DistritoDTO;
import ModeloDTO.ProvinciaDTO;
import config.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DistritoDAO implements DistrictInterface{
    conexion con = new conexion();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    DistritoDTO dis;
    ProvinciaDTO p;
    DepartamentoDAO dd = new DepartamentoDAO();
    DepartamentoDTO d;
    ProvinciaDAO pd = new ProvinciaDAO();
    
    @Override
    public boolean insertar(DistritoDTO c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizar(DistritoDTO c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(Integer codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public DistritoDTO listarUno(String codigo) {
        DistritoDTO dis = null;
        try {
            String sql = "select * from ubigeo_peru_districts where id = ?";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            while(rs.next()){
                dis = new DistritoDTO();
                dis.setCodigo(rs.getString("id"));
                dis.setNombre(rs.getString("name"));
                p = new ProvinciaDTO();
                p = pd.listarUno(rs.getString("province_id"));
                dis.setProvincia(p);
                d = new DepartamentoDTO();
                d = dd.listarUno(rs.getString("department_id"));
                dis.setDepartamento(d);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DistritoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dis;
    }

    @Override
    public DistritoDTO listarUnoNom(String nom) {
        DistritoDTO dis = null;
        try {
            String sql = "select * from ubigeo_peru_districts where name = ?";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, nom);
            rs = ps.executeQuery();
            while(rs.next()){
                dis = new DistritoDTO();
                dis.setCodigo(rs.getString("id"));
                dis.setNombre(rs.getString("name"));
                p = new ProvinciaDTO();
                p = pd.listarUno(rs.getString("province_id"));
                dis.setProvincia(p);
                d = new DepartamentoDTO();
                d = dd.listarUno(rs.getString("department_id"));
                dis.setDepartamento(d);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DistritoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dis;
    }

    @Override
    public ArrayList<DistritoDTO> listarTodo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public ArrayList<DistritoDTO> listarProvincia(String provincia){
        ArrayList<DistritoDTO> vd = new ArrayList<>();
        try {
            String sql = "select * from ubigeo_peru_districts where province_id = ?";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, provincia);
            rs = ps.executeQuery();
            while(rs.next()){
                dis = new DistritoDTO();
                dis.setCodigo(rs.getString("id"));
                dis.setNombre(rs.getString("name"));
                p = new ProvinciaDTO();
                p = pd.listarUno(rs.getString("province_id"));
                dis.setProvincia(p);
                d = new DepartamentoDTO();
                d = dd.listarUno(rs.getString("department_id"));
                dis.setDepartamento(d);
                vd.add(dis);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DistritoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vd;
    }

    @Override
    public DistritoDTO listarUno(Integer codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
