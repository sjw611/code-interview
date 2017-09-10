package ood.filesystem;

public interface Permission {
	boolean isRead();
	boolean isWrite();
	boolean isExecute();
}
