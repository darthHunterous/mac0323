# 09 - Extras

* **Instruções para lidar com sub-rotinas:**
    * **Save:**:
            SAVE $X, $Y, $Z
        * Grava nas posições de memória  $X, $X + 8, ...
        <br>O conteúdo de Y, Y+1, ..., Z
        <br>E depois, $X recebe avança para o próximo endereço na <br>
        memória, logo após o conteúdo gravado de Y a Z
        * u($X) <- u($X) + 8(Z - Y + 1)
    * **Restore:**
            REST $X, $Y, $Z
        * Desfaz SAVE
        * Carrega nos registradores de Y a Z o conteúdo de memória de
        <br>$X a $X + 8(Z - Y)
        * X passa a apontar para o primeiro espaço em tal bloco de
        <br>memória copiado
        * u($X) <- u($X) - 8(Z - Y + 1)

* **No Operation:**
        NOP
    * Instrução sem efeito algum

* **Tabela de Opcodes:**
    * Opcode da forma #XY
        * Onde Y pode ser **u** ou **d**, de acordo com a coluna **u/d**

        | X\Y |  0   |   1   |  2   |   3   |  4   |   5   |  6   |   7   |
        | :-: | :--: | :---: | :--: | :---: | :--: | :---: | :--: | :---: |
        | #0  | LDB  | LDBI  | LDW  | LDWI  | LDT  | LDTI  | LDO  | LDOI  |
        | #1  | STB  | STBI  | STW  | STWI  | STT  | STTI  | STO  | STOI  |
        | #2  | ADD  | ADDI  | SUB  | SUBI  | MUL  | MULI  | DIV  | DIVI  |
        | #3  | ADDU | ADDUI | SUBU | SUBUI | MULU | MULUI | DIVU | DIVUI |
        | #4  | AND  | ANDI  | OR   | ORI   | XOR  | XORI  | NXOR | NXORI |
        | #5  | JN   | JNB   | JNN  | JNNB  | JNP  | JNPB  | GO   | GOB   |
        | #f  |      |       |      |       |      |       |      |       |
        |*****|******|*******|******|*******|******|*******|******|*******|
        | X/Y |  8   |   9   |  a   |   b   |  c   |   d   |  e   |   f   |
        | #0  | LDBU | LDBUI | LDWU | LDWUI | LDTU | LDTUI | LDOU | LDOUI |
        | #1  | STBU | STBUI | STWU | STWUI | STTU | STTUI | STOU | STOUI |
        | #2  | CMP  | CMPI  | SL   | SLI   | SR   | SRI   | NEG  | NEGI  |
        | #3  | CMPU | CMPUI | SLU  | SLUI  | SRU  | SRUI  | NEGU | NEGUI |
        | #4  | JMP  | JMPB  | JZ   | JZB   | JNZ  | JNZB  | JP   | JPB   |
        | #5  | GETA | GETAB | SETW | SAVE  | REST |       |      |       |
        | #f  |      |       |      |       |      |       | INT  | NOP   |
