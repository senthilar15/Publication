package org.mag.subscribe;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Entity(name="Lifetime")
@DiscriminatorValue("2")
public class LifetimeSubscription extends Subscription {

	private static final long serialVersionUID = 1478751020028340562L;
	private boolean eliteClub;
	
	
	@Basic(fetch=FetchType.LAZY)
    @Column(name="EliteClub")
    private boolean getEliteClub () {
     return eliteClub;
	}
    public void setEliteClub (boolean elite) {
     this.eliteClub = elite;
    }

   
}