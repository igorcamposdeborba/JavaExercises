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
	
}
