package com.ssm.model;

import java.util.*;

import org.aspectj.weaver.ArrayAnnotationValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.entity.Comps;
import com.ssm.entity.Projects;
import com.ssm.entity.Words;
import com.ssm.entity.*;
import com.ssm.mapper.ICompsProjectMapper;
import com.sun.org.apache.bcel.internal.generic.AALOAD;

@Transactional
@Component("compsModel")
public class CompanyModel {
	
	ICompsProjectMapper cm=null;
	@Autowired
	public void setCm(@Qualifier("compsProject")ICompsProjectMapper cm) {
		this.cm = cm;
	}
	public CompanyModel() {		
		  
	} 
	//查询所有公司信息
	public List<Map<String,Object>> CompsList(){
    	List<Comps> lc=this.cm.selectCompanyAll();
    	Map<String, Object> mp=null;
    	List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
    	for (Comps comps2 : lc) {
    		mp=new HashMap<String, Object>();
    		mp.put("cid",comps2.getCid());
    		mp.put("cname",comps2.getCname());
    		mp.put("clogo", comps2.getClogo());
    		list.add(mp);
		}
    	return list;
    } 
	//公司注册中用于遍历专业复选框
	public List<Map<String,Object>> SearchProjectList(String pros) {
    	List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
    	List<Projects> lsp=cm.SelectProjectList(pros);
    	Map<String,Object> map=null;
    	for (Projects comps2 : lsp) {
    		map=new HashMap<String, Object>();
    		map.put("pid",comps2.getPid());
    		map.put("pname",comps2.getPname());
    		map.put("pdetail",comps2.getPdetail());         
            list.add(map);
//			System.out.println(comps2.getPname()+" - "+
//    	comps2.getNumbers());
		}
    	return list;
    }
	//查询专业列表及公司列表
	public Map<String ,List> GetComPrjOptions(){
    	Map<String ,List> map=new HashMap<String, List>();
    	List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
    	List<Comps> lc=this.cm.selectCompanyAll();
    	List<Projects> lp=this.cm.SelectProjectList(null);
    	Map<String, Object> mp=null;
    	for (Projects projects : lp) {
			mp=new HashMap<String, Object>();
			mp.put("pid",projects.getPid());
    		mp.put("pname",projects.getPname());
    		list.add(mp);
		}
    	map.put("pro",list);
    	list=new ArrayList<Map<String,Object>>();
    	for (Comps comps2 : lc) {
    		mp=new HashMap<String, Object>();
    		mp.put("cid",comps2.getCid());
    		mp.put("cname",comps2.getCname());
    		list.add(mp);
		}
    	map.put("coms",list);
    	return map;
    }
	//企业注册
	public String insertComps(Comps coms) {
		int count = this.cm.insertComps(coms);
		return count>0?"ok":"false";
	}
	//查询公司中被学生选择的专业及数量
	public List<Map<String,Object>> selectCompsProList(){
		//sql查询出来的重复数据
		List<Scores> lsScores=this.cm.selectCompsProList();
		//用于封装主菜单的公司集合
		List<Map<String,Object>> lsComps=new ArrayList<Map<String,Object>>();
		//用于判断公司名是否重复
		List<String> names=new ArrayList<String>();
		//用于遍历
		Map<String,Object> map=null;
		String str=null;
		for (Scores scores : lsScores) {
			str=scores.getComps().getCname();
			if(!names.contains(str)) {
				names.add(str);
				map=new HashMap<String, Object>();
				map.put("authorityId", scores.getComps().getCid());
				map.put("parentId", -1);
				map.put("authorityName", str);
				lsComps.add(map);
			}
		}
		//用于封装父子菜单
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		for (Map<String,Object> map2 : lsComps) {
			//循环遍历赋值子菜单
			int count=0;
			for (Scores sc : lsScores) {
				if(map2.get("authorityName").equals(sc.getComps().getCname())) {
					//put更多的是专业明细和人数
    				map=new HashMap<String, Object>();
    				// 主："authorityId": 18,  子  "parentId": 18
    				map.put("parentId",Integer.valueOf(map2.get("authorityId").toString()));
    				//目的是虽然遍历put的是子目录，但是authorityId也是有的，也是唯一性的
    				map.put("authorityId",sc.getComps().getCid()+100);
    				// 主：put 公司name,  子  put 专业name
    				map.put("authorityName",sc.getProject().getPname());
    				map.put("cName",sc.getComps().getCname());
    				map.put("nums",sc.getNumber());
    				map.put("pdetail",sc.getProject().getPdetail());
    				list.add(map);
    				count+=sc.getNumber();
				}
			}
			//继续把父菜单装入
			map2.put("nums",count);
			list.add(map2);
		}
		return list;
	}
	//查询公司被选人数，话题数，留言数，员工数，轮播图，视频，clogo，cname
	public Map<String,Object> selectCompanyCountsBycid(int cid){
		Comps comps=this.cm.selectCompanyCountsBycid(cid);
		Map<String,Object> map=null;
		map=new HashMap<String, Object>();
		map.put("cname",comps.getCname());
		map.put("clogo", comps.getClogo());
		map.put("cvideo",comps.getCvideo());
		List<Map<String,Object>> l=new ArrayList<Map<String,Object>>();
		Map<String,Object> m=null;
		String[] s=comps.getCimgs().split(",");
		for (String string : s) {
			m=new HashMap<String, Object>();
			m.put("img", "../../WeAdmin/images/imglunbo/"+string);
			l.add(m);
		}
		map.put("cimgs", l);
		map.put("ctvchoose", comps.getCtvchoose());
		map.put("numbers", comps.getNumbers());
		map.put("usersnumbers", comps.getUsersnumbers());
		map.put("huati", comps.getHuati());
		map.put("liuyan", comps.getLiuyan());
		return map;
	}
	//根据cid查询公司所有话题
  	public List<Map<String,Object>> selectCompWordsBycid(int cid){
  		List<Words> words=new ArrayList();
  		words=cm.selectCompWordsBycid(cid);
  		List<Map<String,Object>> listMap=new ArrayList<Map<String,Object>>();
  		Map<String,Object> map=null;
  		for(Words word:words) {
  			map=new HashMap<String, Object>();
  			map.put("wid", word.getWid());
  			map.put("wtitle", word.getWtitle());
  			map.put("wcontent", word.getWcontent());
  			map.put("wdate", word.getWdate());
  			map.put("w_cid", word.getW_cid());
  			map.put("w_sid", word.getW_sid());
  			map.put("wimages", word.getWimages());
  			map.put("wauthor", word.getWauthor());
  			map.put("wcount", word.getWcount());
  			map.put("whid", word.getWhid());
  			map.put("slogo", "../../WeAdmin/upload/"+word.getStu().getSlogo());
  			//map.put("clogo", "images/clogo/"+word.getComp().getClogo());
  			map.put("sname", word.getStu().getSname());
  			listMap.add(map);
  		}
  		return listMap;
  	}
	//查询学生
  	@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
	public Map<String,Object> StusCompyList(Comps ocm){
		List<Map<String, Object>> lists=new ArrayList<Map<String,Object>>();
		List<Scores> lc=this.cm.selectStusCompsDetail(ocm);
		Map<String, Object> mp=null;
		for (Scores scors : lc) {
			mp=new HashMap<String, Object>();
			//put的根目录的json数据，特点：				
			mp.put("sid",scors.getS_sid());
			mp.put("slogo", scors.getStus().getSlogo());
			mp.put("sname", scors.getStus().getSname());
			mp.put("clname", scors.getStus().getClasses().getClname());
			mp.put("pname", scors.getProject().getPname());
			mp.put("number", scors.getNumber());
			lists.add(mp);
		}
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("data",lists);
		map.put("count",cm.selectCountStusComps(ocm));
		return map;
	}
	
