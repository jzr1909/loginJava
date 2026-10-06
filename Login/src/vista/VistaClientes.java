package vista;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import conexion.Conexion;

public class VistaClientes extends JFrame {

	
	JTable tabla;
	DefaultTableModel modelo;

	public VistaClientes() {

		setTitle("Clientes registrados");
		setSize(700, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		modelo = new DefaultTableModel();

		modelo.addColumn("ID");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		modelo.addColumn("Correo");
	

		tabla = new JTable(modelo);

		JScrollPane scroll = new JScrollPane(tabla);

		add(scroll, BorderLayout.CENTER);

		cargarClientes();
	}

	public void cargarClientes() {

		Conexion conexion = new Conexion();
		Connection cn = conexion.getConnection();

		String sql = "SELECT id, nombres, apellidos, correo  FROM cliente";

		try {

			PreparedStatement ps = cn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Object[] fila = { rs.getInt("id"), rs.getString("nombres"), rs.getString("apellidos"),
						rs.getString("correo") };

				modelo.addRow(fila);
			}

			rs.close();
			ps.close();
			

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
