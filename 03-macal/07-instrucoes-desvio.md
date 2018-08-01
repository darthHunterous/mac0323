# 07 - Instruções de Desvio

* **Desvio incondicional de fluxo do programa**:
    * **Jump e Jump Back**:
            JMP XYZ    @ <- @ + 4 * XYZ
            JMPB XYZ   @ <- @ - 4 * XYZ
        * Possível desviar 16777215 instruções para frente ou para trás
        <br>Combina-se as quantidades nos 3 registradores

* **Desvio condicional para frente**:
    * Pula a quantidade YZ de instruções se a quantidade em $X satisfaz a
    condição
    * **Jump If Zero:**
            JZ $X, YZ
    * **Jump If Nonzero:**
            JNZ $X, YZ
    * **Jump If Positive:**
            JP $X, YZ
    * **Jump If Negative:**
            JN $X, YZ
    * **Jump If Non-Negative:**
            JNN $X, YZ
    * **Jump If Non-Positive:**
            JNP $X, YZ

* **Desvio condicional para trás:**
    * Instruções análogas ao desvio condicional para frente
    * Opcode equivalente ao opcode da convencional + 1
            JZB $X, YZ
            JNZB $X, YZ
            JPB $X, YZ
            JNB $X, YZ
            JNNB $X, YZ
            JNPB $X, YZ

* **Desvio para posição de memória arbitrária:**
        GO $X, YZ     @ <- u($X) + 4 * YZ
        GOB $X, YZ    @ <- u($X) - 4 * YZ

* **Carregar em registrador o endereço de memória de uma instrução:**
    * **Get Address:**
            GETA $X, YZ     u($X) <- @ + 4 * YZ
    * **Get Address Back:**
            GETAB $X, YZ    u($X) <- @ - 4 * YZ
    * Exemplo:
        * GETA $0, 0
        <br>Coloca no registrador $0, o valor da instrução atual