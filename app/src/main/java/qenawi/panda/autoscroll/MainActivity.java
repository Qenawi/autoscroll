package qenawi.panda.autoscroll;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import qenawi.panda.autosc.AutoScMain;
import qenawi.panda.autosc.PandaCallBack;

public class MainActivity extends AppCompatActivity implements PandaCallBack {
    private AutoScMain autoScMain;
    final int viewPagersZ = 5;
    private int counter=0;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        autoScMain = new AutoScMain(this);
        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new View_pager_Adapter(this));
        autoScMain.Start();

    }

    @Override
    public void PandaTimer()
    {
        if (viewPager!=null)
        {
            counter+=1;
            counter=(counter%viewPagersZ);
            viewPager.setCurrentItem(counter);
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        autoScMain.Stop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        autoScMain.Resume();
    }
}
