package bg.musicapp.musicdb;

import bg.musicapp.musicdb.service.ArtistService;
import bg.musicapp.musicdb.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MusicDBApplicationInit implements CommandLineRunner {

  private final UserService userService;
  private final ArtistService artistService;

  public MusicDBApplicationInit(UserService userService,
      ArtistService artistService) {
    this.userService = userService;
    this.artistService = artistService;
  }

  @Override
  public void run(String... args) throws Exception {
    userService.seedUsers();
    artistService.seedArtists();
  }
}
