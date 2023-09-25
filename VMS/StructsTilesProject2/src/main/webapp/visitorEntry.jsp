<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<html>
<head>
<title>First Login Example Project</title>
<script type="text/javascript">
        
        function submitSave()
        {     alert("insert");
        	 document.vf.action="visitorEntry.do?method=saveVisitorEntry";
        	 document.vf.submit();
        }
        
        function getDistList()
        {  
        var stCode=document.getElementById("stateCode").value;
         document.vf.action="visitorEntry.do?method=getDistList&stcode="+stCode+"";
         document.vf.submit();
        }
        </script>
</head>
<body bgcolor="cyan">
	<h1 align="center">
		<font size="40px" color="black">Vehicle Monitoring System</font>
	</h1>
	<br>
	<h2 align="center">
		<font size="20px" color="red">Visitor Entry</font>
	</h2>

	<html:form action="visitorEntry">


		<table border="1" align="center">

			<logic:present name="saveEntry">
				<bean:write name="saveEntry" />
			</logic:present>

			<logic:present name="unsaveEntry">
				<bean:write name="unsaveEntry" />
			</logic:present>


			<tr>
				<td class="link4">State Name :</td>
				<td><html:select property="stateCode" styleId="stateCode"
						onchange="getDistList();">
						<html:option value="0">select state</html:option>

						<logic:present name="stList">
							<html:options collection="stList" property="stateCode"
								labelProperty="stateName" />

						</logic:present>


					</html:select></td>

				<td class="link4">District Name :</td>

				<td><html:select property="distCode" styleId="distCode">
						<html:option value="0">--select District--</html:option>

						<logic:present name="distList">
							<html:options collection="distList" property="distCode"
								labelProperty="distName" />
						</logic:present>
					</html:select></td>

			</tr>

			<tr>
				<td class="link4">User Name :</td>
				<td><html:text name="vf" property="visitorName" /><br></td>
				<td class="link4">Email :</td>
				<td><html:text name="vf" property="visitorEmail" /><br></td>
			</tr>

			<tr>
				<td class="link4">Addres :</td>
				<td><html:text name="vf" property="visitorAdd" /><br></td>
				<td class="link4">Phone :</td>
				<td><html:text name="vf" property="visitorPhone" /><br></td>
			</tr>

			<tr>

				<td><html:submit property="method" value="Save"
						onclick="submitSave();" /></td>

			</tr>

		</table>
	</html:form>
</body>
</html>
