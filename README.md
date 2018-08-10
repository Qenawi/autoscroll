# autoscroll
 [ ![Download](https://api.bintray.com/packages/qenawi/PandaAutoScroll/qenawi.panda.autosc/images/download.svg) ](https://bintray.com/qenawi/PandaAutoScroll/qenawi.panda.autosc/_latestVersion) 
 
### Gradle
```

 implementation 'qenawi.panda.autosc:autosc:1.0.0'
 
```

## Maven
        maven { url "https://dl.bintray.com/qenawi/PandaAutoScroll" }
## Authors

* **MrQenawi😏** 
## How To use

* 1 -> MainActivity extends AppCompatActivity implements PandaCallBack // implement interface to get callbacks each nSeconds (defult n = 2) 
* 2 ->    private AutoScMain autoScMain =new AutoScMain(this);  // creat instance from AutoScMain this->PandaCallBack
* 3 -> add  autoScMain.Stop() at onPause  &  autoScMain.Resume();  at onResume
* 4 -> put  autoScMain.Start(); after you initialize your viewpager or what ever you want to add auto Scroll on it 🤤
* 5-> do your logic code in 
@Override
    public void PandaTimer(){}

