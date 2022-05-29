public class StaticQueue<E> implements Queue<E> {

	private int first;
	private int last;
	private E elements[];

	public StaticQueue(int maxSize) {
		elements = (E[])new Object[maxSize];
		first = last = -1;
	}

	public boolean isEmpty() {
		return first == -1;
	}

	public boolean isFull() {
		return first == ((last + 1) % elements.length);
	}

	public int numElements() {
		if (isEmpty())
			return 0;
		else {
			int n = elements.length; // p/ legibilidade da expressÃ£o abaixo
			return ((n + last - first) % n) + 1;
		}
	}

	public void enqueue(E element) throws OverflowException {
		if (isFull())
			throw new OverflowException();
		else {
			if (last == -1)
				first = last = 0;
			else
				last = (last + 1) % elements.length;
			elements[last] = element;
		}
	}

	public E dequeue() throws UnderflowException {
		if (isEmpty())
			throw new UnderflowException();
		E element = elements[first];
		elements[first] = null; // p/ coleta de lixo
		if (first == last)
			first = last = -1;
		else
			first = (first + 1) % elements.length;

		return element;
	}

	public E front() throws UnderflowException {
		if (isEmpty())
			throw new UnderflowException();
		return elements[first];
	}

	public E back() throws UnderflowException {
		if (isEmpty())
			throw new UnderflowException();
		return elements[last];
	}

	public String toString() {
		if (isEmpty())
			return "[Empty]";
		else {
			String s = "[" + elements[first];
			int n = numElements();
			for (int i = 1; i < n; i++) {
				int k = (first + i) % elements.length;
				s += ", " + elements[k];
			}
			s += "]";
			return s;
		}
	}
	
	// Implemente, em uma classe qualquer, um método que remove todas as ocorrências 
	// de um determinado elemento em uma fila de caracteres. Considere a assinatura a seguir:
	public void exterminateFromQueue(Queue<Character> q, char element) {
		// salvar uma fila auxiliar para guardar só os elementos que não têm o elemento que quero que não esteja na fila
		StaticQueue<Character> queueAuxiliar = new StaticQueue<Character>(q.numElements());
		
		char value;
		while (!q.isEmpty()) {
			value = q.dequeue(); // retirar o valor da posição atual. E descartar o valor se for igual ao element porque não faço nada com ele
			if (value != element) { // testar se a posição atual é diferente do elemento que busco
				queueAuxiliar.enqueue(value);
			}
			
			while (!queueAuxiliar.isEmpty()) {
				q.enqueue(queueAuxiliar.dequeue()); // colocar só os valores que não têm o elemento que quero retirar
			}
		}
	}
	
	// Implemente o método contains, definido abaixo, que informa se a fila contém determinado elemento.
	public boolean contains (E element) {
		while (!isEmpty()) {
			if (front() == element) { // comparar se o valor atual é igual ao element buscado
				return true;
			}
			dequeue(); // retirar o elemento da lista. Isso é para comparar no if acima
		}
		return false; // não encontrado o element
	}
	
	// Implemente um método que inverte a ordem dos elementos da fila.
	public void flip() {
		E arrayAuxiliar[] = (E[]) new Object[numElements()]; // array auxiliar para guardar valores para depois adicionar na fila na ordem inversa
		for (int i=0; i < arrayAuxiliar.length; i++) {
			arrayAuxiliar[i] = dequeue(); // retirar cada elemento e guardar no arrayAuxiliar
		}
		
		for (int i=arrayAuxiliar.length -1; i >= 0; i--) { // inverter a ordem do loop do array
			enqueue(arrayAuxiliar[i]); // adicionar cada elemento na ordem inversa
		}
	}
	
	// 5) Implemente uma sobrecarga do método enqueue que recebe como parâmetro uma quantidade de elementos variáveis, mantendo a primeira pilha na frente. 
	public void concatenateQueue (Queue<E> original, E ... variableArgs) { // argumentos de tamanho variável
		StaticQueue<E> queueAuxiliar = new StaticQueue<E>(original.numElements() + variableArgs.length);
		
		E value;
		while (!original.isEmpty()) {
			queueAuxiliar.enqueue(original.dequeue()); // colocar pilha original na temporária deixando a original vazia
		}
		for (int i=0; i < variableArgs.length; i++) {
			queueAuxiliar.enqueue((E) variableArgs); // adicionar argumentos de tamanho variável
		}
	}
	
	// 6) Implemente uma sobrecarga do método enqueue que recebe como parâmetro uma fila, em vez de um elemento. 
	// Esse método deve adicionar ao final da fila corrente os elementos da fila passada como parâmetro, mantendo a ordem original.
	public E enqueue(Queue<E> queueOriginal, Queue<E> queueAdd) throws UnderflowException {
		// tratar erro se alguma das listas está vazia
		if (queueOriginal.isEmpty() || queueAdd.isEmpty()) {
			throw new UnderflowException();
		}
		
		// salvar uma fila auxiliar
		StaticQueue<E> queueAuxiliar = new StaticQueue<E>(queueOriginal.numElements() + queueAdd.numElements());
		
		// retirar todos os elementos e colocar na fila auxiliar
		while(!queueOriginal.isEmpty()) {
			queueAuxiliar.enqueue(queueOriginal.dequeue());	
		}
		while(!queueAdd.isEmpty()) {
			queueAuxiliar.enqueue(queueAdd.dequeue());
		}
		
		return (E) queueAuxiliar;
	}
}
