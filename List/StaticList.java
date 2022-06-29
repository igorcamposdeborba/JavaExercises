/**
 * Implementação de uma lista linear com armazenamento estático,
 * baseado em array.
 */
public class StaticList<E> implements List<E> {
	private E[] elements;
	private int numElements;
	private int counter = 0;
	
	/**
	 * Constrói uma lista com um tamanho máximo.
	 * @param maxSize O tamanho máximo da lista
	 */
	public StaticList(int maxSize) {
		elements = (E[])new Object[maxSize];
		numElements = 0;
	}

	public int numElements() {
		return numElements;
	}

	public boolean isEmpty() {
		return numElements == 0;
	}

	public boolean isFull() {
		return numElements == elements.length;
	}
	

	public void insert(E element, int pos) throws OverflowException, IndexOutOfBoundsException{
		// verifica se há espaço na lista
		if (isFull())
			throw new OverflowException();

		// verifica se a posição é válida
		if (pos < 0  ||  pos > numElements)
			throw new IndexOutOfBoundsException();
		
		// desloca para a direita os elementos necessários,
		// abrindo espaço para o novo
		for (int i = numElements-1; i >= pos; i--)
			elements[i+1] = elements[i];
		
		// armazena o novo elemento e ajusta o total
		elements[pos] = element;
		numElements++;
	}

	
	public E remove(int pos) throws UnderflowException, IndexOutOfBoundsException{
		if(isEmpty())
			throw new UnderflowException();
		
		// verifica se a posição é válida
		if (pos < 0  ||  pos >= numElements)
			throw new IndexOutOfBoundsException();
		
		// guarda uma refer ncia temporária ao elemento removido
		E element = elements[pos];
		
		// desloca para a esquerda os elementos necessários,
		// sobrescrevendo a posição do que está sendo removido
		for (int i = pos; i < numElements-1; i++)
			elements[i] = elements[i+1];
		
		// define para null a posição antes ocupada pelo último,
		// para que a coleta de lixo possa atuar, e ajusta o total
		elements[numElements-1] = null;
		numElements--;

		return element;
	}

	
	public E get(int pos) throws IndexOutOfBoundsException{
		// verifica se a posição é válida
		if (pos < 0  ||  pos >= numElements)
			throw new IndexOutOfBoundsException();

		return elements[pos];
	}

	
	public int search(E element) {
		for (int i = 0; i < numElements; i++)
			if (element.equals(elements[i]))
				return i;
		
		// se chegar até aqui, é porque não encontrou
		return -1;
	}
	
	
	public int countElements(E el) throws IllegalArgumentException {
		if (el == null) {
			throw new IllegalArgumentException();
		}
		return  countElements(el, numElements);
	}
	
	private int  countElements(E el, int numElements) {
		if (el != null) {
			counter++;
		}
		
		return counter;
	}
	
