package org.mag.subscribe;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="ContractType")
public class Contract extends Document {

	private static final long serialVersionUID = 7558311453834449996L;
	
    private String terms;

    @Lob
    @Column(name="Terms",columnDefinition="VARCHAR(MAX)")
	public String getTerms() {
		return terms;
	}

	public void setTerms(String terms) {
		this.terms = terms;
	}

    
}
