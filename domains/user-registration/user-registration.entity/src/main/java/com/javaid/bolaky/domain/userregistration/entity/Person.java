package com.javaid.bolaky.domain.userregistration.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.collections15.set.ListOrderedSet;
import org.apache.commons.collections15.set.UnmodifiableSet;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.javaid.bolaky.domain.jpa.entity.AbstractTimestampUsernameEntity;
import com.javaid.bolaky.domain.userregistration.entity.enumerated.AgeGroup;
import com.javaid.bolaky.domain.userregistration.entity.enumerated.Gender;
import com.javaid.bolaky.domain.userregistration.entity.enumerated.Role;
import com.javaid.bolaky.domain.userregistration.enumerated.PersonErrorCode;
import com.javaid.bolaky.domain.userregistration.hibernate.constraint.AgeAndLicenseCheck;
import com.javaid.bolaky.domain.userregistration.hibernate.group.AgeGroupDataRule;
import com.javaid.bolaky.domain.userregistration.hibernate.group.GenderDataRule;
import com.javaid.bolaky.domain.userregistration.hibernate.group.MandatoryDataRules;
import com.javaid.bolaky.domain.userregistration.hibernate.group.ValidLicenseDataRule;

@Entity
@Table(name = "PERSON")
@AgeAndLicenseCheck(groups = ValidLicenseDataRule.class)
@TypeDefs({
		@TypeDef(name = "hibernate_persistentDateTime", typeClass = org.joda.time.contrib.hibernate.PersistentDateTime.class),
		@TypeDef(name = "gender_user_types", typeClass = com.javaid.bolaky.domain.hibernate.jpa.enumeration.GenericEnumUserType.class, parameters = @Parameter(name = "type", value = "com.javaid.bolaky.domain.userregistration.entity.enumerated.Gender")),
		@TypeDef(name = "age_user_types", typeClass = com.javaid.bolaky.domain.hibernate.jpa.enumeration.GenericEnumUserType.class, parameters = @Parameter(name = "type", value = "com.javaid.bolaky.domain.userregistration.entity.enumerated.AgeGroup")) })
public class Person extends AbstractTimestampUsernameEntity {

	private static final long serialVersionUID = -687567688155349393L;

	@Id
	@Size(min = 6, groups = MandatoryDataRules.class, message = "UM1")
	@NotNull(groups = MandatoryDataRules.class, message = "UM2")
	@Column(name = "USERNAME")
	private String username;

	@Size(min = 8, groups = MandatoryDataRules.class, message = "UM3")
	@NotNull(groups = MandatoryDataRules.class, message = "UM4")
	@Column(name = "PASSWORD")
	private String password;

	@NotNull(groups = MandatoryDataRules.class, message = "UM5")
	@Column(name = "FIRSTNAME")
	private String firstname;

	@NotNull(groups = MandatoryDataRules.class, message = "UM6")
	@Column(name = "LASTNAME")
	private String lastname;

	@Column(name = "ACTIVE")
	@Type(type = "boolean")
	private Boolean active = Boolean.TRUE;

	@Column(name = "AGE")
	private Integer age;

	@NotNull(groups = AgeGroupDataRule.class, message = "U25")
	@Column(name = "AGE_GROUP")
	@Type(type = "age_user_types")
	private AgeGroup ageGroup;

	@Column(name = "ROLE")
	@Enumerated(EnumType.STRING)
	private Role role = Role.ROLE_USER;

	@NotNull(groups = GenderDataRule.class, message = "U30")
	@Column(name = "GENDER")
	@Type(type = "gender_user_types")
	private Gender gender;

	@NotNull(groups = ValidLicenseDataRule.class, message = "U35")
	@Column(name = "VALID_LICENSE_IND")
	@Type(type = "yes_no")
	private Boolean validLicense;

	@Column(name = "VEHICLE_OWNER")
	@Type(type = "yes_no")
	private Boolean vehicleOwner;

	@Column(name = "SHARE_COST_IND")
	@Type(type = "yes_no")
	private Boolean shareCost;

	@Column(name = "SHARE_DRIVING_IND")
	@Type(type = "yes_no")
	private Boolean shareDriving;

	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
	private Set<Authority> authorities = new ListOrderedSet<Authority>();

	@Embedded
	private UserPreferences userPreferences = new UserPreferences();

	@Valid
	@Embedded
	private ContactDetails contactDetails = new ContactDetails(this);

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public Boolean isActive() {
		return active;
	}

	public Integer getAge() {
		return age;
	}

	public AgeGroup getAgeGroup() {
		return ageGroup;
	}

	public Role getRole() {
		return role;
	}

	public Gender getGender() {
		return gender;
	}

	public Boolean hasValidLicense() {
		return validLicense;
	}

	public Boolean isAVehicleOwner() {
		return vehicleOwner;
	}

	public Boolean canShareCost() {
		return shareCost;
	}

	public Boolean canShareDriving() {
		return shareDriving;
	}

	public UserPreferences getUserPreferences() {
		return userPreferences;
	}

	public Set<Authority> getAuthorities() {
		return authorities;
	}

	public void addAuthority(Authority authority) {

		if (authority != null) {
			authority.setPerson(this);
		}

		System.out.println(this.authorities.add(authority));
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public void setAgeGroup(AgeGroup ageGroup) {
		this.ageGroup = ageGroup;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public void setValidLicense(Boolean validLicense) {
		this.validLicense = validLicense;
	}

	public void setVehicleOwner(Boolean vehicleOwner) {
		this.vehicleOwner = vehicleOwner;
	}

	public void setShareCost(Boolean shareCost) {
		this.shareCost = shareCost;
	}

	public void setShareDriving(Boolean shareDriving) {
		this.shareDriving = shareDriving;
	}

	public ContactDetails getContactDetails() {
		return contactDetails;
	}

	public Set<PersonErrorCode> validate(
			@SuppressWarnings("rawtypes") Class... clazz) {

		Set<PersonErrorCode> personErrorCodes = new ListOrderedSet<PersonErrorCode>();
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<Person>> constraintViolations = validator
				.validate(this, clazz);

		for (ConstraintViolation<Person> constraintViolation : constraintViolations) {

			personErrorCodes.add(PersonErrorCode
					.convertFrom(constraintViolation.getMessage()));
		}

		return UnmodifiableSet.decorate(personErrorCodes);
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}

		Person rhs = (Person) obj;

		return new EqualsBuilder().appendSuper(super.equals(obj))
				.append(username, rhs.username).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(9, 11).append(username).toHashCode();

	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
