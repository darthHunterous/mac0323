/******************************************************************************
 *  Name: Édio Cerati Neto
 *  NetID: NUSP 9762678
 *  Precept: --
 *
 *  Partner Name: --
 *  Partner NetID: --    
 *  Partner Precept: --  
 *
 *  Hours to complete assignment (optional): 5
 *
 ******************************************************************************/

Programming Assignment 2: Deques and Randomized Queues


/******************************************************************************
 *  Explain briefly how you implemented the randomized queue and deque.
 *  Which data structure did you choose (array, linked list, etc.)
 *  and why?
 *****************************************************************************/
	A fila aleatorizada foi implementada com um vetor para facilitar a remoção
de um elemento aleatório, de maneira a tomar tempo sempre costante.
	A fila duplamente terminada foi implementada com uma lista ligada para
acompanhar a dinamicidade de tal estrutura de dados, facilitando a remoção nas pontas.

/******************************************************************************
 *  How much memory (in bytes) do your data types use to store n items
 *  in the worst case? Use the 64-bit memory cost model from Section
 *  1.4 of the textbook and use tilde notation to simplify your answer.
 *  Briefly justify your answers and show your work.
 *
 *  Do not include the memory for the items themselves (as this
 *  memory is allocated by the client and depends on the item type)
 *  or for any iterators, but do include the memory for the references
 *  to the items (in the underlying array or linked list).
 *****************************************************************************/

Randomized Queue:   ~  _24+8*n_  bytes

Deque:              ~  _48*n__  bytes




/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/


/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 *****************************************************************************/



/******************************************************************************
 *  Describe any serious problems you encountered.                    
 *****************************************************************************/
	Fiquei confuso em relação aos pacotes do Java.


/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 *****************************************************************************/
	Seria interessante aos alunos uma breve explicação ou material sobre pacotes,
pois vimos apenas de passagem durante esse tempo utilizando Java nas matérias anteriores