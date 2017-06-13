/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcs.ignite.survey.servlets;

import com.tcs.ignite.survey.beans.Emptable;
import com.tcs.ignite.survey.services.userServices;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ignite151
 */
public class AddEmp extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            PrintWriter out = response.getWriter();
            int emplID = Integer.parseInt(request.getParameter("EmpID"));
            String userName = request.getParameter("EmpName");
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date userDOB = formatter.parse(request.getParameter("EmpDOB"));
            Date userDOJ = formatter.parse(request.getParameter("EmpDOJ"));
            int userAadhaarNumber = Integer.parseInt(request.getParameter("EmpAadharNo"));
            int userMobile = Integer.parseInt(request.getParameter("EmpMobileNo"));
            String presentAddress = request.getParameter("EmpPresentAddress");
            String permanentAddress = request.getParameter("EmpPermanantAddress");
            String marital = request.getParameter("EmpMarital");
            Emptable c = new Emptable();
            c.setEmpid(emplID);
            c.setEmpname(userName);
            c.setEmpdob(userDOB);
            c.setEmpdoj(userDOJ);
            c.setEmpaadhar(userAadhaarNumber);
            c.setEmpmobile(userMobile);
            c.setEmppresentaddress(presentAddress);
            c.setEmppermanantaddress(permanentAddress);
            c.setMarital(marital);
            userServices us = new userServices();
            boolean isEmpAdd = us.addUserdata(c);
//        isEmpAdd = us.addUserdata(c);
            if (isEmpAdd) {
                out.print("true");
            } else {
                out.print("false");
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
            Logger.getLogger(AddEmp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
