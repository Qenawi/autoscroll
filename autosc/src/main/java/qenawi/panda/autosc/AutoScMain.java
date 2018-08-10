package qenawi.panda.autosc;

import android.util.Log;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.schedulers.Timed;

public class AutoScMain {
    private CompositeDisposable cdisposable;
    private PandaCallBack pandaCallBack;

    public AutoScMain(PandaCallBack pandaCallBack)
    {
this.pandaCallBack=pandaCallBack;
    }

    private void AddDisposable(Disposable disposable)
    {
        if (cdisposable == null || cdisposable.isDisposed())
        {
            cdisposable = new CompositeDisposable();
        }
        cdisposable.add(disposable);
    }

    private Disposable StartTimer()
    {
        Log.v("Panda","Start IS OK");

        return (Observable.interval(2000L, TimeUnit.MILLISECONDS).timeInterval().doOnNext
                (
                        t -> {
                            Log.v("CurrentWorkingThread", Thread.currentThread().getName());
                        }
                )
                .observeOn(AndroidSchedulers.mainThread()).subscribe(S -> {
                            if (IsDisposed()) {
                                return;
                            }
                            Notify(S);
                        },
                        t ->
                        {
                            if (IsDisposed()) {
                                return;
                            }
                            t.printStackTrace();
                        }
                ));
    }

    private void Notify(Timed<Long> s)
    {

        Log.v("CurrentNotifyThread", Thread.currentThread().getName());
pandaCallBack.PandaTimer();
    }

    private void Dispose()
    {
        if (cdisposable != null && !cdisposable.isDisposed())
        {
            cdisposable.clear();
            cdisposable.dispose();
            Log.v("Panda","Disposec IS OK");

        }
    }

    private Boolean IsDisposed()
    {
        return cdisposable == null || cdisposable.isDisposed();
    }

    public void Start() {
        AddDisposable(StartTimer());
    }
    public void Resume()
    {
        if (IsDisposed())
        {
            Log.v("Panda","OnResume IS OK");
            AddDisposable(StartTimer());
        }
    }


    public void Stop() {
        Log.v("Panda","Stop IS OK");

        Dispose();
    }
}
