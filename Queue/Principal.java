public class Principal {

	public static void main(String[] args) {
  
    // Exercício: Implemente, em uma classe qualquer, um método que recebe duas filas q1 e q2 de inteiros e transfere os elementos da segunda 
		// para a primeira de modo que eles fiquem na frente dos originais. Exemplo: supondo q1 = {1, 2, 3, 4} e q2 = {5, 6, 7, 8}, 
		// após a chamada do método devemos ter q1 = {5, 6, 7, 8, 1, 2, 3, 4} e q2 = {}. Dica: use uma fila auxiliar.
		// public void prependQueue(Queue<Integer> q1, Queue<Integer> q2)
  
    StaticQueue<Integer> q1 = new StaticQueue<Integer>(8);
		StaticQueue<Integer> q2 = new StaticQueue<>(4);
  try {
			q1.enqueue(1);
			q1.enqueue(2);
			q1.enqueue(3);
			q1.enqueue(4);
			
			q2.enqueue(6);
			q2.enqueue(7);
			q2.enqueue(8);
			q2.enqueue(9);
			
			System.out.println("Exercício 2");
			System.out.println("***********");
			System.out.println("Imprimindo a fila 1: ");
			System.out.println(q1.toString());
			System.out.println("Imprimindo a fila 2: ");
			System.out.println(q2.toString());
			
			prependQueue(q1,q2);
			
			System.out.println("Imprimindo a fila 1 depois da chamada do método : ");
			System.out.println(q1.toString());
			System.out.println("Imprimindo a fila 2 depois da chamada do método : ");
			System.out.println(q2.toString());
      
			
		} catch (OverflowException e) {
			System.out.println(e);
		} catch (UnderflowException e) {
			System.out.println(e);
		}
}
  
  public static void prependQueue(Queue<Integer> q1, Queue<Integer> q2) {
		StaticQueue<Integer> queueAuxiliar = new StaticQueue<Integer>(q1.numElements());
		
		// inserir o q1 na fila auxiliar para colocar o q2 na frente do q1
		while (!q1.isEmpty()) {
			queueAuxiliar.enqueue(q1.dequeue());
		}
		// colocar q2 na frente do q1 que está temporariamente na fila auxiliar
		while (!q2.isEmpty()) {
			q1.enqueue(q2.dequeue());
		}
		
		while (!queueAuxiliar.isEmpty()) {
			q1.enqueue(queueAuxiliar.dequeue());
		}
	}
