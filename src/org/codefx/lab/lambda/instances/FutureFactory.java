package org.codefx.lab.lambda.instances;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Creates instances of {@link Future}.
 */
public class FutureFactory {

	private FutureFactory() {
		// private constructor for utility class
	}

	/**
	 * Creates a new future with the default result.
	 *
	 * @return a new {@link Future}
	 */
	public static Future<Integer> createWithDefaultResult() {
		ImmediateFuture<Integer> immediateFuture = () -> 0;
		return immediateFuture;
	}

	/**
	 * Creates a new future which returns a random result on each {@link Future#get() get()}.
	 *
	 * @return a new {@link Future}
	 */
	public static Future<Integer> createWithRandomResult() {
		ImmediateFuture<Integer> immediateFuture = new ImmediateFuture<Integer>() {

			@Override
			public Integer get() throws InterruptedException, ExecutionException {
				return (int) Math.random() * 10;
			}
		};
		return immediateFuture;
	}

	/**
	 * Creates a new future with the specified result.
	 *
	 * @param result
	 *            the {@link Future#get() result} of the returned future
	 * @return a new {@link Future}
	 */
	public static Future<Integer> createWithResult(Integer result) {
		ImmediateFuture<Integer> immediateFuture = () -> result;
		return immediateFuture;
	}

}
