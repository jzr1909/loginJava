package procesos;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import dao.ClienteDAO;
import dto.ClienteDTO;

public class Procesos {
	
	
	private ClienteDTO cliente; 
	
	
	public Procesos (ClienteDTO cliente) {
		
		this.cliente = cliente; 
	}
	
	
	public void registrarCliente() {
		
		 
		 
		 try {
			 
			 
			 
			ClienteDAO clienteDAO = new ClienteDAO();
			String registro = clienteDAO.registrarPersona(cliente);
			
			
			if(registro.equals("ok")) {
				
				String mensaje = "Registro Completado\n" + 
				"Nombre: " + cliente.getNombre() + "\n" +  
				"Apellido: " + cliente.getApellidos() +  "\n" + 
				"Correo: "+ cliente.getCorreo() + "\n" + 
				"Registro Exitoso"; 
				
				
				JOptionPane.showMessageDialog(null, mensaje);
				
			}else {
				
				JOptionPane.showMessageDialog(null, "No se hizo el registro", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			
			
			
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "ERROR de SQL", "Error", JOptionPane.ERROR_MESSAGE);
		} 

	}

}
