function Ajax_query(url) 
{  	

    
	if(url !="")
	{          
		if(window.XMLHttpRequest)
		{
			//For Non-IE browsers	
						        
			req =new XMLHttpRequest();
			                 
			req.onreadystatechange = processMessage; 
						        			             
			try 
			{						        			             
	     		req.open("GET", url, true);              
			}
			catch (e){}              
			
			req.send(null);          
		}          
		else if(window.ActiveXObject)
		{
			//For IE browsers		
			            
			req =new ActiveXObject("Microsoft.XMLHTTP");  
			      
			if(req)
			{       
				           
				req.onreadystatechange = processMessage;                  
				req.open("POST", url, true);                  
				req.send(null);				              
			}          
		} 
		
	}  
}  

function processMessage()
{
	
	if(req.readyState==4)
	{	
		// Complete
		if(req.status==200)
		{		
				
			// OK response   
			var resp = req.responseText;
		    
		    alert(resp);
			 
		}      
	}  
}