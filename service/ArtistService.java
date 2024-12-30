package bg.musicapp.musicdb.service;

import bg.musicapp.musicdb.model.entities.ArtistEntity;
import bg.musicapp.musicdb.model.view.ArtistViewModel;
import java.util.List;

public interface ArtistService {

  List<String> findAllArtists();

  void seedArtists();

    ArtistEntity findByName(String artist);
}
