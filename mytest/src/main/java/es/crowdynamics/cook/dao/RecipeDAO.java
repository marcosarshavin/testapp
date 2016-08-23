package es.crowdynamics.cook.dao;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import es.crowdynamics.cook.domain.Recipe;

@Component
public class RecipeDAO {
	
	@PersistenceContext
	private EntityManager entitymanager;

	
	@Transactional(rollbackFor=Exception.class)
	public void createRecipe(Recipe receta)	{
		
		this.entitymanager.persist(receta);
	}
	
	public @ResponseBody Recipe findByName(String name)	{
		String query = "select o from Recipe o where o.name = :name";
		return this.entitymanager.createQuery(query, Recipe.class).setParameter("name", name).getSingleResult();
	}
	public  Recipe findById(BigDecimal id)	{
		return this.entitymanager.find(Recipe.class, id);
				
	}
	@Transactional(rollbackFor=Exception.class)
	public void deleteRecipe(Recipe receta)	{
		
		this.entitymanager.remove(receta);
	}
	@Transactional(rollbackFor=Exception.class)
	public void updateRecipe(Recipe receta)	{
		
		this.entitymanager.merge(receta);
	}
}
