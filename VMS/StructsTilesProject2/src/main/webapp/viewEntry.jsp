<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<html>
    <head>
        <title>First Login Example Project</title>
        <script type="text/javascript">
        
        function submitView()
        
        { 
        	alert("hii");
        	var vn= document.getElementById("visitorName").value;
        	 document.vf.action="visitorEntry.do?method=viewAllRecords&vn="+vn+"";
        	 document.vf.submit();
        }  
        </script> 
        
        
    </head>
   <body bgcolor="cyan" >
   <h1 align ="center">
   <font size="40px" color="black">Vehicle Monitoring System</font></h1><br>
	<h2 align ="center"><font size="20px" color="red"> View Visitor </font></h2>
	
        <html:form action="visitorEntry" >
       
       
    <table border="1" align="center">
        		
        	  <logic:present name="lst">
        		<tr>
        			<td class="link4">User ID : </td>
        			
                       <td> 
                       <html:select property="visitorName" styleId="visitorName">
                        <html:option value="">--Select--</html:option>
                         <html:option value="All">--All--</html:option>
                        <logic:iterate id="lst" name="lst">
                       
                         <html:option value="${lst}">${lst}</html:option>
                       </logic:iterate>
                       </html:select>
                       </td>
        			</tr>
        		
        		</logic:present>
        		
        		
      <logic:present name="vlist">
      <html>
      <body bgcolor="cyan" >
   
   <font  color="black">Vehicle Monitoring System</font></h1><br>
	<h2 align ="center"><font size="20px" color="red">Visitor Entry</font></h2>
	 <table border="1" align="center">
	 <tr><td>Name</td><td>Email</td><td>Add</td><td>Phone</td><td>StateName</td><td>DistrictName</td></tr>
	 
	 <logic:iterate id="vlist" name="vlist">
			<tr>
				<td><bean:write name="vlist" property="visitorName" /></td>
				<td><bean:write name="vlist" property="visitorEmail" /></td>
				<td><bean:write name="vlist" property="visitorAdd" /></td>
				<td><bean:write name="vlist" property="visitorPhone" /></td>
				<td><bean:write name="vlist" property="stateName" /></td>
				<td><bean:write name="vlist" property="distName" /></td>
			</tr>


		</logic:iterate>
	 
	 </table>
      
      
      </logic:present>  		
					
				<tr><td><html:submit property="method" value="View" onclick="submitView();" /></td>
				
        		</tr>
        		
        	</table>
        </html:form>
    </body>
</html>
