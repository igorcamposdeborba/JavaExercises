/**
 * Interface que define o comportamento de uma lista linear.
 */
public interface List<E> {
	/**
	 * Informa a quantidade de elementos armazenados na lista.
	 * @return A quantidade de elementos armazenados na lista.
	 */
	public int numElements();
	
	/**
	 * Informa se a lista está vazia.
	 * @return Verdadeiro se a lista estiver vazia,
	 * 			falso caso contrário.
	 */
	public boolean isEmpty();
	
	/**
	 * Informa se a lista está cheia.
	 * @return Verdadeiro se a lista estiver cheia,
	 * 			falso caso contrário.
	 */
	public boolean isFull();
	
	/**
	 * Insere um novo elemento na posição indicada.
	 * @param element O elemento a ser inserido
	 * @param pos A posição onde o elemento será inserido
	 * 				(iniciando em 0)
	 */
	public void insert(E element, int pos);
	
	/**
	 * Remove o elemento da posição indicada.
	 * @param pos A posição de onde o elemento será removido
	 * 				(iniciando em 0)
	 * @return O elemento removido
	 */
	public E remove(int pos);
	
	/**
	 * Retorna o elemento da posição indicada, sem removê-lo.
	 * @param pos A posição do elemento
	 * @return O elemento
	 */
	public E get(int pos);
	
	/**
	 * Localiza a primeira ocorrência do elemento indicado na lista.
	 * @param element O elemento a ser localizado
	 * @return A posição da primeira ocorrência do elemento,
	 * 			ou -1 se ele não for encontrado.
	 */
	public int search(E element);
}