package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
		
		private String nombreBd = "login";
	    private String usuario = "root";
	    private String password = "ju4n12345";

	    private String url = "jdbc:mysql://localhost:3307/" + nombreBd + "?useUnicode=true&use"
	            + "JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&"
	            + "serverTimezone=UTC";

	    Connection conn = null;

	    public Conexion() {
	        try {

	            Class.forName("com.mysql.cj.jdbc.Driver");

	            conn = DriverManager.getConnection(url, usuario, password);

	            if (conn != null) {
	                System.out.println("Conexion exitosa a la BD: " + nombreBd);
	            } else {
	                System.out.println("No se pudo conectar " + nombreBd);
	            }

	        } catch (ClassNotFoundException e) {
	            System.out.println("Ocurre una ClassNotFoundException: " + e.getMessage());

	        } catch (SQLException e) {
	            System.out.println("Ocurre una SQLException: " + e.getMessage());
	            System.out.println("Verifique que Mysql este encendido");
	        }
	    }

	    public Connection getConnection() {
	        return conn;
	    }

	    public void desconectar() {
	        conn = null;
	    }

}
