package jclee.study.books.ddd.chap1;

public enum OrderState {
	PAYMENT_WATING,
	PREPARINMG{
		public boolean isShippingChangeable() {
			return true;
		}
	}, SHIPPED, DELIVERING, DELIVERY_COMPLETED, CANCELED;

	public boolean isShippingChangeable() {
		return false;
	}
}
