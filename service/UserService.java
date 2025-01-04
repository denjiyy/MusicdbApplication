package bg.musicapp.musicdb.service;

import bg.musicapp.musicdb.model.entities.UserEntity;
import bg.musicapp.musicdb.model.service.UserRegistrationServiceModel;

public interface UserService {

  void seedUsers();

  void registerAndLoginUser(UserRegistrationServiceModel serviceModel);

  boolean userNameExists(String username);

    UserEntity findByName(String username);

    UserEntity findById(Long id);
}
