package max;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class UserAction extends DispatchAction{
	
	public ActionForward login(ActionMapping maping,ActionForm 
			form,HttpServletRequest req,HttpServletResponse res)throws Exception
			{
		System.out.println("in");
		return maping.findForward("lgn");
		
			}

}
