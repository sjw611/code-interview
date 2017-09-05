package ood.jigsaw;

import java.awt.Image;

public class PuzzleBlock {
	private PuzzleBlockEdge left;
	private PuzzleBlockEdge right;
	private PuzzleBlockEdge up;
	private PuzzleBlockEdge down;
	private Image image;

	public PuzzleBlock(PuzzleBlockEdge left, PuzzleBlockEdge right, PuzzleBlockEdge up, PuzzleBlockEdge down,
			Image image) {
		this.left = left;
		this.right = right;
		this.up = up;
		this.down = down;
		this.image = image;
	}

	public PuzzleBlockEdge getLeft() {
		return left;
	}

	public PuzzleBlockEdge getRight() {
		return right;
	}

	public PuzzleBlockEdge getUp() {
		return up;
	}

	public PuzzleBlockEdge getDown() {
		return down;
	}

	public Image getImage() {
		return image;
	}

}
