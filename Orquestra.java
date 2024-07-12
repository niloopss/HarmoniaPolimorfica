import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa uma orquestra virtual, capaz de armazenar instrumentos e partituras,
 * e tocar a sequência de notas armazenada.
 *
 * @author Nivea Lins
 */
class Orquestra {
    private List<Instrumento> instrumentos = new ArrayList<>();
    private List<Partitura> partituras = new ArrayList<>();

    /**
     * Adiciona um instrumento à orquestra.
     *
     * @param instrumento O instrumento a ser adicionado.
     */
    public void adicionarInstrumento(Instrumento instrumento) {
        instrumentos.add(instrumento);
    }

    /**
     * Retorna a lista de instrumentos da orquestra.
     *
     * @return A lista de instrumentos.
     */
    public List<Instrumento> getInstrumentos() {
        return instrumentos;
    }

    /**
     * Adiciona uma partitura (instrumento e nota) à orquestra.
     *
     * @param instrumento O instrumento da partitura.
     * @param nota A nota a ser tocada pelo instrumento (pode ser null para instrumentos de percussão).
     */
    public void adicionarPartitura(Instrumento instrumento, String nota) {
        partituras.add(new Partitura(instrumento, nota));
    }

    /**
     * Toca a orquestra, executando a sequência de notas armazenada nas partituras.
     */
    public void tocarOrquestra() {
        if (partituras.isEmpty()) {
            System.out.println("Nenhuma partitura armazenada ainda.");
            return;
        }

        System.out.println("\nTocando a orquestra:");
        for (Partitura partitura : partituras) {
            partitura.instrumento.play(partitura.nota);
        }
    }
}
