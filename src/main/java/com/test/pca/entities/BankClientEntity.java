package com.test.pca.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Clients")
public class BankClientEntity implements Serializable {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//private Long id;
	@Column(name="fullName")
	private String fullName;
	@Email
	@Column(name="emailAddress")
	private String email;
	@Column(name="phoneNumber")
	private String phone;
	@Temporal(TemporalType.DATE)
	@Column(name="clientJoinDate")
	private Calendar joinDate;
	@Column(name="cin")
	private String identityCardNumber;
	@OneToMany(mappedBy = "bankClientEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<BankCardEntity> cardsOwned;
	@OneToMany(mappedBy = "bankClientEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<BankAccountEntity> bankAccounts;

	public BankClientEntity(String fullName, String email, String phone, Calendar joinDate, String identityCardNumber) {
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
		this.joinDate = joinDate;
		this.identityCardNumber = identityCardNumber;
	}
}
