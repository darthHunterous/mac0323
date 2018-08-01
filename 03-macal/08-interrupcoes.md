# 08 - Interrupções

* **Interrupções**: o programa precisa se comunicar com o sistema operacional
<br>Um exemplo é para as operações de entrada e saída
        INT XYZ
    * Transfere o controle para o Sistema operacional
    * Tetrabyte mais significativo do registrador rX (Operation Register)
    <br>recebe XYZ
    * rIB recebe o endereço da próxima instrução
    * @ recebe o endereço de memória apontado por rI (Interruption Address
    <br>Register), que se refere à rotina do SO que trata da interrupção
    * rY, rZ e o tetrabyte menos significativo de rX passam informações para a
    <br>rotina que trata a interrupção
    * A rotina do SO devolve em rA algum valor necessário
    * O Sistema garante que após a interrupção, o conteúdo em todos os
    <br>registradores será o mesmo de antes da interrupção

* **Exemplos de interrupção:**
    * **INT 0** -> encerra o programa
    * **INT #80** -> operações de entrada e saída
        * tetra menos significativo de rX == 1
            * Lê-se um caracter da entrada padrão, armazenando seu código em rA
        * tetra menos significativo de rX == 2
            * Imprime na saída padrão o caracter armazenado em rY
        * Fim da entrada -> rA recebe -1
    * **INT #DBYYZZ** -> depuração
        * Escreve na saída padrão o conteúdo dos registradores de Y a Z
        * Para escrever de $10 a $20
            * INT #DB0A14
    * **INT #ADYYZZ** -> depuração
        * Escreve na saída padrão o conteúdo da posição de memória cujo
        <br>endereço se encontra no registrador $Y
        * Z varia de 1 a 8, referindo-se ao byte até o octabyte que ocupa a
        <br>posição referenciada em $Y
        * Exemplo:
            * Com $11 == 1000
            * INT #AD0B04 mostra o conteúdo do tetra M<sub>4</sub>[1000]