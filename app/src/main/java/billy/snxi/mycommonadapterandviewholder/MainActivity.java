package billy.snxi.mycommonadapterandviewholder;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import billy.snxi.mycommonadapterandviewholder.utils.CommonAdapter;
import billy.snxi.mycommonadapterandviewholder.bean.Bean;
import billy.snxi.mycommonadapterandviewholder.utils.ViewHolder;

public class MainActivity extends Activity {
    private Context mContext;
    private ListView mListview;
    private List<Bean> mDatas;
    private CommonAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        initView();
        initDatas();
    }

    private void initView() {
        mListview = findViewById(R.id.listview);
    }

    private void initDatas() {
        mDatas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mDatas.add(new Bean("移动开发工程师【" + i + "】",
                    "痴迷于Android开发。乐于分享，善于将技术生活化，唯愿与大千男女攻城狮共同进步【" + i + "】",
                    "2018-09-29",
                    (10080 + i) + ""));
        }
        mAdapter = new CommonAdapter<Bean>(mContext, mDatas, R.layout.item_listview) {

            @Override
            public void setItemViewAttribute(ViewHolder holder, Bean bean) {
                //链式编程
                holder.setText(R.id.tv_title, bean.getTitle())
                        .setText(R.id.tv_desc, bean.getDesc())
                        .setText(R.id.tv_date, bean.getDate())
                        .setText(R.id.tv_phone, bean.getPhone());
            }
        };
        mListview.setAdapter(mAdapter);
    }
}
