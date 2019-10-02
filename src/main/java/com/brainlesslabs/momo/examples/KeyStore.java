package com.brainlesslabs.momo.examples;

public interface KeyStore {

	String add(String idx, Object obj);

	Object get(String key);

	boolean delete(String key);

	void purge();

	void show();

}
