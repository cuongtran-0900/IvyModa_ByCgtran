package ivymoda.service.mapper;

import static ivymoda.domain.UserAccountAsserts.*;
import static ivymoda.domain.UserAccountTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserAccountMapperTest {

    private UserAccountMapper userAccountMapper;

    @BeforeEach
    void setUp() {
        userAccountMapper = new UserAccountMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getUserAccountSample1();
        var actual = userAccountMapper.toEntity(userAccountMapper.toDto(expected));
        assertUserAccountAllPropertiesEquals(expected, actual);
    }
}
