package bg.musicapp.musicdb.web;

import bg.musicapp.musicdb.service.CarouselService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// these were all supposed to be just controllers
@RestController
public class HomeController {

  private final CarouselService carouselService;

  public HomeController(CarouselService carouselService) {
    this.carouselService = carouselService;
  }

  @GetMapping("/")
  public String index() {
    return "index";
  }

  @GetMapping("/home")
  public String home(Model model) {

    model.addAttribute("firstImg", carouselService.firstImage());
    model.addAttribute("secondImg", carouselService.secondImage());
    model.addAttribute("thirdImg", carouselService.thirdImage());

    return "home";
  }

}
