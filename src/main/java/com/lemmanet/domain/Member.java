package com.lemmanet.domain;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Table(name = "member", schema = "malankara")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "memberId")
    private String memberId;
    @Column(name = "description")
    private String description;
    @Column(name = "imageUrl")
    private String imageUrl;
    @Column(name = "age")
    private Integer age;
    @Column(name = "firstName")
	private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "nickName")
    private String nickName;
    @Column(name = "email")
    private String email;
    @Column(name = "cellPhone")
    private String cellPhone;
    @Column(name = "education")
    private String education;
    @Column(name = "profession")
    private String profession;
    @Column(name = "religion")
    private String religion;
    @Column(name = "address")
    private String address;
    @Column(name = "height")
    private String height;
    @Column(name = "linkedInURL")
    private URL linkedInURL;
    @Column(name = "faceBookLink")
    private URL faceBookLink;
    
    @OneToMany(targetEntity=MemberReference.class, mappedBy="member")
    @ElementCollection(targetClass=MemberReference.class)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<MemberReference> memberReference;
    
    
    @OneToMany(targetEntity=MemberEducation.class, mappedBy="member")
    @ElementCollection(targetClass=MemberEducation.class)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<MemberEducation> memberEducation;
    
    public enum Provider {
        LOCAL, GOOGLE
    }
	@Enumerated(EnumType.STRING)
	private Provider provider;
	public Provider getProvider() {
	return provider;
	}
	
	public void setProvider(Provider provider) {
	this.provider = provider;
	}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

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
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * @param nickName the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
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
	 * @return the linkedInURL
	 */
	public URL getLinkedInURL() {
		return linkedInURL;
	}

	/**
	 * @param linkedInURL the linkedInURL to set
	 */
	public void setLinkedInURL(URL linkedInURL) {
		this.linkedInURL = linkedInURL;
	}

	/**
	 * @return the faceBookLink
	 */
	public URL getFaceBookLink() {
		return faceBookLink;
	}

	/**
	 * @param faceBookLink the faceBookLink to set
	 */
	public void setFaceBookLink(URL faceBookLink) {
		this.faceBookLink = faceBookLink;
	}

	/**
	 * @return the education
	 */
	public String getEducation() {
		return education;
	}

	/**
	 * @param education the education to set
	 */
	public void setEducation(String education) {
		this.education = education;
	}

	/**
	 * @return the profession
	 */
	public String getProfession() {
		return profession;
	}

	/**
	 * @param profession the profession to set
	 */
	public void setProfession(String profession) {
		this.profession = profession;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the height
	 */
	public String getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(String height) {
		this.height = height;
	}

	/**
	 * @return the religion
	 */
	public String getReligion() {
		return religion;
	}

	/**
	 * @param religion the religion to set
	 */
	public void setReligion(String religion) {
		this.religion = religion;
	}

	/**
	 * @return the memberReference
	 */
	public List<MemberReference> getMemberReference() {
		return memberReference;
	}

	/**
	 * @param memberReference the memberReference to set
	 */
	public void setMemberReference(List<MemberReference> memberReference) {
		this.memberReference = memberReference;
	}

	/**
	 * @return the memberEducation
	 */
	public List<MemberEducation> getMemberEducation() {
		return memberEducation;
	}

	/**
	 * @param memberEducation the memberEducation to set
	 */
	public void setMemberEducation(List<MemberEducation> memberEducation) {
		this.memberEducation = memberEducation;
	}
}
