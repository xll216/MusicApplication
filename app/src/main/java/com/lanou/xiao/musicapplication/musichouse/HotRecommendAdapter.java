package com.lanou.xiao.musicapplication.musichouse;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou.xiao.musicapplication.R;
import com.lanou.xiao.musicapplication.bean.GeDanBean;

import java.util.List;

/**
 * 　　　　　　　　┏┓　　　┏┓+ +
 * 　　　　　　　┏┛┻━━━┛┻┓ + +
 * 　　　　　　　┃　　　　　　　┃
 * 　　　　　　　┃　　　━　　　┃ ++ + + +
 * 　　　　　　 ████━████ ┃+
 * 　　　　　　　┃　　　　　　　┃ +
 * 　　　　　　　┃　　　┻　　　┃
 * 　　　　　　　┃　　　　　　　┃ + +
 * 　　　　　　　┗━┓　　　┏━┛
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃ + + + +
 * 　　　　　　　　　┃　　　┃　　　　Code is far away from bug with the animal protecting
 * 　　　　　　　　　┃　　　┃ + 　　　　神兽保佑,代码无bug
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃　　+
 * 　　　　　　　　　┃　 　　┗━━━┓ + +
 * 　　　　　　　　　┃ 　　　　　　　┣┓
 * 　　　　　　　　　┃ 　　　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━┳┓┏┛ + + + +
 * 　　　　　　　　　　┃┫┫　┃┫┫
 * 　　　　　　　　　　┗┻┛　┗┻┛+ + + +
 */

public class HotRecommendAdapter extends RecyclerView.Adapter<HotRecommendAdapter.ViewHolder> {
    private List<GeDanBean.HotSongBean.SongBean> songList;

    public void setSongList(List<GeDanBean.HotSongBean.SongBean> songList) {
        this.songList = songList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.hot_recomment_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        GeDanBean.HotSongBean.SongBean song = songList.get(position);
        holder.titleTv.setText(song.getTitle());
        holder.authorTv.setText(song.getTag());
    }


    @Override
    public int getItemCount() {
        return songList != null ? songList.size() : 0;
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView titleTv, authorTv, descriptionTv;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            titleTv = (TextView) itemView.findViewById(R.id.titleTv);
            authorTv = (TextView) itemView.findViewById(R.id.authorTv);
            descriptionTv = (TextView) itemView.findViewById(R.id.descriptionTv);
        }
    }
}
