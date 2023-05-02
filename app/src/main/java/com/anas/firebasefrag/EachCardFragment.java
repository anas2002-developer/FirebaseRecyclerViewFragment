package com.anas.firebasefrag;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class EachCardFragment extends Fragment {

    String Name,Course,Email,Pimage;
    public EachCardFragment() {


    }

    public EachCardFragment(String Name, String Course, String Email, String Pimage) {
        this.Name = Name;
        this.Course = Course;
        this.Email = Email;
        this.Pimage = Pimage;
    }

    public EachCardFragment(int contentLayoutId, CircleImageView imgEach_image, TextView txtEach_name, TextView txtEach_course, TextView txtEach_email) {
        super(contentLayoutId);
        this.imgEach_image = imgEach_image;
        this.txtEach_name = txtEach_name;
        this.txtEach_course = txtEach_course;
        this.txtEach_email = txtEach_email;
    }

    CircleImageView imgEach_image;
    TextView txtEach_name,txtEach_course,txtEach_email;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_each_card, container, false);

        imgEach_image = view.findViewById(R.id.imgEach_image);
        txtEach_name = view.findViewById(R.id.txtEach_name);
        txtEach_course = view.findViewById(R.id.txtEach_course);
        txtEach_email = view.findViewById(R.id.txtEach_email);

        txtEach_name.setText(Name);
        txtEach_course.setText(Course);
        txtEach_email.setText(Email);
        Glide.with(getContext()).load(Pimage).into(imgEach_image);

        return view;
    }

    public void onBackPressed(){
        AppCompatActivity activity=(AppCompatActivity) getContext();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.layFL,new RecyclerFragment()).addToBackStack(null).commit();

    }
}