package com.mycompany.mavenproject1.Service;

import com.mycompany.mavenproject1.Entity.WatchTable;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TableRepository {
    public void save(WatchTable watchTable){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction tx = session.beginTransaction();
            session.merge(watchTable);
            tx.commit();
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    public List<WatchTable> findAll() {
        List<WatchTable> list = (List<WatchTable>)  HibernateUtil.getSessionFactory().openSession().createQuery("From WatchTable ").list();
        return list;
    }
    public void delete(WatchTable watchTable) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.delete(watchTable);
            tx1.commit();
        }
    }
    public void deleteByRow(int posRow){
        List<WatchTable> list = findAll();
        for(WatchTable watchTable : list){
            if(watchTable.getPosRow() == posRow){
                delete(watchTable);
                return;
            }
        }
    }
    public void dropTable(){
       Session session = HibernateUtil.getSessionFactory().openSession();
       Transaction tx1 = session.beginTransaction();
       session.createQuery("delete from WatchTable").executeUpdate();
       tx1.commit();
       session.close();
    }
}
