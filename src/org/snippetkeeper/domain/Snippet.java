package org.snippetkeeper.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Snippet {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long snippetId;
	
	@OneToOne
	@JoinColumn(name="userId")
	private User user;
	
	@NotEmpty(message="should not be empty")
	private String title;
	
	@Valid
	@OneToOne
	@JoinColumn(name="language")
	private Language language;
	
	@Valid
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "Snippet_Category", 
    joinColumns = { @JoinColumn(name = "id") }, 
    inverseJoinColumns = { @JoinColumn(name = "categoryId") })
	private List<Category> categories;
	
	@NotEmpty
	@Type(type="text")
	private String snippet;
	
	public Long getSnippetId() {
		return snippetId;
	}
	public void setSnippetId(Long snippetId) {
		this.snippetId = snippetId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSnippet() {
		return snippet;
	}
	public void setSnippet(String snippet) {
		this.snippet = snippet;
	}
	public Language getLanguage() {
		return language;
	}
	public void setLanguage(Language language) {
		this.language = language;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	/* One important remark : In case of *Many* association, always override hashcode and 
	 * equals method which are looked by hibernate when holding entities into collections.
	 */
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((snippetId == null) ? 0 : snippetId.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((user == null) ? 0 : user.hashCode());
        result = prime * result + ((snippet == null) ? 0 : snippet.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof User))
            return false;
        Snippet other = (Snippet) obj;
        if (snippetId == null) {
            if (other.snippetId != null)
                return false;
        } else if (!snippetId.equals(other.snippetId))
            return false;
        return true;
    }
	
	
}
