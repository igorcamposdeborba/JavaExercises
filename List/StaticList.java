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
}
