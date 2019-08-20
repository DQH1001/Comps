package com.ssm.model;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.entity.*;
import com.ssm.mapper.ICompsProjectMapper;

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
	public List<Map<String,Object>> SearchProjectList() {
    	List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
    	List<Projects> lsp=cm.SelectProjectList();
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
    	List<Projects> lp=this.cm.SelectProjectList();
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
	//专业插入(院长功能,待完善)
	public boolean SaveProject(Projects pro) {
		// TODO Auto-generated method stub
		return false;
	}
	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		CompanyModel sm=(CompanyModel)ac.getBean("compsModel");
		System.out.println(sm.selectCompsProList().toString());
	}
}