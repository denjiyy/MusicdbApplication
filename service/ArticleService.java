package bg.musicapp.musicdb.service;

import bg.musicapp.musicdb.model.service.ArticleServiceModel;
import bg.musicapp.musicdb.model.view.ArticleViewModel;
import java.util.List;
import java.util.Optional;

public interface ArticleService {

  Optional<ArticleViewModel> findLatestArticle();

  List<ArticleViewModel> findAllArticles();

  void createArticle(ArticleServiceModel articleServiceModel);

}
