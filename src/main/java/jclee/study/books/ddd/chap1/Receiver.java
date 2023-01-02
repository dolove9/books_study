package jclee.study.books.ddd.chap1;

import lombok.Getter;

@Getter
public class Receiver {
	public String receiverName;
	public String receiverPhoneNumber;

	public Receiver(String receiverName, String receiverPhoneNumber) {
		this.receiverName = receiverName;
		this.receiverPhoneNumber = receiverPhoneNumber;
	}
}