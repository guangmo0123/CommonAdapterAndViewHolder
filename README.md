# AbsListView通用的Adapter和通用的ViewHolder

## 项目介绍
这是一个AbsListView通用的Adapter，并配合通用的ViewHolder，来实现一个通用的Adapter+ViewHolder。</br>
凡是由BaseAdapter能实现的，此通用Adapter均能实现，它封装并实现了BaseAdapter的大部分方法，用户只需要传入Item的布局文件及实现很少部分的代码即可完成。</br>
<b>注：此Demo中的通用只是在Item单一布局时。</b></br>

### 如下为示例代码

给mListView设置Adapter，只需要实现CommonAdapter的setItemViewAttribute方法即可，该方法就是设置Item的属性。<br/>
在CommonAdapter中使用了通用的ViewHolder，不管Item布局是怎样的通用的ViewHolder均可使用，而用户不需要去为每个BaseAdapter编写对应的ViewHolder。</br>

```android
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
```

### 感谢
感谢hyman大神慕课网的教学视频