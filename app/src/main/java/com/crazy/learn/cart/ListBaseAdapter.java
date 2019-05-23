package com.crazy.learn.cart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.crazy.learn.R;

import java.util.List;

/**
 * Created by zhangqie on 2018/11/15
 * Describe:
 */
public class ListBaseAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private List<CartInfo.DataBean.ItemsBean> list;//商品列表
    private int positionO;//店铺的position

    public ListBaseAdapter(Context context, int position, List<CartInfo.DataBean.ItemsBean> list) {
        this.positionO = position;
        this.layoutInflater = LayoutInflater.from(context);
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (null == convertView) {
            convertView = layoutInflater.inflate(R.layout.item_chlid, null);
            viewHolder = new ViewHolder(convertView, position);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.swipeLayout.setShowMode(SwipeLayout.ShowMode.PullOut);





        viewHolder.cbChild.setChecked(list.get(position).ischeck());
        viewHolder.tvChild.setText(list.get(position).getTitle());
        viewHolder.textView.setText("¥ " + list.get(position).getPrice());
        viewHolder.btnNum.setText(list.get(position).getNum() + "");


        viewHolder.cbChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListenterModel.onItemClick(viewHolder.cbChild.isChecked(), v, positionO, position);
            }
        });



        //删除
        viewHolder.llDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.swipeLayout.close();//隐藏侧滑菜单区域
                onClickDeleteListenter.onItemClick(v,positionO, position);
            }
        });


        return convertView;
    }

    //每个商品的删除

    private OnClickDeleteListenter onClickDeleteListenter;
    public void setOnClickDeleteListenter (OnClickDeleteListenter onClickDeleteListenter){
        this.onClickDeleteListenter=onClickDeleteListenter;
    }



    // CheckBox2接口的方法
    private OnClickListenterModel onClickListenterModel = null;

    public void setOnClickListenterModel(OnClickListenterModel listener) {
        this.onClickListenterModel = listener;
    }






    // 数量接口的方法
    private OnClickAddCloseListenter onClickAddCloseListenter = null;

    public void setOnClickAddCloseListenter(OnClickAddCloseListenter listener) {
        this.onClickAddCloseListenter = listener;
    }


    private OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }





    class ViewHolder implements View.OnClickListener {

        public TextView tvChild;
        public CheckBox cbChild;
        public TextView textView;
        public ImageView imageView;
        private Button btnAdd;
        private Button btnNum;
        private Button btnClose;
        private SwipeLayout swipeLayout;
        private LinearLayout llDelete;
        private int position;

        public ViewHolder(View view, int position) {
            this.position = position;
            tvChild = (TextView) view.findViewById(R.id.tv_child);
            cbChild = (CheckBox) view.findViewById(R.id.cb_child);
            textView = view.findViewById(R.id.item_chlid_money);
            imageView = view.findViewById(R.id.item_chlid_image);
            btnAdd = (Button) view.findViewById(R.id.item_chlid_add);
            btnAdd.setOnClickListener(this);
            btnNum = (Button) view.findViewById(R.id.item_chlid_num);
            btnClose = (Button) view.findViewById(R.id.item_chlid_close);
            btnClose.setOnClickListener(this);

            swipeLayout = view.findViewById(R.id.s);
            llDelete= view.findViewById(R.id.swipe_bottom_del_layout);

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.item_chlid_add:
                    onClickAddCloseListenter.onItemClick(v, 2, positionO, position, Integer.valueOf(btnNum.getText().toString()));
                    break;
                case R.id.item_chlid_close:
                    onClickAddCloseListenter.onItemClick(v, 1, positionO, position, Integer.valueOf(btnNum.getText().toString()));
                    break;
            }
        }
    }
}
