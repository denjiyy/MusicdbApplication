package bg.musicapp.musicdb.service.impl;

import bg.musicapp.musicdb.exceptions.ObjectNotFoundException;
import bg.musicapp.musicdb.model.entities.AlbumEntity;
import bg.musicapp.musicdb.model.entities.ArtistEntity;
import bg.musicapp.musicdb.model.entities.UserEntity;
import bg.musicapp.musicdb.model.service.AlbumServiceModel;
import bg.musicapp.musicdb.model.view.AlbumViewModel;
import bg.musicapp.musicdb.repository.AlbumRepository;
import bg.musicapp.musicdb.repository.UserRepository;
import bg.musicapp.musicdb.service.AlbumService;
import bg.musicapp.musicdb.service.ArtistService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;
    private final UserRepository userRepository;
    private final ArtistService artistService;
    private final ModelMapper modelMapper;

    public AlbumServiceImpl(AlbumRepository albumRepository,
                            UserRepository userRepository,
                            ArtistService artistService, ModelMapper modelMapper) {
        this.albumRepository = albumRepository;
        this.userRepository = userRepository;
        this.artistService = artistService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void createAlbum(AlbumServiceModel serviceModel) {
        AlbumEntity albumEntity = modelMapper.map(serviceModel, AlbumEntity.class);
        UserEntity creator = userRepository.
                findByUsername(serviceModel.getUser()).
                orElseThrow(() -> new IllegalArgumentException("Creator " + serviceModel.getUser() + " could not be found"));
        albumEntity.setUserEntity(creator);

        ArtistEntity artistEntity = artistService
                .findByName(serviceModel.getArtist());

        albumEntity.setArtistEntity(artistEntity);

        albumRepository.save(albumEntity);
    }

    @Override
    public AlbumViewModel findById(Long id) {
        return albumRepository
                .findById(id)
                .map(albumEntity -> {
                    AlbumViewModel albumViewModel = modelMapper
                            .map(albumEntity, AlbumViewModel.class);
                    albumViewModel.setArtist(albumEntity.getArtistEntity().getName());
                    return albumViewModel;
                })
                .orElseThrow(ObjectNotFoundException::new);
    }

    @Override
    public AlbumEntity findEntityById(Long albumId) {
        return albumRepository
                .findById(albumId)
                .orElseThrow(ObjectNotFoundException::new);
    }
}
