import java.util.Arrays;

public class StaticStack<E> implements Stack<E> {
	private int top;

	private E elements[];

	public StaticStack(int maxSize) {
		elements = (E[])new Object[maxSize];
		top = -1;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return top == elements.length - 1;
	}

	public int numElements() {
		return top + 1;
	}
	
	public void push(E element) throws OverflowException {
		if (isFull())
			throw new OverflowException();
		elements[++top] = element;
	}

	public E pop() throws UnderflowException {
		if (isEmpty())
			throw new UnderflowException();
		E element = elements[top];
		elements[top--] = null; // p/ coleta de lixo
		return element;
	}

	public E top() throws UnderflowException {
		if (isEmpty())
			throw new UnderflowException();
		return elements[top];
	}

	public String toString() {
		if (isEmpty())
			return "[Empty]";
		else {
			String s = "[";
			for (int i = numElements() - 1; i >= 0; i--) {
				s += "\n" + elements[i];
			}
			s += "\n]";
			return s;
		}
	}
	
	// 3) Implemente em uma classe qualquer o seguinte método: public Integer[] itemsExcept(int number, Stack<Integer> p)
	// Esse método deve percorrer a pilha p e retornar um vetor com os elementos de p sem a ocorrência do elemento number. 
	// O conteúdo original da pilha deve ser preservado.
	public Integer [] itemsExcept(int number, Stack<Integer> p) {
		Integer [] newStack = new Integer [p.numElements() - 1]; // array com números filtrados sem o number
		Integer [] temporary = new Integer [p.numElements()]; // array temporário para restaurar a pilha
		
		// variável temporária
		int element = 0;
		int dimension = this.numElements();
		int j = 0;
		
		// passar elementos sem o number para a lista temporária
		int counter = 0;
		while (!p.isEmpty()) {
			element = p.pop();
			
			if (element != number) {
				newStack[counter++] = element; // salvar array filtrado sem o number
			}
			temporary[j] = element; // salvar pilha original num array
			j++;
		}
		
		// restaurar pilha original
		int newDimension = element + newStack.length;
		for (int i = newDimension - 1; i >= 0; i--) {
			p.push(temporary[i]);
			temporary[i] = null;
		}

		return temporary;
	}
	
	// 4) Implemente um método que recebe duas pilhas s1 e s2 e transfere os elementos da primeira para a segunda de modo que os elementos 
	// em s2 fiquem na mesma ordem que em s1. Dica: use uma pilha auxiliar.
	public void transferElements(Stack <E> s1, Stack<E> s2) {
		StaticStack <E> temporary = new StaticStack<E>(s1.numElements() + s2.numElements());
		
		while (!s1.isEmpty())
			temporary.push(s1.pop());
		
		while(!temporary.isEmpty())
			s2.push(temporary.pop());
	}
	
	// 5) Implemente em uma classe qualquer o seguinte método: void prependStack(Stack<Integer> p1, Stack<Integer> p2)
	// Esse método deve armazenar todos os elementos de p2 em p1 de maneira que eles fiquem abaixo dos elementos originais de p1, 
	// mantendo os dois conjuntos de elementos em sua ordem original. Podem ser utilizados vetores ou pilhas auxiliares.
	public void prependStack(Stack<Integer> p1, Stack<Integer> p2) {
		StaticStack <Integer> temporary1 = new StaticStack <Integer>(p1.numElements());
		StaticStack <Integer> temporary2 = new StaticStack <Integer>(p2.numElements());
		
		// salvar dados da pilha 1 numa pilha temporária para depois colocar no topo da pilha
		while (!p1.isEmpty())
			temporary1.push(p1.pop());
		
		// salvar dados da pilha 2 numa pilha temporária para depois colocar no topo da pilha
		while (!p2.isEmpty())
			temporary2.push(p2.pop());

		// inserir a pilha temporária 2 na base da pilha 1
		while (!temporary2.isEmpty())
			p1.push(temporary2.pop());
		
		// restaurar pilha 1: inserir a pilha temporária 1 na pilha 1
		while (!temporary1.isEmpty())
			p1.push(temporary1.pop());
		
		System.out.println(p1);
	}
	
	// 8) Implemente um método que recebe uma pilha como parâmetro e inverte a ordem dos seus elementos. 
	// Use somente outras pilhas como estruturas auxiliares
	public void reverse(Stack<E> s1) {
		StaticStack <E> temporary1 = new StaticStack<E>(s1.numElements());
		StaticStack <E> temporary2 = new StaticStack<E>(s1.numElements());
		
		
		while (!s1.isEmpty()) 
			temporary1.push(s1.pop()); // adicionar na pilha 1 para inverter a ordem na próxima pilha
		
		while (!temporary1.isEmpty()) 
			temporary2.push(temporary1.pop()); // adicionar na pilha 1 para inverter a ordem ao restaurar a pilha
		
		while (!temporary2.isEmpty())
			s1.push(temporary2.pop());
	}
}
