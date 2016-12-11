package com.market.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

public interface ICollectListService {
	public List<Integer> getCollectList(Integer studentId);

	public void addCollectList(Integer studentId, Integer goodsId);

	public int deleteCollectList(Integer studentId, Integer goodsId);

	public int clearCollectList(Integer studentId);
}
