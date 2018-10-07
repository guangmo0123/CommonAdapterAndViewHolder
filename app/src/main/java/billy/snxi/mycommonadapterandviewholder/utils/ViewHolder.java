package billy.snxi.mycommonadapterandviewholder.utils;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 一个通用的ViewHolder
 * 原理：<br/>
 * 在adapter中调用getViewHolder()来获取一个ViewHoloder<br/>
 * 每个ViewHolder中均创建了集合SparseArray<View> mViews，用于存储该ViewHolder中的View<br/>
 * 而在ViewHolder中调用getView()时，通过viewid来返回view，<br/>
 * 第一次调用时则findViewById，并将view添加至mViews中，下次调用则直接从mVIews中获取<br/>
 * 从而实现了ViewHolder的作用，减少View的findViewById<br/>
 */
public class ViewHolder {

    private Context mContext;
    private LayoutInflater mInflater;
    private SparseArray<View> mViews;   //集合，类似于map，但key只能为int，效率高于map
    private int mPosition;
    private View mConvertView;

    public ViewHolder(Context context, LayoutInflater inflater, ViewGroup parent, int layoutResId) {
        this.mContext = context;
        this.mInflater = inflater;
        mViews = new SparseArray<>();
        mConvertView = mInflater.inflate(layoutResId, parent, false);
        mConvertView.setTag(this);
    }

    /**
     * 获取Viewholder<br/>
     * 若convertView==null，new ViewHolder，否则convertView.getTag()
     *
     * @param context
     * @param inflater    一个adapter只需要一次inflater创建即可，因此不再ViewHolder中重复创建，由adapter直接传入
     * @param parent      BaseAdapter的getView的传入同名的参数
     * @param convertView BaseAdapter的getView的传入同名的参数
     * @param layoutResId item的layout布局资源resid
     * @param position    BaseAdapter的getView的传入同名的参数
     * @return
     */
    public static ViewHolder getViewHolder(Context context, LayoutInflater inflater,
                                           ViewGroup parent, View convertView, int layoutResId, int position) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder(context, inflater, parent, layoutResId);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.mPosition = position;
        return holder;
    }

    /**
     * 获取item中指定resid的view
     *
     * @param viewId
     * @param <T>
     * @return
     */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            //将当前的view保存至集合中
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public Context getContext() {
        return mContext;
    }

    public LayoutInflater getLayoutInflater() {
        return mInflater;
    }

    public int getPosition() {
        return mPosition;
    }

    public View getConvertView() {
        return mConvertView;
    }

    /*-------- 以下为常用控件的属性设置，可以不断完善各种控件的各种属性设置 ------------*/

    /**
     * 给textview及其子类（如：EditText）设置显示的text
     *
     * @param viewId
     * @param text
     * @return
     */
    public ViewHolder setText(int viewId, String text) {
        TextView view = getView(viewId);
        view.setText(text);
        return this;
    }

    /**
     * 给imageview设置图片资源
     *
     * @param viewId
     * @param imageResId
     * @return
     */
    public ViewHolder setImageResource(int viewId, int imageResId) {
        ImageView view = getView(viewId);
        view.setImageResource(imageResId);
        return this;
    }

}
