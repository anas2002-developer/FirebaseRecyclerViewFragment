package com.anas.firebasefrag;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class Adapter_Student extends FirebaseRecyclerAdapter<Model_Recycler,Adapter_Student.ViewHolder_Student> {

    Context context;

    public Adapter_Student(@NonNull FirebaseRecyclerOptions<Model_Recycler> options) {
        super(options);


    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder_Student holder, final int position, @NonNull Model_Recycler model) {
        holder.txtStudent_name.setText(model.getName());
        holder.txtStudent_course.setText(model.getCourse());
        holder.txtStudent_email.setText(model.getEmail());
        Glide.with(holder.imgStudent.getContext()).load(model.getPimage()).into(holder.imgStudent);

        holder.imgStudent.setOnClickListener(v -> {

            AppCompatActivity activity=(AppCompatActivity) v.getContext();
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.layFL,
                    new EachCardFragment(model.getName(),model.getCourse(),model.getEmail(),model.getPimage()))
                    .addToBackStack(null).commit();

        });

    }



    @NonNull
    @Override
    public ViewHolder_Student onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        context=parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_row,parent,false);
        return new ViewHolder_Student(view);
    }

    public class ViewHolder_Student extends RecyclerView.ViewHolder {

        CircleImageView imgStudent;
        TextView txtStudent_name,txtStudent_email,txtStudent_course;

        public ViewHolder_Student(@NonNull View itemView) {
            super(itemView);

            imgStudent=itemView.findViewById(R.id.imgStudent);
            txtStudent_name=itemView.findViewById(R.id.txtStudent_name);
            txtStudent_course=itemView.findViewById(R.id.txtStudent_course);
            txtStudent_email=itemView.findViewById(R.id.txtStudent_email);
        }
    }


}
