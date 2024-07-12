abstract class InstrumentoSopro implements Instrumento {
    @Override
    public void play(String nota) {
        System.out.println(this + " tocando a nota: " + nota);
    }
}