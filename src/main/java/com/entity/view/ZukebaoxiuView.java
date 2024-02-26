package com.entity.view;

import com.entity.ZukebaoxiuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 租客报修
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-03-20 17:20:43
 */
@TableName("zukebaoxiu")
public class ZukebaoxiuView  extends ZukebaoxiuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZukebaoxiuView(){
	}
 
 	public ZukebaoxiuView(ZukebaoxiuEntity zukebaoxiuEntity){
 	try {
			BeanUtils.copyProperties(this, zukebaoxiuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
