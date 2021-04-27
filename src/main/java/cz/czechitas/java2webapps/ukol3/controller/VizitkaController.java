package cz.czechitas.java2webapps.ukol3.controller;

import cz.czechitas.java2webapps.ukol3.entity.Vizitka;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

/**
 * Kontroler obsluhující zobrazování vizitek.
 */
@Controller
public class VizitkaController {

  private final List<Vizitka> vizitky;

  public VizitkaController() {
    vizitky = Arrays.asList(
            new Vizitka("Jana Janová", "Czechitas", "Václavské náměstí 837/11", "11000 Praha 1",
                    "jana@czechitas.cs", "+420 800123456", "www.czechitas.cz"),
            new Vizitka("Jana Nová", "Ambo", "U Řempa 331", "66451 Kobylnice",
                    null, "+420 800123450", null),
            new Vizitka("Jane Doe", "Městský úřad Tišnov", "nám. Míru 111", "66601 Tišnov",
                    "jane@tisnov.cz", null, "www.tisnov.cz"),
            new Vizitka("Monika Ptáčníková", "Czechitas", "Kobližná 20", "602 00 Brno",
                    "monika@czechitas.cs", "+420 800987654", null)
    );
  }

  @GetMapping("/")
  public ModelAndView seznam() {
    ModelAndView modelAndView = new ModelAndView("seznam");
    modelAndView.addObject("vizitky", vizitky);
    return modelAndView;
  }

  @GetMapping("/detail")
  public ModelAndView detail(int id) {
    ModelAndView modelAndView = new ModelAndView("detail");
    modelAndView.addObject("detailVizitky", vizitky.get(id));
    return modelAndView;
  }
}
