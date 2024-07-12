abstract class InstrumentoPercussao implements Instrumento {
    @Override
    public void play(String nota) {
        System.out.println(this + " tocando."); // Percussão não precisa de nota
    }
}