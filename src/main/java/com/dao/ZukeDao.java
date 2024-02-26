package com.dao;

import com.entity.ZukeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZukeVO;
import com.entity.view.ZukeView;


/**
 * 租客
 * 
 * @author 
 * @email 
 * @date 2022-03-20 17:20:42
 */
public interface ZukeDao extends BaseMapper<ZukeEntity> {
	
	List<ZukeVO> selectListVO(@Param("ew") Wrapper<ZukeEntity> wrapper);
	
	ZukeVO selectVO(@Param("ew") Wrapper<ZukeEntity> wrapper);
	
	List<ZukeView> selectListView(@Param("ew") Wrapper<ZukeEntity> wrapper);

	List<ZukeView> selectListView(Pagination page,@Param("ew") Wrapper<ZukeEntity> wrapper);
	
	ZukeView selectView(@Param("ew") Wrapper<ZukeEntity> wrapper);
	

}
