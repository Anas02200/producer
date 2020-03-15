package com.test.pca.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

@Entity
@Table(name = "Cards")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BankCardEntity implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String cardNumber;
	@Temporal(TemporalType.DATE)
	private Calendar cardExpirationDate;
	@Temporal(TemporalType.DATE)
	private Calendar cardIssueDate;
	private int cardCCV;
	@ManyToOne(optional = false)
	@JsonIgnore
	@JoinColumn(name = "BankAccount", nullable = false)
	private BankAccountEntity bankAccountEntity ;

	//constructor

	public BankCardEntity(String cardNumber, Calendar cardExpirationDate, Calendar cardIssueDate, int cardCCV, BankAccountEntity bankAccountEntity) {
		this.cardNumber = cardNumber;
		this.cardExpirationDate = cardExpirationDate;
		this.cardIssueDate = cardIssueDate;

		this.cardCCV = cardCCV;
		this.bankAccountEntity = bankAccountEntity;

	}
}
