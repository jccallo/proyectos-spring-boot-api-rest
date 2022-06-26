package pe.jccallo.model;

import javax.persistence.*;

@Entity
@Table(name="telefonos") // nombre de la tabla en la base de datos
public class Telefono { // nombre del modelo
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;       // llave primaria
	private String primerTelefono; // campos
	private String segundoTelefono;  // campos
	
	// constructores
	public Telefono() {
	}
	public Telefono(Long id, String primerTelefono, String segundoTelefono) {
		this.id = id;
		this.primerTelefono = primerTelefono;
		this.segundoTelefono = segundoTelefono;
	}
	
	// getters y setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPrimerTelefono() {
		return primerTelefono;
	}
	public void setPrimerTelefono(String primerTelefono) {
		this.primerTelefono = primerTelefono;
	}
	public String getSegundoTelefono() {
		return segundoTelefono;
	}
	public void setSegundoTelefono(String segundoTelefono) {
		this.segundoTelefono = segundoTelefono;
	}
}
