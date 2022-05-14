package com.lemmanet.domain;

import javax.persistence.*;

@Entity
@Table(name = "memberreference", schema = "malankara")
public class MemberReference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idreference;
    
    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;
    
	@Column(name = "firstName")
	private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "cellPhone")
    private String cellPhone;


	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the cellPhone
	 */
	public String getCellPhone() {
		return cellPhone;
	}

	/**
	 * @param cellPhone the cellPhone to set
	 */
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	  
    /**
	 * @return the member
	 */
	public Member getMember() {
		return member;
	}

	/**
	 * @param member the member to set
	 */
	public void setMember(Member member) {
		this.member = member;
	}

	/**
	 * @return the idreference
	 */
	public Integer getIdreference() {
		return idreference;
	}

	/**
	 * @param idreference the idreference to set
	 */
	public void setIdreference(Integer idreference) {
		this.idreference = idreference;
	}

}
