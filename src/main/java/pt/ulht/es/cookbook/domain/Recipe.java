package pt.ulht.es.cookbook.domain;

import java.util.Comparator;

import org.joda.time.DateTime;





public class Recipe extends Recipe_Base{

	/*private String id;
	
	private String titulo;
	private String problema;
	private String solucao;*/
	
	public static class CreationComparator implements Comparator<Recipe> {

		public int compare(Recipe o1, Recipe o2) {
			return o1.getTitulo().compareTo(o2.getTitulo());
		}
	}
	public Recipe() {
		setCookbookManager(CookbookManager.getInstance());
	}


	public Recipe(String titulo, String problema, String solucao, String autor) {
		setCookbookManager(CookbookManager.getInstance());

		setTitulo(titulo);
		setProblema(problema);
		setSolucao(solucao);
		setAutor (autor);
		setCreationTimestamp(new DateTime());
		
	}
	public void delete() {
		for (Tag tag : getTagSet()) {
			tag.delete();
		}
		setCookbookManager(null);
		super.deleteDomainObject();
	}

	public String getTitle() {
		return getTitulo();
	}
	
	public String getProblem() {
		return getProblema();
	}
	
	public String getSolution() {
		return getSolucao();
		
	}

	
	public void addTag(String TagText) {
		addTag(new Tag(TagText));
	}
}

