package jclee.study.books.ddd.chap1;

public class OrderLine {
	private Product product;
	private Money price;
	private int quantity;
	private Money amount;

	public Product getProduct() {
		return product;
	}

	public Money getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public Money getAmount() {
		return amount;
	}

	public OrderLine(Product product, Money price, int quantity) {
		this.product = product;
		this.price = price;
		this.quantity = quantity;
		this.amount = calculateAmounts();
	}

	private Money calculateAmounts() {
		return new Money(this.price.getValue() * this. quantity);
	}
}