	/**
	 * Retorna uma representação String da lista.
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String s = "";
		for (int i = 0; i < numElements; i++)
			s += elements[i] + " ";
		return s;
	}
	
	// 1) Retornar números pares de uma lista, via array
	public Integer[] evenNumbers (List<Integer> lista) {
		int nullSpaces = 0;
		int even = 0;
		
		// Contar espaços vazios da nova lista
		for (int i = 0; i < lista.numElements(); i++) {
			if (lista.get(i) % 2 > 0) {
				nullSpaces++;
			}
		}
		Integer [] evenArray = new Integer[lista.numElements() - nullSpaces]; // criar nova lista e diminuir os espaços vazios
		
		// Colocar numa nova lista apenas números pares
		for (int i=0; i < lista.numElements(); i++) {
			if (lista.get(i) % 2 == 0) {
				evenArray[even++] = lista.get(i);
			}
		}
		return evenArray;
	}
	
	// 2) Intercalar listas
	public List<Character> mergeLists(List<Character> t1, List<Character> t2) {
		List<Character> newList = new StaticList<>(t1.numElements() + t2.numElements());
		
		int countT1 = 0; 
		int countT2 = 0;
		
		while (true) {
			if (countT1 < t1.numElements()) {
				newList.insert(t1.get(countT1++), newList.numElements());
			}
			if (countT2 < t2.numElements()) {
				newList.insert(t2.get(countT2++), newList.numElements());
			}
			if (countT1 >= t1.numElements()
				&& countT2 >= t2.numElements()) {
				break;
			}
		}
		return newList;
	}
	
	// 3) Inserir a segunda lista no início da primeira lista
	public void prependList(List<Double> t1, List<Double> t2) {
		for (int i = t2.numElements() -1; i>=0; i--) {
			t1.insert(t2.get(i), 0);		
		}
		System.out.println(t1);
	}
	
	// 4) Implemente um método que remove da lista um elemento passado como parâmetro. Esse método retorna true quando o elemento é achado e removido, 
	// false caso contrário. Será removida apenas a primeira ocorrência do elemento.
	public boolean remove(E element) {
		// salvar lista auxiliar
		StaticList<E> listAuxiliar = new StaticList<E>(this.numElements);
		boolean flag = false;
		
		E elementAuxiliar1 = (E) new Object();
		int counter1 = 0;
		
		while (!this.isEmpty()) {
			elementAuxiliar1 = this.remove(counter1); // retirar o elemento atual para usar depois
			
			if (elementAuxiliar1.equals(element)) { // encontrou elemento
				return true;
			}
		}

		return flag;
	}
	
	// 5) Implemente um método insertAfter, abaixo, que insere o elemento obj2 uma posição após o elemento obj1. Considere a primeira ocorrência de obj1.
	// Se obj1 não for encontrado, gere uma exceção apropriada.
	public void insertAfter(E obj1, E obj2) throws NullPointerException {
		// salvar lista auxiliar
		StaticList<E> auxiliarList = new StaticList<E>(this.numElements + 2);
		E elementAuxiliar = (E) new Object();
		boolean flag = false;
		boolean flagException = false;
		int dimension = this.numElements();
		int index = 0;
		
			for (int i=0; i < this.numElements; i++) {
				if (this.get(i) == obj1) { // encontrar objeto 1 na lista
					flag = true;// elemento encontrado
					flagException = true;
					index = i + 2;
				}
				// copiar para lista secundária a partir do elemento encontrado
				if (flag == true) {
					elementAuxiliar = this.remove(i); // retirar elemento atual para adicionar na lista auxiliar
					auxiliarList.insert(elementAuxiliar, i); // adicionar na lista auxiliar o elemento
					
					// adicionar na lista o obj2 na posição atual vazia da lista original
					this.insert(obj2, i);
				}
				flag = false;	
			}
			// adicionar na lista original o restante dos elementos que estão na lista temporária
			for (int i = index; i < dimension; i++) { // começar a inserção do próximo índice vazio
				this.insert(elementAuxiliar, i);
			}
			
			if (flagException == true) {
				throw new NullPointerException();
			}
			
		}
	
	
	// 6) Implemente um método que troca de lugar os objetos localizados nas posições passadas como parâmetro. 
	// Se alguma das posições for inválida, deve ser gerada a exceção do Java IndexOutOfBoundsException.
	public void swap (int pos1, int pos2) throws IndexOutOfBoundsException {
		if (pos1 < 0 || pos1 >= this.elements.length || pos2 < 0 || pos2 >= this.elements.length)
			throw new IndexOutOfBoundsException();
		
		if (pos1 != pos2) {
			// salvar elementos numa variável para usar depois
			E value1 = this.remove(pos1); // usei tipo genérico E porque a lista pode ser de qualquer tipo de dado.
			E value2 = this.remove(pos2); //this faz referência ao objeto da lista atual
			
			// inverter ordem
			this.insert(value2, pos1);
			this.insert(value1, pos2);
		}
	}
	
	// 7) Implemente um método que inverte a ordem dos elementos da lista.
	public void flip() {
		// temporary list
		StaticList <E> temporaryList = new StaticList<E>(this.numElements());
		
		int counter = 0;
		// insert each element inner temporary list starting from the end
		for (int i = this.numElements -1; i >= 0; i--) {
			E item = this.remove(i);
			temporaryList.insert(item, counter);
			counter++;
		}
		
		// restore original list with inverted elements
		int i = 0;
		int counterTempList = temporaryList.numElements -1;
		while (!temporaryList.isEmpty()) {
			E item = temporaryList.remove(counterTempList);
			counterTempList--;
			this.insert(item, i);
		}
	}
	
	// 8) Implemente uma sobrecarga do método insert que recebe como parâmetro uma lista, em vez de um elemento. 
	// Esse método deve adicionar à lista corrente os elementos daquela passada como parâmetro, a partir da posição indicada.
	/**
	 * Insere uma lista de elementos na posição indicada.
	 * @param list A lista a ser inserida
	 * @param pos A posição onde o elemento será inserido
	 * 				(iniciando em 0)
	 */
	public void insert (List<E> list, int pos) throws IllegalStateException {
		if (list.numElements() > (this.elements.length - this.numElements()))
			throw new IllegalStateException("Lista maior que o espaço disponível");
		
		E element; // variável temporária
		int counter = this.numElements;
		// passar por toda a lista
		for (int j=0; j < list.numElements(); j++) {
			element = list.get(j); // armazenar o elemento na variável temporária 
			this.insert(element, counter); // inserir o elemento da lista na lista maior
			counter++;
			numElements++;
		}
	 }
	
