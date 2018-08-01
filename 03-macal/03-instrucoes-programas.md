# 03 - Instruções e Programas

* **Instrução**: tetrabyte composto pelos bytes OP, X, Y e Z
    * OP -> código da operação
    * X, Y, Z -> operandos
    * Exemplo: 0x2001ff03
        * Coloque em $1, o resultado da soma de $255 e $3
        * O código 0x20 equivale à instrução ADD
        * ADD $1, $255, $3
        * ADD $X, $Y, $Z
    * Instrução com 2 operandos:
        * O primeiro operando é X e o segundo é o wyde YZ
            * YZ = 2^8 &ast; Y + Z
    * Instrução com 1 operando:
        * Apenas o operando XYZ
            * XYZ = 2^16 &ast; X + 2^8 &ast; Y + Z

* **Execução de um programa**:
    * **Instruction Pointer @**: aponta para o endereço de memória que contém
    <br> a próxima instrução a ser executada. Após a execução, @ passa a apontar
    para a seguinte.