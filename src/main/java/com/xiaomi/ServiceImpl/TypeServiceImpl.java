package com.xiaomi.ServiceImpl;

import com.xiaomi.dao.TypeMapper;
import com.xiaomi.pojo.Type;
import com.xiaomi.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    TypeMapper typeMapper = null;

    @Override
    public List<Type> getAllType() {
        return typeMapper.getAllType();
    }

    @Override
    public Type getTypeById(Integer id) {
        return typeMapper.getTypeById(id);
    }

    @Cacheable(cacheNames = "getTypeForIndex",key = "'index测试'")
    @Override
    public List<Type> getTypeForIndex() {
        return typeMapper.getTypeForIndex();
    }
}
