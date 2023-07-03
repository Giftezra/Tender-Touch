package com.example.tendertouch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Description of UsersAdapter
 * <p>
 * Auto-generated class for XML file: UsersAdapter
 */
public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserHolder> {

    private Context context;
    private ArrayList<Users> userList;

    public UsersAdapter (Context context, ArrayList<Users> userList) {
        this.context = context;
        this.userList = userList;
    }

    @Override
    public int getItemCount () {
        return userList.size ();
    }

    @NonNull
    @Override
    public UserHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from (context).inflate (R.layout.user_layout,
                parent,false);

        return new UserHolder (view);
    }

    @Override
    public void onBindViewHolder (@NonNull UsersAdapter.UserHolder holder, int position) {

        Users user = userList.get (position);
        holder.SetDetails (user);
    }

    class UserHolder extends RecyclerView.ViewHolder{

        TextView txtCountry, txtDistance, txtGravity, txtDiameter;

        public UserHolder (View itemView){
            super(itemView);

            txtCountry = itemView.findViewById (R.id.txtCountry);
            txtDistance = itemView.findViewById (R.id.txtDistance);
            txtDiameter = itemView.findViewById (R.id.txtDiameter);
            txtGravity = itemView.findViewById (R.id.txtGravity);
        }

        void SetDetails(Users user){
            txtCountry.setText (user.getCountryName ());
            txtGravity.setText (String.format (Locale.UK,
                   "Distance from sun : %d million Km", user.getDistance ()));
            txtDiameter.setText (String.format (Locale.UK,
                    "Surface gravity %d N/kg", user.getGravity ()));
            txtDistance.setText (String.format (Locale.UK,
                    "Distance from sun : %d miles", user.getDistance ()));
        }
    }

}
