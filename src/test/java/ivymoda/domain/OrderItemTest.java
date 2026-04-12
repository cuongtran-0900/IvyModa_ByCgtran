package ivymoda.domain;

import static ivymoda.domain.OrderItemTestSamples.*;
import static ivymoda.domain.OrderTestSamples.*;
import static ivymoda.domain.ProductVariantTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import ivymoda.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class OrderItemTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(OrderItem.class);
        OrderItem orderItem1 = getOrderItemSample1();
        OrderItem orderItem2 = new OrderItem();
        assertThat(orderItem1).isNotEqualTo(orderItem2);

        orderItem2.setId(orderItem1.getId());
        assertThat(orderItem1).isEqualTo(orderItem2);

        orderItem2 = getOrderItemSample2();
        assertThat(orderItem1).isNotEqualTo(orderItem2);
    }

    @Test
    void productVariantTest() {
        OrderItem orderItem = getOrderItemRandomSampleGenerator();
        ProductVariant productVariantBack = getProductVariantRandomSampleGenerator();

        orderItem.setProductVariant(productVariantBack);
        assertThat(orderItem.getProductVariant()).isEqualTo(productVariantBack);

        orderItem.productVariant(null);
        assertThat(orderItem.getProductVariant()).isNull();
    }

    @Test
    void orderTest() {
        OrderItem orderItem = getOrderItemRandomSampleGenerator();
        Order orderBack = getOrderRandomSampleGenerator();

        orderItem.setOrder(orderBack);
        assertThat(orderItem.getOrder()).isEqualTo(orderBack);

        orderItem.order(null);
        assertThat(orderItem.getOrder()).isNull();
    }
}
