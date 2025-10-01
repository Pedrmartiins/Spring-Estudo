import java.util.List;
import java.util.Optional;
@Service
public class SistemaService {
    

     @Autowired
    private SolicitacaoRepository repository;

    public Solicitacao criarSolicitacao(Solicitacao solicitacao) {
        return repository.save(solicitacao);
    }

    public List<Solicitacao> listarSolicitacoes() {
        return repository.findAll();
    }

    public Optional<Solicitacao> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Solicitacao finalizarSolicitacao(Long id) {
        Optional<Solicitacao> solicitacao = buscarPorId(id);
        if (solicitacao.isPresent()) {
            Solicitacao s = solicitacao.get();
            s.setStatus(Solicitacao.StatusSolicitacao.FINALIZADO);
            s.setDataFechamento(java.time.LocalDateTime.now());
            return repository.save(s);
        }
        return null;
    }
}
