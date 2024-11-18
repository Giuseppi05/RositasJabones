package ModeloDAO;

import Interfaces.ClientInterface;
import ModeloDTO.ClienteDTO;
import ModeloDTO.DepartamentoDTO;
import ModeloDTO.DistritoDTO;
import ModeloDTO.ProvinciaDTO;
import ModeloDTO.TipoDocumentoDTO;
import config.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO implements ClientInterface{
    conexion con = new conexion();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    ClienteDTO c;
    
    DepartamentoDAO dd = new DepartamentoDAO();
    DepartamentoDTO d;
    
    ProvinciaDAO pd = new ProvinciaDAO();
    ProvinciaDTO p;
    
    DistritoDAO disd = new DistritoDAO();
    DistritoDTO dis;
    
    TipoDocumentoDAO tdd = new TipoDocumentoDAO();
    TipoDocumentoDTO td;
    
    @Override
    public boolean insertar(ClienteDTO c) {
        try {
            String sql = "insert into cliente (tipdoc, numdoc, nomcli, telcli, mailcli, dircli, iddis, idpro, iddep) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, c.getTipoDocumento().getCodigo());
            ps.setString(2, c.getDNI());
            ps.setString(3, c.getNombre());
            ps.setString(4, c.getTelefono());
            ps.setString(5, c.getCorreo());
            ps.setString(6, c.getDireccion());
            ps.setString(7, c.getDistrito().getCodigo());
            ps.setString(8, c.getProvincia().getCodigo());
            ps.setString(9, c.getDepartamento().getCodigo());
            ps.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean actualizar(ClienteDTO c) {
        try {
            String sql = "update cliente set tipdoc=?, numdoc=?, nomcli=?, telcli=?, mailcli=?, dircli=?, iddis=?, idpro=?, iddep=? where idcli = "+c.getCodigo();
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, c.getTipoDocumento().getCodigo());
            ps.setString(2, c.getDNI());
            ps.setString(3, c.getNombre());
            ps.setString(4, c.getTelefono());
            ps.setString(5, c.getCorreo());
            ps.setString(6, c.getDireccion());
            ps.setString(7, c.getDistrito().getCodigo());
            ps.setString(8, c.getProvincia().getCodigo());
            ps.setString(9, c.getDepartamento().getCodigo());
            ps.executeUpdate();
            conn.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean eliminar(Integer codigo) {
        try {
            String sql = "delete from cliente where idcli = ?";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql); 
            ps.setInt(1, codigo);
            ps.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ClienteDTO listarUno(Integer codigo) {
        ClienteDTO c = null;
        try {
            String sql = "select * from cliente where idcli = ?";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            while(rs.next()){
                c = new ClienteDTO();
                c.setCodigo(rs.getInt("idcli"));
                c.setDNI(rs.getString("numdoc"));
                c.setNombre(rs.getString("nomcli"));
                c.setTelefono(rs.getString("telcli"));
                c.setCorreo(rs.getString("mailcli"));
                c.setDireccion(rs.getString("dircli"));
                
                td = new TipoDocumentoDTO();
                td = tdd.listarUno(rs.getInt("tipdoc"));
                c.setTipoDocumento(td);
                                        
                dis = new DistritoDTO();
                dis = disd.listarUno(rs.getString("iddis"));
                c.setDistrito(dis);
                
                p = new ProvinciaDTO();
                p = pd.listarUno(rs.getString("idpro"));
                c.setProvincia(p);
                
                d = new DepartamentoDTO();
                d = dd.listarUno(rs.getString("iddep"));
                c.setDepartamento(d);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    @Override
    public ClienteDTO listarUnoNom(String nom) {
        ClienteDTO c = null;
        try {
            String sql = "select * from cliente where nomcli = ?";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, nom);
            rs = ps.executeQuery();
            while(rs.next()){
                c = new ClienteDTO();
                c.setCodigo(rs.getInt("idcli"));
                c.setDNI(rs.getString("numdoc"));
                c.setNombre(rs.getString("nomcli"));
                c.setTelefono(rs.getString("telcli"));
                c.setCorreo(rs.getString("mailcli"));
                c.setDireccion(rs.getString("dircli"));
                
                td = new TipoDocumentoDTO();
                td = tdd.listarUno(rs.getInt("tipdoc"));
                c.setTipoDocumento(td);
                                        
                dis = new DistritoDTO();
                dis = disd.listarUno(rs.getString("iddis"));
                c.setDistrito(dis);
                
                p = new ProvinciaDTO();
                p = pd.listarUno(rs.getString("idpro"));
                c.setProvincia(p);
                
                d = new DepartamentoDTO();
                d = dd.listarUno(rs.getString("iddep"));
                c.setDepartamento(d);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    @Override
    public ArrayList<ClienteDTO> listarTodo() {
        ArrayList<ClienteDTO> vc = new ArrayList<>();
        try {
            String sql = "select * from cliente";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                c = new ClienteDTO();
                c.setCodigo(rs.getInt("idcli"));
                c.setDNI(rs.getString("numdoc"));
                c.setNombre(rs.getString("nomcli"));
                c.setTelefono(rs.getString("telcli"));
                c.setCorreo(rs.getString("mailcli"));
                c.setDireccion(rs.getString("dircli"));
                
                td = new TipoDocumentoDTO();
                td = tdd.listarUno(rs.getInt("tipdoc"));
                c.setTipoDocumento(td);
                                        
                dis = new DistritoDTO();
                dis = disd.listarUno(rs.getString("iddis"));
                c.setDistrito(dis);
                
                p = new ProvinciaDTO();
                p = pd.listarUno(rs.getString("idpro"));
                c.setProvincia(p);
                
                d = new DepartamentoDTO();
                d = dd.listarUno(rs.getString("iddep"));
                c.setDepartamento(d);
                
                vc.add(c);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vc;
    }
    
    public ClienteDTO listarUnoDNI(String dni) {
        ClienteDTO c = null;
        try {
            String sql = "select * from cliente where numdoc = ?";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, dni);
            rs = ps.executeQuery();
            while(rs.next()){
                c = new ClienteDTO();
                c.setCodigo(rs.getInt("idcli"));
                c.setDNI(rs.getString("numdoc"));
                c.setNombre(rs.getString("nomcli"));
                c.setTelefono(rs.getString("telcli"));
                c.setCorreo(rs.getString("mailcli"));
                c.setDireccion(rs.getString("dircli"));
                
                td = new TipoDocumentoDTO();
                td = tdd.listarUno(rs.getInt("tipdoc"));
                c.setTipoDocumento(td);
                                        
                dis = new DistritoDTO();
                dis = disd.listarUno(rs.getString("iddis"));
                c.setDistrito(dis);
                
                p = new ProvinciaDTO();
                p = pd.listarUno(rs.getString("idpro"));
                c.setProvincia(p);
                
                d = new DepartamentoDTO();
                d = dd.listarUno(rs.getString("iddep"));
                c.setDepartamento(d);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
}
