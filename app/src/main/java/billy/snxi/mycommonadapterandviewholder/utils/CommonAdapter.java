package billy.snxi.mycommonadapterandviewholder.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * 一个通用的adapter + 通用的ViewHolder<br/>
 * 用户需要实现 setItemViewAttribute()方法来实现view的属性的设置
 *
 * @param <T>
 */
public abstract class CommonAdapter<T> extends BaseAdapter {

    protected Context mContext;
    protected List<T> mDatas;
    protected int mItemLayoutResId;
    protected LayoutInflater mInflater;

    public CommonAdapter(Context context, List<T> mDatas, int itemlayoutId) {
        this.mContext = context;
        this.mDatas = mDatas;
        this.mItemLayoutResId = itemlayoutId;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = ViewHolder.getViewHolder(mContext, mInflater, parent, convertView,
                mItemLayoutResId, position);
        //item的属性设置交给抽象方法去处理，由用户去实现具体的细节
        setItemViewAttribute(holder, getItem(position));
        return holder.getConvertView();
    }

    /**
     * 用户只需要实现此方法来设置Item view的属性即可
     *
     * @param holder
     * @param bean
     */
    public abstract void setItemViewAttribute(ViewHolder holder, T bean);
}
