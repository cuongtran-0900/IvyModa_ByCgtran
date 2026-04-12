package ivymoda.service.mapper;

import ivymoda.domain.Order;
import ivymoda.domain.UserAccount;
import ivymoda.service.dto.OrderDTO;
import ivymoda.service.dto.UserAccountDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Order} and its DTO {@link OrderDTO}.
 */
@Mapper(componentModel = "spring")
public interface OrderMapper extends EntityMapper<OrderDTO, Order> {
    @Mapping(target = "user", source = "user", qualifiedByName = "userAccountId")
    OrderDTO toDto(Order s);

    @Named("userAccountId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    UserAccountDTO toDtoUserAccountId(UserAccount userAccount);
}
