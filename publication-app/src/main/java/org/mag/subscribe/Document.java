package org.mag.subscribe;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public abstract class Document implements Serializable{


	private static final long serialVersionUID = -5030724665705786392L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private long id;

    @Column(name="Version")
    @Version private int version;

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

 
}