	public Map<String, Object> getLogin(Comps com) {
		Map<String, Object> map=new HashMap<String, Object>();
		Comps c=this.cm.getLogin(com);
		if(c==null) {
			map.put("msg", "账号错误");
		}else if(!c.getCpwd().equals(com.getCpwd())) {
			map.put("msg", "密码错误");
		}else {
			map.put("msg", "ok");
			map.put("cid", c.getCid());
			map.put("cname", c.getCname());
			map.put("clogo", c.getClogo());
			map.put("c_pros", c.getC_pros());
		}
		return map;
	}
	public Map<String, Object> getChart(int cid,String projects) {
		List<Projects> pros=new ArrayList();
		Comps com=new Comps();
		com.setCid(cid);
		com.setC_pros(projects);
		//System.out.println(com.getC_pros()+" / "+com.getCid());
		pros=cm.getChart(com);
		Map<String, Object> map=new HashMap<String, Object>();
		List<String> ls1=new ArrayList<String>();
		List<Integer> ls2=new ArrayList<Integer>();
		for(Projects pro:pros) {
			ls1.add(pro.getPname());
			ls2.add(pro.getNumbers());
		}
		map.put("pnames", ls1);
		map.put("pnumbers", ls2);
		return map;
	}
	//更新公司话题被回复数量
		public boolean updateCompWordsBywhid(int whid) {
			int count=0;
	    	count=cm.updateCompWordsBywhid(whid);
	    	return count>0;
		}
		//插入留言
		public boolean insertCompWords(Words word) {
			int count=0;
			if(word.getW_sid()==0) {
				word.setW_sid(1);
			}
			count=cm.insertCompWords(word);
	    	return count>0;
		}
		//删除留言
		public int deleteCompWordsBywid(Words word) {
			int count=0;
			count=cm.deleteCompWordsBywid(word);
	    	return count;
		}		
	//专业插入(院长功能,待完善)
		public boolean SaveProject(Projects pro) {
			// TODO Auto-generated method stub
			return false;
		}
//		public static void main(String[] args) {
//			ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
//			CompanyModel sm=(CompanyModel)ac.getBean("compsModel");
//			System.out.println(sm.getChart(1,"1,2,3,4,5,6").toString());
//		}
}