package pt.ulht.es.cookbook.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pt.ist.fenixframework.pstm.AbstractDomainObject;
import pt.ulht.es.cookbook.domain.CookbookManager;
import pt.ulht.es.cookbook.domain.Recipe;
import pt.ulht.es.cookbook.domain.Tag;





@Controller
public class RecipeController {
  
 /*   @RequestMapping(method=RequestMethod.GET, value="/recipes")
    public String listRecipes(Model model) {
    	Collection<Recipe> recipes = CookbookManager.getRecipes ();
    	model.addAttribute("Recipes", recipes);
    	return "listRecipes";
    }
    */
	@RequestMapping(method=RequestMethod.GET, value="/recipes")
	
	public String listRecipes(Model model) {
		
		List<Recipe> ListRecipes = new ArrayList<Recipe>(CookbookManager.getInstance().getRecipeSet());
		Collections.sort(ListRecipes, new Recipe.CreationComparator());
		model.addAttribute("Recipes",ListRecipes);
		
		return "listRecipes";
	}
		
		
    @RequestMapping(method=RequestMethod.GET, value="/recipes/create")
    public String showRecipeCreationForm(){
    
    return "createRecipe";
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/recipes")
    public String createRecipe(@RequestParam Map<String,String> params) {
    	String titulo = params.get("titulo");
    	String problema = params.get("problema");
    	String solucao = params.get("solucao");
    	String tag = params.get("tag");
    	String idrecipe;
    	
    	
    	Recipe recipe = new Recipe(titulo, problema, solucao);
    	
    	if (tag.contains(",")){
    		List<String> ListTag = new ArrayList<String>(Arrays.asList(tag.split(",")));
    		
    		for (String Tags :ListTag) {
    		recipe.addTag(Tags);
    		}
    	} else {
    		recipe.addTag(tag);
    	}
    	
    	
    	
         idrecipe=recipe.getOid()+"";
    	//CookbookManager.saveRecipe(recipe);
    	
    return "redirect:/recipes/"+idrecipe;
    }
    
    
   @RequestMapping(method=RequestMethod.GET, value="/recipes/{id}")
    public String showRecipe(Model model, @PathVariable String id) {
    	Recipe recipe = AbstractDomainObject.fromExternalId(id);
    	
    	List<Tag> Tags = new ArrayList<Tag>(recipe.getTagSet());
    	if(recipe != null) {
    		model.addAttribute("recipe", recipe);
    		model.addAttribute("tag", Tags);
    		return "detailedRecipe";
    }	else  {
    		return "recipeNotFound";
    }
    	
    }
   @RequestMapping(method = RequestMethod.GET, value = "/recipes/delete/{id}")
	public String deleteRecipe(@PathVariable("id") String id) {
		Recipe recipe = AbstractDomainObject.fromExternalId(id);
		recipe.delete();
		CookbookManager.getInstance().removeRecipe(recipe);
		return "redirect:/recipes/";
   }
        
    
    
}