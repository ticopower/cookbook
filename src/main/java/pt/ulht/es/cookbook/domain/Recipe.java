package pt.ulht.es.cookbook.domain;

import java.util.Comparator;





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


	public Recipe(String titulo, String problema, String solucao) {
		setCookbookManager(CookbookManager.getInstance());

		setTitulo(titulo);
		setProblema(problema);
		setSolucao(solucao);
		
	}
	public void delete() {
		for (Tag tag : getTagSet()) {
			tag.delete();
		}
		setCookbookManager(null);
		super.deleteDomainObject();
	}

/*	public String getTitulo() {
		return titulo;
	}
	
	public String getProblema() {
		return problema;
	}
	
	public String getSolucao() {
		return solucao;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
		
	}*/
	public void addTag(String TagText) {
		addTag(new Tag(TagText));
	}
}

