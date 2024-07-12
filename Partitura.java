/**
 * Classe que representa uma partitura, contendo um instrumento e a nota a ser tocada por ele.
 *
 * @author Nivea Lins
 */
class Partitura {
    /**
     * O instrumento da partitura.
     */
    Instrumento instrumento;

    /**
     * A nota a ser tocada pelo instrumento (pode ser null para instrumentos de percussão).
     */
    String nota;

    /**
     * Cria uma nova partitura com o instrumento e a nota especificados.
     *
     * @param instrumento O instrumento da partitura.
     * @param nota A nota a ser tocada (ou null para percussão).
     */
    public Partitura(Instrumento instrumento, String nota) {
        this.instrumento = instrumento;
        this.nota = nota;
    }
}
