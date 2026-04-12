package ivymoda.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class ProductVariantTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));
    private static final AtomicInteger intCount = new AtomicInteger(random.nextInt() + (2 * Short.MAX_VALUE));

    public static ProductVariant getProductVariantSample1() {
        return new ProductVariant().id(1L).productSize("productSize1").color("color1").stock(1).imageUrl("imageUrl1");
    }

    public static ProductVariant getProductVariantSample2() {
        return new ProductVariant().id(2L).productSize("productSize2").color("color2").stock(2).imageUrl("imageUrl2");
    }

    public static ProductVariant getProductVariantRandomSampleGenerator() {
        return new ProductVariant()
            .id(longCount.incrementAndGet())
            .productSize(UUID.randomUUID().toString())
            .color(UUID.randomUUID().toString())
            .stock(intCount.incrementAndGet())
            .imageUrl(UUID.randomUUID().toString());
    }
}
