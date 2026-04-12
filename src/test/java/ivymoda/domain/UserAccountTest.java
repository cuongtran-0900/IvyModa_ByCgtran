package ivymoda.domain;

import static ivymoda.domain.CartTestSamples.*;
import static ivymoda.domain.RoleTestSamples.*;
import static ivymoda.domain.UserAccountTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import ivymoda.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class UserAccountTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(UserAccount.class);
        UserAccount userAccount1 = getUserAccountSample1();
        UserAccount userAccount2 = new UserAccount();
        assertThat(userAccount1).isNotEqualTo(userAccount2);

        userAccount2.setId(userAccount1.getId());
        assertThat(userAccount1).isEqualTo(userAccount2);

        userAccount2 = getUserAccountSample2();
        assertThat(userAccount1).isNotEqualTo(userAccount2);
    }

    @Test
    void roleTest() {
        UserAccount userAccount = getUserAccountRandomSampleGenerator();
        Role roleBack = getRoleRandomSampleGenerator();

        userAccount.setRole(roleBack);
        assertThat(userAccount.getRole()).isEqualTo(roleBack);

        userAccount.role(null);
        assertThat(userAccount.getRole()).isNull();
    }

    @Test
    void cartTest() {
        UserAccount userAccount = getUserAccountRandomSampleGenerator();
        Cart cartBack = getCartRandomSampleGenerator();

        userAccount.setCart(cartBack);
        assertThat(userAccount.getCart()).isEqualTo(cartBack);
        assertThat(cartBack.getUser()).isEqualTo(userAccount);

        userAccount.cart(null);
        assertThat(userAccount.getCart()).isNull();
        assertThat(cartBack.getUser()).isNull();
    }
}
