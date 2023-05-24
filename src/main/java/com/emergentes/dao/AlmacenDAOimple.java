package com.emergentes.dao;

import com.emergentes.modelo.Almacen;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AlmacenDAOimple extends ConexionDB implements AlmacenDAO {

    @Override
    public void insert(Almacen aviso) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO productos (descripcion,cantidad,precio,categoria) VALUES(?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, aviso.getDescripcion());
            ps.setInt(2, aviso.getCantidad());
            ps.setFloat(3, aviso.getPrecio());
            ps.setString(4, aviso.getCategoria());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Almacen aviso) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE productos SET descripcion=?, cantidad=?, precio=?, categoria=? WHERE ?=id";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, aviso.getDescripcion());
            ps.setInt(2, aviso.getCantidad());
            ps.setFloat(3, aviso.getPrecio());
            ps.setString(4, aviso.getCategoria());
            ps.setInt(5, aviso.getId());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            String sql = "DELETE FROM productos WHERE id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Almacen getById(int id) throws Exception {
        Almacen avi = new Almacen();
        try {
            this.conectar();
            String sql = "SELECT * FROM productos where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                avi.setId(rs.getInt("id"));
                avi.setDescripcion(rs.getString("descripcion"));
                avi.setCantidad(rs.getInt("cantidad"));
                avi.setPrecio(rs.getFloat("precio"));
                avi.setCategoria(rs.getString("categoria"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return avi;

    }

    @Override
    public List<Almacen> getAll() throws Exception {
        ArrayList<Almacen> lista = new ArrayList<Almacen>();
        try {
            this.conectar();
            String sql = "SELECT * FROM productos ";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Almacen avi = new Almacen();
                avi.setId(rs.getInt("id"));
                avi.setDescripcion(rs.getString("descripcion"));
                avi.setCantidad(rs.getInt("cantidad"));
                avi.setPrecio(rs.getFloat("precio"));
                avi.setCategoria(rs.getString("categoria"));

                lista.add(avi);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;

    }

}
