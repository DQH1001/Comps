package com.ssm.model;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
	public static void main(String[] args) {
	
	}
	public boolean SaveProject(Projects pro) {
		// TODO Auto-generated method stub
		return false;
	}
	public String insertComps(Comps coms) {
		int count = this.cm.insertComps(coms);
		return count>0?"ok":"false";
	}
}