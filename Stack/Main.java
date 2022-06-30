import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		
		// 2) 
		/*StaticStack<Integer> p1 = new StaticStack<Integer>(5);
		StaticStack<Integer> p2 = new StaticStack<Integer>(5);
		StaticStack<Integer> p3 = new StaticStack<Integer>(5);
		try {
		p1.push(10);
		p1.push(20);
		p1.push(30);
		p1.push(40);
		
		p2.push(p1.pop());
		p2.push(p1.pop());
		
		p3.push(p1.pop());
		p3.push(p1.pop());
		int temp = p2.pop();
		p3.push(p2.pop());
		p3.push(temp);

		System.out.println(p3);
		*/
		
		// 3) Implemente em uma classe qualquer o seguinte método: public Integer[] itemsExcept(int number, Stack<Integer> p)
		// Esse método deve percorrer a pilha p e retornar um vetor com os elementos de p sem a ocorrência do elemento number. 
		// O conteúdo original da pilha deve ser preservado.
		try {
			StaticStack <Integer> p1 = new StaticStack<Integer>(5);
			StaticStack <Integer> p2 = new StaticStack<Integer>(5);
			
			p1.push(1);
			p1.push(2);
			p1.push(3);
			p1.push(4);
			System.out.println("Original " + p1.toString());
			
			p2.itemsExcept(3, p1);
		
		} catch (Exception e) {
		System.out.println(e);
		}
		
		
		
		/*
		StaticStack<Integer> stackInt = new StaticStack<Integer>(8);
		Queue<Integer> queueInt = new StaticQueue<Integer>(2);
		
		try {
			for (int i=10, j=0; i>-3; i--, j++) {
				queueInt.enqueue(j-i);
				stackInt.push(queueInt.dequeue());
				queueInt.enqueue(stackInt.pop()*-1);
			}
			System.out.println(queueInt);
		} catch (UnderflowException e) {
			e.printStackTrace();
		} catch (OverflowException e) {
			e.printStackTrace();
		}
		System.out.println("Teste Igor:");
		System.out.println(queueInt);
		
		StaticStack<String> queueStr = new StaticStack<String>(stackInt.numElements() + queueInt.numElements());
		while (!stackInt.isEmpty())
			while(!queueInt.isEmpty())
				queueStr.enqueue(stackInt.pop() + " - " + queueInt.dequeue());
				// System.out.println("Teste do while:");
		System.out.println(queueStr);
		*/
	}

}
