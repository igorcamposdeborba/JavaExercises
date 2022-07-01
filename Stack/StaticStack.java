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
			temporary2.push(temporary1.pop()); // adicionar na pilha 2 para inverter a ordem ao restaurar a pilha
		
		while (!temporary2.isEmpty()) // restaurar pilha
			s1.push(temporary2.pop());
	}
	
	// 9) Escreva um algoritmo para verificar se um dado elemento está presente em uma pilha. 
	// Em caso positivo, o algoritmo deve fornecer também a posição do item na pilha, considerando a base como posição 0. 
	// A pilha deve permanecer a mesma após a execução do procedimento.
	public void search(Stack<E> s1, E search) {
		StaticStack <E> temporary = new StaticStack<E>(s1.numElements());
		int counter = -1;
		
		// contar se o elemento está na pilha, desempilhando-a
		for (int i = s1.numElements(); i > 0; i--) {
			if (s1.top().equals(search)) { // se encontrar o elemento, contar a posição dele
				counter = i - 1;
				temporary.push(s1.pop());
			} else {
				temporary.push(s1.pop());
			}
		}
		
		// restaurar pilha
		while (!temporary.isEmpty()) {
			s1.push(temporary.pop());
		}
		
		System.out.println("Element position: " + counter);
	}
	
	// 10) Implemente o método contains, definido abaixo, que informa se a pilha contém determinado elemento   public boolean contains(E element)
	public boolean contains (E element) {
		StaticStack <E> temporary = new StaticStack<>(this.numElements());
		
		E el;
		// buscar se o elemento está na pilha, desempilhando-a
		while (!this.isEmpty()) {
			el = this.pop();
			if (el.equals(element)) {
				return true; // encontrou o elemento
			}
			temporary.push(el); // adicionar na pilha temporária
		}
		
		// restaurar pilha
		while (!temporary.isEmpty()) {
			this.push(temporary.pop());
		}
		
		return false;// retornar falso caso não encontrou o elemento
	}
	
	// 11) Implemente um método que inverte a ordem dos elementos da pilha.
	public void flip() {
		StaticStack <E> temporary1 = new StaticStack<>(this.numElements());
		StaticStack <E> temporary2 = new StaticStack<>(this.numElements());
		
		// inverter elementos enviando à pilha temporária
		while (!this.isEmpty()) {
			temporary1.push(this.pop()); // adicionar na pilha 1 para inverter a ordem na próxima pilha
		}
		
		while (!temporary1.isEmpty()) {
			temporary2.push(temporary1.pop()); // adicionar na pilha 2 para inverter a ordem ao restaurar a pilha
		}
		
		while (!temporary2.isEmpty()) {
			this.push(temporary2.pop()); // restaurar pilha
		}
	}
	
	// 12) Implemente uma sobrecarga do método push que recebe como parâmetro uma pilha, em vez de um elemento. 
	// Esse método deve adicionar à pilha corrente os elementos da pilha passada como parâmetro, 
	// porém mantendo a ordem original — ou seja, o elemento do topo da pilha passada como parâmetro deve ficar no topo da pilha corrente.
	public void push(StaticStack <E> s1) throws OverflowException {
		if (isFull())
			throw new OverflowException();
		
		StaticStack <E> temporary = new StaticStack<E>(this.numElements() + s1.numElements());
		
		// passar pilha original para a pilha temporária
		while (!this.isEmpty()) {
			temporary.push(this.pop());
		}
		// adicionar na pilha temporária a pilha do parâmetro
		while (!s1.isEmpty()) {
			temporary.push(s1.pop());
		}
		
		// restaurar pilha original
		while (!temporary.isEmpty()) {
			this.push(temporary.pop());
		}
	}
	
	// 13) Implemente um método equals para a pilha. Uma pilha será igual a outra se contiver os mesmos elementos, empilhados na mesma ordem. 
	// Para comparar os elementos, use também o método equals
	public boolean equals(StaticStack <E> s1) {
		StaticStack <E> temporary1 = new StaticStack<E>(this.numElements());
		StaticStack <E> temporary2 = new StaticStack<E>(this.numElements());
		E elementStack1, elementStack2;
		
		// comparar elementos se se são iguais
		while (!this.isEmpty()) {
			elementStack1 = this.pop(); // pilha original
			elementStack2 = s1.pop(); // pilha do parâmetro
			if (elementStack1.equals(elementStack2)) {
				temporary1.push(elementStack1); // adicionar na pilha temporária a pilha original
				temporary2.push(elementStack2); // adicionar na pilha temporária a pilha do parâmetro
			}
		}
		System.out.println(temporary1.numElements());
		System.out.println(temporary2.numElements());
		
		if (temporary1.numElements() == temporary2.numElements() && temporary1.numElements() > 0)
			return true;
		else 
			return false;
	}
	
	// 14) Implemente um método clone para a pilha. Esse método deve retornar uma nova pilha contendo os mesmos elementos da atual. 
	// Os elementos em si não devem ser duplicados.
	public StaticStack<E> clone () {
		StaticStack <E> temporary = new StaticStack<E>(this.numElements());
		StaticStack <E> clone = new StaticStack<E>(this.numElements());
		
		// colocar na pilha temporária
		while (!this.isEmpty()) {
			temporary.push(this.pop());
		}
		
		// inverter pilha para a ordem correta igual da pilha original
		while (!temporary.isEmpty()) {
			clone.push(temporary.pop());
		}
		
		return clone;
	}	
}
