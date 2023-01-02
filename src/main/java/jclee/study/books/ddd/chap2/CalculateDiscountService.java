package jclee.study.books.ddd.chap2;

import java.util.List;

import jclee.study.books.ddd.chap1.Money;
import jclee.study.books.ddd.chap1.OrderLine;

public class CalculateDiscountService {
	private RuleDiscounter ruleDiscounter;
	private CustomerRepository customerRepository;

	public CalculateDiscountService(RuleDiscounter ruleDiscounter) {
		this.ruleDiscounter = ruleDiscounter;
	}

	public Money calculateDiscount(List<OrderLine> orderLines, String customerId){
		Customer customer = findCustomer(customerId);
		return ruleDiscounter.applyRules(customer, orderLines);
	}

	private Customer findCustomer(String customerId) {
		return customerRepository.findById(customerId);
	}
}
