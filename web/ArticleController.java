package bg.musicapp.musicdb.web;

import bg.musicapp.musicdb.model.binding.ArticleAddBindingModel;
import bg.musicapp.musicdb.model.service.ArticleServiceModel;
import bg.musicapp.musicdb.model.view.ArticleViewModel;
import bg.musicapp.musicdb.service.ArticleService;
import java.util.Optional;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

// these were all supposed to be just controllers
@RestController
@RequestMapping("/articles")
public class ArticleController {

  private final ModelMapper modelMapper;
  private final ArticleService articleService;

  public ArticleController(ModelMapper modelMapper,
      ArticleService articleService) {
    this.modelMapper = modelMapper;
    this.articleService = articleService;
  }

  @GetMapping("/all")
  public String getAllArticles(Model model) {
    Optional<ArticleViewModel> articleOpt = articleService.findLatestArticle();
    if (articleOpt.isPresent()) {
      model.addAttribute("latestArticle", articleOpt.get());
    }
    return "all-articles";
  }

  @GetMapping("/add")
  public String addArticle() {
    return "add-article";
  }

  @ModelAttribute("articleAddBindingModel")
  public ArticleAddBindingModel createBindingModel() {
    return new ArticleAddBindingModel();
  }


  @PostMapping("/add")
  public String addArticle(
      @Valid ArticleAddBindingModel articleAddBindingModel,
      BindingResult bindingResult,
      RedirectAttributes redirectAttributes,
      @AuthenticationPrincipal UserDetails principal) {

    if(bindingResult.hasErrors()){
      redirectAttributes.addFlashAttribute("articleAddBindingModel", articleAddBindingModel);
      redirectAttributes
          .addFlashAttribute("org.springframework.validation.BindingResult.articleAddBindingModel", bindingResult);

      return "redirect:/articles/add";
    }


    ArticleServiceModel articleServiceModel = modelMapper.map(
        articleAddBindingModel,
        ArticleServiceModel.class);

    articleServiceModel.setUser(principal.getUsername());

    articleService.createArticle(articleServiceModel);

    return "redirect:/articles/all";
  }

}
