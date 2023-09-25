
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<html>
    <head>
        <title>First Login Example Project</title>
    </head>
   <body bgcolor="tan" >
   <h1 align ="center"><marquee> 
   <font size="40px" color="black">Vehicle Monitoring System</font></marquee></h1><br>
	<h2 align ="center"><font size="20px" color="red">Login</font></h2>
	
        <html:form action="login" >
      	<table border="1" bgcolor="grey" align="center">
        		<div style="color:red">
           			 <html:errors />
       			 </div>
        	
        	
        		<tr>
        			<td class="link4">User Name : </td>
        			<td ><html:text name="l" property="vdsUserName" /><br></td>
        		</tr>
        		
        		<tr>
        			<td class="link4">Password  : </td>
        			<td><html:password name="l" property="vdsPassword" /><br></td>
        		</tr>
        		
        		<tr>
					<td><html:submit property="method" value="login"/></td>
					
        		</tr>
        		
        	</table>
        </html:form>
    </body>
</html>
