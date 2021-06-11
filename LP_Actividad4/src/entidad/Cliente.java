package entidad;

import java.sql.Date;

public class Cliente {
	private int idCliente;
	private String nombre;
	private String apellido;
	private String dni;
	private Date fecNac;
	private TipoCliente idTipoCliente;
	private String tipoClientetxt;
	
	public int getIdCliente() {	
		tipoClientetxt = idTipoCliente.getNomTip();
		return idCliente;
	}
	public void setIdCliente(int idCliente) {	
		this.idCliente = idCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Date getFecNac() {
		return fecNac;
	}
	public void setFecNac(Date fecNac) {
		this.fecNac = fecNac;
	}
	public TipoCliente getIdTipoCliente() {
		return idTipoCliente;
	}
	public void setIdTipoCliente(TipoCliente idTipoCliente) {
		this.idTipoCliente = idTipoCliente;
	}
	public String getTipoClientetxt() {
		return tipoClientetxt;
	}
	public void setTipoClientetxt(String tipoClientetxt) {
		this.tipoClientetxt = tipoClientetxt;
	}
	
	
	
	
}
