# 05 - Operações Aritméticas e Bitwise

* **Operações Aritméticas Fundamentais, com sinal**: devolvem no registrador
<br>$X o resultado da operação com os operandos $Y e $Z.
<br>Na operação de divisão, guarda-se o quociente em $X e o resto em rR
        ADD $X, $Y, $Z
        SUB $X, $Y, $Z
        MUL $X, $Y, $Z
        DIV $X, $Y, $Z  
    * Pode ocorrer **OVERFLOW** em **ADD, SUB, MUL**

* **Operações Aritméticas Fundamentais, sem sinal**:
        ADDU $X, $Y, $Z
        SUBU $X, $Y, $Z
        MULU $X, $Y, $Z
        DIVU $X, $Y, $Z

* **Instruções de SHIFT, com e sem sinal**:
    * **Shift Left:**
            SL $X, $Y, $Z
        * Coloca no registrador $X, o valor de $Y transferido $Z casas à
        esquerda
        * Exemplo: SL $X, 0b01, 1
        <br>Coloca em X, 01 em binário shiftado um à esquerda, 10
        <br>Com SL $X, 0b01, 2 resultaria 00
    * **Shift Left Unsigned:**
            SLU $X, $Y, $Z
    * **Shift Right:**
            SR $X, $Y, $Z
    * **Shift Right Unsigned:**
            SRU $X, $Y, $Z

* **Negate:**
    * Coloca o complemento de 2 do número em $Z, no registrado $X
    * Y é uma Constante
    * $X <- Y - $Z
    * Exemplos:
        * NEG $X, 0, 0b01
            * X recebe 0b11
        * NEG $X, 1, 0b01
            * X recebe 0b00
    * **Negate Signed**:
            NEG $X, Y, $Z
    * **Negate Unsigned:**
            NEGU $X, Y, $Z

* **Operações Lógicas (bitwise, bit a bit):**
    * Aplicam a comparação lógica devida, bit a bit
    * Exemplo AND em 0b00 e 0b11 resulta em 0b00
    * Exemplo XOR em 0b01 e 0b11 resulta em 0b10
    * NXOR é a negação de XOR
    * Operações:
            AND $X, $Y, $Z
            OR $X, $Y, $Z
            XOR $X, $Y, $Z
            NXOR $X, $Y, $Z 