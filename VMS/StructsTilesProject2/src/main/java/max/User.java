package max;

import org.apache.struts.action.ActionForm;

public class User extends ActionForm{
  String vdsUserName;
  String vdsPassword;
public String getVdsUserName() {
	return vdsUserName;
}
public void setVdsUserName(String vdsUserName) {
	this.vdsUserName = vdsUserName;
}
public String getVdsPassword() {
	return vdsPassword;
}
public void setVdsPassword(String vdsPassword) {
	this.vdsPassword = vdsPassword;
}
  
}
