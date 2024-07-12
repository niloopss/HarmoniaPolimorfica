/**
 * Classe abstrata que representa um instrumento de sopro genérico.
 * Implementa a interface {@link Instrumento}.
 *
 * @author Nivea Lins
 */
abstract class InstrumentoSopro implements Instrumento {

    /**
     * Toca uma nota musical no instrumento de sopro.
     *
     * @param nota A nota musical a ser tocada.
     */
    @Override
    public void play(String nota) {
        System.out.println(this + " tocando a nota: " + nota);
    }
}
