package pe.jccallo.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="saraos")
public class Saraos implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer saraosId;
	
	@Column
	private String nombre;
	
	@Column
	private Integer asistentes;
	
	@Column
	private String url;
	
	@Column
	private Integer notas;
	
	public Saraos() {
	}

	public Saraos(Integer saraosId, String nombre, Integer asistentes, String url, Integer notas) {
		this.saraosId = saraosId;
		this.nombre = nombre;
		this.asistentes = asistentes;
		this.url = url;
		this.notas = notas;
	}

	public Integer getSaraosId() {
		return saraosId;
	}

	public void setSaraosId(Integer saraosId) {
		this.saraosId = saraosId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getAsistentes() {
		return asistentes;
	}

	public void setAsistentes(Integer asistentes) {
		this.asistentes = asistentes;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getNotas() {
		return notas;
	}

	public void setNotas(Integer notas) {
		this.notas = notas;
	}
}
