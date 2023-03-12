<%@ page language="java" contentType="text/html"  pageEncoding="UTF-8"%>
<%@ page import="java.lang.*" import="java.sql.*"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bet Data</title>
</head>
<body>


	<%
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=BettingData;encrypt=true;trustServerCertificate=true;", "sa", "Subhash_9657723827");
	Statement stmt = conn.createStatement();
	String sqlQuery="Select * from bet";
	ResultSet rs = stmt.executeQuery(sqlQuery);
	%>
<%
out.println("<table>"); 
out.println("<tr> <th>"+"Client ID"+"</th><th>"+"Game"+"</th><th>"+"Date"+"</th><th>"+"Numbets"+"</th><th>"+"Returns"+"</th><th>"+"Stake"+"</th></tr>"); 
%>	
		<%
		while (rs.next()) {
			out.println("<tr><td>" +  rs.getInt("clientid")+"</td> <td>"+ rs.getString("game") +"</td> <td>"+ rs.getDate("date") + "</td><td>"+rs.getInt("numbets")+
					"</td><td>"+ rs.getFloat("returns") + "</td><td>" + rs.getFloat("stake") + "</td></tr>");
		}

out.println("</table>"); 
		%>
</body>
</html>