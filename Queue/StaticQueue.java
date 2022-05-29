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
	
	// 7) Implemente o método abaixo, que insere um elemento na primeira posição da fila.
	// public void enqueueWithPriority(E element)
	public void enqueueWithPriority(E element) throws UnderflowException {
		// exception se a lista está vazia ou não tem valor no parâmetro
		if (last == -1 || element == null) {
			throw new UnderflowException();
		}
		// salvar uma fila auxiliar
		StaticQueue<E> queueAuxiliar = new StaticQueue<E>(elements.length + 1);
		
		queueAuxiliar.enqueue(element); // adicionar elemento na primeira posição da fila
		
		// colocar na fila AUXILIAR todos os elementos
		while (!this.isEmpty()) {
			queueAuxiliar.enqueue(this.dequeue());
		}
		
		// passar para a fila ORIGINAL todos os elementos
		while (!queueAuxiliar.isEmpty()) {
			this.enqueue(queueAuxiliar.dequeue());
		}
	}
	
	// 8) Implemente um método equals para a fila. Uma fila será igual a outra se contiver os mesmos elementos, 
	// dispostos na mesma ordem. Para comparar os elementos, use também o método equals.
	public boolean equalsQueues(Queue<E> queue2) {
		if (this.numElements() != queue2.numElements()) {
			return false;
		}
		boolean flag = true; // informar se as filas são iguais
		
		// salvar filas auxiliares
		StaticQueue<E> queueAuxiliar1 = new StaticQueue<E>(this.numElements());
		StaticQueue<E> queueAuxiliar2 = new StaticQueue<E>(this.numElements());
		
		// salvar elementos para comparar depois
		E auxiliar1 = (E) new Object();
		E auxiliar2 = (E) new Object();
		
		while(!this.isEmpty()) {
			auxiliar1 = this.dequeue();
			auxiliar2 = queue2.dequeue();
			
			// comparar se os elementos não são iguais
			if (!auxiliar1.equals(auxiliar2)) {
				flag = false;
			}
			queueAuxiliar1.enqueue(auxiliar1); // colocar a fila original na fila auxiliar
			queueAuxiliar2.enqueue(auxiliar2); // colocar a fila original na fila auxiliar
		}
		
		// colocar fila auxiliar na fila original
		while(!queueAuxiliar1.isEmpty()) {
			this.enqueue(queueAuxiliar1.dequeue()); // retirar o elemento da fila auxiliar
			queue2.enqueue(queueAuxiliar2.dequeue()); // retirar o elemento da fila auxiliar
		}
		
		return flag;
	}
	
	// 9) Implemente um método clone para a fila. Esse método deve retornar uma nova fila contendo os mesmos elementos da atual. 
	// Os elementos em si não devem ser duplicados.
	public Queue<E> clone(){
		// processo: esvaziar fila original em duas filas cópias e depois voltar os elementos para a fila original esvaziando uma das filas cópias.
		StaticQueue<E> queueAuxiliar1 = new StaticQueue<E>(this.numElements());
		StaticQueue<E> queueAuxiliar2 = new StaticQueue<E>(this.numElements());
		
		// salvar cada elemento para depois salvar nas filas auxiliares
		E elementAuxiliar = (E) new Object();
		
		// salvar elementos nas filas auxiliares
		while(!this.isEmpty()) {
			elementAuxiliar = this.dequeue();
			
			queueAuxiliar1.enqueue(elementAuxiliar);
			queueAuxiliar2.enqueue(elementAuxiliar);
		}
		
		// restaurar fila original: retirando todos os elementos da fila auxiliar e colocando na original
		while(!queueAuxiliar1.isEmpty()) {
			this.enqueue(queueAuxiliar1.dequeue());
		}
		
		return queueAuxiliar2;
	}
	
		// Implemente o método split, de acordo com a assinatura definida a seguir, que divide a fila em duas partes. 
	// A fila corrente deve permanecer somente com os elementos do início até a primeira ocorrência de element, inclusive. 
	// O restante dos elementos deve ser retornado em uma nova fila. Para comparar os elementos, utilize o método equals.
	public Queue<E> split(E element) {
		// salvar filas auxiliares
		StaticQueue<E> queueAuxiliar1 = new StaticQueue<E>(this.numElements());
		StaticQueue<E> queueAuxiliar2 = new StaticQueue<E>(this.numElements());
		
		E elementAuxiliar = (E) new Object(); // salvar elemento num objeto auxiliar
		boolean flag = false; // flag para comparar se o elemento do parâmetro é igual ao elemento atual da fila para 
		
		while(!this.isEmpty()) {
			elementAuxiliar = this.dequeue(); // colocar o elemento atual no objeto elementAuxiliar
			
			if (flag == false) {
				queueAuxiliar1.enqueue(elementAuxiliar); // colocar na fila auxiliar 1 o elemento atual
			}
			if (flag == true) {
				queueAuxiliar2.enqueue(elementAuxiliar);  // colocar na fila auxiliar 2 o elemento atual porque encontrou o element do parâmetro
			}
			
			if (elementAuxiliar.equals(element)) { // setar que encontrou o elemento
				flag = true;
			}
		}
		
		while(!queueAuxiliar1.isEmpty()) {
			this.enqueue(queueAuxiliar1.dequeue());
		}
		
		return queueAuxiliar2; // retornar apenas o final da fila depois do element do parâmetro
	}
	
		// 11) Implemente um método que percorra a fila e mova para o final todas as ocorrências de um determinado elemento
	public void moveToBackAllOccurrencesOf(E element) {
		// salvar filas auxiliares para passsar os elementos para elas
		StaticQueue<E> queueAuxiliar1 = new StaticQueue<E>(this.numElements());
		StaticQueue<E> queueAuxiliar2 = new StaticQueue<E>(this.numElements()); 
		
		E elementAuxiliar = (E) new Object(); // salvar o elemento atual num objeto
		
		while(!this.isEmpty()) {
			elementAuxiliar = this.dequeue();
			
			if (elementAuxiliar.equals(element)) {
				queueAuxiliar2.enqueue(elementAuxiliar); // salvar na segunda fila os elementos iguais identificados pelo parâmetro
			} else {
				queueAuxiliar1.enqueue(elementAuxiliar); 
			}
		}
		
		while(!queueAuxiliar1.isEmpty()) {
			this.enqueue(queueAuxiliar1.dequeue()); // juntar na fila original a primeira parte
		}
		while (!queueAuxiliar2.isEmpty()) {
			this.enqueue(queueAuxiliar2.dequeue()); // juntar na fila orignal a segunda parte com os elementos iguais identificados no parâmetro
		}
	}
	
	// 12) Implemente na classe StaticQueue um método que aumente a capacidade de armazenamento da fila, se necessário, para o valor passado como parâmetro. 
	// Os elementos atuais devem ser preservados.
	public void ensureCapacity(int capacity) throws UnderflowException {
		// salvar fila auxiliar
		StaticQueue<E> auxiliarQueue = new StaticQueue<E>(this.numElements());
		int oldCapacity = this.numElements();
		
		// passar os elementos da fila original para a fila auxiliar
		while(!this.isEmpty()) {
			auxiliarQueue.enqueue(this.dequeue());
		}
		
		this.elements = (E[]) new Object[oldCapacity + capacity];
		
		while(!auxiliarQueue.isEmpty()) {
			this.enqueue(auxiliarQueue.dequeue());
		}
		
	}
}
