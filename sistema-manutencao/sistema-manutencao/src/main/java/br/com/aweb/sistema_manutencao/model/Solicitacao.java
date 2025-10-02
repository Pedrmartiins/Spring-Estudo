import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class solicitacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank
    @Column(nullable = false)
    private String nome;

    @NotNull
    @Positive
    @Column(nullable = false)
    private Integer numeroMaq;

    @NotBlank
    @Column(nullable = false)
    private String descricao;

    @NotBlank
    private String tipoMaq;

    @Column(nullable = false)
    private LocalDateTime criadoEm =  LocalDateTime.now();

    @Column(nullable = true)
    private LocalDate dataFinalizado;    
}
