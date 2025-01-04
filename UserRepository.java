package bg.musicapp.musicdb.repository;

import bg.musicapp.musicdb.model.services.UserEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<UserEntity, Long>  {

  Optional<UserEntity> findByUsername(String userName);
}
