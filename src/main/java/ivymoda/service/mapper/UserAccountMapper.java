package ivymoda.service.mapper;

import ivymoda.domain.Role;
import ivymoda.domain.UserAccount;
import ivymoda.service.dto.RoleDTO;
import ivymoda.service.dto.UserAccountDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link UserAccount} and its DTO {@link UserAccountDTO}.
 */
@Mapper(componentModel = "spring")
public interface UserAccountMapper extends EntityMapper<UserAccountDTO, UserAccount> {
    @Mapping(target = "role", source = "role", qualifiedByName = "roleId")
    UserAccountDTO toDto(UserAccount s);

    @Named("roleId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    RoleDTO toDtoRoleId(Role role);
}
