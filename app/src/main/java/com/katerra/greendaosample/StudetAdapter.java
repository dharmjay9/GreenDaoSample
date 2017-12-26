package com.katerra.greendaosample;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.katerra.greendaosample.database.Student;

import java.util.List;

/**
 * Created by divum on 24/12/17.
 */

public class StudetAdapter extends RecyclerView.Adapter<StudetAdapter.MyViewHolder>{
    private StudentClickListener clickListener;
    private List<Student> dataset;
    public interface StudentClickListener {
        void onStudentClick(int position);
    }

    public StudetAdapter(StudentClickListener clickListener) {
        this.clickListener = clickListener;
        this.dataset = dataset;
    }

    public void setStudent(@NonNull List<Student> notes) {
        dataset = notes;
        notifyDataSetChanged();
    }
    public Student getStudents(int position) {
        return dataset.get(position);
    }

    @Override
    public StudetAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.student_list_layout, parent, false);
        return new MyViewHolder(view, clickListener);
    }

    @Override
    public void onBindViewHolder(StudetAdapter.MyViewHolder holder, int position) {
        Student student = dataset.get(position);
        holder.sName.setText(student.getName());
        holder.address.setText(student.getAddress());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView sName;
        public TextView address;
        public MyViewHolder(View itemView,final StudentClickListener clickListener) {
            super(itemView);
            sName = itemView.findViewById(R.id.name);
            address = itemView.findViewById(R.id.address);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (clickListener != null) {
                        clickListener.onStudentClick(getAdapterPosition());
                    }
                }
            });
        }


    }
}


