package com.market.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.market.dao.ContactWaysMapper;
import com.market.dao.GoodsMapper;
import com.market.dao.GoodsPicturesMapper;
import com.market.model.ContactWays;
import com.market.model.Goods;
import com.market.model.GoodsPictures;
import com.market.service.IGoodsService;

@Service("goodsService")
public class GoodsServiceImpl implements IGoodsService {
	@Autowired
	private GoodsMapper goodsDao;
	@Autowired
	private GoodsPicturesMapper goodsPicturesDao;
	@Autowired
	private ContactWaysMapper contatctWaysDao;
	
	
	@Override
	public int publishGoods(Goods goods) {
		// TODO Auto-generated method stub
		return goodsDao.insertSelective(goods);
	}

	@Override
	public int deleteGoods() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyGoods() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Object> queryGoods() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> uploadImages(int goodsid, String pathRoot, MultipartFile[] files) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub

		List<String> filePaths = new ArrayList<String>();

		for (int i = 0; i < files.length; i++) {

			// 获得物理路径webapp所在路径
			String path = "";
			if (!files[i].isEmpty()) {
				// 生成uuid作为文件名称
				String uuid = UUID.randomUUID().toString().replaceAll("-", "");
				// 获得文件类型（可以判断如果不是图片，禁止上传）
				String contentType = files[i].getContentType();
				// 获得文件后缀名称
				String imageName = contentType.substring(contentType.indexOf("/") + 1);
				path = "/images/" + uuid + "." + imageName.trim();

				try {
					files[i].transferTo(new File(pathRoot + path));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			System.out.println(pathRoot + path);

			// request.setAttribute("imagesPath", "../../static" + path);
			filePaths.add("../../static" + path);
			if (!path.trim().equals("")) {
				GoodsPictures image = new GoodsPictures();
				image.setGoodsid(goodsid);
				;
				image.setPictureaddr(path);
				System.out.println("uploadImage: " + goodsPicturesDao.insertSelective(image));
			}
		}
		
		return filePaths;
	}
	
	@Override
	public int uploadContactWay(ContactWays contactWays){
		
		int ret = contatctWaysDao.insertSelective(contactWays);
		return ret;
		
	}
	
}
