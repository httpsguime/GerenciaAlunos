import java.util.HashMap;
import java.util.Scanner;

public class MainController {
    private final MainView view;
    private final HashMap<Integer, Estudante> hm;
    private int chave;

    public MainController() {
        view = new MainView();
        hm = new HashMap<>();
        inicializarDados();
        chave = 4;
    }

    private void inicializarDados() {
        hm.put(1, new Estudante(1062021, "Raphael", 8.5f));
        hm.put(2, new Estudante(1062021, "Caroline", 10f));
        hm.put(3, new Estudante(2062020, "Gilson", 6f));
    }

    public void iniciar() {
        int opcao;
        do {
            opcao = view.exibirMenu();

            try {

                switch (opcao) {
                    case 1:
                        cadastrarAluno();
                        break;
                    case 2:
                        exibirAlunos();
                        break;
                    case 3:
                        alterarNota();
                        break;
                    case 4:
                        excluirAluno();
                        break;
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro" + e.getMessage());
            }

        } while (opcao != 0);
        view.closeScanner();
    }

    private void exibirAlunos() {
        if (!hm.isEmpty()) {
            hm.forEach((key, value) -> {
                System.out.println("ID: " + key);
                System.out.println("Matricula: " + value.getMatricula());
                System.out.println("Nome: " + value.getNome());
                System.out.println("Nota: " + value.getNota());
                System.out.println("-----------------------------");
            });
        } else {
            System.out.println("Não há alunos cadastrados.");
        }
    }

    private void cadastrarAluno() {
        Scanner scanner = new Scanner(System.in);

        try {
                System.out.println("Digite a Matricula: ");
                int matricula = scanner.nextInt();
                System.out.println("Digite o nome: ");
                String nome = scanner.next();
                System.out.println("Digite a nota: ");
                float nota = scanner.nextFloat();
                hm.put(chave++, new Estudante(matricula, nome, nota));
            }catch (Exception e) {
            System.out.println("Erro ao cadastrar aluno:" + e.getMessage());
        }
    }

    private void alterarNota() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Digite o nome do aluno que deseja alterar a nota: ");
            String nomePesquisa = scanner.next();
            boolean alunoEncontrado = false;
            for (Estudante estudante : hm.values()) {
                if (estudante.getNome().equalsIgnoreCase(nomePesquisa)) {
                    System.out.println("Digite a nova nota: ");
                    float novaNota = scanner.nextFloat();
                    estudante.setNota(novaNota);
                    alunoEncontrado = true;
                    break;
                }
            }
            if (!alunoEncontrado) {
                System.out.println("Aluno não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao alterar nota: " + e.getMessage());
        }
    }

    private void excluirAluno() {
        Scanner scanner = new Scanner(System.in);
        try {
            exibirAlunos();
            System.out.println("Digite o ID do aluno que deseja excluir: ");
            int id = scanner.nextInt();
            Estudante alunoRemovido = hm.remove(id);
            if (alunoRemovido != null) {
                System.out.println("Aluno removido com sucesso:");
                System.out.println(alunoRemovido);
            } else {
                System.out.println("Aluno não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao excluir aluno: " + e.getMessage());
        }
    }
}