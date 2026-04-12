package ivymoda.service.mapper;

import ivymoda.domain.Notification;
import ivymoda.domain.Order;
import ivymoda.service.dto.NotificationDTO;
import ivymoda.service.dto.OrderDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Notification} and its DTO {@link NotificationDTO}.
 */
@Mapper(componentModel = "spring")
public interface NotificationMapper extends EntityMapper<NotificationDTO, Notification> {
    @Mapping(target = "order", source = "order", qualifiedByName = "orderId")
    NotificationDTO toDto(Notification s);

    @Named("orderId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    OrderDTO toDtoOrderId(Order order);
}
