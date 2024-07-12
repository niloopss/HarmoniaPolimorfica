/**
 * Classe abstrata que representa um instrumento de percussão genérico.
 * Implementa a interface {@link Instrumento}.
 *
 * @author Nivea Lins
 */
abstract class InstrumentoPercussao implements Instrumento {

    /**
     * Toca o instrumento de percussão.
     *
     * @param nota Este parâmetro é ignorado, pois instrumentos de percussão geralmente não têm notas específicas.
     */
    @Override
    public void play(String nota) {
        System.out.println(this + " tocando.");
    }
}
