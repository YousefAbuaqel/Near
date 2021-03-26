package com.mine.near;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

/**
 * Created by Devlomi on 05/04/2017.
 */

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.StudentHolder> {
    private Context context;
    private List<PostView> studentList;

    public PostAdapter(Context context, List<PostView> studentList) {
        this.context = context;
        this.studentList = studentList;
    }

    @Override
    public StudentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_row, parent, false);
        return new StudentHolder(row);
    }

    @Override
    public void onBindViewHolder(StudentHolder holder, int position) {
        final PostView student = studentList.get(position);
        String Uid = student.Uid;
        holder.studentNameTv.setText("غير معرف");
        holder.studentAvgTv.setText(String.valueOf(student.getPost()));

      /*  holder.editStudentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, EditStudentActivity.class);
                intent.putExtra("name", student.getName());
                context.startActivity(intent);
            }
        });*/


      /*  holder.deleteStudentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference ref = database.getReference();
                Query query = ref.child("students").orderByChild("name").equalTo(student.getName());

                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            snapshot.getRef().removeValue();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    class StudentHolder extends RecyclerView.ViewHolder {
        TextView studentNameTv, studentAvgTv;
        /*Button deleteStudentBtn, editStudentBtn;*/

        public StudentHolder(View itemView) {
            super(itemView);
            studentNameTv = (TextView) itemView.findViewById(R.id.username);
            studentAvgTv = (TextView) itemView.findViewById(R.id.post);
            /*deleteStudentBtn = (Button) itemView.findViewById(R.id.delete_student);
            editStudentBtn = (Button) itemView.findViewById(R.id.edit_student);*/


        }
    }
}