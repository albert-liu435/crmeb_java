package com.zbkj.crmeb.bargain.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.PageParamRequest;
import com.github.pagehelper.PageInfo;
import com.zbkj.crmeb.bargain.model.StoreBargain;
import com.zbkj.crmeb.bargain.request.StoreBargainRequest;
import com.zbkj.crmeb.bargain.request.StoreBargainSearchRequest;
import com.zbkj.crmeb.bargain.response.StoreBargainResponse;
import com.zbkj.crmeb.front.request.BargainFrontRequest;
import com.zbkj.crmeb.front.response.BargainDetailResponse;
import com.zbkj.crmeb.store.request.StoreProductStockRequest;
import com.zbkj.crmeb.store.response.StoreProductResponse;

import java.util.List;
import java.util.Map;

/**
 * 砍价 Service
 * +----------------------------------------------------------------------
 * | CRMEB [ CRMEB赋能开发者，助力企业发展 ]
 * +----------------------------------------------------------------------
 * | Copyright (c) 2016~2020 https://www.crmeb.com All rights reserved.
 * +----------------------------------------------------------------------
 * | Licensed CRMEB并不是自由软件，未经许可不能去掉CRMEB相关版权
 * +----------------------------------------------------------------------
 * | Author: CRMEB Team <admin@crmeb.com>
 * +----------------------------------------------------------------------
 */
public interface StoreBargainService extends IService<StoreBargain> {

    /**
     * 分页显示砍价商品列表
     */
    PageInfo<StoreBargainResponse> getList(StoreBargainSearchRequest request, PageParamRequest pageParamRequest);

    /**
     * 新增砍价商品
     */
    boolean saveBargain(StoreBargainRequest storeBargainRequest);

    /**
     * 删除砍价商品
     */
    boolean deleteById(Integer id);

    /**
     * 修改砍价商品
     */
    boolean updateBarhain(StoreBargainRequest storeBargainRequest);

    /**
     * 修改砍价商品状态
     */
    boolean updateBargainStatus(Integer id, boolean status);

    /**
     * 查询砍价商品详情
     */
    StoreProductResponse getAdminDetail(Integer id);

    /**
     * H5 砍价商品列表
     */
    PageInfo<StoreBargainResponse> getH5List(PageParamRequest pageParamRequest);

    /**
     * H5 获取查看、分享、参与人数
     * @param id BargainDetailResponse
     */
    Map<String, Object> getH5Share(Integer id);

    /**
     * H5 获取砍价商品详情信息
     * @return BargainDetailResponse
     */
    BargainDetailResponse getH5Detail(Integer id);

    /**
     * 获取当前时间的砍价商品
     * @return List<StoreBargain>
     */
    List<StoreBargain> getCurrentBargainByProductId(Integer productId);

    /**
     * 参与砍价活动
     * @return Boolean
     */
    Boolean start(BargainFrontRequest bargainFrontRequest);

    /**
     * 砍价商品根据实体查询
     * @return Boolean
     */
    List<StoreBargain> getByEntity(StoreBargain storeBargainParam);

    /**
     * 扣减砍价商品库存
     * @param bargainId     砍价产品id
     * @param num           购买商品数量
     * @param attrValueId   砍价产品规格
     * @param productId     主商品id
     * @param uid           用户uid
     * @return Boolean
     */
    Boolean decProductStock(Integer bargainId, Integer num, Integer attrValueId, Integer productId, Integer uid);

    /**
     * 添加库存
     */
    Boolean stockAddRedis(StoreProductStockRequest stockRequest);

    /**
     * 后台任务批量操作库存
     */
    void consumeProductStock();

    /**
     * 砍价活动结束后处理
     */
    void stopAfterChange();

    /**
     * 商品是否存在砍价活动
     * @param productId 商品编号
     */
    Boolean isExistActivity(Integer productId);

    /**
     * 查询带异常
     * @param id 砍价商品id
     * @return StoreBargain
     */
    StoreBargain getByIdException(Integer id);

    /**
     * 添加/扣减库存
     * @param id 秒杀商品id
     * @param num 数量
     * @param type 类型：add—添加，sub—扣减
     */
    Boolean operationStock(Integer id, Integer num, String type);
}
