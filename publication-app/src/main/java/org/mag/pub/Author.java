package org.mag.pub;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Version;

import org.mag.Article;

@Entity
@Table(name="AuthorPublication")
public class Author implements Serializable{

	private static final long serialVersionUID = 9173360325891557444L;

	@Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="AuthorGen")
    
    @TableGenerator(name="AuthorGen", table="AuthorGenerator", pkColumnName="PK",
        valueColumnName="AuthorId")
    @Column(name="AuthorId", columnDefinition="INTEGER64")
    private long id;

    @Column(name="Version")
    @Version private int version;

    @Column(name="FirstName")
    private String firstName;

    @Column(name="LastName")
    private String lastName;

    private Address address;
    
    @ManyToMany(mappedBy="authors", cascade=CascadeType.PERSIST)
    private Collection<Article> arts;

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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Collection<Article> getArts() {
		return arts;
	}

	public void setArts(Collection<Article> arts) {
		this.arts = arts;
	}

   
}

