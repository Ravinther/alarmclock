package com.google.android.gms.drive.widget;

import android.content.Context;
import android.database.CursorIndexOutOfBoundsException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.gms.common.data.DataBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataBufferAdapter extends BaseAdapter {
    private final int Hd;
    private int He;
    private final int Hf;
    private final List Hg;
    private final LayoutInflater Hh;
    private boolean Hi;
    private final Context mContext;

    public DataBufferAdapter(Context context, int resource) {
        this(context, resource, 0, new ArrayList());
    }

    public DataBufferAdapter(Context context, int resource, int textViewResourceId) {
        this(context, resource, textViewResourceId, new ArrayList());
    }

    public DataBufferAdapter(Context context, int resource, int textViewResourceId, List objects) {
        this.Hi = true;
        this.mContext = context;
        this.He = resource;
        this.Hd = resource;
        this.Hf = textViewResourceId;
        this.Hg = objects;
        this.Hh = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public DataBufferAdapter(Context context, int resource, int textViewResourceId, DataBuffer... buffers) {
        this(context, resource, textViewResourceId, Arrays.asList(buffers));
    }

    public DataBufferAdapter(Context context, int resource, List objects) {
        this(context, resource, 0, objects);
    }

    public DataBufferAdapter(Context context, int resource, DataBuffer... buffers) {
        this(context, resource, 0, Arrays.asList(buffers));
    }

    private View m6707a(int i, View view, ViewGroup viewGroup, int i2) {
        View inflate = view == null ? this.Hh.inflate(i2, viewGroup, false) : view;
        try {
            TextView textView = this.Hf == 0 ? (TextView) inflate : (TextView) inflate.findViewById(this.Hf);
            Object item = getItem(i);
            if (item instanceof CharSequence) {
                textView.setText((CharSequence) item);
            } else {
                textView.setText(item.toString());
            }
            return inflate;
        } catch (Throwable e) {
            Log.e("DataBufferAdapter", "You must supply a resource ID for a TextView");
            throw new IllegalStateException("DataBufferAdapter requires the resource ID to be a TextView", e);
        }
    }

    public void append(DataBuffer buffer) {
        this.Hg.add(buffer);
        if (this.Hi) {
            notifyDataSetChanged();
        }
    }

    public void clear() {
        for (DataBuffer close : this.Hg) {
            close.close();
        }
        this.Hg.clear();
        if (this.Hi) {
            notifyDataSetChanged();
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getCount() {
        int i = 0;
        for (DataBuffer count : this.Hg) {
            i = count.getCount() + i;
        }
        return i;
    }

    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return m6707a(position, convertView, parent, this.He);
    }

    public Object getItem(int position) {
        int i = position;
        for (DataBuffer dataBuffer : this.Hg) {
            int count = dataBuffer.getCount();
            if (count <= i) {
                i -= count;
            } else {
                try {
                    return dataBuffer.get(i);
                } catch (CursorIndexOutOfBoundsException e) {
                    throw new CursorIndexOutOfBoundsException(position, getCount());
                }
            }
        }
        throw new CursorIndexOutOfBoundsException(position, getCount());
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        return m6707a(position, convertView, parent, this.Hd);
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.Hi = true;
    }

    public void setDropDownViewResource(int resource) {
        this.He = resource;
    }

    public void setNotifyOnChange(boolean notifyOnChange) {
        this.Hi = notifyOnChange;
    }
}
