package pe.jccallo.model;

import javax.persistence.*;

@Entity
@Table(name="productos")
public class Producto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private double precio;
	
	@ManyToOne
	@JoinColumn(name="categoria_id",nullable=false,
	foreignKey=@ForeignKey(foreignKeyDefinition =
	"foreign key (categoria_id) references categorias (id)"))
	private Categoria categoria;
	
	public Producto() {
	}

	public Producto(Long id, String nombre, double precio, Categoria categoria) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.categoria = categoria;
	}

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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}