/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcs.ignite.survey.services;

import com.tcs.ignite.survey.beans.Emptable;
import com.tcs.ignite.survey.beans.Familydetail;
import com.tcs.ignite.survey.utils.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


/**
 *
 * @author ignite151
 */
public class userServices {
     public boolean addUserdata(Emptable c) {

        boolean isAdd = false;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(c);
            session.getTransaction().commit();
            isAdd = true;
        } catch (Exception ex) {
            ex.printStackTrace();
            if (session != null) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
        return isAdd;

    }
      public JSONObject fetchUserData() {
        JSONObject object = new JSONObject();
        JSONArray array = new JSONArray();
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            String hql = "SELECT c from Emptable c";
            Query query = session.createQuery(hql);
//            List<Cmnuserdetails> userList = new <Cmnuserdetails>();
            List<Emptable> userdata = query.list();
            if (userdata.size() > 0) {
                for (int i = 0; i < userdata.size(); i++) {
                    JSONObject jsono = new JSONObject();
                    jsono.put("EmpId", userdata.get(i).getEmpid());
                    jsono.put("EmpName", userdata.get(i).getEmpname());
                    jsono.put("EmpDOB", userdata.get(i).getEmpdob().toString());
                    jsono.put("EmpDOJ", userdata.get(i).getEmpdoj().toString());
                    jsono.put("EmpAadharNo", userdata.get(i).getEmpaadhar());
                    jsono.put("EmpMobile", userdata.get(i).getEmpmobile());
                    jsono.put("EmpPresentAddress", userdata.get(i).getEmppresentaddress());
                    jsono.put("EmpPermanantAddress", userdata.get(i).getEmppermanantaddress());
                    
                    array.add(jsono);
                }
            }
            object.put("UserData", array);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (session != null) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
        return object;
    }

}
