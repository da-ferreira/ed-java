
package tad_mapa_ordenado_usando_abb.exceptions;

@SuppressWarnings("serial")
public class InvalidEntryException extends RuntimeException {
	public InvalidEntryException(String error) {
		super(error);
	}
}
 