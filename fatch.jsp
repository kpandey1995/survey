<%-- 
    Document   : fatch
    Created on : May 30, 2017, 11:40:52 AM
    Author     : ignite151
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fatching Page</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row addUser-content">
                <div class="col-md-8">
                    <table border="1" class="table table-bordered table-condensed table-hover table-responsive table-striped" style="border-bottom-color: black;border-radius: 2px;">
                        <thead>
                            <tr>
                                <th>Emp Id</th>
                                <th>Name</th>
                                <th>DOB</th>
                                <th>DOJ</th>
                                <th>Aadhar No</th>
                                <th>Mobile</th>
                                <th>Present Address</th>
                                <th>permanant Address</th>
                            </tr>
                        </thead>
                        <tbody>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <script src="Assets/plugins/jquery/jquery.min.js" type="text/javascript"></script>
        <script>
            $("document").ready(function () {
                $.ajax({
                    method: "POST",
                    url: "FetchUser",
                    success: function (data) {
                        console.log(data);
                        data = JSON.parse(data);
                        console.log(data);

                        for (var i = 0; i < data.UserData.length; i++) {
                            var user = '';
                            user += '<tr>';
                            user += '<td>' + data.UserData[i].EmpId + '</td>';
                            user += '<td>' + data.UserData[i].EmpName + '</td>';
                            user += '<td>' + data.UserData[i].EmpDOB + '</td>';
                            user += '<td>' + data.UserData[i].EmpDOJ + '</td>';
                            user += '<td>' + data.UserData[i].EmpAadharNo + '</td>';
                            user += '<td>' + data.UserData[i].EmpMobile + '</td>';
                            user += '<td>' + data.UserData[i].EmpPresentAddress + '</td>';
                            user += '<td>' + data.UserData[i].EmpPermanantAddress + '</td>';
                            user += '</tr>';
                            $("tbody").append(user);
                        }


                    }
                });
            });
        </script>
    </body>
</html>
