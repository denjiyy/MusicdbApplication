package service;

import src.main.model.entities.AlbumEntity;
import src.main.model.service.AlbumServiceModel;
import src.main.model.view.AlbumViewModel;

public interface AlbumService {
  void createAlbum(AlbumServiceModel serviceModel);

    AlbumViewModel findById(Long id);

    AlbumEntity findEntityById(Long albumId);
}
