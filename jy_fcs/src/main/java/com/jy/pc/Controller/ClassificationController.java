package com.jy.pc.Controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.jy.pc.Entity.ClassificationEntity;
import com.jy.pc.Service.ClassificationService;

@Controller
@ResponseBody
@RequestMapping(value = "classification")
public class ClassificationController {
	@Autowired
	private ClassificationService classificationService;

	// 分类添加
	@RequestMapping(value = "save")
	public Map<String, String> save(HttpServletRequest res, HttpServletResponse req) {
		Map<String, String> map = new HashMap<String, String>();
		String s = res.getParameter("classificationEntity");
		JSONObject jsonObject = JSONObject.parseObject(s);
		Date date = new Date();
		ClassificationEntity classificationEntity = jsonObject.toJavaObject(ClassificationEntity.class);
		classificationEntity.setCreateDate(date);
		classificationService.save(classificationEntity);
		map.put("message", "添加成功");
		return map;
	}

	// 分类修改前查询
	@RequestMapping(value = "findById")
	public Map<String, Object> findById(HttpServletRequest res, HttpServletResponse req,
			@RequestParam(name = "id") String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		ClassificationEntity classification = classificationService.findBId(id);
		if (classification != null) {
			map.put("state", "0");// 查询数据成功
			map.put("data", classification);
		} else {
			map.put("state", "1");// 查询数据失败
		}
		return map;
	}

	// 下拉列表显示
	@RequestMapping(value = "findAll")
	public Map<String, Object> findAll(HttpServletRequest res, HttpServletResponse req) {

		Map<String, Object> map = new HashMap<String, Object>();// 接收数据容器
		List<ClassificationEntity> Classi = classificationService.findAll(); // 查询所有数据方法
		map.put("state", "0");
		map.put("message", "查询成功");
		map.put("data", Classi);
		return map;
	}

	// 分类修改
	@RequestMapping(value = "update")
	public Map<String, String> update(HttpServletRequest res, HttpServletResponse req) {
		Map<String, String> map = new HashMap<String, String>();
		String s = res.getParameter("classificationEntity");
		JSONObject jsonObject = JSONObject.parseObject(s);
		Date date = new Date();
		ClassificationEntity classificationEntity = jsonObject.toJavaObject(ClassificationEntity.class);
		classificationEntity.setUpdateDate(date);
		classificationService.update(classificationEntity);
		map.put("message", "修改成功");
		return map;
	}

	// 分类删除
	@RequestMapping(value = "delete")
	public Map<String, Object> delete(HttpServletRequest res, HttpServletResponse req,
			@RequestParam(name = "id") String id) {
		Map<String, Object> map = new HashMap<String, Object>();// 接收数据容器		
		List<ClassificationEntity> classi = classificationService.findCropLink();//农作物
		
		List<ClassificationEntity> classiFicat = classificationService.findDipLink();//病虫害
		List<ClassificationEntity> classiFication = classificationService.findKeywordLink();//关键词
		ClassificationEntity classificationEntity = classificationService.findBId(id);
		for (int i = 0; i < classi.size(); i++) {
			ClassificationEntity calssiFicat = classi.get(i);
			calssiFicat.getId();
			if (classificationEntity.getId().equals(calssiFicat.getId())) {
				for (int j = 0; j < classiFicat.size(); j++) {
					ClassificationEntity ficat = classiFicat.get(j);
					ficat.getId();
					if (classificationEntity.getId().equals(ficat.getId())) {
						for (int k = 0; k < classiFication.size(); k++) {
							ClassificationEntity calssiFicati = classiFication.get(k);
							calssiFicati.getId();
							if (classificationEntity.getId().equals(calssiFicati.getId())) {
								classificationService.delete(id);
								map.put("status", "0");
								map.put("message", "删除成功");
							} else {
							}
						}
						if (classiFication.size() <= 0) {
						}

					} else {
					}
				}
				if (classiFicat.size() <= 0) {
				}

			} else {}
		}
		if (classi.size() <= 0) {
		}
		return map;
	}

	// 分类模糊查询与分页
	@RequestMapping(value = "/findByName")
	public Map<String, Object> findByName(HttpServletRequest res, HttpServletResponse req,
			 @RequestParam(name = "code") String code,
			@RequestParam(name = "page") Integer page, @RequestParam(name = "size") Integer size) {
		Map<String, Object> map = new HashMap<String, Object>();
		Pageable pageable = new PageRequest(page - 1, size);
		Page<ClassificationEntity> classiList = classificationService.findListByName( code,pageable);
		map.put("state", "0");// 成功
		map.put("message", "查询成功");
		map.put("data", classiList);
		return map;
	}

	// 启用禁用
	@RequestMapping(value = "/enable")
	public Map<String, String> opensulf(HttpServletRequest res, HttpServletResponse req,
			@RequestParam(name = "status") String status, @RequestParam(name = "id") String id) {
		Map<String, String> map = new HashMap<String, String>();
		ClassificationEntity classificationEntity = classificationService.findBId(id);
		classificationEntity.setStatus(status);
		classificationEntity.getStatus();
		if (status.equals("1")) {
			classificationEntity.setStatus("1");
			map.put("state", "0");
			map.put("message", "启用成功");
		} else if (status.equals("0")) {
			classificationEntity.setStatus("0");
			map.put("state", "0");
			map.put("message", "禁用成功");
		}
		classificationService.update(classificationEntity);
		return map;
	}

	/**
	 * 查询上级分类编码列表
	 * 
	 */
	@RequestMapping(value = "/findSubClassiList")
	public Map<String, Object> findSubClassiList(HttpServletRequest res, HttpServletResponse req) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<ClassificationEntity> classificat = classificationService.findSubClassiList();
		if (classificat != null) {
			map.put("state", "0");
			map.put("data", classificat);
		} else {
			map.put("state", "1");
		}
		return map;
	}

	/**
	 * 查询病虫害分类编码列表
	 * 
	 */
	@RequestMapping(value = "/findDipList")
	public Map<String, Object> findDipList(HttpServletRequest res, HttpServletResponse req) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<ClassificationEntity> classificat = classificationService.findDipList();
		if (classificat != null) {
			map.put("state", "0");
			map.put("data", classificat);
		} else {
			map.put("state", "1");
		}
		return map;
	}

	/**
	 * 查询农作物种类分类编码列表
	 * 
	 */
	@RequestMapping(value = "/findCaseList")
	public Map<String, Object> findCaseList(HttpServletRequest res, HttpServletResponse req) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<ClassificationEntity> classificat = classificationService.findCaseList();
		if (classificat != null) {
			map.put("state", "0");
			map.put("data", classificat);
		} else {
			map.put("state", "1");
		}
		return map;
	}

	/**
	 * 查询关键词分类编码列表
	 * 
	 */
	@RequestMapping(value = "/findKeyWordList")
	public Map<String, Object> findKeyWordList(HttpServletRequest res, HttpServletResponse req) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<ClassificationEntity> classificat = classificationService.findKeyWordList();
		if (classificat != null) {
			map.put("state", "0");
			map.put("data", classificat);
		} else {
			map.put("state", "1");
		}
		return map;
	}
}
