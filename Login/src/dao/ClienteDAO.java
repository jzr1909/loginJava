package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import conexion.Conexion;
import dto.ClienteDTO;


public class ClienteDAO {

	public String registrarPersona(ClienteDTO cliente) throws SQLException {
		String resultado = "";
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;

		connection = conexion.getConnection();

		if (connection != null) {
			String consulta = "INSERT INTO cliente (nombres, apellidos, correo)"
					+ "VALUES (?,?,?)";

			System.out.println(consulta);

			try {
				preStatement = connection.prepareStatement(consulta);
				preStatement.setString(1, cliente.getNombre());
				preStatement.setString(2, cliente.getApellidos());
				preStatement.setString(3, cliente.getCorreo());
			

				preStatement.execute();
				resultado = "ok";
			} catch (SQLException e) {
				System.out.println("No se pudo registrar el dato: " + e.getMessage());
				resultado = "error";
			} finally {
				if (preStatement != null)
					preStatement.close();
				if (connection != null)
					connection.close();
				conexion.desconectar();
			}
		} else {
			System.out.println("No conecta!");
		}
		return resultado;
	}



}
