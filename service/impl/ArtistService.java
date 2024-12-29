package service;

import src.main.model.entities.ArtistEntity;
import src.main.model.view.ArtistViewModel;
import java.util.List;

public interface ArtistService {

  List<String> findAllArtists();

  void seedArtists();

    ArtistEntity findByName(String artist);
}
