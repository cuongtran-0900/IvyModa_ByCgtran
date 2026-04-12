package ivymoda.service.impl;

import ivymoda.domain.UserAccount;
import ivymoda.repository.UserAccountRepository;
import ivymoda.service.UserAccountService;
import ivymoda.service.dto.UserAccountDTO;
import ivymoda.service.mapper.UserAccountMapper;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link ivymoda.domain.UserAccount}.
 */
@Service
@Transactional
public class UserAccountServiceImpl implements UserAccountService {

    private static final Logger LOG = LoggerFactory.getLogger(UserAccountServiceImpl.class);

    private final UserAccountRepository userAccountRepository;

    private final UserAccountMapper userAccountMapper;

    public UserAccountServiceImpl(UserAccountRepository userAccountRepository, UserAccountMapper userAccountMapper) {
        this.userAccountRepository = userAccountRepository;
        this.userAccountMapper = userAccountMapper;
    }

    @Override
    public UserAccountDTO save(UserAccountDTO userAccountDTO) {
        LOG.debug("Request to save UserAccount : {}", userAccountDTO);
        UserAccount userAccount = userAccountMapper.toEntity(userAccountDTO);
        userAccount = userAccountRepository.save(userAccount);
        return userAccountMapper.toDto(userAccount);
    }

    @Override
    public UserAccountDTO update(UserAccountDTO userAccountDTO) {
        LOG.debug("Request to update UserAccount : {}", userAccountDTO);
        UserAccount userAccount = userAccountMapper.toEntity(userAccountDTO);
        userAccount = userAccountRepository.save(userAccount);
        return userAccountMapper.toDto(userAccount);
    }

    @Override
    public Optional<UserAccountDTO> partialUpdate(UserAccountDTO userAccountDTO) {
        LOG.debug("Request to partially update UserAccount : {}", userAccountDTO);

        return userAccountRepository
            .findById(userAccountDTO.getId())
            .map(existingUserAccount -> {
                userAccountMapper.partialUpdate(existingUserAccount, userAccountDTO);

                return existingUserAccount;
            })
            .map(userAccountRepository::save)
            .map(userAccountMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<UserAccountDTO> findAll(Pageable pageable) {
        LOG.debug("Request to get all UserAccounts");
        return userAccountRepository.findAll(pageable).map(userAccountMapper::toDto);
    }

    /**
     *  Get all the userAccounts where Cart is {@code null}.
     *  @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<UserAccountDTO> findAllWhereCartIsNull() {
        LOG.debug("Request to get all userAccounts where Cart is null");
        return StreamSupport.stream(userAccountRepository.findAll().spliterator(), false)
            .filter(userAccount -> userAccount.getCart() == null)
            .map(userAccountMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserAccountDTO> findOne(Long id) {
        LOG.debug("Request to get UserAccount : {}", id);
        return userAccountRepository.findById(id).map(userAccountMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete UserAccount : {}", id);
        userAccountRepository.deleteById(id);
    }
}
