package org.zdh.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zdh.cartmgr.service.ICartService;
import org.zdh.cartmgr.vo.CartModel;
import org.zdh.cartmgr.vo.CartQueryModel;
import org.zdh.common.pageutil.Page;
import org.zdh.common.util.format.DateFormatHelper;
import org.zdh.goodsmgr.service.IGoodsService;
import org.zdh.goodsmgr.vo.GoodsModel;
import org.zdh.goodsmgr.vo.GoodsQueryModel;
import org.zdh.ordermgr.service.IOrderDetailService;
import org.zdh.ordermgr.service.IOrderService;
import org.zdh.ordermgr.vo.OrderModel;

@Controller
@RequestMapping("/")
public class IndexController {
	@Autowired
	private IGoodsService igs = null;
	@Autowired
	private ICartService ics = null;
	@Autowired
	private IOrderService ios = null;
	@Autowired
	private IOrderDetailService iods = null;
//	@Autowired
//	private IStoreService iss = null;
//	
	@RequestMapping(value="/toIndex",method=RequestMethod.GET)
	public String toIndex(Model model){
		GoodsQueryModel gqm = new GoodsQueryModel();
		gqm.getPage().setPageShow(100);

		Page<GoodsModel> page = igs.getByConditionPage(gqm);
		
		model.addAttribute("page",page);
		
		
		return "index";
	}
	
	@RequestMapping(value="/toGoodsDesc/{goodsUuid}",method=RequestMethod.GET)
	public String toGoodsDesc(Model model,@PathVariable("goodsUuid")int goodsUuid){
		GoodsModel gm = igs.getByUuid(goodsUuid);
		
		model.addAttribute("m",gm);
		return "goods/desc";
	}
	
	@RequestMapping(value="/addToCart/{goodsUuid}",method=RequestMethod.GET)
	public String addToCart(Model model,@PathVariable("goodsUuid")int goodsUuid,@CookieValue("MyLogin")String myLogin){
		int customerUuid = Integer.parseInt( myLogin.split(",")[0]);
		
		CartModel cm = new CartModel();
		cm.setBuyNum(1);
		cm.setCustomerUuid(customerUuid);
		cm.setGoodsUuid(goodsUuid);
		
		ics.create(cm);
		
		CartQueryModel cqm = new CartQueryModel();
		cqm.getPage().setPageShow(1000);
		cqm.setCustomerUuid(customerUuid);
		
		
		Page<CartModel>  page = ics.getByConditionPage(cqm);
		
		model.addAttribute("page",page);
		
		return "cart/myCart";
	}
	@RequestMapping(value="/toCart",method=RequestMethod.GET)
	public String toCart(Model model,@CookieValue("MyLogin")String myLogin){
		int customerUuid = Integer.parseInt( myLogin.split(",")[0]);
		
		CartQueryModel cqm = new CartQueryModel();
		cqm.getPage().setPageShow(1000);
		cqm.setCustomerUuid(customerUuid);
		
		Page<CartModel>  page = ics.getByConditionPage(cqm);
		
		model.addAttribute("page",page);
		
		return "cart/myCart";
	}
	@RequestMapping(value="/order",method=RequestMethod.GET)
	public String order(@CookieValue("MyLogin")String myLogin){
		//1:查出这个人购物车所有的信息		
		int customerUuid=Integer.parseInt( myLogin.split(",")[0]);
		CartQueryModel cqm=new CartQueryModel();
		cqm.getPage().setPageShow(100);
		cqm.setCustomerUuid(customerUuid);
		Page<CartModel> page=ics.getByConditionPage(cqm);
		float totalMoney=0.0f;
		for (CartModel c: page.getResult()) {
			totalMoney+=10.0f;
		}
		OrderModel om=new OrderModel();
		om.setCustomerUuid(customerUuid);
		om.setOrderTime(DateFormatHelper.long2str(System.currentTimeMillis()));
		om.setSaveMoney(0.0f);
		om.setState(1);
		om.setTotalMoney(totalMoney);
		ios.create(om);
		return "success";
	}
}
