# 04 - Comunicação Memória-Registrador

* **Instruções de movimentação entre memória e registradores**:
    * Registrador X. Y e Z calculam o endereço A de memória
    * A = (u($Y) + u($Z)) mod 2^64

* **Memória para registradores, quantidades com sinal**:
    * **Load Byte, Load Wyde, Load Tetra, Load Octa**:
            LDB $X, $Y, $Z
            LDW $X, $Y, $Z
            LDT $X, $Y, $Z
            LDO $X, $Y, $Z
        * Movem a quantidade com sinal no endereço A para o registrador X,
        <br>transformando-a em um octa com sinal, de mesmo valor.
    * Exemplos:
        * M[1000] = 0x0f = 15, $2 = 1000 e $3 = 0 <br>
        Após LDB, resulta $1 = 0x000000000000000f
        * M[1000] = 0xff = -1, $2 = 1000 e $3 = 0 <br>
        Após LDB, resulta $1 = 0xffffffffffffffff
        * Ou seja, o bit de sinal é estendido à esquerda

* **Memória para registradores, quantidade sem sinal**:
    * **Load Byte Unsigned, Load Wyde Unsigned, Load Tetra Unsigned,
    Load Octa Unsigned:**
            LDBU $X, $Y, $Z
            LDWU $X, $Y, $Z
            LDTU $X, $Y, $Z
            LDOU $X, $Y, $Z

* **Transferência de Registrador para Memória, com sinal**:
    * Análogo aos comandos de LOAD acima
    * **Store Byte/Wyde/Tetra/Octa**:
            STB $X, $Y, $Z
            STW $X, $Y, $Z
            STT $X, $Y, $Z
            STO $X, $Y, $Z
    * Pode ocorrer **OVERFLOW** caso a quantidade armazenada em $X não
    <br> puder ser armazenada em um byte, wyde ou tetra

* **Transferência de Registrador para Memória, sem sinal**:
    * Análogo ao com sinal
    * **Store Byte/Wyde/Tetra/Octa Unsigned:**
            STBU $X, $Y, $Z
            STWU $X, $Y, $Z
            STTU $X, $Y, $Z
            STOU $X, $Y, $Z

* **Carregar Constante em um Registrador**:
    * **Load Constant Wyde**:
            SETW $X, YZ
        * Carrega no registrador $X, o wyde YZ sem sinal