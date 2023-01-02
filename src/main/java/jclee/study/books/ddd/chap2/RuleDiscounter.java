package jclee.study.books.ddd.chap2;

import java.util.List;

import jclee.study.books.ddd.chap1.Money;
import jclee.study.books.ddd.chap1.OrderLine;

public interface RuleDiscounter {
	Money applyRules(Customer customer, List<OrderLine> orderLines);
}
