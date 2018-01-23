package org.mag;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import org.mag.pub.Author;

@Entity
@Table(name="Article"/*, uniqueConstraints=@Unique(columnNames="TITLE")*/)
public class Article implements Serializable{

	private static final long serialVersionUID = 822069193471324176L;

	@Id
	@SequenceGenerator(name="ArticleSeq", sequenceName="ArticleSeq",allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ArticleSeq") 
	@Column(name="Id")
	private long id;

    @Column(name="Version")
    @Version private int version;

    @Column(name="Title")
    private String title;
    
    @Column(name="Content",columnDefinition="VARBINARY(MAX)")
    private byte[] content;

    /*@ManyToMany(cascade=CascadeType.PERSIST)*/
    @ManyToMany
    @OrderBy("lastName, firstName")
    @JoinTable(name="ArticleAuthors",
        joinColumns=@JoinColumn(name="ArticleId"),
        inverseJoinColumns=@JoinColumn(name="AuthorId"))
    private Collection<Author> authors;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public Collection<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Collection<Author> authors) {
		this.authors = authors;
	}
	
	
	public void addAuthors(Author author) {
		if(authors == null){
			authors = new ArrayList<Author>();
		}
		authors.add(author);
		author.addAricles(this);
	}
	
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    

}
