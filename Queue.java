// CS 0445 Spring 2022
//
// Testing of simple queue implementations.
// This program should run without changes with your PrimQ1 and PrimQ2 classes.  This
// program requires the following files:
//		QueueInterface.java
//		Moves.java
//		PrimQ1.java
//		PrimQ2.java
//		EmptyQueueException.java

import java.util.*;

public class Queue
{
	public static void main(String [] args)
	{
		// Create ArrayLists of interface types
		ArrayList<QueueInterface<Integer>> kyews = new ArrayList<QueueInterface<Integer>>();
		ArrayList<Moves> moo = new ArrayList<Moves>();
		
		// Add an instance of each Q type to each ArrayList.  Note that we only
		// create two objects here -- each object is being accessed (in turn) as
		// a QueueInterface<T> and as a Moves, with each interface giving access to
		// only the methods defined therein.  Note that we are not using any
		// PrimQ1 or PrimQ2 variables even though we are using objects of those
		// types.
		
		// Important Note: The 10 being passed into the constructor is the
		// size of the underlying array.  In this simple implementation, if the
		// array fills you will no longer be able to enqueue() any items until
		// some have been removed.  A better approach is to "resize" the array
		// when it fills.  We will discuss this approach in the future.
		kyews.add(new PrimQ1<Integer>(10));  moo.add((Moves) kyews.get(0));
		kyews.add(new PrimQ2<Integer>(10));	 moo.add((Moves) kyews.get(1));
	
		// Set moves for each object to 0
		for (Moves m: moo)
			m.setMoves(0);
		
		System.out.print("Adding to Queues: ");	
		for (int i = 0; i < 10; i++)
		{
			Integer X = Integer.valueOf(i);
			System.out.print(X + " ");
			for (QueueInterface<Integer> Q: kyews)
			{
				Q.enqueue(X);
			}
		}
		System.out.println();
		
		for (int j = 0; j < moo.size(); j++)
		{
			System.out.println("Queue " + j + " moves: " + moo.get(j).getMoves());
		}
		System.out.println();

		for (Moves m: moo)
			m.setMoves(0);
		
		// Note the syntax below.  An assignment is being made using cascading
		// method calls. Simply put, this code is iterating through the ArrayList
		// of QueueInterface<Integer> and removing all items from each
		// QueueInterface<Integer> therein.  This could also have been done using
		// the "foreach" version of the for loop or in other ways as well.  Java
		// has many ways of iterating through a collection.
		Integer temp;
		for (int j = 0; j < kyews.size(); j++)
		{
			System.out.print("Removing from Queue " + j + ": ");
			try
			{
				// This looks like an infinite loop, but when the queue is empty
				// the dequeue() method will throw an exception.
				while (true)
				{
					temp = kyews.get(j).dequeue();
					System.out.print(temp + " ");
				}
			}
			catch (EmptyQueueException e)
			{
				// Println when we reach the end
				System.out.println();
			}
		}
		System.out.println();
			
		for (int j = 0; j < moo.size(); j++)
		{
			System.out.println("Queue " + j + " moves: " + moo.get(j).getMoves());
		}
	}
}
		
