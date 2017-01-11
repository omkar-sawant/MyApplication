package com.example.domain.subscriber;

/**
 * Created by A653401 on 04-01-2017.
 */

public class DefaultSubscriber<T> extends rx.Subscriber<T> {
    @Override
    public void onCompleted() {
this.unsubscribe();
    }

    @Override
    public void onError(Throwable e) {
this.unsubscribe();
    }

    @Override
    public void onNext(T t) {

    }
}
