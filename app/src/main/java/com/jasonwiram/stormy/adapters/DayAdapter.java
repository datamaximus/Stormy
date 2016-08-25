package com.jasonwiram.stormy.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jasonwiram.stormy.R;
import com.jasonwiram.stormy.weather.Day;

public class DayAdapter extends BaseAdapter {

    private Context mContext;
    private Day[] mDays;

    public DayAdapter(Context context, Day[] days) {
        mContext = context;
        mDays = days;
    }

    @Override
    public int getCount() {
        return mDays.length;
    }

    @Override
    public Object getItem(int i) {
        return mDays[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.daily_list_item, null);
            holder = new ViewHolder();
            holder.iconImageView = (ImageView)view.findViewById(R.id.iconImageView);
            holder.temperatueLabel = (TextView) view.findViewById(R.id.temperatureLabel);
            holder.dayLabel = (TextView)view.findViewById(R.id.dayNameLabel);

            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }
        Day day = mDays[i];
        holder.iconImageView.setImageResource(day.getIconId());
        holder.temperatueLabel.setText(day.getTemperatureMax() + "");
        if (i == 0) {
            holder.dayLabel.setText("Today");
        }
        else {
            holder.dayLabel.setText(day.getDayOfTheWeek());
        }
        return view;
    }

    private static class ViewHolder {
        ImageView iconImageView;
        TextView temperatueLabel;
        TextView dayLabel;
    }
}
