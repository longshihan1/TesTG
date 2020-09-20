package thread.thread;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public interface ExecutorService extends Executor {
    // 启动有序关闭，在这个关闭过程中，会继续执行先前提交的任务，但是不接受新任务，如果已经关闭，调用这个方法没有额外影响
    void shutdown();

    // 尝试停止所有正在执行的任务，停止等待任务的处理，并且返回等待执行的任务列表
    List<Runnable> shutdownNow();

    // 如果Excutor已经关闭，就返回true，否则返回false
    boolean isShutdown();

    // 如果关闭后所有任务都已经完成，就返回true，要注意的是，除非先调用shutdown()方法或者shutdownNow()方法，否则这个方法永远不会返回true
    boolean isTerminated();

    // 阻塞，直到所有任务在关闭请求，或者发生超时，或者当前线程被中断（要注意的是，以最先发生的为准）后完成执行执行
    boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException;

    // 提交一个有返回值的任务以执行，并且返回一个表示该任务挂起结果的Future，Future的get方法将在任务成功完成时返回任务的结果
    <T> Future<T> submit(Callable<T> task);

    // 提交一个可运行的任务以执行，并且返回一个表示该任务挂起结果的Future，Future的get方法将在任务成功完成时返回任务的结果
    <T> Future<T> submit(Runnable task, T result);

    // 提交一个可运行的任务以执行，并且返回一个表示该任务挂起结果的Future，Future的get方法将在任务完成后返回null
    Future<?> submit(Runnable task);

    // 执行给定的任务，当所有任务完成时，返回包含其状态和结果的Future列表，Future列表中的每个元素中的isDone()方法是返回true，
    // 要注意的是，一个已完成的任务可以正常终止，也可以通过抛出异常终止，如果在执行此操作时修改了给定的集合，则此方法的结果将未知
    <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks)
            throws InterruptedException;

    // 执行给定的任务，当所有任务完成时，返回包含其状态和结果的Future列表，Future列表中的每个元素中的isDone()方法是返回true，在返回时，未完成的任务将被取消，
    // 要注意的是，一个已完成的任务可以正常终止，也可以通过抛出异常终止，如果在执行此操作时修改了给定的集合，则此方法的结果将未知
    <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException;

    // 执行给定的任务，如果有的话，就返回一个已成功完成的任务的结果（例如：没有抛出异常），在正常或者异常返回时，未完成的任务将被取消，
    // 要注意的是，如果在执行此操作时修改了给定的集合，则此方法的结果将未知
    <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException;

    // 执行给定的任务，如果有任务在给定超时结束之前完成，就返回已成功完成的任务的结果（例如：没有抛出异常），在正常或者异常返回时，
    // 未完成的任务将被取消，如果在执行此操作时修改了给定的集合，则此方法的结果将未知
    <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException;
}
