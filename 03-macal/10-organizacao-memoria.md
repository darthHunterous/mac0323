# 10 - Organização da Memória

* **Espaço virtual**:
    * Dividido em duas parte de 2^63 bytes
    * **Espaço do Usuário:**
        * De #0000000000000000 a #7fffffffffffffff
        * Programa do usuário e dados sobre os quais ele opera
    * **Espaço do Kernel:**
        * De #8000000000000000 a #ffffffffffffffff
        * Onde reside o sistema operacional

* **Espaço do Usuário:**
    * 3 Segmentos
    * **Heap Segment:** pode ser usado pelo programa da maneira desejada
        * 2^62 bytes (metade do espaço do usuário)
    * **Segmento da Pilha de Execução:** 2^61 bytes (1/4 do espaço do usuário)
        * Pilha de execução usada na chamada de sub-rotinaa
        * No início do programa, o rSP contém o endereço inicial
        <br>do primeiro octa fora do segmento da pilha
        * Argumentos da linha de comando são colocados na pilha
    * **Segmento do texto:** 2^61 bytes (1/4 do espaço do usuário)
        * Contém o programa sendo executado
        * @ aponta para o primeiro byte ao início da execução do programa