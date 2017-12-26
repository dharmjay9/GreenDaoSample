package com.katerra.greendaosample.database;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.katerra.greendaosample.database.Student;
import com.katerra.greendaosample.database.Student2;

import com.katerra.greendaosample.database.StudentDao;
import com.katerra.greendaosample.database.Student2Dao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig studentDaoConfig;
    private final DaoConfig student2DaoConfig;

    private final StudentDao studentDao;
    private final Student2Dao student2Dao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        studentDaoConfig = daoConfigMap.get(StudentDao.class).clone();
        studentDaoConfig.initIdentityScope(type);

        student2DaoConfig = daoConfigMap.get(Student2Dao.class).clone();
        student2DaoConfig.initIdentityScope(type);

        studentDao = new StudentDao(studentDaoConfig, this);
        student2Dao = new Student2Dao(student2DaoConfig, this);

        registerDao(Student.class, studentDao);
        registerDao(Student2.class, student2Dao);
    }
    
    public void clear() {
        studentDaoConfig.clearIdentityScope();
        student2DaoConfig.clearIdentityScope();
    }

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public Student2Dao getStudent2Dao() {
        return student2Dao;
    }

}
