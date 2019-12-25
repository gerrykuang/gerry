package com.numberone.web.controller.mtdata;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.numberone.common.annotation.Log;
import com.numberone.common.base.AjaxResult;
import com.numberone.common.config.Global;
import com.numberone.common.enums.BusinessType;
import com.numberone.common.page.TableDataInfo;
import com.numberone.common.support.Convert;
import com.numberone.common.utils.file.FileUploadUtils;
import com.numberone.framework.config.ServerConfig;
import com.numberone.framework.util.ShiroUtils;
import com.numberone.framework.web.base.BaseController;
import com.numberone.system.domain.SysMsds;
import com.numberone.system.service.ISysMsdsService;

/**
 * MSDS維護
 * 
 * @author Q18020504
 *
 */
@Controller
@RequestMapping("/mtdata/msds")
public class MsdsUpload extends BaseController {
	private String prefix = "mtdata/msds";

	/**
	 * 文件上传路径
	 */
	public static final String MSDS_UPLOAD_PATH = "/profile/upload/";
	@Autowired
	private ServerConfig serverConfig;

	@Autowired
	private ISysMsdsService msdsService;

	@RequiresPermissions("mtdata:msds:view")
	@GetMapping()
	public String exception() {
		return prefix + "/msds";
	}

	@RequiresPermissions("mtdata:msds:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SysMsds msdsid) {
		startPage();
		List<SysMsds> list = msdsService.selectMsdsList(msdsid);
		return getDataTable(list);
	}

	/**
	 * 上傳MSDS PDF檔
	 */
	@RequiresPermissions("mtdata:msds:upload")
	@PostMapping("/upload/{msdsid}")
	@ResponseBody
	public AjaxResult addSave(HttpServletRequest request, MultipartFile file, Long msdsid) throws IOException {
		try {
			java.text.SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			// 上传文件路径
			String filePath = Global.getUploadPath();
			String extension = ".PDF";
			String exten = file.getContentType();
			String uploadTime = request.getParameter("startTime");
			Date startTime = formatter.parse(uploadTime);
			Date date = new Date();
			String currentTime = formatter.format(date);
			Date current = formatter.parse(currentTime);
			Long m = (current.getTime() - startTime.getTime()) / (1000 * 60 * 60 * 24);
			Long days = 365 * 3 - m;
			System.out.println(days);
			String material = msdsService.selectMsdsById(msdsid);
			System.out.println(material);
			// 上传并返回新文件名称
			String fileName = FileUploadUtils.upload(filePath, file, exten);
			int endIndex = fileName.lastIndexOf(".");
			String msds = fileName.substring(0, endIndex);
			String extra = fileName.substring(endIndex);
			String updateBy = ShiroUtils.getLoginName();
			// Long msdsid=Convert.toLong(request.getParameter("msdsid"));
			if (extra.equalsIgnoreCase(extension)) {
				return toAjax(msdsService.updateMsds(msdsid, msds, updateBy, startTime, days));
			} else {
				return AjaxResult.error("請上傳PDF格式的文件！");
			}
			// String url = serverConfig.getUrl() + MSDS_UPLOAD_PATH + fileName;
		} catch (Exception e) {
			return AjaxResult.error(e.getMessage());
		}
	}

	/**
	 * 修改物料
	 */
	@GetMapping("/edit/{msdsid}")
	public String edit(@PathVariable("msdsid") Long msdsid, ModelMap mmap) {
		// System.out.println(msdsid);
		mmap.put("msdsid", msdsService.selectMsdsById(msdsid));
		// System.out.println(msdsid);
		return prefix + "/edit";
	}

	/**
	 * MSDS 文件下載
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequiresPermissions("mtdata:msds:download")
	@PostMapping("/downloadFile/{msdsid}")
	@ResponseBody
	public String downloadFile(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String downloadFilePath = Global.getUploadPath();
		Long msdsid = Convert.toLong(request.getParameter("id"));

		System.out.println(msdsid);
		String sysFile = msdsService.selectMsdsById(msdsid);
		String fileName = sysFile.toString().concat(".PDF");
		System.out.println("filePath" + downloadFilePath);

		File file = new File(downloadFilePath.concat(fileName));
		if (file.exists()) {
			response.setContentType("application/force-download");// 设置强制下载不打开  
																	//        
			response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
			byte[] buffer = new byte[1024];
			FileInputStream fis = null;
			BufferedInputStream bis = null;
			try {
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				OutputStream outputStream = response.getOutputStream();
				int i = bis.read(buffer);
				while (i != -1) {
					outputStream.write(buffer, 0, i);
					i = bis.read(buffer);
				}
				return "恭喜您，文件下載成功！";
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (bis != null) {
					try {
						bis.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (fis != null) {
					try {
						fis.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return "文件下載失敗，請重試";
	}

	/**
	 * 新增msds
	 */
	@GetMapping("/add")
	public String add() {
		return prefix + "/add";
	}

	/**
	 * 新增保存msds
	 */
	@RequiresPermissions("mtdata:msds:add")
	@Log(title = "安全庫存管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@Transactional(rollbackFor = Exception.class)
	@ResponseBody
	public AjaxResult addSave(SysMsds msdsid) {
		msdsid.setCreateBy(ShiroUtils.getLoginName());
		ShiroUtils.clearCachedAuthorizationInfo();
		return toAjax(msdsService.insertMsds(msdsid));
	}
}
