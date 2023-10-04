package com.nice.taskmanager;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TaskManager 
{
	private static final int DEFAULT_MAX_CAPACITY = 30;

	public static final int PRIORITY_HIGH = 2;
	public static final int PRIORITY_LOW = 0;

	private int maxCapacity = DEFAULT_MAX_CAPACITY;
	
	
	private BlockingQueue<Task> highPriorityQ = new LinkedBlockingQueue<Task>();
	private BlockingQueue<Task> normalPriorityQ = new LinkedBlockingQueue<Task>();
	private BlockingQueue<Task> lowPriorityQ = new LinkedBlockingQueue<Task>();
	
	private List< BlockingQueue<Task> > vector = new ArrayList< BlockingQueue<Task> >();

	//"waiting list":
	//keep them sorted by the timeToInsert, so if we have many items we do not have to iterate all:
	private SortedSet<TimedTask> reoccurences = new TreeSet<TimedTask>();

	
	public TaskManager()
	{
		vector.add(lowPriorityQ);
		vector.add(normalPriorityQ);
		vector.add(highPriorityQ);
	}
	
	/**
	 * 
	 * @param jobNumber
	 * @param priority
	 * @return false if there is no space for this new task. true if successful
	 * @throws IOException 
	 */
			
	public boolean insertTask(int jobNumber, int priority) throws IOException
	{
		return insertTask(jobNumber, priority, 0);		
	}
	
	/**
	 * 
	 * @param jobNumber
	 * @param priority
	 * @param interval
	 * @return false if there is no space for this new task. true if successful
	 * @throws IOException 
	 */
	public boolean insertTask(int jobNumber, int priority, int interval) throws IOException
	{
		handleWaitingReoccurences();

		return innerInsertTask(jobNumber, priority, interval);				
	}

	
	private boolean innerInsertTask(int jobNumber, int priority, int interval) throws IOException
	{
		//validate input....
		if(priority < PRIORITY_LOW || priority > PRIORITY_HIGH)
		{
			//error
			throw new IOException("Error: bad priority value");
		}

		//first of all, make sure we have room for this new task
		int numElements = 0;
		for( BlockingQueue<Task> q : vector )
		{
			numElements += q.size();
		}
		if(numElements >= maxCapacity)
		{
			return false;
		}

		Task taskToInsert = new Task(jobNumber, priority, interval);
				
		//check the priority to analyse what Q to insert to:
		BlockingQueue<Task> q = vector.get( priority );
		
		//if Q is full, offer() returns false. true upon success:
		return q.offer(taskToInsert);
				
	}

	
	private void handleWaitingReoccurences() throws IOException
	{
		for(TimedTask timedTask : reoccurences)
		{
			if(timedTask.timeHasPassed())
			{
				innerInsertTask(timedTask.jobNumber, timedTask.priority, timedTask.interval);
			}
			else		//we meet item that its time hasn;t arrived - so we can stop iteration
				//this structure is sorted by the time-to-insert
			{
				return;
			}
		}
	}

	/**
	 * gets the highest priority task. seach in all Qs, by priority
	 * @return -1 if no jobs are available
	 * @throws IOException 
	 */
	public int getNextJob() throws IOException
	{
		handleWaitingReoccurences();

		//NOTE: reverse iteration 
		for(ListIterator< BlockingQueue<Task> > it = vector.listIterator(vector.size()); it.hasPrevious(); )
		//for(BlockingQueue<Task> q : vector)
		{
			BlockingQueue<Task> q = it.previous();
			Task task = q.poll(); 		//TODO: check poll()
			if( task == null)
				continue;		//to the next Q
			else
			{
				//if this is reoccurenceTask, handle it:
				if(task.getInterval() != 0)
				{
					//put it in a waiting list:
					TimedTask timedTask = new TimedTask(task);
					reoccurences.add(timedTask);
				}
				return task.getJobNumber();
			}
		}
				
		return -1;		//did not find any task in all Qs
	}



	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) 
	{
		this.maxCapacity = maxCapacity;
	}
}