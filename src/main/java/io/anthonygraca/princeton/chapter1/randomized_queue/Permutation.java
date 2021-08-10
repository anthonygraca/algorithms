package io.anthonygraca.princeton.chapter1.randomized_queue;

import edu.princeton.cs.algs4.StdIn;

public class Permutation {
  public static void main(String[] args) {
    RandomizedQueue<String> queue = new RandomizedQueue<String>();
  	int number_of_strings = Integer.valueOf(args[0]);
  	while (!StdIn.isEmpty()){
	    String item = StdIn.readString();
	    queue.enqueue(item);
	  }
	  while (number_of_strings > 0){
	    StdOut.println(queue.dequeue());
	    number_of_strings--;
	  }
  }
}
