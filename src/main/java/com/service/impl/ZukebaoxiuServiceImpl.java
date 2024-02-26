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


import com.dao.ZukebaoxiuDao;
import com.entity.ZukebaoxiuEntity;
import com.service.ZukebaoxiuService;
import com.entity.vo.ZukebaoxiuVO;
import com.entity.view.ZukebaoxiuView;

@Service("zukebaoxiuService")
public class ZukebaoxiuServiceImpl extends ServiceImpl<ZukebaoxiuDao, ZukebaoxiuEntity> implements ZukebaoxiuService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZukebaoxiuEntity> page = this.selectPage(
                new Query<ZukebaoxiuEntity>(params).getPage(),
                new EntityWrapper<ZukebaoxiuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZukebaoxiuEntity> wrapper) {
		  Page<ZukebaoxiuView> page =new Query<ZukebaoxiuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZukebaoxiuVO> selectListVO(Wrapper<ZukebaoxiuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZukebaoxiuVO selectVO(Wrapper<ZukebaoxiuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZukebaoxiuView> selectListView(Wrapper<ZukebaoxiuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZukebaoxiuView selectView(Wrapper<ZukebaoxiuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
