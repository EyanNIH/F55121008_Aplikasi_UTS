package com.Muhammad_Ryhan_F55121008.Aplikasi_UTS;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FriendsAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Friends> friend;
    void setFriend(ArrayList<Friends> friend) {
        this.friend = friend;
    }
    public FriendsAdapter(Context context){
        this.context = context;
        friend = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return friend.size();
    }

    @Override
    public Object getItem(int i) {
        return friend.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view =
                    LayoutInflater.from(context).inflate(R.layout.item_teman, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        Friends friends = (Friends) getItem(i);
        viewHolder.bind(friends);
        return view;
    }
    private class ViewHolder {
        private TextView txtName;
        private TextView txtDescription;
        private ImageView imgPhoto;
        ViewHolder (View view) {
            txtName = view.findViewById(R.id.txt_name);
            txtDescription = view.findViewById(R.id.txt_description);
            imgPhoto = view.findViewById(R.id.img_photo);
        }
        void bind(Friends friends) {
            txtName.setText(friends.getName());
            txtDescription.setText(friends.getDescription());
            imgPhoto.setImageResource(friends.getPhoto());
        }
    }
}

