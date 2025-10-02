import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/sistema-manutencao")
public class ManutencaoController {
    
    @Autowired
    ManutencaoRepository manutencaoRepository;

    @GetMapping
    public ModelAndView list(){
        return new ModelAndView("list", Map.of("manutencoes", manutencaoRepository.findAll()));
    }

    @GetMapping("/nova-manutencao")
    public ModelAndView nova(){
        return new ModelAndView("form", Map.of("manutencao", new Manutencao()));
    }

    @PostMapping("/nova-manutencao")
    public String nova(@Valid Manutencao manutencao, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors())
            return "form";
        
        manutencaoRepository.save(manutencao);
        
        return "redirect:/sistema-manutencao";

    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable long id){
        Optional<Manutencao> manutencao = manutencaoRepository.findById(id);
        if(manutencao.isPresent() && manutencao.get().getDataFinalizado()==null)
            return new ModelAndView("form", Map.of("manutencao", manutencao.get()));

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/edit/{id}")
    public String edit(@Valid Manutencao manutencao, BindingResult result){
        if(result.hasErrors())
            return "form";
        
            manutencaoRepository.save(manutencao);
            return "redirect:/sistema-manutencao";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id){
        var manutencao =  manutencaoRepository.findById(id);
        if(manutencao.isPresent()){
            return new ModelAndView("delete", Map.of("manutencao", manutencao.get()));
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/delete/{id}")
    public String delete(Manutencao manutencao){
        manutencaoRepository.delete(manutencao);
        return "redirect:/sistema-manutencao";
    }

    @PostMapping("/finalizar/{id}")
    public String finalizar(@PathVariable Long id){
        var optionalManutencao = manutencaoRepository.findById(id);
        if (optionalManutencao.isPresent()) {
            var manutencao = optionalManutencao.get();
            manutencao.setDataFinalizado(LocalDate.now());
            manutencaoRepository.save(manutencao);
            return "redirect:/sistema-manutencao";
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

}
