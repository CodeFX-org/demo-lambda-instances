package org.codefx.lab.lambda.instances;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Future;

public class CreatingInstances {

	public static void main(String[] args) {
		demoAnonymousClass();
		demoNonCapturingLambda();
		demoCapturingLambda();
	}

	private static void demoAnonymousClass() {
		Set<Future<?>> futures = new HashSet<>();

		futures.add(FutureFactory.createWithRandomResult());
		futures.add(FutureFactory.createWithRandomResult());

		System.out.println("Anonymous class: " + futures.size());
	}

	private static void demoNonCapturingLambda() {
		Set<Future<?>> futures = new HashSet<>();

		futures.add(FutureFactory.createWithResult(2));
		futures.add(FutureFactory.createWithResult(5));

		System.out.println("Capturing lambda: " + futures.size());
	}

	private static void demoCapturingLambda() {
		Set<Future<?>> futures = new HashSet<>();

		futures.add(FutureFactory.createWithDefaultResult());
		futures.add(FutureFactory.createWithDefaultResult());

		System.out.println("Non-capturing lambda: " + futures.size());
	}

}
