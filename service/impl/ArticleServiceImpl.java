package bg.musicapp.musicdb.service.impl;

import bg.musicapp.musicdb.model.entities.ArticleEntity;
import bg.musicapp.musicdb.model.entities.UserEntity;
import bg.musicapp.musicdb.model.service.ArticleServiceModel;
import bg.musicapp.musicdb.model.view.ArticleViewModel;
import bg.musicapp.musicdb.repository.ArticleRepository;
import bg.musicapp.musicdb.repository.UserRepository;
import bg.musicapp.musicdb.service.ArticleService;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

  private final ModelMapper modelMapper;
  private final ArticleRepository articleRepository;
  private final UserRepository userRepository;

  public ArticleServiceImpl(ModelMapper modelMapper,
      ArticleRepository articleRepository,
      UserRepository userRepository) {
    this.modelMapper = modelMapper;
    this.articleRepository = articleRepository;
    this.userRepository = userRepository;
  }

  @Override
  public Optional<ArticleViewModel> findLatestArticle() {
    return articleRepository.
        findTopByOrderByCreatedOnDesc().
        map(ae -> {
          ArticleViewModel avm = modelMapper.map(ae, ArticleViewModel.class);
          avm.setAuthor(ae.getUserEntity().getUsername());
          return avm;
        });
  }

  @Override
  public List<ArticleViewModel> findAllArticles() {
    return articleRepository.
        findAll().
        stream().
        map(ae -> {
          ArticleViewModel avm = modelMapper.map(ae, ArticleViewModel.class);
          avm.setAuthor(ae.getUserEntity().getUsername());
          return avm;
        }).
        collect(Collectors.toList());
  }

  @Override
  public void createArticle(ArticleServiceModel articleServiceModel) {

    ArticleEntity articleEntity = modelMapper.map(articleServiceModel, ArticleEntity.class);
    articleEntity.setCreatedOn(Instant.now());

    UserEntity creator = userRepository.
        findByUsername(articleServiceModel.getUser()).
        orElseThrow(() -> new IllegalArgumentException("Creator " + articleServiceModel.getUser() + " could not be found"));

    articleEntity.setUserEntity(creator);

    articleRepository.save(articleEntity);
  }
}
