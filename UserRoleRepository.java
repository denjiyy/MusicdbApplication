package bg.musicapp.musicdb.repository;

import bg.musicapp.musicdb.model.entities.UserRole;
import bg.musicapp.musicdb.model.entities.UserRoleEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {

  Optional<UserRoleEntity> findByRole(UserRole role);
}
