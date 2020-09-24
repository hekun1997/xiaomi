package com.xiaomi.commodity.service;

import com.xiaomi.common.bo.Type;

import java.util.List;

public interface TypeService {

    List<Type> getAllType();

    Type getTypeById(Integer id);

    List<Type> getTypeForIndex();
}
