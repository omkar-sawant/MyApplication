package com.example.domain.interactor;

import com.example.domain.executor.PostExecutionThread;
import com.example.domain.executor.ThreadExecutor;


import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

/**
 * Created by A653401 on 04-01-2017.
 * This is a Base interactor class which is being extended by all other UseCase(Interactors).
 */

public abstract class Interactor {

    /*
    ThreadExecutor - A new Thread creted for execution.
     */
    private final ThreadExecutor threadExecutor;
    /*
    PostExecutionThread - This is the UI Thread.
     */
    private final PostExecutionThread postExecutionThread;
    private Subscription subscription = Subscriptions.empty();

    protected Interactor(
            ThreadExecutor threadExecutor,
            PostExecutionThread postExecutionThread) {
        if (threadExecutor == null || postExecutionThread == null) {
            throw new IllegalArgumentException("Null not allowed");
        }
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }

    protected abstract Observable buildUseCaseObservable();

    /**
     * Observable is subscribe on a thread from JobExecutor, which observed on UI thread.
     * The result is passed to subscribed subscriber.
     * @param useCaseSubscriber - A callback subscriber passed from Presentr layer.
     */
    public void execute(Subscriber useCaseSubscriber) {
        this.subscription = this.buildUseCaseObservable()
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.getScheduler())
                .subscribe(useCaseSubscriber);
    }

    public void unsubscribe() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
