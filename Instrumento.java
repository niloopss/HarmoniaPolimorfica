/**
 * Interface que representa um instrumento musical genérico.
 *
 * @author Nivea Lins
 */
interface Instrumento {

    /**
     * Toca uma nota musical no instrumento.
     *
     * @param nota A nota musical a ser tocada. Pode ser nula para instrumentos de percussão.
     */
    void play(String nota);

    /**
     * Retorna uma representação em string do instrumento.
     *
     * @return O nome do instrumento.
     */
    String toString();
}
