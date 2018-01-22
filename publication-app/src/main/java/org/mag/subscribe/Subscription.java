package org.mag.subscribe;

import java.io.Serializable;
import java.sql.Date;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.mag.Magazine;

@Entity
@Table(name="Subscription")
@DiscriminatorColumn(name="Kind", discriminatorType=DiscriminatorType.INTEGER)
@DiscriminatorValue("1")
public class Subscription implements Serializable {

	private static final long serialVersionUID = -8683003787187928598L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
    private long id;

    @Column(name="Version")
    @Version private int version;

    @Column(name="StartDate")
    private Date startDate;

    @Column(name="Payment")
    private double payment;

    @OneToMany(cascade={CascadeType.PERSIST,CascadeType.REMOVE})
    @MapKey(name="num")
    @JoinTable(name="SubscribedItems",
        joinColumns=@JoinColumn(name="SubscriptionId"),
        inverseJoinColumns=@JoinColumn(name="Itemid"))
    private Map<Long,LineItem> items;

   

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



	public Date getStartDate() {
		return startDate;
	}



	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}



	public double getPayment() {
		return payment;
	}



	public void setPayment(double payment) {
		this.payment = payment;
	}



	public Map<Long, LineItem> getItems() {
		return items;
	}



	public void setItems(Map<Long, LineItem> items) {
		this.items = items;
	}



	@Entity
    @Table(name="LineItem")
    public static class LineItem  extends Contract {

      
		private static final long serialVersionUID = 3055792425435803930L;

		@Column(name="Comments")
        private String comments;

		@Column(name="Price")
		private double price;
		
		@Column(name="Number")
        private long num;

        @ManyToOne
        @JoinColumns({
             @JoinColumn(name="MagazineIsbn", referencedColumnName="Isbn"),
             @JoinColumn(name="MagazineTitle", referencedColumnName="Title")
        })
        private Magazine magazine;

		public String getComments() {
			return comments;
		}

		public void setComments(String comments) {
			this.comments = comments;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public long getNum() {
			return num;
		}

		public void setNum(long num) {
			this.num = num;
		}

		public Magazine getMagazine() {
			return magazine;
		}

		public void setMagazine(Magazine magazine) {
			this.magazine = magazine;
		}
        
        
        
    }
}