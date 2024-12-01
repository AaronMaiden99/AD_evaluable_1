package dao;

import database.DBConnection;
import database.SchemaDB;
import model.Empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpleadoDAO {
    private Connection conn;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public void addEmpleado(Empleado empleado) throws SQLException {
        conn = DBConnection.getConnection();
        String query = String.format("INSERT INTO %s(%s, %s, %s) VALUES(?, ?, ?)", SchemaDB.REL_EMPLEADOS, SchemaDB.COL_NOMBRE, SchemaDB.COL_APELLIDOS, SchemaDB.COL_CORREO);
        preparedStatement = conn.prepareStatement(query);

        preparedStatement.setString(1, empleado.getNombre());
        preparedStatement.setString(2, empleado.getApellidos());
        preparedStatement.setString(3, empleado.getCorreo());

        preparedStatement.execute();
    }

    public void imprimirEmpleados() throws SQLException {
        conn = DBConnection.getConnection();
        String query = String.format("SELECT* FROM %s", SchemaDB.REL_EMPLEADOS);
        preparedStatement = conn.prepareStatement(query);

        resultSet = preparedStatement.executeQuery();

        Empleado empleado;

        System.out.println("-------Lista de empleados-------");
        while(resultSet.next()){
            int id = resultSet.getInt(1);
            String nombre = resultSet.getString(2);
            String apellidos = resultSet.getString(4);
            String correo = resultSet.getString(3);
            empleado = new Empleado(id, nombre, apellidos, correo);
            System.out.println();
            empleado.imprimirDatos();
            System.out.println();
        }
        System.out.println("-------------------------------");

    }
}
