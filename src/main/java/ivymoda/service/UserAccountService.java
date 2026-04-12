package ivymoda.service;

import ivymoda.service.dto.UserAccountDTO;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link ivymoda.domain.UserAccount}.
 */
public interface UserAccountService {
    /**
     * Save a userAccount.
     *
     * @param userAccountDTO the entity to save.
     * @return the persisted entity.
     */
    UserAccountDTO save(UserAccountDTO userAccountDTO);

    /**
     * Updates a userAccount.
     *
     * @param userAccountDTO the entity to update.
     * @return the persisted entity.
     */
    UserAccountDTO update(UserAccountDTO userAccountDTO);

    /**
     * Partially updates a userAccount.
     *
     * @param userAccountDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<UserAccountDTO> partialUpdate(UserAccountDTO userAccountDTO);

    /**
     * Get all the userAccounts.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<UserAccountDTO> findAll(Pageable pageable);

    /**
     * Get all the UserAccountDTO where Cart is {@code null}.
     *
     * @return the {@link List} of entities.
     */
    List<UserAccountDTO> findAllWhereCartIsNull();

    /**
     * Get the "id" userAccount.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<UserAccountDTO> findOne(Long id);

    /**
     * Delete the "id" userAccount.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
