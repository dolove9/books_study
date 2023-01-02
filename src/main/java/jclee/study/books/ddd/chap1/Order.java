package jclee.study.books.ddd.chap1;

import static com.google.common.base.Preconditions.*;

import java.util.List;

public class Order {
	private String orderNumber;
	private List<OrderLine> orderLines;
	private Money totalAmounts;
	private OrderState state;

	private Orderer orderer;

	private ShippingInfo shippingInfo;

	public Order(List<OrderLine> orderLines, Orderer orderer) {
		this.orderLines = orderLines;
		this.orderer = orderer;
	}

	public void setOrderLines(List<OrderLine> orderLines, ShippingInfo shippingInfo) {
		verifyAtLeastOneOrMoreOrderLines(orderLines);
		this.orderLines = orderLines;
		setShippingInfo(shippingInfo);

		calculateTotalAmounts();
	}

	private void setShippingInfo(ShippingInfo shippingInfo) {
		this.shippingInfo = checkNotNull(shippingInfo, "shippingInfo");
	}

	public void changeShippingInfo(ShippingInfo newShippingInfo){
		verifyNotYetShipped();
		setShippingInfo(newShippingInfo);
	}

	private void verifyAtLeastOneOrMoreOrderLines(List<OrderLine> orderLines) {
		if(orderLines == null || orderLines.isEmpty()){
			throw new IllegalArgumentException("no OrderLine");
		}
	}

	private void calculateTotalAmounts() {
		int sum = orderLines.stream().mapToInt(x -> x.getAmount().getValue()).sum();
		this.totalAmounts = new Money(sum);

	}
	public void changeShippinged(){}
	public void cancel(){
		verifyNotYetShipped();
		this.state = OrderState.CANCELED;
	}

	public void completePayment(){}

	private void verifyNotYetShipped() {
		if(state != OrderState.PAYMENT_WATING && state != OrderState.PREPARINMG)
			throw new IllegalStateException("already shipped");
	}

	private boolean isShippingChangeable(){
		return state == OrderState.PAYMENT_WATING || state == OrderState.PREPARINMG;
	}

	//bad case
	public void shippingTo(ShippingInfo newShippingInfo, boolean useNewShippingAddrAsMemberAddr){
		verifyNotYetShipped();
		setShippingInfo(newShippingInfo);
		if(useNewShippingAddrAsMemberAddr){
			orderer.getMember().changeAddress(newShippingInfo.getAddress());
		}
	}



	public void shippingTo(ShippingInfo newShippingInfo) {
		// TODO: 2022/12/24
	}

	public Object getOrderer() {
		return this.orderer;
	}
}
