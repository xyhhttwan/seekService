package com.seek.soft.common.dao;

import com.seek.soft.common.domain.BaseDomain;

/**
 * Created by baixiaobin on 16/8/4.
 */
public interface IDaoAware <D extends IBaseDAO, T extends BaseDomain> {
    D getDao();
}