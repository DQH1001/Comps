package com.ssm.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ssm.entity.*;
import com.ssm.model.CompanyModel;

@Controller
@RequestMapping("/coms")
public class CompsController {
	//
    CompanyModel comModel=null;

	public CompanyModel getComModel() {
		return comModel;
	}
    @Autowired
	public void setComModel(@Qualifier("compsModel")CompanyModel comModel) {
		this.comModel = comModel;
	}
    @RequestMapping(value="/list")
	@ResponseBody
	public List<Map<String,Object>> CompyList(HttpServletRequest req) {
		try {
			req.setCharacterEncoding("utf-8");
			
			List<Map<String,Object>> ma=this.comModel.CompsList();
			System.out.println("ssi:"+ma.size());			
			return ma;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}		
	}
    @RequestMapping(value="/prolist")
	@ResponseBody
	public List<Map<String,Object>> ProjList(HttpServletRequest req) {
		try {
			req.setCharacterEncoding("utf-8");			
			List<Map<String,Object>> ma=this.comModel.SearchProjectList();
			System.out.println("ssi:"+ma.size());			
			return ma;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}		
	}
   /*
    *  field: 'file'  和 @RequestParam(value="file",required=false)呼应
    */
    @RequestMapping(value="/upload",method=RequestMethod.POST)
	private String fildUpload(Comps coms ,
			@RequestParam(value="file",required=false) MultipartFile[] file,
			HttpServletRequest request)throws Exception{
		//基本表单
		System.out.println(file.length+" * "+coms.getCname());
//		org.springframework.web.multipart.commons.CommonsMultipartResolver t;
		//获得物理路径webapp所在路径
//		String pathRoot = request.getSession().getServletContext().getRealPath("");
		String pathRoot=request.getRealPath("upload/comps/");
		String pathRootTxt="C:\\Users\\AD钙\\git\\WeAdmin\\WeAdmin\\WebContent\\txt\\";
		String pathRootClogo="C:\\Users\\AD钙\\git\\WeAdmin\\WeAdmin\\WebContent\\images\\clogo\\";
		String pathRootLunbo="C:\\Users\\AD钙\\git\\WeAdmin\\WeAdmin\\WebContent\\images\\imglunbo\\";
		String pathRootVideo="C:\\Users\\AD钙\\git\\WeAdmin\\WeAdmin\\WebContent\\video\\";

		String path="";
		List<String> listImagePath=new ArrayList<String>();
		int j=0;
		for (MultipartFile mf : file) {			
			if(!mf.isEmpty()){				
				//生成uuid作为文件名称
				//String uuid = UUID.randomUUID().toString().replaceAll("-","");
				//获得文件类型（可以判断如果不是图片，禁止上传）
				String contentType=mf.getContentType();
				//获得文件后缀名称
				String imageName=contentType.substring(contentType.indexOf("/")+1);
				//file name jpeg - image/jpeg
				System.out.println(mf.getOriginalFilename()+" name "+imageName+" - "+contentType);
				//使用底下注上的方式能上传但是会导致文件损坏(文件上传ok，文件流不行)
				//上传
				//mf.transferTo(new File(pathRoot+mf.getOriginalFilename()));
				 // 使用getBytes()方法 上传companys项目的绝对路径上
		       // byte[] data=mf.getOriginalFilename().getBytes();		        
		        //写出byte数组到文件
		       // File file3=null;
		        if(j==0) {
		        	//file3=new File(pathRootClogo+mf.getOriginalFilename());
		        	FileUtils.copyInputStreamToFile(mf.getInputStream(), new File(pathRoot+mf.getOriginalFilename()));
		        	FileUtils.copyInputStreamToFile(mf.getInputStream(), new File(pathRootClogo+mf.getOriginalFilename()));
		        }else if(j==1) {
		        	//file3=new File(pathRootTxt+mf.getOriginalFilename());	
		        	FileUtils.copyInputStreamToFile(mf.getInputStream(), new File(pathRoot+mf.getOriginalFilename()));
		        	FileUtils.copyInputStreamToFile(mf.getInputStream(), new File(pathRootTxt+mf.getOriginalFilename()));
		        }else if(j==2) {
		        	//file3=new File(pathRootVideo+mf.getOriginalFilename());	
		        	FileUtils.copyInputStreamToFile(mf.getInputStream(), new File(pathRoot+mf.getOriginalFilename()));
		        	FileUtils.copyInputStreamToFile(mf.getInputStream(), new File(pathRootVideo+mf.getOriginalFilename()));
		        }else {
		        	//file3=new File(pathRootLunbo+mf.getOriginalFilename());	
		        	FileUtils.copyInputStreamToFile(mf.getInputStream(), new File(pathRoot+mf.getOriginalFilename()));
		        	FileUtils.copyInputStreamToFile(mf.getInputStream(), new File(pathRootLunbo+mf.getOriginalFilename()));
		        }
//		        FileOutputStream fosWithByte=new FileOutputStream(file3);
//		        fosWithByte.write(data,0,data.length);
//		        fosWithByte.close();
				j++;
				listImagePath.add(mf.getOriginalFilename());
			}
		}
		//将list集合换成String数组
		String str="";
		int i=0;
		for (String string : listImagePath) {
			if(i<3) {
				str+=string+";";
			}else {
				str+=string+",";
			}
			i++;
		}
		//将coms对象未封装的属性封装一次
		String[] str1=str.split(";");
		coms.setClogo(str1[0]);
		coms.setCtext(str1[1]);
		coms.setCvideo(str1[2]);
		coms.setCimgs(str1[3]);
		System.out.println(coms.toString());
		String s=this.comModel.insertComps(coms);
		//System.out.println(path);
		//request.setAttribute("imagesPathList", listImagePath);
		return s;
	}
    @RequestMapping(value="/addPro")
	@ResponseBody
	public String ProjectSave(HttpServletRequest req) {
		try {
			req.setCharacterEncoding("utf-8");
			Projects pro=new Projects();
			pro.setPdetail("detallll");
			pro.setPname("EJB1");
			pro.setPlogo("ai.jpg");
			boolean sl=this.comModel.SaveProject(pro);
			return sl?"ok":"sorry";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}		
	}
}
