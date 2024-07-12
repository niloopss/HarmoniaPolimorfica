# Laboratório 2 - Atividade #3 - Instrumentos musicais
O projeto HarmoniaPolimórfica é uma aplicação Java que simula uma orquestra virtual, explorando os conceitos de Programação Orientada a Objetos (POO), com ênfase em polimorfismo e herança. O objetivo é demonstrar como diferentes instrumentos musicais, mesmo com características distintas, podem ser tratados de forma unificada através de uma interface comum.

## Como usar

1. **Execute o programa:** Main
2. **Siga as instruções do menu:**
   * Escolha um instrumento (1-3) e, se necessário, digite a nota ou pressione Enter para uma nota aleatória.
   * Repita para adicionar mais instrumentos à partitura.
   * Escolha a opção 4 para tocar a orquestra.
   * Escolha a opção 0 para sair.

## Funcionalidades
1. **Instrumentos Musicais:**
   * Violão (Instrumento de Corda)
   * Tambor (Instrumento de Percussão)
   * Flauta (Instrumento de Sopro)
2. **Menu Interativo:** Permite ao usuário escolher o instrumento e a nota (opcional) a ser tocada.
3. **Seleção Aleatória de Notas:** Ao pressionar Enter, uma nota aleatória é escolhida para instrumentos que a utilizam (exceto percussão).
4. **Armazenamento de Partituras:** O sistema armazena as escolhas do usuário (instrumento e nota) para reproduzir posteriormente.
5. **Tocar Orquestra:** Reproduz a sequência de instrumentos e notas armazenadas.

## Fluxograma

Este fluxograma representa a lógica do projeto, ele reflete as opções do menu e o fluxo de execução para cada escolha.

![Fluxograma - HarmoniaPolimorfica - Mermaid.png](Fluxograma%20-%20HarmoniaPolimorfica%20-%20Mermaid.png)


**Código Mermaid**
```
graph TD
subgraph Menu
A[Iniciar] --> B{Escolha uma opção}
B -->|1| C[Tocar Violão]
B -->|2| D[Tocar Tambor]
B -->|3| E[Tocar Trompete]
B -->|4| F[Tocar Orquestra]
B -->|0| G[Sair]
end

    C --> H[Solicitar nota ou aleatória]
    D --> I[Tocar Tambor]
    E --> H
    H --> J[Armazenar Partitura]
    I --> J
    J --> B

    F --> K[Verificar se há partituras]
    K --> |Sim| L[Tocar cada instrumento da partitura]
    K --> |Não| M[Exibir mensagem 'Nenhuma partitura']

    L --> B
    M --> B

    G --> Z[Fim]
```


**Explicação do Fluxograma:**

1. **Menu (A-G):**

   * O programa inicia (A) e apresenta o menu de opções (B).
   * O usuário escolhe uma opção (1-4 ou 0).
   * Se a opção for 0, o programa termina (G).
2. **Tocar Instrumento (C, D, E):**

   * Se a opção for 1, 2 ou 3, o programa solicita a nota (ou gera uma aleatória para instrumentos que usam notas) (H).
   * Se a opção for 2 (Tambor), o tambor é tocado diretamente sem solicitar nota (I).
   * A partitura (instrumento e nota) é armazenada (J).
   * O programa retorna ao menu (B).
3. **Tocar Orquestra (F):**

   * Se a opção for 4, o programa verifica se há partituras armazenadas (K).
      * Se sim, cada instrumento da partitura é tocado em sequência (L).
      * Se não, uma mensagem é exibida informando que não há partituras (M).
   * O programa retorna ao menu (B).


## Diagrama de Classes

O diagrama reflete a estrutura do código, incluindo os tipos de relacionamentos, a multiplicidade e a visibilidade dos membros das classes.

![Diagrama de Classes - HarmoniaPolimorfica - IntelliJ.png](Diagrama%20de%20Classes%20-%20HarmoniaPolimorfica%20-%20IntelliJ.png)
Diagrama gerado pelo IntelliJ

![Diagrama de Classes - HarmoniaPolimorfica - Mermaid.png](Diagrama%20de%20Classes%20-%20HarmoniaPolimorfica%20-%20Mermaid.png)
Diagrama gerado no Mermaid

