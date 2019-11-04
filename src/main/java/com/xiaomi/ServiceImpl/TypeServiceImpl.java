package com.xiaomi.ServiceImpl;

import com.xiaomi.dao.TypeMapper;
import com.xiaomi.pojo.Type;
import com.xiaomi.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@CacheConfig(cacheNames = "types", cacheManager = "cacheManager")
@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    TypeMapper typeMapper = null;

    @Cacheable(key = "'getAllType'")
    @Override
    public List<Type> getAllType() {
        return typeMapper.getAllType();
    }

    @Cacheable(key = "'getTypeById'+#id")
    @Override
    public Type getTypeById(Integer id) {
        return typeMapper.getTypeById(id);
    }

    @Cacheable(key = "'getTypeForIndex'")
    @Override
    public List<Type> getTypeForIndex() {
        return typeMapper.getTypeForIndex();
    }
}
