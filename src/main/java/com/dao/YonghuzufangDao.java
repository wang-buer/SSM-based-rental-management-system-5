package com.dao;

import com.entity.YonghuzufangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YonghuzufangVO;
import com.entity.view.YonghuzufangView;


/**
 * 用户租房
 * 
 * @author 
 * @email 
 * @date 2022-03-20 17:20:42
 */
public interface YonghuzufangDao extends BaseMapper<YonghuzufangEntity> {
	
	List<YonghuzufangVO> selectListVO(@Param("ew") Wrapper<YonghuzufangEntity> wrapper);
	
	YonghuzufangVO selectVO(@Param("ew") Wrapper<YonghuzufangEntity> wrapper);
	
	List<YonghuzufangView> selectListView(@Param("ew") Wrapper<YonghuzufangEntity> wrapper);

	List<YonghuzufangView> selectListView(Pagination page,@Param("ew") Wrapper<YonghuzufangEntity> wrapper);
	
	YonghuzufangView selectView(@Param("ew") Wrapper<YonghuzufangEntity> wrapper);
	

}
