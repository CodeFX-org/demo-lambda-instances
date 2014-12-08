# Instances of Non-Capturing Lambdas

This project provides the code samples for the [CodeFX post about instance identity of lambda evaluations](http://blog.codefx.org/jdk/instances-non-capturing-lambdas/). In particular it demonstrates that the current JRE (or at least Oracle JRE 1.8.0_25-b18 for Win 64) reuses the same instance for repeated evaluations of the same non-capturing lambda expression.

## Code

There is not much code. The `ImmediateFuture` is a functional interface which extends [`Future`](http://docs.oracle.com/javase/8/docs/api/java/util/concurrent/Future.html) and only leaves `get()` unimplemented. The `FutureFactory` uses lambda expressions to create instances of this particular `Future`. Finally `CreatingInstances` shows that the non-capturing lambda expression used in `FutureFactory.createWithDefaultResult()` always returns the same instance.

This example uses `Future` to simulate a somewhat realistic use case and to show that this is by no means limited to "obvious" situations where identity of new functional interfaces like `Supplier` or `Consumer` are handled.
