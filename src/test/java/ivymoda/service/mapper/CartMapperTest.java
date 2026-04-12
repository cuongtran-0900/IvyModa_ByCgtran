package ivymoda.service.mapper;

import static ivymoda.domain.CartAsserts.*;
import static ivymoda.domain.CartTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CartMapperTest {

    private CartMapper cartMapper;

    @BeforeEach
    void setUp() {
        cartMapper = new CartMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getCartSample1();
        var actual = cartMapper.toEntity(cartMapper.toDto(expected));
        assertCartAllPropertiesEquals(expected, actual);
    }
}
