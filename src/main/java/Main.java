import dao.EmpleadoDAO;
import dao.PedidoDAO;
import dao.ProductoDAO;
import database.DBConnection;
import model.Empleado;
import model.Pedido;
import model.Producto;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        //asumimos que la base de datos y las tablas están creadas y vacías (ejecutar el .sql que se encuentra en la carpeta resources)
        poblarDB();
        addEmpleados();
        addPedidos();
        mostrarEmpleados();
        mostrarProductos();
        mostrarPedidos();
        mostrarProductos(600F);

    }

    private static void mostrarProductos(float precioMax) {
        ProductoDAO productoDAO = new ProductoDAO();
        try {
            productoDAO.imprimirProductos(precioMax);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void mostrarProductos() {
        ProductoDAO productoDAO = new ProductoDAO();
        try {
            productoDAO.imprimirProductos();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void mostrarPedidos() {
        PedidoDAO pedidoDAO = new PedidoDAO();
        try {
            pedidoDAO.imprimirPedidos();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void addPedidos() {
        Pedido pedido1 = new Pedido("descripcion pedido 1", 104.54F, 14);
        Pedido pedido2 = new Pedido("descripcion pedido 2", 65.20F, 7);
        PedidoDAO pedidoDAO = new PedidoDAO();
        try {
            pedidoDAO.addPedido(pedido1);
            pedidoDAO.addPedido(pedido2);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void poblarDB(){
        // Metemos los productos desde el JSON a la base de datos
        String urlString = "https://dummyjson.com/products";
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            JSONObject response = new JSONObject(reader.readLine());
            JSONArray products = response.getJSONArray("products");

            for (Object object : products){
                if (object instanceof JSONObject){
                    JSONObject productoJO = (JSONObject) object;
                    Producto producto = new Producto(productoJO.getInt("id"), productoJO.getString("title"),
                            productoJO.getString("description"), productoJO.getInt("stock"),
                            productoJO.getFloat("price"));
                    ProductoDAO dao = new ProductoDAO();
                    dao.insertProducto(producto);
                }
            }

        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void addEmpleados(){
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        Empleado empleado1 = new Empleado("Aaron", "Lavinz", "aaron@mail.com");
        Empleado empleado2 = new Empleado("Fermin", "Galarga", "fermin@mail.com");
        Empleado empleado3 = new Empleado("Alex", "Cremento", "alex@mail.com");
        try {
            empleadoDAO.addEmpleado(empleado1);
            empleadoDAO.addEmpleado(empleado2);
            empleadoDAO.addEmpleado(empleado3);
        } catch (SQLException e) {

        }
    }

    private static void mostrarEmpleados(){
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        try {
            empleadoDAO.imprimirEmpleados();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
