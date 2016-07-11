package es.crowdynamics.cook.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import es.crowdynamics.cook.dao.RecipeDAO;
import es.crowdynamics.cook.domain.Recipe;

@Controller
public class RecipeController {

	@Autowired
	private RecipeDAO recipeDAO;
	
	@RequestMapping(value = "/create")
	public ResponseEntity<String> createRecipe(@RequestParam String name)	{
		
		recipeDAO.createRecipe(name);
		
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/find")
	public @ResponseBody Recipe findRecipe(@RequestParam String name)	{
		
		Recipe recipe = recipeDAO.findByName(name);
		
		return recipe;
	}
	
}
