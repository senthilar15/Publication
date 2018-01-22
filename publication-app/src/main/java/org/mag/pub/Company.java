package org.mag.pub;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.mag.Magazine;
import org.mag.subscribe.Subscription;

@Entity
@Table(name="Company")
public class Company implements Serializable{

	private static final long serialVersionUID = 4657895403595977189L;

	@Column(name="CompanyId")
    @Id private long id;

    @Column(name="Version")
    @Version private int version;

    private String name;

    @Column(name="Revenue")
    private double revenue;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name="street", column=@Column(name="Street")),
        @AttributeOverride(name="city", column=@Column(name="City"))
    })
    private Address address;
    
    @OneToMany(mappedBy="publisher", cascade=CascadeType.PERSIST)
    private Collection<Magazine> mags;

   /* @OneToMany(cascade=CascadeType.PERSIST ,CascadeType.REMOVE)*/
    @OneToMany(cascade={CascadeType.PERSIST ,CascadeType.REMOVE} )
    @JoinTable(name="CompanySubscriptions",
        joinColumns=@JoinColumn(name="CompanyId"),
        inverseJoinColumns=@JoinColumn(name="SubscriptionId"))
    private Collection<Subscription> subscriptions;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getRevenue() {
		return revenue;
	}

	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Collection<Magazine> getMags() {
		return mags;
	}

	public void setMags(Collection<Magazine> mags) {
		this.mags = mags;
	}

	public Collection<Subscription> getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(Collection<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}

   
}