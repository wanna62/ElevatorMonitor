package com.elevator.elevatormonitor.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.elevator.elevatormonitor.R;

import java.util.List;

public class InformationGridViewAdapter extends BaseAdapter{


        private final Context mContext;
        private final List<ResultBeanData.ResultBean.RecommendInfoBean> datas;

        public InformationGridViewAdapter(Context mContext, List<ResultBeanData.ResultBean.RecommendInfoBean> recommend_info) {
            this.mContext = mContext;
            this.datas = recommend_info;
        }

        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null){
                view = View.inflate(mContext, R.layout.information_item_gridview,null);
                viewHolder = new ViewHolder();
                viewHolder.gridImage = (ImageView) view.findViewById(R.id.grid_item_image);
                viewHolder.gridTitle= (TextView) view.findViewById(R.id.grid_item_title);
                view.setTag(viewHolder);
            }else {
                viewHolder = (ViewHolder) view.getTag();
            }
            //根据位置得到对应的数据
            ResultBeanData.ResultBean.RecommendInfoBean recommendInfoBean = datas.get(position);
            //设置网络图片
            Glide.with(mContext).load(Constants.BASE_URL_IMAGE+recommendInfoBean.getFigure()).into(viewHolder.iv_recommend);
            viewHolder.tv_name.setText(recommendInfoBean.getName());
            viewHolder.tv_price.setText("¥"+recommendInfoBean.getCover_price());
            return view;
        }
        static class ViewHolder{
            ImageView gridImage;
            TextView gridTitle;
        }

}
