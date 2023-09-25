<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<html>
    <head>
        <title>First Login Example Project</title>
        <script type="text/javascript">
        
        function submitView()
        {    var vn= document.getElementById("visitorName").value;
        	 document.vf.action="visitorEntry.do?method=updateAllRecords&vn="+vn+"";
        	 document.vf.submit();
        }
        
        function submitUpdate()
        {    
        	 document.vf.action="visitorEntry.do?method=updateSave";
        	 document.vf.submit();
        }
        
        
        </script> 
    </head>
   <body bgcolor="cyan" >
   <h1 align ="center">
   <font size="40px" color="black">Vehicle Monitoring System</font></h1><br>
	<h2 align ="center"><font size="20px" color="red"> Update Visitor </font></h2>
	
        <html:form action="visitorEntry" >
       
       
    <table border="1" align="center">
        		
        	  <logic:present name="lst">
        		<tr>
        			<td class="link4">User ID : </td>
        			
                       <td> 
                       <html:select property="visitorName" styleId="visitorName">
                        <html:option value="">--Select--</html:option>
                         
                        <logic:iterate id="lst" name="lst">
                       
                         <html:option value="${lst}">${lst}</html:option>
                       </logic:iterate>
                       </html:select>
                       </td>
        			</tr>
        		<tr><td><html:submit property="method" value="View" onclick="submitView();" /></td></tr>
        		
        		</logic:present>
        		
        		
      <logic:present name="vlist">
      <html>
      <body bgcolor="cyan" >
   
   <font  color="black">Vehicle Monitoring System</font></h1><br>
	<h2 align ="center"><font size="20px" color="red">Visitor Entry</font></h2>
	 <table border="1" align="center">
	  
	 <logic:iterate id="vlist" name="vlist">
	 <tr><td>Name</td><td><html:text name="vlist" property="visitorName"/></td>
	  <td>Email</td><td><html:text name="vlist" property="visitorEmail"/></td></tr>
	   
	   <tr><td>Add</td><td><html:text name="vlist" property="visitorAdd"/></td>
	    <td>Phone</td><td><html:text name="vlist" property="visitorPhone"/></td></tr>
	     
	     <tr><td>State </td><td><html:text name="vlist" property="stateName"/></td>
	 <td>District</td><td><html:text name="vlist" property="distName"/></td></tr>
</logic:iterate>
	 <tr><td><html:submit property="method" value="Update" onclick="submitUpdate();" /></td></tr>
        		
	 </table>
      
      
      </logic:present>  		
					
				
        	</table>
        </html:form>
    </body>
</html>
