# 01 - Introdução

* **ADT:** Abstract Data Type
    * Conjunto de itens e de operações sobre tais itens
    * **Operações:** especificadas na interface **API**, sem implementação
        * API: Applications Programming Interface
    * **Cliente:** usuário da ADT
        * Acesso apenas às operações na API, sem conhecer a implementação


* **Anatomia Java:**
    ```Java
    public class MinhaClasse {
        atributos de estado;
        variáveis;

        //construtor
        public MinhaClasse(...) {
        ...        
        }

        // Métodos públicos da API
        ...

        // Métodos privados
        ...

        // Unit test
        public static void main(String[] args) {
        ...
        }
    } 
    ```


* **Nó em Lista Ligada:**
    ```Java
    private class Node {
        private Item item;
        private Node next;
    }
    ```

* **Iterador:**
    * Permite percorrer os elementos de uma ADT


* **Bag:**
    * **Operações:**
        * *add* para inserir algo na coleção
        * *iterate* percorre cada elemento na Bag
    * **API:**
        * <code>Bag()</code>: cria o saco de itens
        * <code>void add(Item item)</code>: coloca o item no saco
        * <code>boolean isEmpty()</code>: checa se o saco está vazio
        * <code>int size()</code>: número de itens no saco
        * <code>void startIterator()</code>: inicializa o iterador
        * <code>boolean hasNext()</code>: checa se ainda há itens para a iteração
        * <code>Item next()</code>: próximo item na coleção
