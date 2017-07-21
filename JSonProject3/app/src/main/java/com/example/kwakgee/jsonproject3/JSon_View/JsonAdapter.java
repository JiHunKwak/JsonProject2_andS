package com.example.kwakgee.jsonproject3.JSon_View;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kwakgee.jsonproject3.JSon_Object.ListObject;
import com.example.kwakgee.jsonproject3.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by kwakgee on 2017. 7. 21..
 */

public class JsonAdapter extends RecyclerView.Adapter<JsonAdapter.ViewHolder>{

    List<ListObject> listObjects;
    Context context;

    public JsonAdapter(List<ListObject> listObjects, Context context) {

        this.listObjects = listObjects;
        this.context = context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Picasso.with(context).load(listObjects.get(position).getImgSrc()).into(holder.imageView);
        holder.edt_Rank.setText(listObjects.get(position).getRank());
        holder.edt_Sequence.setText(listObjects.get(position).getSequence());

    }

    @Override
    public int getItemCount() {
        return listObjects.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView imageView;
        public TextView edt_Rank;
        public TextView edt_Sequence;

        public ViewHolder(View itemView){
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.card_ImageView);
            edt_Rank = (TextView) itemView.findViewById(R.id.card_rank_TextView);
            edt_Sequence = (TextView) itemView.findViewById(R.id.card_sequence_TextView);
        }


    }
}
