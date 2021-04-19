
package list_of_nodes;

public interface Position<Type> {
	/**
	 * @return Retorna o elemento armazenado nesta posição.
	 * @throws InvalidPositionException Se o elemento nao estiver na lista (previous == null e next == null).
	 */
	public Type element() throws InvalidPositionException;
}
