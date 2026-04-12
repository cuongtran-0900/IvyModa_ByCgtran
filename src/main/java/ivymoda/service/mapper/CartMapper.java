package ivymoda.service.mapper;

import ivymoda.domain.Cart;
import ivymoda.domain.UserAccount;
import ivymoda.service.dto.CartDTO;
import ivymoda.service.dto.UserAccountDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Cart} and its DTO {@link CartDTO}.
 */
@Mapper(componentModel = "spring")
public interface CartMapper extends EntityMapper<CartDTO, Cart> {
    @Mapping(target = "user", source = "user", qualifiedByName = "userAccountId")
    CartDTO toDto(Cart s);

    @Named("userAccountId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    UserAccountDTO toDtoUserAccountId(UserAccount userAccount);
}
