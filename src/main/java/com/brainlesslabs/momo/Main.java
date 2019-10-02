package com.brainlesslabs.momo;

import com.brainlesslabs.momo.examples.MemoryStore;

public class Main {
    public static void main(String... args){
    	
    	//  MemoryStore example
    	System.out.println("== MemoryStore example ==");
    	
    	MemoryStore memoryStore =  new MemoryStore();

    	memoryStore.add("idx1",new String("test 1"));
    	 
    	memoryStore.add("idx2",new String("test 2"));

    	memoryStore.add("idx3",new String("test 3"));

    	memoryStore.show();
    	
    	memoryStore.delete("idx1");
    	 
    	memoryStore.purge();
    	  
    }
}
