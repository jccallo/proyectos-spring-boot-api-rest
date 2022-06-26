package pe.jccallo.model;

import javax.persistence.*;

@Entity
@Table(name="productos")
public class Producto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String descripcion;
	private double precioventa;
	private double preciocompra;
	private Integer stock;
	
	@ManyToOne
	@JoinColumn(name="categoria_id",nullable=false,
	foreignKey=@ForeignKey(foreignKeyDefinition =
	"foreign key (categoria_id) references categorias (id)"))
	private Categoria categoria;
	
	public Producto() {
	}

	public Producto(Long id, String nombre, String descripcion, double precioventa, double preciocompra, Integer stock, Categoria categoria) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioventa = precioventa;
		this.preciocompra = preciocompra;
		this.stock = stock;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioventa() {
		return precioventa;
	}

	public void setPrecioventa(double precioventa) {
		this.precioventa = precioventa;
	}

	public double getPreciocompra() {
		return preciocompra;
	}

	public void setPreciocompra(double preciocompra) {
		this.preciocompra = preciocompra;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
