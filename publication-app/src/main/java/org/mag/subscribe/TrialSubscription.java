package org.mag.subscribe;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name="Trial")
@DiscriminatorValue("3")
public class TrialSubscription extends Subscription {

	private static final long serialVersionUID = 1476634743782466046L;
	
	private Date endDate;
	
	@Column(name="EndDate")
    public Date getEndDate () {
       return endDate;
	}
    public void setEndDate (Date endDate) {
    	
    	this.endDate = endDate;
    }

}
