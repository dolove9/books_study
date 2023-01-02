package jclee.study.books.ddd.chap2;

import jclee.study.books.ddd.chap1.Member;
import jclee.study.books.ddd.chap1.Order;
import jclee.study.books.ddd.chap1.ShippingInfo;
import org.springframework.transaction.annotation.Transactional;

public class CancelOrderService {
	private OrderRepository orderRepository;

	@Transactional //응용 서비스는 트랜잭션을 관리해야한다.
	public void cancel(OrderNumber number) throws NoOrderException {
		Order order = orderRepository.findByNumber(number);
		if(order == null) throw new NoOrderException(number);
		order.cancel();
	}

	public void changeShippingInfo(OrderId id, ShippingInfo newShippingInfo, boolean useNewShippingAddrAsMemberAddr) throws
		NoOrderException, OrderNotFoundExceptio {
		Order order = orderRepository.findById(id);
		if(order == null){
			throw new OrderNotFoundExceptio();
		}

		order.shippingTo(newShippingInfo);

		if(useNewShippingAddrAsMemberAddr){
			Member member = findMember(order.getOrderer());
			member.changeAddress(newShippingInfo.getAddress());
		}
	}

	private Member findMember(Object orderer) {
		return new Member();
	}

	private class NoOrderException extends Throwable {
		public NoOrderException(OrderNumber number) {
		}
	}

	private class OrderNotFoundExceptio extends Throwable {
	}
}
