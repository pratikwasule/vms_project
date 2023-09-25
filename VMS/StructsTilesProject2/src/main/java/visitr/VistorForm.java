package visitr;

import org.apache.struts.action.ActionForm;

public class VistorForm extends ActionForm{
	 
	private static final long serialVersionUID = 1L;
	String visitorName;
	String visitorAdd;
	String visitorPhone;
	String visitorEmail;
	String stateCode;
	String stateName;
	String distCode;
	String distName;
	
	
	public String getDistCode() {
		return distCode;
	}
	public void setDistCode(String distCode) {
		this.distCode = distCode;
	}
	public String getDistName() {
		return distName;
	}
	public void setDistName(String distName) {
		this.distName = distName;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getVisitorEmail() {
		return visitorEmail;
	}
	public void setVisitorEmail(String visitorEmail) {
		this.visitorEmail = visitorEmail;
	}
	public String getVisitorName() {
		return visitorName;
	}
	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}
	public String getVisitorAdd() {
		return visitorAdd;
	}
	public void setVisitorAdd(String visitorAdd) {
		this.visitorAdd = visitorAdd;
	}
	public String getVisitorPhone() {
		return visitorPhone;
	}
	public void setVisitorPhone(String visitorPhone) {
		this.visitorPhone = visitorPhone;
	}
	
	

}
