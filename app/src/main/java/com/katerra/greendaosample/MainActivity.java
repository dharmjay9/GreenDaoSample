package com.katerra.greendaosample;

import android.app.DownloadManager;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.katerra.greendaosample.database.DaoMaster;
import com.katerra.greendaosample.database.DaoSession;
import com.katerra.greendaosample.database.Student;
import com.katerra.greendaosample.database.StudentDao;

import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.query.Query;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Queue;

public class MainActivity extends AppCompatActivity {
    private StudentDao studentDao;
    private Query<Student> studentQuery;
    private EditText name;
    private TextView showName;
    private Button save;
    private StudetAdapter studetAdapter;
    public static final boolean ENCRYPTED = true;

    private DaoSession daoSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpViews();

        init();


    }

    private void init() {
        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, ENCRYPTED ? "student-db-encrypted" : "student-db");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();

        // DaoSession daoSession = ((App) getApplicationContext()).getDaoSession();
        studentDao = daoSession.getStudentDao();

        // get all student data in a shorted form

        studentQuery = studentDao.queryBuilder().orderAsc(StudentDao.Properties.Name).build();
        //   studentQuery.list()

        updateStudents();
    }

    private void updateStudents() {
        List<Student> studentList = studentQuery.list();
        studetAdapter.setStudent(studentList);
    }

    private void setUpViews() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        //noinspection ConstantConditions
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        studetAdapter = new StudetAdapter(studentClickListener);
        recyclerView.setAdapter(studetAdapter);
        name = findViewById(R.id.etName);
        save = findViewById(R.id.btnSave);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addStudentsDetails();
            }
        });
    }

    private void addStudentsDetails() {

        String nameText = name.getText().toString();
        name.setText("");

        final DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
        String comment = "Added on " + df.format(new Date());

        Student student = new Student();
        student.setName(nameText);
        student.setAddress(comment);

        studentDao.insert(student);
        Log.d("DaoExample", "Inserted new note, ID: " + student.getId());

        updateStudents();
    }

    StudetAdapter.StudentClickListener studentClickListener = new StudetAdapter.StudentClickListener() {
        @Override
        public void onStudentClick(int position) {
            Student student = studetAdapter.getStudents(position);
            Long studentId = student.getId();

            studentDao.deleteByKey(studentId);
            Log.d("DaoExample", "Deleted students, ID: " + studentId);

            updateStudents();
        }

    };
}
