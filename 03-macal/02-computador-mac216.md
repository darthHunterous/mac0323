# 02 - Computador MAC0216

* **Computador MAC0216**:
    * 2^64 células de memória, que comportam um byte cada
    * 2^8 registradores de 64 bits, com 6 especiais e 3 reservados
    * **Fluxo**:
        * Memória -> Registradores -> Transformações -> Memória
    * **Registradores reservados**: @, rI, rIB

* 2^64 bytes de memória divididos em 2^63 wydes compostos por dois<br>
bytes consecutivos M[2k]M[2k+1], denotados por M<sub>2</sub>[2k] ou
M<sub>2</sub>[2k+1]
    * M<sub>2</sub>[0] = M<sub>2</sub>[1] = M[0]M[1]
    * **Big Endian**: primeiro byte de M<sub>2</sub>[2k] é o mais significativo
        * u(M<sub>2</sub>[2k]) = u(M[2k]) * 2^8 + u(M[2k+1])
        * Assemelha-se a como escrevemos os números em notação decimal
    * **Little Endian**: primeiro byte na memória é o menos significativ0
        * Mais comumente usado nos computadores modernos
* Também há a divisão em 2^62 tetrabytes e 2^61 octabytes:
    * M<sub>4</sub>[4k] = M<sub>4</sub>[4k+1] = ... = M<sub>4</sub>[4k+3]
    = M[4k]M[4k+1]...M[4k+3]
    * M<sub>8</sub>[8k] = M<sub>8</sub>[8k+1] = ... = M<sub>8</sub>[8k+7]
    = M[8k]M[8k+1]...M[8k+7]
