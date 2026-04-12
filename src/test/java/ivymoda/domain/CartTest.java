package ivymoda.domain;

import static ivymoda.domain.CartItemTestSamples.*;
import static ivymoda.domain.CartTestSamples.*;
import static ivymoda.domain.UserAccountTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import ivymoda.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class CartTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Cart.class);
        Cart cart1 = getCartSample1();
        Cart cart2 = new Cart();
        assertThat(cart1).isNotEqualTo(cart2);

        cart2.setId(cart1.getId());
        assertThat(cart1).isEqualTo(cart2);

        cart2 = getCartSample2();
        assertThat(cart1).isNotEqualTo(cart2);
    }

    @Test
    void userTest() {
        Cart cart = getCartRandomSampleGenerator();
        UserAccount userAccountBack = getUserAccountRandomSampleGenerator();

        cart.setUser(userAccountBack);
        assertThat(cart.getUser()).isEqualTo(userAccountBack);

        cart.user(null);
        assertThat(cart.getUser()).isNull();
    }

    @Test
    void itemsTest() {
        Cart cart = getCartRandomSampleGenerator();
        CartItem cartItemBack = getCartItemRandomSampleGenerator();

        cart.addItems(cartItemBack);
        assertThat(cart.getItems()).containsOnly(cartItemBack);
        assertThat(cartItemBack.getCart()).isEqualTo(cart);

        cart.removeItems(cartItemBack);
        assertThat(cart.getItems()).doesNotContain(cartItemBack);
        assertThat(cartItemBack.getCart()).isNull();

        cart.items(new HashSet<>(Set.of(cartItemBack)));
        assertThat(cart.getItems()).containsOnly(cartItemBack);
        assertThat(cartItemBack.getCart()).isEqualTo(cart);

        cart.setItems(new HashSet<>());
        assertThat(cart.getItems()).doesNotContain(cartItemBack);
        assertThat(cartItemBack.getCart()).isNull();
    }
}
