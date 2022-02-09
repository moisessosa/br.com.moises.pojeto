import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class Alunos {
    public String nomeCompleto;
    public String turma;
}
