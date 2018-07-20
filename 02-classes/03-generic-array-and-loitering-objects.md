# 03 - Generic Arrays and Loitering Objects

* **Vetores genéricos:**
    * Java não aceita a criação de vetores de itens genéricos diretamente.
    * <code>private Item[] a = new Item[n];</code>
        * Não é aceito pelo compilador
    * Forma correta com **CASTING**:
        * <code>private Item[] a = (Item[]) new Object[n];</code>

* **Loitering objects:** objetos ociosos
    * Atribuir null avisa ao coletor de lixo que a memória não é mais necessária
        * **Exemplo:** remoção de elemento no topo da pilha
            * Atribui-se null ao elemento removido em um pop()
