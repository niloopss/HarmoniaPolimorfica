import java.util.ArrayList;
import java.util.List;

class Orquestra {
    private List<Instrumento> instrumentos = new ArrayList<>();
    private List<Partitura> partituras = new ArrayList<>();

    public void adicionarInstrumento(Instrumento instrumento) {
        instrumentos.add(instrumento);
    }

    public List<Instrumento> getInstrumentos() {
        return instrumentos;
    }

    public void adicionarPartitura(Instrumento instrumento, String nota) {
        partituras.add(new Partitura(instrumento, nota));
    }

    public void tocarOrquestra() {
        if (partituras.isEmpty()) {
            System.out.println("Nenhuma partitura armazenada ainda.");
            return;
        }

        System.out.println("\nTocando a orquestra:");
        for (Partitura partitura : partituras) {
            partitura.instrumento.play(partitura.nota); // Toca o instrumento diretamente
        }
    }
}
