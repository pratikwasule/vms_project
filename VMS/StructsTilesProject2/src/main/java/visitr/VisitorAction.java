package visitr;


import java.util.List; 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import util.StateMasterDAO;

public class VisitorAction extends DispatchAction{
	VisitorDAO vdao=new VisitorDAO();
	
	
	public ActionForward updateSave(ActionMapping maping,ActionForm 
			form,HttpServletRequest req,HttpServletResponse res)throws Exception
			{
		     VistorForm v=(VistorForm)form;
		      System.out.println("---update---- "+v.getVisitorPhone());
		      return maping.findForward("update");
		
			}
	public ActionForward viewAllRecords(ActionMapping maping,ActionForm 
			form,HttpServletRequest req,HttpServletResponse res)throws Exception
			{
		       String vn=req.getParameter("vn");
		        
		       List<String> list = vdao.getVisitorEntry();
		      List<VisitorDTO> vlist = vdao.getVisitorDetail(vn);
		      System.out.println("vlist "+vlist.size());
		       req.setAttribute("lst", list);
		       req.setAttribute("vlist", vlist);
		    return maping.findForward("viewEntry");
				
		
			}
	
	public ActionForward updateAllRecords(ActionMapping maping,ActionForm 
			form,HttpServletRequest req,HttpServletResponse res)throws Exception
			{
		       String vn=req.getParameter("vn");
		        
		       List<String> list = vdao.getVisitorEntry();
		      List<VisitorDTO> vlist = vdao.getVisitorDetail(vn);
		      System.out.println("vlist "+vlist.size());
		       req.setAttribute("lst", list);
		       req.setAttribute("vlist", vlist);
		    return maping.findForward("updateAllRecords");
				
		
			}
	
	
	
	
	
	
	public ActionForward getDistList(ActionMapping maping,ActionForm 
			form,HttpServletRequest req,HttpServletResponse res)throws Exception
			{  
		//req.getServletContext().setAttribute("sl", );
		      String stcode=	req.getParameter("stcode");
		      req.setAttribute("stList", new StateMasterDAO().getStateDetail());
			  req.setAttribute("distList", new StateMasterDAO().getDistrictList(stcode));
		   
		        return maping.findForward("s");
		
			}
	public ActionForward visitorEntry(ActionMapping maping,ActionForm 
			form,HttpServletRequest req,HttpServletResponse res)throws Exception
			{ 
		req.setAttribute("stList", new StateMasterDAO().getStateDetail());
		   
		        return maping.findForward("s");
		
			}
	
	public ActionForward saveVisitorEntry(ActionMapping maping,ActionForm 
			form,HttpServletRequest req,HttpServletResponse res)throws Exception
			{
		VistorForm vistorForm = (VistorForm)form;
		VisitorDTO vdto=new VisitorDTO();
		BeanUtils.copyProperties(vdto, vistorForm);
		vdto.setVid(Integer.parseInt(vistorForm.getVisitorPhone().substring(6)));
		
		
		     int i = vdao.insertVisitorEntry(vdto);
		     if(i>0)
		     {
		    	 req.setAttribute("saveEntry", "Visitor Successfull Regist");
		    	 return maping.findForward("saveEntry"); 
		     }
		     else
		     {
		    	 req.setAttribute("unsaveEntry", "Visitor Successfull Fail");
				    
		    return maping.findForward("s");
		     }
		
			}
	
	
	public ActionForward searchVisitor(ActionMapping maping,ActionForm 
			form,HttpServletRequest req,HttpServletResponse res)throws Exception
			{
		     List<String> list = vdao.getVisitorEntry();
		    
		       req.setAttribute("lst", list);
		     
		    return maping.findForward("viewEntry");
		
			}
	public ActionForward updateVisitor(ActionMapping maping,ActionForm 
			form,HttpServletRequest req,HttpServletResponse res)throws Exception
			{
		     List<String> list = vdao.getVisitorEntry();
		    
		       req.setAttribute("lst", list);
		     
		    return maping.findForward("updateVisitor");
		
			}
	
	


}
