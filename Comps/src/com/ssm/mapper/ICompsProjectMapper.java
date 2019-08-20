package com.ssm.mapper;


import java.util.*;

import org.springframework.stereotype.Component;

import com.ssm.entity.*;
@Component("compsProject")
public interface ICompsProjectMapper {
	public List<Projects> SelectProjectList();
	public List<Comps> selectCompanyProjectByObject(Comps com);	
	public List<Projects> SelectProjectListByComps(Comps com);
	public Comps selectCompanyBycid(int cid);
	public List<Users> SelectUsersInfoByCid(int cid);
	public List<Comps> selectCompanyAll();
	public int insertComps(Comps coms);
	public List<Scores> selectCompsProList();
}
