import java.util.ArrayList;
import java.util.Scanner;

// Classe para representar um aluno
class Aluno {
    private String nome;
    private double nota;

    public Aluno(String nome, double nota) {
        this.nome = nome;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public double getNota() {
        return nota;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Nota: " + nota;
    }
}

public class Cadastro {
    public static void main(String[] args) {
        ArrayList<Aluno> listaDeAlunos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar aluno");
            System.out.println("2. Remover aluno");
            System.out.println("3. Visualizar alunos");
            System.out.println("4. Sair");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1: // Adicionar aluno
                    System.out.print("Digite o nome do aluno: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite a nota do aluno: ");
                    double nota = scanner.nextDouble();
                    scanner.nextLine(); // Consumir a quebra de linha
                    listaDeAlunos.add(new Aluno(nome, nota));
                    System.out.println("Aluno adicionado com sucesso!");
                    break;

                case 2: // Remover aluno
                    System.out.print("Digite o nome do aluno a ser removido: ");
                    String nomeParaRemover = scanner.nextLine();
                    boolean removido = listaDeAlunos.removeIf(aluno -> aluno.getNome().equalsIgnoreCase(nomeParaRemover));
                    if (removido) {
                        System.out.println("Aluno removido com sucesso!");
                    } else {
                        System.out.println("Aluno não encontrado.");
                    }
                    break;

                case 3: // Visualizar alunos
                    if (listaDeAlunos.isEmpty()) {
                        System.out.println("Nenhum aluno cadastrado.");
                    } else {
                        System.out.println("Lista de alunos:");
                        for (Aluno aluno : listaDeAlunos) {
                            System.out.println(aluno);
                        }
                    }
                    break;

                case 4: // Sair
                    System.out.println("Encerrando o programa...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}