package com.mobiletrain.mapper;

import com.mobiletrain.domain.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {

    public List<Product>search(@Param("minPrice")Integer minPrice,@Param("maxPrice")Integer maxPrice);
}
