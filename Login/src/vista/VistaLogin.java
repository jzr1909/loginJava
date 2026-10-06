package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dto.ClienteDTO;
import procesos.Procesos;

public class VistaLogin extends JFrame implements ActionListener {

	private JPanel miPanel;

	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtCorreo;

	private JLabel lblTitulo, lblNombres, lblApellidos, lblCorreo;

	private JButton btnRegistrar;
	private JButton btnLimpiar;
	private JButton btnVerClientes;
	
	
	Procesos miP; 
	ClienteDTO cliente; 

	

	public  VistaLogin() {

		setTitle("Registro de Clientes");
		setSize(460, 350);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		iniciarComponentes();
	}

	public void iniciarComponentes() {

		miPanel = new JPanel();
		miPanel.setLayout(null);
		miPanel.setBackground(new Color(240, 240, 240));


	

		lblTitulo = new JLabel();
		lblTitulo.setBounds(125, 20, 220, 25);
		lblTitulo.setText("REGISTRO DE CLIENTES");
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 14));



		lblNombres = new JLabel();
		lblNombres.setBounds(50, 70, 100, 25);
		lblNombres.setText("Nombre");


		lblApellidos = new JLabel();
		lblApellidos.setBounds(50, 110, 100, 25);
		lblApellidos.setText("Apellidos");


		lblCorreo = new JLabel();
		lblCorreo.setBounds(50, 150, 100, 25);
		lblCorreo.setText("Correo");


		
		txtNombres = new JTextField();
		txtNombres.setBounds(140, 70, 250, 22);


		txtApellidos = new JTextField();
		txtApellidos.setBounds(140, 110, 250, 22);


		txtCorreo = new JTextField();
		txtCorreo.setBounds(140, 150, 250, 22);


	

		btnRegistrar = new JButton();
		btnRegistrar.setBounds(90, 210, 120, 30);
		btnRegistrar.setText("Registrar");
		btnRegistrar.addActionListener(this);


		

		btnLimpiar = new JButton();
		btnLimpiar.setBounds(230, 210, 120, 30);
		btnLimpiar.setText("Limpiar");
		btnLimpiar.addActionListener(this);


	

		btnVerClientes = new JButton();
		btnVerClientes.setBounds(150, 260, 150, 30);
		btnVerClientes.setText("Ver Clientes");
		btnVerClientes.addActionListener(this);


		

		miPanel.add(lblTitulo);
		miPanel.add(lblNombres);
		miPanel.add(lblApellidos);
		miPanel.add(lblCorreo);


		miPanel.add(txtNombres);
		miPanel.add(txtApellidos);
		miPanel.add(txtCorreo);


		miPanel.add(btnRegistrar);
		miPanel.add(btnLimpiar);
		miPanel.add(btnVerClientes);


		add(miPanel);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()== btnRegistrar) {
			
			
			if(txtNombres.getText().trim().isEmpty() ||
				txtApellidos.getText().trim().isEmpty() ||
			   txtCorreo.getText().trim().isEmpty()) {
				
				JOptionPane.showMessageDialog(null, "Deben estar completos todos los campos", "ERROR", JOptionPane.ERROR_MESSAGE);
				
				return; 
			}
			
			try {
				
				cliente = new ClienteDTO(); 
				
				cliente.setNombre(txtNombres.getText());
				cliente.setApellidos(txtApellidos.getText());
				cliente.setCorreo(txtCorreo.getText());
				
				
				miP = new Procesos(cliente);
				miP.registrarCliente();
				
			}catch (NumberFormatException ex) {
			    JOptionPane.showMessageDialog(this, "Ingrese únicamente valores numéricos en las notas", "Error de formato", JOptionPane.ERROR_MESSAGE);
			} 	
			
			
			
			
			
			
		} else if(e.getSource() == btnLimpiar) {
			
			txtNombres.setText(""); 
			txtApellidos.setText("");
			txtCorreo.setText("");
			
		}else if (e.getSource() == btnVerClientes) {
			
			VistaClientes vistaC = new VistaClientes(); 
			vistaC.setVisible(true);
			
		}
		
	}

}
