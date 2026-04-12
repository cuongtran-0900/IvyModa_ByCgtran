package ivymoda.service.mapper;

import static ivymoda.domain.OrderItemAsserts.*;
import static ivymoda.domain.OrderItemTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderItemMapperTest {

    private OrderItemMapper orderItemMapper;

    @BeforeEach
    void setUp() {
        orderItemMapper = new OrderItemMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getOrderItemSample1();
        var actual = orderItemMapper.toEntity(orderItemMapper.toDto(expected));
        assertOrderItemAllPropertiesEquals(expected, actual);
    }
}
