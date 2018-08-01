# 01 - Bits e Bytes

* **Notação Hexadecimal**: cada 4 bits representados por um dígito hex
    * De 64 bits para 16 dígitos de 0 a F

* **Byte**: 8 bits
* **Wyde**: 16 bits
* **Tetrabyte**: 32 bits
* **Octabyte**: 64 bits

* **Complemento de 2**:
    * u(x) unsigned e s(x) unsigned
        * s(x) = u(x) - 2^8
        * Para números de 8 bits
        * -1 = 0xFF = 11111111 = -2^7 + (2^7 - 1)

* **Registradores Especiais**:
    * **rA**: Return value register, #FF (255)
    * **rR**: Remainder register, #FE (254)
    * **rSP**: Stack pointer, #FD (253)
    * **rX**: Interrupt operation register, #FC (252)
    * **rY**: Interrupt operand register, #FB (251)
    * **rZ**: Interrupt operand register, #FA (250)
        * rX, rY e rZ são usados para guardar valores temporários