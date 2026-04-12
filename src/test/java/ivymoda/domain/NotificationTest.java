package ivymoda.domain;

import static ivymoda.domain.NotificationTestSamples.*;
import static ivymoda.domain.OrderTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import ivymoda.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class NotificationTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Notification.class);
        Notification notification1 = getNotificationSample1();
        Notification notification2 = new Notification();
        assertThat(notification1).isNotEqualTo(notification2);

        notification2.setId(notification1.getId());
        assertThat(notification1).isEqualTo(notification2);

        notification2 = getNotificationSample2();
        assertThat(notification1).isNotEqualTo(notification2);
    }

    @Test
    void orderTest() {
        Notification notification = getNotificationRandomSampleGenerator();
        Order orderBack = getOrderRandomSampleGenerator();

        notification.setOrder(orderBack);
        assertThat(notification.getOrder()).isEqualTo(orderBack);

        notification.order(null);
        assertThat(notification.getOrder()).isNull();
    }
}
