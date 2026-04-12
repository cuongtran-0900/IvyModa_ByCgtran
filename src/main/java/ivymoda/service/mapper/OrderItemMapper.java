package ivymoda.service.mapper;

import ivymoda.domain.Order;
import ivymoda.domain.OrderItem;
import ivymoda.domain.ProductVariant;
import ivymoda.service.dto.OrderDTO;
import ivymoda.service.dto.OrderItemDTO;
import ivymoda.service.dto.ProductVariantDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link OrderItem} and its DTO {@link OrderItemDTO}.
 */
@Mapper(componentModel = "spring")
public interface OrderItemMapper extends EntityMapper<OrderItemDTO, OrderItem> {
    @Mapping(target = "productVariant", source = "productVariant", qualifiedByName = "productVariantId")
    @Mapping(target = "order", source = "order", qualifiedByName = "orderId")
    OrderItemDTO toDto(OrderItem s);

    @Named("productVariantId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ProductVariantDTO toDtoProductVariantId(ProductVariant productVariant);

    @Named("orderId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    OrderDTO toDtoOrderId(Order order);
}
