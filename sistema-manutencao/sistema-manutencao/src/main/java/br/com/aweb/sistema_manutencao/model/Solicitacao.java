import java.time.LocalDateTime;

@Entity
public class solicitacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do solicitante é obrigatório")
    private String nomeSolicitante;

    @NotBlank(message = "A descrição do problema é obrigatória")
    private String descricaoProblema;

    private LocalDateTime dataSolicitacao;

    private LocalDateTime dataFechamento;

    @Enumerated(EnumType.STRING)
    private StatusSolicitacao status;

    public Solicitacao() {
        this.status = StatusSolicitacao.ABERTO;
        this.dataSolicitacao = LocalDateTime.now();
    }

}
