# 13 - Sub-Rotinas

* **Chamar Sub-Rotina:** pular para sua primeira instrução
* **Retornar:** devolver o fluxo para a instrução àquela que chamou a sub-Rotina

* **Endereço de retorno:** guardado no registrador $10, chamado de Ret
    * **Devolução do fluxo:**
        * GO Ret, 0
    * **Valores devolvidos:** em rA
    * A sub-rotina pode alterar qualquer registrador, porém deve devolver o <br>
    rSP ao estado inicial   

* **Problema:**
    * Uma sub-rotina não pode chamar outra nessa<br>
    convenção acima, pois irá sobrescrever o endereço
    <br> de retorno
    * **Solução:** usar uma pilha para guardar os dados<br>
    locais da sub-rotina bem como o endereço de<br>
    retorno

* **Auxiliar a codar em linguagem de máquina:**
    * Utilização do montador (**ASSEMBLER**) para traduzir linguagem simbólica como
    <br> "ADD $0, $1, $2" para #580a0002
    * O Montador auxilia podendo rotular instruções, facilitando os desvios de
    <br>fluxo no programa
    * **Vinculador/Linker:** junta as diferentes sub-rotinas
    * O Assembler gera código-objeto de cada sub-rotina e o Linker associa os
    <br>pedaços num programa completo