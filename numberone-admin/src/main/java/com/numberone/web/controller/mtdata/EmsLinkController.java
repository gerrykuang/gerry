package com.numberone.web.controller.mtdata;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.numberone.common.base.AjaxResult;
import com.numberone.framework.web.base.BaseController;
import com.numberone.system.service.ISysConfigService;

import net.bytebuddy.asm.Advice.Return;
/**
 * 化學品領用
 * @author Q18020504
 *
 */
@Controller
@RequestMapping("/mtdata/emsLink")
public class EmsLinkController extends BaseController{
	
	private String prefix = "mtdata/emsLink";
	
    @Autowired
    private ISysConfigService configService;
	@RequiresPermissions("mtdata:emsLink:view")
	@GetMapping()
	public String emsLink()
	{
		return prefix + "/emsLink";
	}

	/**
	 * EMS鏈接
	 * 
	 * @param response
	 * @return
	 */
	@RequiresPermissions("mtdata:emsLink:clickLink")
	@ResponseBody
	public String ClickLink(){
		String url=configService.selectConfigByKey("sys.emslink.clickLink");
		if(url==""){
			return url;
		}else{
			return "點擊鏈接錯誤";
		}		
	}
}
