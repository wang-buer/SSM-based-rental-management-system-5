package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YonghuzufangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YonghuzufangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YonghuzufangView;


/**
 * 用户租房
 *
 * @author 
 * @email 
 * @date 2022-03-20 17:20:42
 */
public interface YonghuzufangService extends IService<YonghuzufangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YonghuzufangVO> selectListVO(Wrapper<YonghuzufangEntity> wrapper);
   	
   	YonghuzufangVO selectVO(@Param("ew") Wrapper<YonghuzufangEntity> wrapper);
   	
   	List<YonghuzufangView> selectListView(Wrapper<YonghuzufangEntity> wrapper);
   	
   	YonghuzufangView selectView(@Param("ew") Wrapper<YonghuzufangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YonghuzufangEntity> wrapper);
   	

}

