package dao;

import database.DBConnection;
import database.SchemaDB;
import model.Pedido;
import model.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ProductoDAO {
    private Connection conn;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public void insertProducto(Producto producto) throws SQLException {
        conn = DBConnection.getConnection();
        String query = String.format("INSERT INTO %s(%s, %s, %s, %s, %s) VALUES(?, ?, ?, ?, ?)",
                                    SchemaDB.REL_PRODUCTOS, SchemaDB.COL_ID, SchemaDB.COL_NOMBRE,
                                    SchemaDB.COL_DESCRIPCION, SchemaDB.COL_CANTIDAD, SchemaDB.COL_PRECIO);

        preparedStatement = conn.prepareStatement(query);

        preparedStatement.setInt(1, producto.getId());
        preparedStatement.setString(2, producto.getNombre());
        preparedStatement.setString(3, producto.getDescripcion());
        preparedStatement.setInt(4, producto.getCantidad());
        preparedStatement.setFloat(5, producto.getPrecio());

        preparedStatement.execute();
    }

    public void imprimirProductos() throws SQLException {
        conn = DBConnection.getConnection();
        String query = String.format("SELECT* FROM %s", SchemaDB.REL_PRODUCTOS);
        preparedStatement = conn.prepareStatement(query);

        resultSet = preparedStatement.executeQuery();

        Producto producto;

        System.out.println("-------Lista de productos-------");
        while(resultSet.next()){
            int id = resultSet.getInt(1);
            String nombre = resultSet.getString(2);
            String descripcion = resultSet.getString(3);
            int cantidad = resultSet.getInt(4);
            float precio_total = resultSet.getFloat(5);
            producto = new Producto(id, nombre, descripcion, cantidad, precio_total);
            System.out.println();
            producto.imprimirDatos();
            System.out.println();
        }
        System.out.println("-------------------------------");

    }

    public void imprimirProductos(float precioMax) throws SQLException {
        conn = DBConnection.getConnection();
        String query = String.format("SELECT* FROM %s WHERE %s <= ?", SchemaDB.REL_PRODUCTOS, SchemaDB.COL_PRECIO);
        preparedStatement = conn.prepareStatement(query);
        preparedStatement.setFloat(1, precioMax);

        resultSet = preparedStatement.executeQuery();

        Producto producto;

        System.out.printf("\n-------Lista de productos de precio hasta %f-------", precioMax);
        while(resultSet.next()){
            int id = resultSet.getInt(1);
            String nombre = resultSet.getString(2);
            String descripcion = resultSet.getString(3);
            int cantidad = resultSet.getInt(4);
            float precio_total = resultSet.getFloat(5);
            producto = new Producto(id, nombre, descripcion, cantidad, precio_total);
            System.out.println();
            producto.imprimirDatos();
            System.out.println();
        }
        System.out.println("-------------------------------");

    }
}
