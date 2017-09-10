package ood.filesystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Directory extends File {

	private Set<File> files;
	private File current;
	private File parent;

	public File getCurrent() {
		return current;
	}

	public File getParent() {
		return parent;
	}

	public List<File> list() {
		return Collections.unmodifiableList(new ArrayList<>(files));
	}

	public File createFile(File f) {
		files.add(f);
		return f;
	}

	public File createDirectory() {
		Directory dir = new Directory();
		dir.setParent(this);
		return dir;
	}

	public void setParent(File parent) {
		this.parent = parent;
	}
}