	// 9) Implemente um método que remove ocorrências múltiplas de elementos na lista. 
	// Para cada elemento contido na lista, somente a primeira ocorrência deve ser mantida.
	public void dedup() {
		// comparar o elemento atual com o próximo e remover o segundo elemento duplicado
		for (int i=0; i < this.numElements; i++) {
			for (int j = i + 1; j < this.numElements; j++) {
				if (this.get(i).equals(this.get(j))) {
					this.remove(j); // remover o segundo duplicado
					j--; // decrementar porque eu removi o j duplicado
				}
			}
		}
	}
	
	//10) Implemente um método equals para a lista. Uma lista será igual a outra se contiver os mesmos elementos, dispostos na mesma ordem. 
	// Para comparar os elementos, use também o método equals. Pesquise como desenvolver o método equals de um objeto no Java.
	public boolean equalsList(List<E> list) {
		int counterSameElements = 0;
		
		// comparar o elemento atual com o próximo e remover o segundo elemento duplicado
		for (int i=0; i < this.numElements; i++) {
			for (int j = i; j < this.numElements; j++) {
				if (this.get(i).equals(list.get(j))) {
					counterSameElements++; // contar que elementos são iguais
				}
			}
		}
		// se listas tiverem o mesmo número de elementos iguais, as listas são iguais
		if (counterSameElements == this.numElements) {
			return true;
		}
		return false;
	}
	
	// 11) Implemente um método clone para a lista. Esse método deve retornar uma nova lista contendo os mesmos elementos da atual. 
	// Os elementos em si não devem ser duplicados.
	public StaticList<E> clone() {
		StaticList <E> clone = new StaticList<E>(this.numElements);
		
		E element;
		// passar pela lista
		for (int i=0; i < this.numElements; i++) {
			// guardar elemento
			element = this.get(i);
			// colocar dentro da lista clone o elemento
			clone.insert(element, i);
		}
		
		return clone;
	}
	
	// 12) Implemente um método que remove da lista os elementos compreendidos entre as posições ini e fim (inclusive). 
	// Ele deve retornar a quantidade de elementos removidos.
	public int remove(int start, int end) {
		int removedElements = 0;
		int newSize = this.numElements - (end - start);
		
		// comparar o elemento atual no range do start ao end
		for (int i = newSize; i >= start; i--) {
			removedElements++;
			this.remove(i);
		}

		return removedElements;
	}
}
