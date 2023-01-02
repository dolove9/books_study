package jclee.study.books.ddd.chap2;

import jclee.study.books.ddd.chap1.Order;

public interface OrderRepository {
	Order findByNumber(OrderNumber number);
	void save(Order order);
	void delete(Order order);

	Order findById(OrderId id);
}
