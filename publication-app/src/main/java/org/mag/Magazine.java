package org.mag;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.mag.pub.Company;

@Entity
@IdClass(Magazine.MagazineId.class)
@Table(name="Magazine")
@DiscriminatorValue("Mag")
public class Magazine implements Serializable{

	private static final long serialVersionUID = -206867058827941392L;
	@Column(name="Isbn", length=9)
    @Id 
    private String isbn;
    
    @Column(name="Title")
    @Id 
    private String title;

    @Column(name="Version")
    @Version private int version;
    
    @Column(name="Name")
    private String name;
    @Column(name="Price")
    private double price;

    @Column(name="Copies")
    private int copiesSold;

    @OneToOne(fetch=FetchType.LAZY, 
        cascade={CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name="CoverId")
    private Article coverArticle;

    @OneToMany(cascade={CascadeType.PERSIST,CascadeType.REMOVE})
    @OrderBy
    @JoinTable(name="MagazineArticles",
        joinColumns={
            @JoinColumn(name="MagazineIsbn", referencedColumnName="Isbn"),
            @JoinColumn(name="MagazineTitle", referencedColumnName="Title")
        },
        inverseJoinColumns=@JoinColumn(name="ArticleId"))
    private Collection<Article> articles;

    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
    @JoinColumn(name="PublisherId")
    private Company publisher; 

    @Transient private byte[] data;
    
    


    /**
     * Application identity class for Magazine.
     */
    public static class MagazineId {

        // each identity field in the Magazine class must have a
        // corresponding field in the identity class
        public String isbn;
        public String title;

        /**
         * Equality must be implemented in terms of identity field
         * equality, and must use instanceof rather than comparing 
         * classes directly (some JPA implementations may subclass the
         * identity class).
         */
        public boolean equals(Object other) {
            if (other == this)
                return true;
            if (!(other instanceof MagazineId))
                return false;
    
            MagazineId mi = (MagazineId) other;
            return (isbn == mi.isbn
                || (isbn != null && isbn.equals(mi.isbn)))
                && (title == mi.title
                || (title != null && title.equals(mi.title)));
        }
     
        /**
         * Hashcode must also depend on identity values.
         */
        public int hashCode() {
            return ((isbn == null) ? 0 : isbn.hashCode())
                ^ ((title == null) ? 0 : title.hashCode());
        } 

        public String toString() {
            return isbn + ":" + title;
        }
    }




	public String getIsbn() {
		return isbn;
	}




	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}




	public String getTitle() {
		return title;
	}




	public void setTitle(String title) {
		this.title = title;
	}




	public int getVersion() {
		return version;
	}




	public void setVersion(int version) {
		this.version = version;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public double getPrice() {
		return price;
	}




	public void setPrice(double price) {
		this.price = price;
	}




	public int getCopiesSold() {
		return copiesSold;
	}




	public void setCopiesSold(int copiesSold) {
		this.copiesSold = copiesSold;
	}




	public Article getCoverArticle() {
		return coverArticle;
	}




	public void setCoverArticle(Article coverArticle) {
		this.coverArticle = coverArticle;
	}




	public Collection<Article> getArticles() {
		return articles;
	}




	public void setArticles(Collection<Article> articles) {
		this.articles = articles;
	}




	public Company getPublisher() {
		return publisher;
	}




	public void setPublisher(Company publisher) {
		this.publisher = publisher;
	}




	public byte[] getData() {
		return data;
	}




	public void setData(byte[] data) {
		this.data = data;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
    
    
    
}