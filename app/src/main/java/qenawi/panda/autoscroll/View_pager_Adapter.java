package qenawi.panda.autoscroll;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class View_pager_Adapter extends PagerAdapter
{

    Context mContext;
    public View_pager_Adapter(Context context)
    {
        mContext = context;
    }
    @Override
    public int getCount()
    {
        return 5;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o)
    {
        return view==o;
    }
    @Override
    public CharSequence getPageTitle(int position)
    {

        return ("Page"+ position);
    }
    @Override
    public void destroyItem(ViewGroup collection, int position, Object view)
    {
        collection.removeView((View) view);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position)
    {

        LayoutInflater inflater = LayoutInflater.from(mContext);

        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.view_pager_row, container, false);
        TextView textView=layout.findViewById(R.id.myText);
        textView.setText(" Page  "+position);
        container.addView(layout);
        return layout;
    }
}
