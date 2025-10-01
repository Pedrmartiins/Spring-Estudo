import java.util.List;
import java.util.Optional;

public class controller {
    

    @RestController
@RequestMapping("/solicitacoes")
public class SolicitacaoController {

    @Autowired
    private SolicitacaoService service;

    @PostMapping
    public Solicitacao criarSolicitacao(@Valid @RequestBody Solicitacao solicitacao) {
        return service.criarSolicitacao(solicitacao);
    }

    @GetMapping
    public List<Solicitacao> listarSolicitacoes() {
        return service.listarSolicitacoes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Solicitacao> buscarPorId(@PathVariable Long id) {
        Optional<Solicitacao> solicitacao = service.buscarPorId(id);
        return solicitacao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/finalizar")
    public ResponseEntity<Solicitacao> finalizarSolicitacao(@PathVariable Long id) {
        Solicitacao solicitacao = service.finalizarSolicitacao(id);
        return solicitacao != null ? ResponseEntity.ok(solicitacao) : ResponseEntity.notFound().build();
    }
}
