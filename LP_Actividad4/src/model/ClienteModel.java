package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import entidad.Cliente;
import entidad.TipoCliente;
import util.MySqlDBConexion;

public class ClienteModel {
	public List<Cliente> consultaCliente(String num){
		ArrayList<Cliente> cli = new ArrayList<Cliente>();
		Connection con =null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = MySqlDBConexion.getConexion();
			String sql ="select c.idCliente, c.nombres, c.apellidos, c.dni, c.fechaNacimiento, tc.nombre " + 
					"from cliente c inner join tipo_cliente tc " + 
					"on c.idTipoCliente = tc.idTpoCliente " + 
					"where c.dni like '"+num+"%' ";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			Cliente c = null;
			TipoCliente tc = null;
			while(rs.next()) 
			{
				c = new Cliente();
				c.setIdCliente(rs.getInt(1));
				c.setNombre(rs.getString(2));
				c.setApellido(rs.getString(3));
				c.setDni(rs.getString(4));
				c.setFecNac(rs.getDate(5));
				
				tc = new TipoCliente();
				tc.setNomTip(rs.getString(6));
				
				
				c.setIdTipoCliente(tc);
				cli.add(c);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)pstm.close();
				if (pstm != null)con.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return cli;
	} 
	
	public List<Cliente> listaDniCliente()
	{
		ArrayList<Cliente> cli = new ArrayList<Cliente>();
		Connection con =null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = MySqlDBConexion.getConexion();
			String sql ="select c.idCliente, c.nombres, c.apellidos, c.dni, c.fechaNacimiento, tc.nombre " + 
					"from cliente c inner join tipo_cliente tc " + 
					"on c.idTipoCliente = tc.idTpoCliente ";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			Cliente c = null;
			TipoCliente tc = null;
			while(rs.next()) 
			{
				c = new Cliente();
				c.setIdCliente(rs.getInt(1));
				c.setNombre(rs.getString(2));
				c.setApellido(rs.getString(3));
				c.setDni(rs.getString(4));
				c.setFecNac(rs.getDate(5));
				
				tc = new TipoCliente();
				tc.setNomTip(rs.getString(6));
				
				c.setIdTipoCliente(tc);
				cli.add(c);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)pstm.close();
				if (pstm != null)con.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return cli;
	}
}
