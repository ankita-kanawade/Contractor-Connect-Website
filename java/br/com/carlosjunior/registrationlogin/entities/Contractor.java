package br.com.carlosjunior.registrationlogin.entities;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="contractor")
public class Contractor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cont_id")
	private Long id;

	@Column(name="first_name",nullable=false)
	private String firstName;

	@Column(name="email", nullable=false, unique=true)
	private String email;

	@Column(name="contact_number",nullable=false,length = 11)
	private Long contact_Number;

	@Column(name="company_name",nullable=false)
	private String company_Name;

	@Column(name="com_address",nullable=false)
	private String company_Address;

	@Column(name="bus_regNo",nullable=false)
	private String business_regNo;

	@Column(name = "description",length = 500)
	private String about_Company; 

	 @OneToMany(cascade = CascadeType.ALL, mappedBy = "contractor")
	    private Collection<Project> projects;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public Long getContact_Number() {
		return contact_Number;
	}
	public void setContact_Number(Long contact_Number) {
		this.contact_Number = contact_Number;
	}
	public String getCompany_Name() {
		return company_Name;
	}
	public void setCompany_Name(String company_Name) {
		this.company_Name = company_Name;
	}
	public String getCompany_Address() {
		return company_Address;
	}
	public void setCompany_Address(String company_Address) {
		this.company_Address = company_Address;
	}
	public String getBusiness_regNo() {
		return business_regNo;
	}
	public void setBusiness_regNo(String business_regNo) {
		this.business_regNo = business_regNo;
	}
	public String getAbout_Company() {
		return about_Company;
	}
	public void setAbout_Company(String about_Company) {
		this.about_Company = about_Company;
	}
	@Override
	public String toString() {
		return "EmployeeEntity [id=" + id + ", firstName=" + firstName + 
				",contact_Number="+contact_Number+", email=" + email   + ",company_Name="+company_Name+",company_Address="+company_Address+",business_regNo="+business_regNo+",about_Company="+about_Company+"]";
	}

}