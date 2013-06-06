package pt.ulht.es.cookbook.domain;

public class Tag extends Tag_Base{

	public Tag(String tags){
		setTag(tags);
	}
	public void delete() {
		setRecipe(null);
		super.deleteDomainObject();
	}
}
