<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.lang.*" import="java.sql.*"%>
    
    <%
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=BettingData;encrypt=true;trustServerCertificate=true;", "sa", "Subhash_9657723827");
	
	%>

<%
    String game = request.getParameter("game");
    String clientId = request.getParameter("clientId");
    ResultSet rs=null;
    
    if (game != null && !game.isEmpty()) {
    	PreparedStatement stmt = conn.prepareStatement("SELECT * FROM bet WHERE game=?"); 
    	stmt.setString(1, game);
    	 rs = stmt.executeQuery();
    }
    if (clientId != null && !clientId.isEmpty()) {
    	PreparedStatement stmt = conn.prepareStatement("SELECT * FROM bet WHERE clientid=?"); 
		stmt.setInt(1, Integer.parseInt(clientId));
		rs = stmt.executeQuery();

    }

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Table</title>
</head>
<body>
	<h1>Search Table</h1>
	<form method="get">
		<label for="game">Game:</label>
		<input type="text" name="game" value="<%= game %>"><br>
		<label for="clientId">Client ID:</label>
		<input type="text" name="clientId" value="<%= clientId %>"><br>
		<button type="submit">Search</button>
	</form>
	<br>
	
	<%
out.println("<table>"); 
out.println("<tr> <th>"+"Client ID"+"</th><th>"+"Game"+"</th><th>"+"Date"+"</th><th>"+"Numbets"+"</th><th>"+"Returns"+"</th><th>"+"Stake"+"</th></tr>"); 
%>	

<% 
if(rs!=null)
		while (rs.next()) {
			out.println("<tr><td>" +  rs.getInt("clientid")+"</td> <td>"+ rs.getString("game") +"</td> <td>"+ rs.getDate("date") + "</td><td>"+rs.getInt("numbets")+
					"</td><td>"+ rs.getFloat("returns") + "</td><td>" + rs.getFloat("stake") + "</td></tr>");
		}

out.println("</table>"); 
		%>
	
</body>
</html>
