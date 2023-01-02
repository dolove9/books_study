package jclee.study.books.ddd.chap1;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OrderStateTest {
	@Test
	void orderStateTest(){
		assertThat(OrderState.DELIVERY_COMPLETED.isShippingChangeable()).isFalse();
		assertThat(OrderState.PREPARINMG.isShippingChangeable()).isTrue();
	}
}