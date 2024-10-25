package ModeloDAO;

import Interfaces.ProductoInterface;
import ModeloDTO.ProductoDTO;
import config.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductoDAO implements ProductoInterface{
    conexion con = new conexion();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    ProductoDTO p;
    
    @Override
    public boolean insertar(ProductoDTO p) {
        try {
            String sql = "insert into producto (nompro, stkpro, prepro, vtopro) values (?, ?, ?, ?)";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setInt(2, p.getStock());
            ps.setFloat(3, p.getPrecio());
            
            if (p.getVencimiento() != null) {
                ps.setDate(4, new java.sql.Date(p.getVencimiento().getTime()));
            } else {
                ps.setNull(4, java.sql.Types.DATE);
            }
            ps.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean actualizar(ProductoDTO p) {
        try {
            String sql = "update producto set nompro=?, stkpro=?, prepro=?, vtopro=? where idpro = "+p.getCodigo();
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setInt(2, p.getStock());
            ps.setFloat(3, p.getPrecio());
            if (p.getVencimiento() != null) {
                ps.setDate(4, new java.sql.Date(p.getVencimiento().getTime()));
            } else {
                ps.setNull(4, java.sql.Types.DATE);
            }
            ps.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean eliminar(Integer codigo) {
        try {
            String sql = "delete from producto where idpro = ?";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql); 
            ps.setInt(1, codigo);
            ps.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ProductoDTO listarUno(Integer codigo) {
        ProductoDTO p = null;
        try {
            String sql = "select * from producto where idpro = ?";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            while(rs.next()){
                p = new ProductoDTO();
                p.setCodigo(rs.getInt("idpro"));
                p.setNombre(rs.getString("nompro"));
                p.setStock(rs.getInt("stkpro"));
                p.setPrecio(rs.getFloat("prepro"));
                p.setVencimiento(rs.getDate("vtopro"));
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public ProductoDTO listarUnoNom(String nom) {
        ProductoDTO p = null;
        try {
            String sql = "select * from producto where nompro = ?";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, nom);
            rs = ps.executeQuery();
            while(rs.next()){
                p = new ProductoDTO();
                p.setCodigo(rs.getInt("idpro"));
                p.setNombre(rs.getString("nompro"));
                p.setStock(rs.getInt("stkpro"));
                p.setPrecio(rs.getFloat("prepro"));
                p.setVencimiento(rs.getDate("vtopro"));
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public ArrayList<ProductoDTO> listarTodo() {
        ArrayList<ProductoDTO> vp = new ArrayList<>();
        try {
            String sql = "select * from producto";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                p = new ProductoDTO();
                p.setCodigo(rs.getInt("idpro"));
                p.setNombre(rs.getString("nompro"));
                p.setStock(rs.getInt("stkpro"));
                p.setPrecio(rs.getFloat("prepro"));
                p.setVencimiento(rs.getDate("vtopro"));
                vp.add(p);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vp;
    }
    
}
