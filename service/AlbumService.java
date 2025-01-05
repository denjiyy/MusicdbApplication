package bg.musicapp.musicdb.service;

import bg.musicapp.musicdb.model.entities.AlbumEntity;
import bg.musicapp.musicdb.model.service.AlbumServiceModel;
import bg.musicapp.musicdb.model.view.AlbumViewModel;

public interface AlbumService {
  void createAlbum(AlbumServiceModel serviceModel);

    AlbumViewModel findById(Long id);

    AlbumEntity findEntityById(Long albumId);
}
