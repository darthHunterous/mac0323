# 10 - Árvore Binária de Busca

* **Árvore Binária de Busca:**
    * Árvore binária cujos nós associam um valor para cada chave
    * A chave de um nó é sempre maior ou igual às chaves na subárvore esquerda
    * A chave de um nó é sempre menor a qualquer chave na subárvore direita

* **Deletar o mínimo:**
    * Andar para esquerda até que x.left seja null, retornando x.right
* **Deletar determinada chave:**
    * Remover o nó correspondente a tal chave, trocando-a pela menor chave na
    <br>subárvore direita

* **Desempenho:**
    * O desempenho de get(), put() e delete() é proporcional à altura da árvore
        * Importância de se trabalhar com árvores balanceadas

* **Número de chaves examinadas em uma busca com sucesso:**
    * **1+p** nós, sendo **p** a profundidade do último nó visitado

* **Comprimento interno:**
    * Soma das profundidades dos nós

* **Número médio de comparações na busca em BST Aleatória:**
    * 2 lg(n)
* **Número esperado de nós visitados na busca em BST Aleatória:**
    * Não passa de **3 lg(n)**