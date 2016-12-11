package com.market.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.market.model.Comments;
import com.market.model.Student;
import com.market.service.IGoodsShowService;
import com.market.tools.BaseResponeData;
import com.market.tools.GoodsData;
import com.market.tools.GoodsInfoData;
import com.market.tools.RequestData;

/**
 * 商品展示
 * 
 * @author hxuhao
 *
 */

@RequestMapping("/GoodsShow")
public class GoodsShowController {

	@Autowired
	private IGoodsShowService iGoodsShowService;

	// 展示商品
	@ResponseBody
	@RequestMapping(value = "/show", method = RequestMethod.POST)
	public GoodsInfoData ShowGoods(@RequestBody RequestData requestData) {
		GoodsInfoData goodsInfoData = new GoodsInfoData();

		Map<String, String> data = requestData.getData().get(0);
		String sortField = data.get("sortField");
		String sortType = data.get("sortType");
		Integer category = Integer.valueOf(data.get("category"));
		String info = data.get("info");

		List<GoodsData> goodsDataList = iGoodsShowService.getGoods(sortField, sortType, category, info);
		if (goodsDataList.size() > 0) {
			goodsInfoData.setCode(200);
			goodsInfoData.setData(goodsDataList);
		} else {
			goodsInfoData.setCode(404);
		}
		return goodsInfoData;

	}

	// 点赞
	@ResponseBody
	@RequestMapping(value = "/praiseGoods/{gid}", method = RequestMethod.GET)
	public BaseResponeData praiseGoods(@PathVariable("gid") Integer gid) {
		BaseResponeData responeData = new BaseResponeData();

		int ret = iGoodsShowService.praiseGoods(gid);
		if (ret > 0) {
			responeData.setCode(200);
			responeData.setInfo("点赞成功");
		} else {
			responeData.setCode(500);
			responeData.setInfo("点赞失败");
		}

		return responeData;
	}

	// 提交评论
	@ResponseBody
	@RequestMapping(value = "/addComment/{gid}", method = RequestMethod.POST)
	public BaseResponeData addComment(@PathVariable("gid") Integer gid, @RequestBody Comments comments,
			HttpSession session) {
		BaseResponeData responeData = new BaseResponeData();

		Student student = (Student) session.getAttribute("student");
		if (comments.getStudentid() == null)
			comments.setStudentid(student.getId());

		int ret = iGoodsShowService.addComments(comments);
		if (ret > 0) {
			responeData.setCode(200);
			responeData.setInfo("评论成功");
		} else {
			responeData.setCode(500);
			responeData.setInfo("评论失败");
		}

		return responeData;
	}

}
