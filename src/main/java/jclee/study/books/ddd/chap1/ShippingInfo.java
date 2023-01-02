package jclee.study.books.ddd.chap1;

import lombok.Getter;

@Getter
public class ShippingInfo {
	private Receiver receiver;
	private Address address;

	public ShippingInfo(Receiver receiver, Address address) {
		this.receiver = receiver;
		this.address = address;
	}
}