**Código Mermaid**
```
classDiagram
class Instrumento {
<<interface>>
+play(String): void
+toString(): String
}

    class InstrumentoPercussao {
        <<abstract>>
        +play(String): void
    }

    class InstrumentoSopro {
        <<abstract>>
        +play(String): void
    }

    class InstrumentoCorda {
        <<abstract>>
        +play(String): void
    }

    class Tambor {
        +Tambor()
        +toString(): String
    }

    class Trompete {
        +Trompete()
        +toString(): String
    }

    class Violao {
        +Violao()
        +toString(): String
    }

    class Partitura {
        -instrumento: Instrumento
        -nota: String
        +Partitura(Instrumento, String)
    }

    class Orquestra {
        -instrumentos: List~Instrumento~
        -partituras: List~Partitura~
        +Orquestra()
        +adicionarInstrumento(Instrumento): void
        +adicionarPartitura(Instrumento, String): void
        +tocarOrquestra(): void
        +getInstrumentos(): List~Instrumento~
    }

    class Main {
        +Main()
        +main(String[]): void
    }

    Instrumento <|-- InstrumentoPercussao
    Instrumento <|-- InstrumentoSopro
    Instrumento <|-- InstrumentoCorda
    InstrumentoPercussao <|-- Tambor
    InstrumentoSopro <|-- Trompete
    InstrumentoCorda <|-- Violao
    Orquestra "1" o-- "*" Instrumento : instrumentos
    Orquestra "1" o-- "*" Partitura : partituras
    Partitura "1" o-- "1" Instrumento : instrumento
    Main "*" --> "1" Orquestra : <<create>>
```

**Explicação do Diagrama:**

1. **Classes e Interfaces:** Representa as classes (`Instrumento`, `InstrumentoPercussao`, `InstrumentoSopro`, `InstrumentoCorda`, `Tambor`, `Trompete`, `Violao`, `Partitura`, `Orquestra`, `Main`) e a interface `Instrumento`.

2. **Relacionamentos:**
   * **Herança:** Indicada pela seta com ponta vazada (ex: `Instrumento <|-- InstrumentoPercussao`).
   * **Composição:** Indicada pela seta com losango preenchido (ex: `Orquestra "1" o-- "*" Instrumento`).
   * **Associação:** Indicada pela seta simples (ex: `Partitura "1" o-- "1" Instrumento`).
3. **Multiplicidade:**
      * `1`: Indica que um objeto da classe se relaciona com exatamente um objeto da outra classe.
      * `*`: Indica que um objeto da classe se relaciona com zero ou mais objetos da outra classe.
4. **Visibilidade:**
      * `+`: Público
      * `-`: Privado

## Resultados

| Opção Escolhida | Ação Realizada  | Instrumento | Nota        | Saída do Programa                                                                                    |
|-----------------|-----------------|-------------|-------------|------------------------------------------------------------------------------------------------------|
| 1               | Tocar Violão    | Violão      | (Aleatória) | Violão tocando a nota: Sol                                                                           |
| 2               | Tocar Tambor    | Tambor      | -           | Tambor tocando.                                                                                      |
| 3               | Tocar Trompete  | Trompete    | (Aleatória) | Trompete tocando a nota: Dó                                                                          |
| 4               | Tocar Orquestra | Orquestra   | -           | Tocando a orquestra:<br>Violão tocando a nota: Sol<br>Tambor tocando.<br>Trompete tocando a nota: Dó |
| 0               | Sair            | -           | -           | Saindo da Harmonia Polimórfica...                                                                    |

![Resultado - HarmoniaPolimorfica - IntelliJ.png](Resultado%20-%20HarmoniaPolimorfica%20-%20IntelliJ.png)
![Resultado 2 - HarmoniaPolimorfica - IntelliJ.png](Resultado%202%20-%20HarmoniaPolimorfica%20-%20IntelliJ.png)
![Resultado 3 - HarmoniaPolimorfica - IntelliJ.png](Resultado%203%20-%20HarmoniaPolimorfica%20-%20IntelliJ.png)
