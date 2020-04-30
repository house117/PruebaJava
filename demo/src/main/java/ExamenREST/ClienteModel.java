package ExamenREST;

import java.sql.Date;

public class ClienteModel {
	private Integer cliente_id;
	private String nombre_usuario;
	private String contrasena;
	private String nombre;
	private String apellidos;
	private String correo_electronico;
	private Integer edad;
	private Double estatura;
	private Double peso;
	private Double IMC;
	private Double GEB;
	private Double ETA;
	private Date fecha_creacion;
	private Date fecha_actualizacion;
	public ClienteModel() {
		
	}
	public ClienteModel(Integer cliente_id, String nombre_usuario, String contrasena, String nombre, String apellidos,
			String correo_electronico, Integer edad, Double estatura, Double peso, Double iMC, Double gEB, Double eTA,
			Date fecha_creacion, Date fecha_actualizacion) {
		super();
		this.cliente_id = cliente_id;
		this.nombre_usuario = nombre_usuario;
		this.contrasena = contrasena;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo_electronico = correo_electronico;
		this.edad = edad;
		this.estatura = estatura;
		this.peso = peso;
		IMC = iMC;
		GEB = gEB;
		ETA = eTA;
		this.fecha_creacion = fecha_creacion;
		this.fecha_actualizacion = fecha_actualizacion;
	}
	public Integer getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(Integer cliente_id) {
		this.cliente_id = cliente_id;
	}
	public String getNombre_usuario() {
		return nombre_usuario;
	}
	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getCorreo_electronico() {
		return correo_electronico;
	}
	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public Double getEstatura() {
		return estatura;
	}
	public void setEstatura(Double estatura) {
		this.estatura = estatura;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public Double getIMC() {
		return IMC;
	}
	public void setIMC(Double iMC) {
		IMC = iMC;
	}
	public Double getGEB() {
		return GEB;
	}
	public void setGEB(Double gEB) {
		GEB = gEB;
	}
	public Double getETA() {
		return ETA;
	}
	public void setETA(Double eTA) {
		ETA = eTA;
	}
	public Date getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	public Date getFecha_actualizacion() {
		return fecha_actualizacion;
	}
	public void setFecha_actualizacion(Date fecha_actualizacion) {
		this.fecha_actualizacion = fecha_actualizacion;
	}
	
}
