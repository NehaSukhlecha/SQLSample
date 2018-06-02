package org.sqlsample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.sqlsample.R;
import org.sqlsample.model.User;

import java.util.ArrayList;

/**
 * Created by Neha on 6/2/18.
 */

public class UserAdapter extends BaseAdapter{

    private ArrayList<User> userArrayList = new ArrayList<>();
    private Context context;
    private LayoutInflater layoutInflater;
    private TextView textView_user_name,textView_email,textView_mobile;

    public UserAdapter(ArrayList<User> userArrayList, Context context) {
        this.userArrayList = userArrayList;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return userArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return userArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        view = layoutInflater.inflate(R.layout.item_user_info, viewGroup, false);
        textView_user_name = view.findViewById(R.id.textView_user_name);
        textView_email = view.findViewById(R.id.textView_email);
        textView_mobile = view.findViewById(R.id.textView_mobile);

        User user = userArrayList.get(position);
        if(user!=null){

            textView_user_name.setText(user.getFirst_name() + " " + user.getLast_name());
            textView_email.setText(user.getEmail());
            textView_mobile.setText(user.getMobile());

        }


        return view;
    }
}
