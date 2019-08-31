package com.xiaomi.service;

import com.xiaomi.pojo.Type;

import java.util.List;

public interface TypeService {

    List<Type> getAllType();

    Type getTypeById(Integer id);

    List<Type> getTypeForIndex();
}
