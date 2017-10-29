package org.zdh.customermgr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zdh.common.pageutil.Page;
import org.zdh.common.util.format.DateFormatHelper;
import org.zdh.common.util.json.JsonHelper;
import org.zdh.customermgr.service.ICustomerService;
import org.zdh.customermgr.vo.CustomerModel;
import org.zdh.customermgr.vo.CustomerQueryModel;


@Controller
@RequestMapping(value="/customer")
public class CustomerController {
	@Autowired
	private ICustomerService ics=null;
	
	@RequestMapping(value="toAdd",method=RequestMethod.GET)
	public String toAdd(){
		return "customermgr/add";
	}
	
	@RequestMapping(value="add",method=RequestMethod.POST)
	public String add(@ModelAttribute("c") CustomerModel c){
		c.setRegisterTime(DateFormatHelper.long2str(System.currentTimeMillis()));
		ics.create(c);
		return "customermgr/success";
	}
	
	@RequestMapping(value="toUpdate/{customerUuid}",method=RequestMethod.GET)
	public String toUpdate(Model model,@PathVariable("customerUuid") int customerUuid){
		CustomerModel c=ics.getByUuid(customerUuid);
		model.addAttribute("cm", c);
		return "customermgr/update";
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String update(@ModelAttribute("c") CustomerModel c){
		ics.update(c);
		return "customermgr/success";
	}
	
	@RequestMapping(value="toDelete/{customerUuid}",method=RequestMethod.GET)
	public String toDelete(Model model,@PathVariable("customerUuid") int customerUuid){
		CustomerModel c=ics.getByUuid(customerUuid);
		model.addAttribute("cm", c);
		return "customermgr/delete";
	}
	
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public String delete(@RequestParam("uuid")int customerUuid){
		ics.delete(customerUuid);
		return "customermgr/success";
	}
	
	@RequestMapping(value="toList",method=RequestMethod.GET)
	public String toList(@ModelAttribute("wm")CustomerWebModel wm,Model model){
		CustomerQueryModel cqm = null;
		if(wm.getQueryJsonStr()==null || wm.getQueryJsonStr().trim().length()==0){
			cqm =  new CustomerQueryModel();
		}else{
			cqm = (CustomerQueryModel)JsonHelper.str2Object(wm.getQueryJsonStr(), CustomerQueryModel.class);
		}
		
		cqm.getPage().setNowPage(wm.getNowPage());
		if(wm.getPageShow() > 0){
			cqm.getPage().setPageShow(wm.getPageShow());
		}
		
		Page dbPage = ics.getByConditionPage(cqm);
		
		//
		model.addAttribute("wm", wm);
		model.addAttribute("page", dbPage);
				
		return "customermgr/list";
	}
	@RequestMapping(value="toQuery",method=RequestMethod.GET)
	public String toQuery(){
		return "customermgr/query";
	}
}
