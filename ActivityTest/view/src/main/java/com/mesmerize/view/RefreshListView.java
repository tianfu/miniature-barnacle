package com.mesmerize.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;

/**
 * Created by mesmerize on 16/9/3.
 */
public class RefreshListView extends ListView {


    private int measuredHeight;
    private float downY;

    public RefreshListView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    private void init(){

        View headerView = LayoutInflater.from(getContext()).inflate(R.layout.listview_header, null);

        addHeaderView(headerView);

        headerView.measure(0,0);

        measuredHeight = - headerView.getMeasuredHeight();

        hideHeaderView();

    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        switch (ev.getAction()){

            case MotionEvent.ACTION_DOWN:

                downY = ev.getY();

                break;

            case MotionEvent.ACTION_MOVE:

                int distanceY = (int) (ev.getY() - downY);

                int meY = distanceY + measuredHeight;
                setMeasuredHeight(meY);
                break;

            case MotionEvent.ACTION_UP:

                hideHeaderView();
                break;

        }

        return super.onTouchEvent(ev);
    }

    public void hideHeaderView(){

        setMeasuredHeight(measuredHeight);
    }

    public void setMeasuredHeight(int distanceY){

        setPadding(0,distanceY,0,0);
    }


}
