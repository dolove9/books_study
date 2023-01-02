package jclee.study.books.ddd.chap2;

public interface CustomerRepository {
	public Customer findById(String customerId);
}
