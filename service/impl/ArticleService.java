package service;

import src.main.model.service.ArticleServiceModel;
import src.main.model.view.ArticleViewModel;
import java.util.List;
import java.util.Optional;

public interface ArticleService {

  Optional<ArticleViewModel> findLatestArticle();

  List<ArticleViewModel> findAllArticles();

  void createArticle(ArticleServiceModel articleServiceModel);

}
