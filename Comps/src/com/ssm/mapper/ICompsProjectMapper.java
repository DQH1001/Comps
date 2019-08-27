package com.ssm.mapper;


import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.ssm.entity.*;

@Component("compsProject")
public interface ICompsProjectMapper {
	public List<Projects> SelectProjectList(@Param("pros")String pros);
	public List<Comps> selectCompanyProjectByObject(Comps com);	
	public List<Projects> SelectProjectListByComps(Comps com);
	public Comps selectCompanyBycid(int cid);
	public List<Users> SelectUsersInfoByCid(int cid);
	public List<Comps> selectCompanyAll();
	public int insertComps(Comps coms);
	public List<Scores> selectCompsProList();
	public Comps selectCompanyCountsBycid(int cid);
	public List<Words> selectCompWordsBycid(int cid);
	public List<Scores> selectStusCompsDetail(Comps ocm);
	public int selectCountStusComps(Comps ocm);
	public Comps getLogin(Comps com);
	public List<Projects> getChart(Comps com);
	public int updateCompWordsBywhid(int whid);
	public int insertCompWords(Words word);
	public int deleteCompWordsBywid(Words word);
}

