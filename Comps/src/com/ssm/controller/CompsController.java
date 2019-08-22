package com.ssm.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
	public List<Map<String,Object>> ProjList(HttpServletRequest req,String pros) {
		try {
			req.setCharacterEncoding("utf-8");			
			List<Map<String,Object>> ma=this.comModel.SearchProjectList(pros);
			System.out.println("ssi:"+ma.size());			
			return ma;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}		
	}
   /*
    *  field: 'file'  �� @RequestParam(value="file",required=false)��Ӧ
    */
    @RequestMapping(value="/upload",method=RequestMethod.POST)
	private String fildUpload(Comps coms ,
			@RequestParam(value="file",required=false) MultipartFile[] file,
			HttpServletRequest request)throws Exception{
		//������
		System.out.println(file.length+" * "+coms.getCname());
//		org.springframework.web.multipart.commons.CommonsMultipartResolver t;
		//�������·��webapp����·��
//		String pathRoot = request.getSession().getServletContext().getRealPath("");
		String pathRoot=request.getRealPath("upload/comps/");
		
		//̨ʽ��·��
		String pathRootTxt="C:\\Users\\AD��\\git\\WeAdmin\\WeAdmin\\WebContent\\txt\\";
		String pathRootClogo="C:\\Users\\AD��\\git\\WeAdmin\\WeAdmin\\WebContent\\images\\clogo\\";
		String pathRootLunbo="C:\\Users\\AD��\\git\\WeAdmin\\WeAdmin\\WebContent\\images\\imglunbo\\";
		String pathRootVideo="C:\\Users\\AD��\\git\\WeAdmin\\WeAdmin\\WebContent\\video\\";
		
		//ƽ��·��
//		String pathRootTxt="C:\\Users\\11040\\git\\WeAdmin\\WeAdmin\\WebContent\\txt\\";
//		String pathRootClogo="C:\\Users\\11040\\git\\WeAdmin\\WeAdmin\\WebContent\\images\\clogo\\";
//		String pathRootLunbo="C:\\Users\\11040\\git\\WeAdmin\\WeAdmin\\WebContent\\images\\imglunbo\\";
//		String pathRootVideo="C:\\Users\\11040\\git\\WeAdmin\\WeAdmin\\WebContent\\video\\";
		
		String path="";
		List<String> listImagePath=new ArrayList<String>();
		int j=0;
		for (MultipartFile mf : file) {			
			if(!mf.isEmpty()){				
				//����uuid��Ϊ�ļ�����
				//String uuid = UUID.randomUUID().toString().replaceAll("-","");
				//����ļ����ͣ������ж��������ͼƬ����ֹ�ϴ���
				String contentType=mf.getContentType();
				//����ļ���׺����
				String imageName=contentType.substring(contentType.indexOf("/")+1);
				//file name jpeg - image/jpeg
				System.out.println(mf.getOriginalFilename()+" name "+imageName+" - "+contentType);
				//ʹ�õ���ע�ϵķ�ʽ���ϴ����ǻᵼ���ļ���(�ļ��ϴ�ok���ļ�������)
				//�ϴ�
				//mf.transferTo(new File(pathRoot+mf.getOriginalFilename()));
				 // ʹ��getBytes()���� �ϴ�companys��Ŀ�ľ���·����
		       // byte[] data=mf.getOriginalFilename().getBytes();		        
		        //д��byte���鵽�ļ�
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
		//��list���ϻ���String����
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
		//��coms����δ��װ�����Է�װһ��
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
    @RequestMapping(value="/selectCounts")
	@ResponseBody
	public Map<String,Object> selectCompanyCountsBycid(HttpServletRequest req,int cid) {
    	
		Map<String,Object> map=new HashMap<String, Object>();			
		map=this.comModel.selectCompanyCountsBycid(cid);
		return map;   	
	}
    @RequestMapping(value="/selectCPList")
	@ResponseBody
	public Map<String,Object> selectCompsProList(HttpServletRequest req) {
    	List<Map<String,Object>> listMap=this.comModel.selectCompsProList();
		Map<String,Object> map=new HashMap<String, Object>();			
		map.put("code",0);
		map.put("msg","ͶƱdetail");
		map.put("count",listMap.size());
		map.put("data",listMap);
		return map;   	
	}
    //��ѯ��˾����
    @RequestMapping(value="/selectCompWords")
	@ResponseBody
	public List<Map<String,Object>> selectCompWordsBycid(HttpServletRequest req,int cid) {
    	List<Map<String,Object>> listMap=this.comModel.selectCompWordsBycid(cid);
		return listMap;   	
	}
    //��ѯѧ���б�
    @RequestMapping(value="/stusList")
	@ResponseBody
	public Map<String,Object> StusCompyList(HttpServletRequest req,
			@RequestBody Scores sco) {
		try {
			req.setCharacterEncoding("utf-8");
			System.out.println("page:"+sco.getPage()+",limit:"+sco.getLimit());
			Comps comps=new Comps();
			comps.setCid(1);
			
			//1   3��   sql limit 0,3    2 3    limit 3 ��3
			comps.setCurrentPage((sco.getPage()-1)*sco.getLimit());//1 2 ��ǰҳ �滻Ϊlimit�ĵ�һ����ֵ
			comps.setPageSize(sco.getLimit());
			if(sco!=null) {
				System.out.println(sco.getNumber()+"-"+
			    sco.getS_pid()+"-"+sco.getStuname());
				//0-0-null
				   comps.setS_pid(sco.getS_pid());
				   comps.setNumbers(sco.getNumber());
//				   sc.setNumbers(0);
//				   sc.setS_pid(2);
//				   sc.setStuname("e");
//				   comps.setScore(sc);
				comps.setScore(sco);
			}			
			Map<String,Object> map=this.comModel.StusCompyList(comps);	
			System.out.println(((List)map.get("data")).size()+" zis"  );
			map.put("code",0);
			map.put("msg","students detail");
			System.out.println("----------");
			return map;			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}		
	}
//    public static void main(String[] args) {
//    	ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
//    	CompsController sm=(CompsController)ac.getBean("compsController");
//		System.out.println(sm.selectCompWordsBycid(1).toString());
//    	
//	}
}
