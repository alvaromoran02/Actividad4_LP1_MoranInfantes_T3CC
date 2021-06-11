package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidad.Cliente;
import model.ClienteModel;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import reporte.GeneradorReporte;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class FrmConsultaCliente extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblConsultaDeCliente;
	private JLabel lblDni;
	private JTextField txtDni;
	private JButton btnFiltrar;
	private JPanel panelReporte;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConsultaCliente frame = new FrmConsultaCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmConsultaCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 821, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblConsultaDeCliente = new JLabel("Consulta de Cliente por DNI");
		lblConsultaDeCliente.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblConsultaDeCliente.setBounds(247, 28, 313, 30);
		contentPane.add(lblConsultaDeCliente);
		
		lblDni = new JLabel("DNI");
		lblDni.setBounds(174, 72, 46, 14);
		contentPane.add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setBounds(257, 69, 254, 20);
		contentPane.add(txtDni);
		txtDni.setColumns(10);
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(this);
		btnFiltrar.setBounds(560, 64, 89, 30);
		contentPane.add(btnFiltrar);
		
		panelReporte = new JPanel();
		panelReporte.setBounds(10, 105, 785, 347);
		contentPane.add(panelReporte);
		panelReporte.setLayout(new BorderLayout(0, 0));
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnFiltrar) {
			actionPerformedBtnFiltrar(arg0);
		}
	}
	protected void actionPerformedBtnFiltrar(ActionEvent arg0) {
		String num = txtDni.getText().trim();
		
		ClienteModel model = new ClienteModel();
		List<Cliente> cli = null;
		if (num.equals("")) {
			cli = model.listaDniCliente();
		}else {
			cli = model.consultaCliente(num);
		}
		
		// 1 La data
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(cli);

		// 2 El diseño del reporte (Diseño)
		String file = "reportCliente.jasper";
				
		// 3 Se genera el reporte
		JasperPrint jasperPrint = GeneradorReporte.genera(file, dataSource, null);

		// 4 Se muestra en el visor
		JRViewer jRViewer = new JRViewer(jasperPrint);
				
		// 5 Se añade el visor al panel
	    panelReporte.removeAll();
		panelReporte.add(jRViewer);
		panelReporte.repaint();
		panelReporte.revalidate();
		}
}
