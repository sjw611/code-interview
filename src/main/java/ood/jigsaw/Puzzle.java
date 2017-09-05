package ood.jigsaw;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Puzzle {
	private int edgeLength;
	private Set<PuzzleBlock> blocks = new HashSet<>();

	public Puzzle(int edgeLength) {
		this.edgeLength = edgeLength;
		initPuzzle();
	}

	private void initPuzzle() {
		for (int i = 0; i < edgeLength * edgeLength; ++i) {
			blocks.add(new PuzzleBlock(null, null, null, null, null));
		}
	}

	public List<List<PuzzleBlock>> solve() {
		return null;
	}
}
