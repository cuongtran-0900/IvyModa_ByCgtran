package ivymoda.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class UserAccountTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static UserAccount getUserAccountSample1() {
        return new UserAccount().id(1L).name("name1").email("email1").password("password1").address("address1");
    }

    public static UserAccount getUserAccountSample2() {
        return new UserAccount().id(2L).name("name2").email("email2").password("password2").address("address2");
    }

    public static UserAccount getUserAccountRandomSampleGenerator() {
        return new UserAccount()
            .id(longCount.incrementAndGet())
            .name(UUID.randomUUID().toString())
            .email(UUID.randomUUID().toString())
            .password(UUID.randomUUID().toString())
            .address(UUID.randomUUID().toString());
    }
}
