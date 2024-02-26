package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZukebaoxiuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZukebaoxiuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZukebaoxiuView;


/**
 * 租客报修
 *
 * @author 
 * @email 
 * @date 2022-03-20 17:20:43
 */
public interface ZukebaoxiuService extends IService<ZukebaoxiuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZukebaoxiuVO> selectListVO(Wrapper<ZukebaoxiuEntity> wrapper);
   	
   	ZukebaoxiuVO selectVO(@Param("ew") Wrapper<ZukebaoxiuEntity> wrapper);
   	
   	List<ZukebaoxiuView> selectListView(Wrapper<ZukebaoxiuEntity> wrapper);
   	
   	ZukebaoxiuView selectView(@Param("ew") Wrapper<ZukebaoxiuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZukebaoxiuEntity> wrapper);
   	

}

