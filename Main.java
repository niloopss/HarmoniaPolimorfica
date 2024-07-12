import java.util.Random;
import java.util.Scanner;

/**
 * Classe principal que executa o programa Harmonia Polimórfica.
 * Permite ao usuário interagir com uma orquestra virtual, tocando instrumentos e criando partituras.
 *
 * @author Nivea Lins
 */
public class Main {
    /**
     * Método principal que inicia a execução do programa.
     *
     * @param args Argumentos de linha de comando (não utilizados neste programa).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Orquestra orquestra = new Orquestra();
        orquestra.adicionarInstrumento(new Violao());
        orquestra.adicionarInstrumento(new Tambor());
        orquestra.adicionarInstrumento(new Trompete());

        String[] notas = {"Dó", "Ré", "Mi", "Fá", "Sol", "Lá", "Si"};
        Random random = new Random();

        int escolha;
        do {
            System.out.println("\n╔══════════════════════════════╗");
            System.out.println("║     HARMONIA POLIMÓRFICA     ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.println("║ 1. Tocar Violão              ║");
            System.out.println("║ 2. Tocar Tambor              ║");
            System.out.println("║ 3. Tocar Trompete            ║");
            System.out.println("║ 4. Começar a Tocar Orquestra ║");
            System.out.println("║ 0. Sair                      ║");
            System.out.println("╚══════════════════════════════╝");
            System.out.print("Escolha uma opçãao: ");

            escolha = scanner.nextInt();
            scanner.nextLine();

            if (escolha > 0 && escolha <= orquestra.getInstrumentos().size()) {
                Instrumento instrumento = orquestra.getInstrumentos().get(escolha - 1);

                if (escolha == 2) {
                    instrumento.play(null);
                    orquestra.adicionarPartitura(instrumento, null);
                } else {
                    System.out.print("Digite a nota (ou Enter para aleatória): ");
                    String nota = scanner.nextLine();
                    if (nota.isEmpty()) {
                        if (instrumento instanceof InstrumentoPercussao) {
                            nota = null;
                        } else {
                            nota = notas[random.nextInt(notas.length)];
                        }
                    }
                    instrumento.play(nota);
                    orquestra.adicionarPartitura(instrumento, nota);
                }
            } else if (escolha == 4) {
                orquestra.tocarOrquestra();
            } else if (escolha != 0) {
                System.out.println("Opção inválida!");
            }
        } while (escolha != 0);


        System.out.println("Saindo da Harmonia Polimórfica...");
    }
}