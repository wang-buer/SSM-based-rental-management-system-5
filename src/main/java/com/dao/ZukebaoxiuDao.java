package com.dao;

import com.entity.ZukebaoxiuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZukebaoxiuVO;
import com.entity.view.ZukebaoxiuView;


/**
 * 租客报修
 * 
 * @author 
 * @email 
 * @date 2022-03-20 17:20:43
 */
public interface ZukebaoxiuDao extends BaseMapper<ZukebaoxiuEntity> {
	
	List<ZukebaoxiuVO> selectListVO(@Param("ew") Wrapper<ZukebaoxiuEntity> wrapper);
	
	ZukebaoxiuVO selectVO(@Param("ew") Wrapper<ZukebaoxiuEntity> wrapper);
	
	List<ZukebaoxiuView> selectListView(@Param("ew") Wrapper<ZukebaoxiuEntity> wrapper);

	List<ZukebaoxiuView> selectListView(Pagination page,@Param("ew") Wrapper<ZukebaoxiuEntity> wrapper);
	
	ZukebaoxiuView selectView(@Param("ew") Wrapper<ZukebaoxiuEntity> wrapper);
	

}
