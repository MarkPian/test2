package test.MyCache;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class DelayedItem<T> implements Delayed {
	/**
	 * base time
	 */
	private final static long ORIGINAL_TIME = System.nanoTime();

	/**
	 * now time
	 * 
	 * @return long
	 */
	final static long now() {
		return System.nanoTime() - ORIGINAL_TIME;
	}

/*	public static void main(String[] args) {
		System.out.println(now());
	}*/
	
	private static final AtomicLong sequencer = new AtomicLong(0);

	private long sequenceNumber;

	private long time;
	private T item;

	public DelayedItem(T t, long timeout) {
		this.time = now() + timeout;
		this.item = t;
		this.sequenceNumber = sequencer.getAndIncrement();
	}

	public T getItem() {
		return this.item;
	}

	@Override
	public int compareTo(Delayed other) {
		// TODO Auto-generated method stub
		if (other == this)
			return 0;
		if (other instanceof DelayedItem) {
			DelayedItem x = (DelayedItem) other;
			long diff = time - x.time;
			if (diff < 0) {
				return  -1;
			} else if (diff < 0) {
				return -1;
			} else if (diff == 0) {
				return 0;
			}

		}

		return 0;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		long d = unit.convert(time - now(), TimeUnit.NANOSECONDS);
		return d;
	}

}
