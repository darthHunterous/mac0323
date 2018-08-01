# 06 - Constantes Imediatas

* A toda instrução da forma OP $X, $Y, $Z, existe outra instrução na forma
<br> OPI $X, $Y, Z
<br>Onde Z é uma constante, ao invés de um registrador.
* O opcode de OPI é opcode de OP + 1
* **Exemplo:**
    * Para adicionar 15 ao registrador dado:
        * ADDI $20, $20, 15