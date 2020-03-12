package com.test.pca.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "Cards")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CardDataEntity implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String cardNumber;
	private int cardExpirationMonth;
	private int cardExpirationDay;
	private int cardExpirationYear;
	private int cardCCV;
	@ManyToOne(optional = false)
	@JoinColumn(name = "CardHolder", nullable = false)
	private UserEntity cardHolder;

	public CardDataEntity(String cardNumber, int cardExpirationMonth, int cardExpirationDay, int cardExpirationYear, int cardCCV, UserEntity cardHolder) {
		this.cardNumber = cardNumber;
		this.cardExpirationMonth = cardExpirationMonth;
		this.cardExpirationDay = cardExpirationDay;
		this.cardExpirationYear = cardExpirationYear;
		this.cardCCV = cardCCV;
		this.cardHolder = cardHolder;
	}
}
