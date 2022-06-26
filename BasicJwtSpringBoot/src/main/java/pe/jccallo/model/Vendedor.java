package pe.jccallo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vendedor") 
public class Vendedor { 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo; 
	
	@Column(length = 25)
	private String nombre; 
	
	@Column(length = 25)
	private String apellido; 
	
	@Column(length = 20)
	private String telefono; 

	public Vendedor() {
	}

	public Vendedor(Long codigo, String nombre, String apellido, String telefono) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
