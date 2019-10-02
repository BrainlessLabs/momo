package com.brainlesslabs.momo.examples;

import java.util.HashMap;

public class MemoryStore implements KeyStore {

	private static HashMap<String, Object> mem;

	public String add(String idx, Object obj) {

		if (mem == null) {
			purge();
		}

		mem.put(idx, obj);

		return idx;
	}

	public Object get(String key) {
		if (mem.containsKey(key)) {
			return mem.get(key);
		} else {
			return null;
		}
	}

	public boolean delete(String key) {
		if (mem.containsKey(key)) {
			mem.remove(key);
			return true;
		}
		return false;
	}

	public void purge() {
		mem = new HashMap<>();
	}

	public void show() {
		mem.forEach((key, value) -> {
			System.out.println("idx: " + key + ", value	: " + value);
		});
	}

}