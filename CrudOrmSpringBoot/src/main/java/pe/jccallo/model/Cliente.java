package pe.jccallo.model;

import javax.persistence.*;

@Entity
@Table(name="clientes") // nombre de la tabla en la base de datos
public class Cliente { // nombre del modelo
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;       // llave primaria
	private String nombre; // campos
	private String apellido;  // campos

	// agregar columna OneToOne
	@OneToOne
	@JoinColumn(name="telefono_id",nullable=false,unique=true, // campo agregado
	foreignKey=@ForeignKey(foreignKeyDefinition =
	"foreign key(telefono_id) references telefonos(id)")) // de donde viene el campo agregado y la tabla
	private Telefono telefono; // campo del tipo de SegundoModelo

	// constructores
	public Cliente() {

	}
	public Cliente(Long id, String nombre, String apellido, Telefono telefono) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
	}

	// getter y setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Telefono getTelefono() {
		return telefono;
	}
	public void setTelefono(Telefono telefono) {
		this.telefono = telefono;
	}
}
