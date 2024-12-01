package dao;

import database.DBConnection;
import database.SchemaDB;
import model.Empleado;
import model.Pedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PedidoDAO {
    private Connection conn;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public void addPedido(Pedido pedido) throws SQLException {
       conn = DBConnection.getConnection();
       String query = String.format("INSERT INTO %s(%s, %s, %s) VALUES(?,?,?)", SchemaDB.REL_PEDIDOS, SchemaDB.COL_ID_PRODUCTO,
                                    SchemaDB.COL_DESCRIPCION, SchemaDB.COL_PRECIO_TOTAL);

       preparedStatement = conn.prepareStatement(query);
       preparedStatement.setInt(1, pedido.getId_producto());
       preparedStatement.setString(2, pedido.getDescripcion());
       preparedStatement.setFloat(3, pedido.getPrecio_total());

       preparedStatement.execute();
    }

    public void imprimirPedidos() throws SQLException {
        conn = DBConnection.getConnection();
        String query = String.format("SELECT* FROM %s", SchemaDB.REL_PEDIDOS);
        preparedStatement = conn.prepareStatement(query);

        resultSet = preparedStatement.executeQuery();

        Pedido pedido;

        System.out.println("-------Lista de pedidos-------");
        while(resultSet.next()){
            int id = resultSet.getInt(1);
            int id_producto = resultSet.getInt(2);
            String descripcion = resultSet.getString(3);
            float precio_total = resultSet.getFloat(4);
            pedido = new Pedido(id, id_producto, descripcion, precio_total);
            System.out.println();
            pedido.imprimirDatos();
            System.out.println();
        }
        System.out.println("-------------------------------");

    }
}
