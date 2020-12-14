package day13;

import static java.math.BigInteger.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import myMath.MyMath;

public class Day13_2 extends Day13_1 {

	List<Integer> moduli = new ArrayList<>();
	Map<Integer, Integer> remainders = new HashMap<>();

	public static void main(String[] args) {
		new Day13_2().testAndPrint();
	}

	@Override
	protected String processBusses(int startTime, String[] busses) {
		for (int i = 0; i < busses.length; i++) {
			if (!busses[i].equals("x")) {
				Integer busNumber = Integer.valueOf(busses[i]);
				moduli.add(busNumber);
				remainders.put(busNumber, (busNumber - i) % busNumber);
			}
		}
		return processRemainders();
	}

	private String processRemainders() {
		return String.valueOf(processRemaindersEfficiently());
		// return String.valueOf(processRemaindersNaively());
	}

	// https://gadial.net/2012/09/12/chinese_remainder_theorem/
	private BigInteger processRemaindersEfficiently() {
		List<BigInteger> n = new ArrayList<>();
		List<BigInteger> d = new ArrayList<>();
		List<BigInteger> e = new ArrayList<>();
		BigInteger result = ZERO;
		BigInteger m = moduli
				.stream()
				.map(BigInteger::valueOf)
				.reduce(ONE, (a, b) -> a.multiply(b));

		for (int i = 0; i < moduli.size(); i++) {
			BigInteger m_i = getModulus(i);
			n.add(m.divide(m_i));
			d.add(MyMath.gcd(n.get(i), m_i)[1]);
			if (d.get(i).compareTo(ZERO) < 0) {
				d.set(i, d.get(i).add(m_i));
			}
			e.add(n.get(i).multiply(d.get(i)));
			result = result.add(e.get(i).multiply(getRemainder(i)));
		}

		return result.mod(m);
	}

	private BigInteger getRemainder(int i) {
		return BigInteger.valueOf(remainders.get(moduli.get(i)));
	}

	private BigInteger getModulus(int i) {
		return BigInteger.valueOf(moduli.get(i));
	}
}
