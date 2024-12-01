package database;

public interface SchemaDB {
    String HOST = "127.0.0.1";
    String PORT = "3306";
    String DB_NAME = "almacen";
    String USER = "root";
    String PASS = "";

    String REL_PRODUCTOS = "productos";
    String COL_ID = "id";
    String COL_NOMBRE  = "nombre";
    String COL_DESCRIPCION = "descripcion";
    String COL_CANTIDAD = "cantidad";
    String COL_PRECIO = "precio";

    String REL_EMPLEADOS = "empleados";
    String COL_APELLIDOS = "apellidos";
    String COL_CORREO = "correo";

    String REL_PEDIDOS = "pedidos";
    String COL_ID_PRODUCTO = "id_producto";
    String COL_PRECIO_TOTAL = "precio_total";

}
