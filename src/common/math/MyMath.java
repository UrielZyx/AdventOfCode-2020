package common.math;

import static java.math.BigInteger.*;

import java.math.BigInteger;

public class MyMath {
	public static long gcd(long x, long y) {
		long t;
		while (true) {
			if (x < y) {
				t = x;
				x = y;
				y = t;
			}
			if (x % y == 0) {
				return y;
			}
			x -= y * (x / y);
		}
	}

	/**
	 * returns GCD and Bézout coefficients.
	 * 
	 * Uses
	 * https://en.wikipedia.org/wiki/Extended_Euclidean_algorithm#Polynomial_extended_Euclidean_algorithm
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public static BigInteger[] gcd(BigInteger x, BigInteger y) {
		BigInteger first = x, second = y, old_s = ONE, s = ZERO, old_t = ZERO, t = ONE, q, tmp;
		while (!second.equals(ZERO)) {
			q = first.divide(second);

			tmp = second;
			second = first.subtract(q.multiply(second));
			first = tmp;

			tmp = s;
			s = old_s.subtract(q.multiply(s));
			old_s = tmp;

			tmp = t;
			t = old_t.subtract(q.multiply(t));
			old_t = tmp;
		}

		return new BigInteger[] { first, old_s, old_t };
	}
}
