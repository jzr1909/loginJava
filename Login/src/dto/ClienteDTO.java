package dto;

public class ClienteDTO {

	private String nombres;
	private String apellidos;
	private String correo;
	
	
	public ClienteDTO() {
		
	}
	
	public ClienteDTO(String nombres, String apellidos, String correo) {
		
		this.nombres = nombres; 
		this.apellidos = apellidos; 
		this.correo = correo; 
		
	}
	
	
	
	

	public String getNombre() {
		return nombres;
	}
	public void setNombre(String nombre) {
		this.nombres = nombre;
	}
	

	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
}
