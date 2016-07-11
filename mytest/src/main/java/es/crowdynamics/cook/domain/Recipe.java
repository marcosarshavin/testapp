package es.crowdynamics.cook.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Recipe")
@SequenceGenerator(name = "id_recipe", sequenceName = "seq_recipe_id", allocationSize = 1, initialValue = 1)
public class Recipe {

	@Id
	@GeneratedValue(generator="id_recipe",strategy=GenerationType.AUTO)
	@Column(name="id")
	private BigDecimal id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="nPersonas")
	private Long nPersonas;
	
	//Tiempo de preparación en segundos
	@Column(name="COOKING_TIME")
	private Long cookingTime;
	
	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getnPersonas() {
		return nPersonas;
	}
	public void setnPersonas(Long nPersonas) {
		this.nPersonas = nPersonas;
	}
	public Long getCookingTime() {
		return cookingTime;
	}
	public void setCookingTime(Long cookingTime) {
		this.cookingTime = cookingTime;
	}
	
}
