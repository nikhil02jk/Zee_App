package com.zee.zee5_app.dto;

import com.zee.zee5_app.exception.InvalidIdLengthException;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Subscription implements Comparable<Subscription> {
	
	public Subscription(String id, String dateOfPurchase, String expiryDate, float amount, String paymentMode,
			String status, String type, String autoRenewal, String regId) throws InvalidIdLengthException {
		super();
		this.setId(id);
		this.dateOfPurchase = dateOfPurchase;
		this.expiryDate = expiryDate;
		this.amount = amount;
		this.paymentMode = paymentMode;
		this.status = status;
		this.type = type;
		this.autoRenewal = autoRenewal;
		this.regId = regId;
	}

	@Setter(value = AccessLevel.NONE)
	private String id;
	private String dateOfPurchase;
	private String expiryDate;
	private float amount;
	private String paymentMode;
	private String status;
	private String type;
	private String autoRenewal;
	private String regId;
	
	public void setId(String id) throws InvalidIdLengthException {
		if(id.length()<6)
			throw new InvalidIdLengthException("id length is less than 6");
		this.id = id;
	}
	
	@Override
	public int compareTo(Subscription o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}

}
