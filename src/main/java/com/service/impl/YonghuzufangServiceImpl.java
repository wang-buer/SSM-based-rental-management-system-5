package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.YonghuzufangDao;
import com.entity.YonghuzufangEntity;
import com.service.YonghuzufangService;
import com.entity.vo.YonghuzufangVO;
import com.entity.view.YonghuzufangView;

@Service("yonghuzufangService")
public class YonghuzufangServiceImpl extends ServiceImpl<YonghuzufangDao, YonghuzufangEntity> implements YonghuzufangService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YonghuzufangEntity> page = this.selectPage(
                new Query<YonghuzufangEntity>(params).getPage(),
                new EntityWrapper<YonghuzufangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YonghuzufangEntity> wrapper) {
		  Page<YonghuzufangView> page =new Query<YonghuzufangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YonghuzufangVO> selectListVO(Wrapper<YonghuzufangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YonghuzufangVO selectVO(Wrapper<YonghuzufangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YonghuzufangView> selectListView(Wrapper<YonghuzufangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YonghuzufangView selectView(Wrapper<YonghuzufangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
