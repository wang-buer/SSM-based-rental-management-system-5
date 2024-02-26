package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.YonghuzufangEntity;
import com.entity.view.YonghuzufangView;

import com.service.YonghuzufangService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 用户租房
 * 后端接口
 * @author 
 * @email 
 * @date 2022-03-20 17:20:42
 */
@RestController
@RequestMapping("/yonghuzufang")
public class YonghuzufangController {
    @Autowired
    private YonghuzufangService yonghuzufangService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YonghuzufangEntity yonghuzufang, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("zuke")) {
			yonghuzufang.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YonghuzufangEntity> ew = new EntityWrapper<YonghuzufangEntity>();
    	PageUtils page = yonghuzufangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yonghuzufang), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YonghuzufangEntity yonghuzufang, 
		HttpServletRequest request){
        EntityWrapper<YonghuzufangEntity> ew = new EntityWrapper<YonghuzufangEntity>();
    	PageUtils page = yonghuzufangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yonghuzufang), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YonghuzufangEntity yonghuzufang){
       	EntityWrapper<YonghuzufangEntity> ew = new EntityWrapper<YonghuzufangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yonghuzufang, "yonghuzufang")); 
        return R.ok().put("data", yonghuzufangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YonghuzufangEntity yonghuzufang){
        EntityWrapper< YonghuzufangEntity> ew = new EntityWrapper< YonghuzufangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yonghuzufang, "yonghuzufang")); 
		YonghuzufangView yonghuzufangView =  yonghuzufangService.selectView(ew);
		return R.ok("查询用户租房成功").put("data", yonghuzufangView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YonghuzufangEntity yonghuzufang = yonghuzufangService.selectById(id);
        return R.ok().put("data", yonghuzufang);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YonghuzufangEntity yonghuzufang = yonghuzufangService.selectById(id);
        return R.ok().put("data", yonghuzufang);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YonghuzufangEntity yonghuzufang, HttpServletRequest request){
    	yonghuzufang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yonghuzufang);

        yonghuzufangService.insert(yonghuzufang);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
	@IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody YonghuzufangEntity yonghuzufang, HttpServletRequest request){
    	yonghuzufang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yonghuzufang);

        yonghuzufangService.insert(yonghuzufang);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody YonghuzufangEntity yonghuzufang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yonghuzufang);
        yonghuzufangService.updateById(yonghuzufang);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yonghuzufangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<YonghuzufangEntity> wrapper = new EntityWrapper<YonghuzufangEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("zuke")) {
			wrapper.eq("zhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = yonghuzufangService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	





}
