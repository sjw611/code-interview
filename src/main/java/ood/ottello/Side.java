package ood.ottello;

public enum Side {
	DARK, LIGHT;

	public Side flip() {
		if (this == DARK) {
			return LIGHT;
		}
		return DARK;
	}
}
