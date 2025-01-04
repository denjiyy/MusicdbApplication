package bg.musicapp.musicdb.web;

import bg.musicapp.musicdb.model.binding.AlbumAddBindingModel;
import bg.musicapp.musicdb.model.service.AlbumServiceModel;
import bg.musicapp.musicdb.model.view.AlbumViewModel;
import bg.musicapp.musicdb.service.AlbumService;
import bg.musicapp.musicdb.service.ArtistService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.ZoneId;

// these were all supposed to be just controllers
@RestController
@RequestMapping("/albums")
public class AlbumController {

  private final ModelMapper modelMapper;
  private final AlbumService albumService;
  private final ArtistService artistService;

  public AlbumController(ModelMapper modelMapper,
      AlbumService albumService,
      ArtistService artistService) {
    this.modelMapper = modelMapper;
    this.albumService = albumService;
    this.artistService = artistService;
  }

  @ModelAttribute("albumAddBindingModel")
  public AlbumAddBindingModel createBindingModel() {
    return new AlbumAddBindingModel();
  }

  @GetMapping("/add")
  public String addAlbum(Model model) {

    model.addAttribute("artists",
            artistService.findAllArtists());

    return "add-album";
  }

  @PostMapping("/add")
  public String addAlbum(@Valid AlbumAddBindingModel albumAddBindingModel,
      BindingResult bindingResult,
      RedirectAttributes redirectAttributes,
      @AuthenticationPrincipal UserDetails principal) {


    if(bindingResult.hasErrors()){
      redirectAttributes.addFlashAttribute("albumAddBindingModel", albumAddBindingModel);
      redirectAttributes
              .addFlashAttribute("org.springframework.validation.BindingResult.albumAddBindingModel", bindingResult);

      return "redirect:add";
    }


    AlbumServiceModel albumServiceModel = modelMapper.map(
        albumAddBindingModel,
        AlbumServiceModel.class);

    albumServiceModel.setUser(principal.getUsername());

   albumServiceModel.setReleaseDate(albumAddBindingModel
           .getReleaseDate().atStartOfDay(ZoneId.systemDefault()).toInstant());


    albumService.createAlbum(albumServiceModel);

    return "redirect:/home";
  }

  @GetMapping("/details/{id}")
  public String details(@PathVariable Long id, Model model){

    AlbumViewModel albumViewModel = albumService.findById(id);

    model.addAttribute("album", albumViewModel);

    return "details";
  }
}
