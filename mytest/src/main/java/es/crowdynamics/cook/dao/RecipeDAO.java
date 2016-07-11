package es.crowdynamics.cook.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import es.crowdynamics.cook.domain.Recipe;

@Component
public class RecipeDAO {
	
	@PersistenceContext
	private EntityManager entitymanager;

	@Transactional(rollbackFor=Exception.class)
	public void createRecipe(String name)	{
		Recipe recipe = new Recipe();
		recipe.setName(name);
		this.entitymanager.persist(recipe);
	}
	
	public Recipe findByName(String name)	{
		String query = "select o from Recipe o where o.name = :name";
		return this.entitymanager.createQuery(query, Recipe.class).setParameter("name", name).getSingleResult();
	}
}
