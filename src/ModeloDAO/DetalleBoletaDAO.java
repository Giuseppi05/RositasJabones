
package ModeloDAO;

import Interfaces.DetalleBoletaInterface;
import ModeloDTO.BoletaDTO;
import ModeloDTO.DetalleBoletaDTO;
import ModeloDTO.ProductoDTO;
import config.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DetalleBoletaDAO implements DetalleBoletaInterface{
    conexion con = new conexion();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    DetalleBoletaDTO db;
    
    ProductoDTO p;
    ProductoDAO pd = new ProductoDAO();
    
    BoletaDTO b;
    BoletaDAO bd = new BoletaDAO();
    
    @Override
    public boolean insertar(DetalleBoletaDTO d) {
        try {
            String sql = "insert into detalleboleta (idpro, idbol, candet, subdet) values (?, ?, ?, ?)";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, d.getProducto().getCodigo());
            ps.setString(2, d.getBoleta().getCodigo());
            ps.setInt(3, d.getCantidad());
            ps.setFloat(4, d.getSubtotal());
            ps.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean actualizar(DetalleBoletaDTO c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(Integer codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DetalleBoletaDTO listarUno(Integer codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DetalleBoletaDTO listarUnoNom(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<DetalleBoletaDTO> listarTodo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public ArrayList<DetalleBoletaDTO> listarPorBoleta(String codigo) {
        ArrayList<DetalleBoletaDTO> vdb = new ArrayList<>();
        try {
            String sql = "select * from detalleboleta where idbol = ?";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            while(rs.next()){
                db = new DetalleBoletaDTO();
                db.setCodigo(rs.getInt("iddet"));
                db.setCantidad(rs.getInt("candet"));
                db.setSubtotal(rs.getFloat("subdet"));
                
                p = new ProductoDTO();
                p = pd.listarUno(rs.getInt("idpro"));
                db.setProducto(p);
                
                b = new BoletaDTO();
                b = bd.listarUno(rs.getString("idbol"));
                db.setBoleta(b);
                
                vdb.add(db);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vdb;
    }
    
    
    
}
