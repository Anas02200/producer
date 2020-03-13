package com.test.pca.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

@Entity
@Table(name = "Cards")
@NoArgsConstructor
@AllArgsConstructor
@Data
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
	@JoinColumn(name = "CardHolder", nullable = false)
	private BankClientEntity bankClientEntity;


	//constructor

	public BankCardEntity(String cardNumber, Calendar cardExpirationDate, Calendar cardIssueDate, int cardCCV, BankClientEntity bankClientEntity) {
		this.cardNumber = cardNumber;
		this.cardExpirationDate = cardExpirationDate;
		this.cardIssueDate = cardIssueDate;

		this.cardCCV = cardCCV;
		this.bankClientEntity = bankClientEntity;

	}
}
