/**
 * Classe abstrata que representa um instrumento de corda genérico.
 * Implementa a interface {@link Instrumento}.
 *
 * @author Nivea Lins
 */
abstract class InstrumentoCorda implements Instrumento {

    /**
     * Toca uma nota musical no instrumento de corda.
     *
     * @param nota A nota musical a ser tocada.
     */
    @Override
    public void play(String nota) {
        System.out.println(this + " tocando a nota: " + nota);
    }
}
