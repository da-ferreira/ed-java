
package calculadora;

public class Calculadora {
	public Object soma(double d, double e) {
		return d + e;
	}

	public Object subtracao(double d, double e) {
		return d - e;
	}

	public Object multiplicacao(double d, double e) {
		return d * e;
	}

	public Object divisao(double d, double e) {
		return d / e;
	}

	public Object exponenciacao(double d, double e) {
		return Math.pow(d, e);
	}	
}
