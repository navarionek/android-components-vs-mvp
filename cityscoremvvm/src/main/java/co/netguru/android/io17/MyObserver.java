package co.netguru.android.io17;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;

public class MyObserver implements LifecycleObserver {

    private Lifecycle lifecycle;

    public MyObserver(Lifecycle lifecycle) {
        this.lifecycle = lifecycle;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onPause() {

    }

    public void enable() {
        if (lifecycle.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            // do something
        }
    }
}
