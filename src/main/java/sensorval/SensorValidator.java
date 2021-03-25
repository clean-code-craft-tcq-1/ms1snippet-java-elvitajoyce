package sensorval;

import java.util.List;

public class SensorValidator {
	public static boolean isJumpGreaterThanMaxDelta(double value, double nextValue, double maxDelta) {
		if (nextValue - value > maxDelta) {
			return false;
		}
		return true;
	}

	public static boolean validateReadings(List<Double> values, double maxDelta) {
		if (values != null) {
			return validateJumps(values, maxDelta);
		}
		return false;

	}

	private static boolean validateJumps(List<Double> values, double maxDelta) {
		int lastButOneIndex = values.size() - 1;
		for (int i = 0; i < lastButOneIndex; i++) {
			if (!isJumpGreaterThanMaxDelta(values.get(i), values.get(i + 1), maxDelta)) {
				return false;
			}
		}
		return true;
	}
}
