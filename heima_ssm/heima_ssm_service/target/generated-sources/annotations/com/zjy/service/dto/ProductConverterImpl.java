package com.zjy.service.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjy.domain.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-05-02T13:20:57+0800",
    comments = "version: 1.2.0.Beta2, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
@Component
public class ProductConverterImpl implements ProductConverter {

    @Override
    public Product dtoToEntity(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( productDto.getId() );
        product.setProductnum( productDto.getProductnum() );
        product.setProductname( productDto.getProductname() );
        product.setCityname( productDto.getCityname() );
        product.setDeparturetime( productDto.getDeparturetime() );
        product.setProductprice( productDto.getProductprice() );
        product.setProductdesc( productDto.getProductdesc() );
        product.setProductstatus( productDto.getProductstatus() );

        return product;
    }

    @Override
    public ProductDto entityToDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setId( product.getId() );
        productDto.setProductnum( product.getProductnum() );
        productDto.setProductname( product.getProductname() );
        productDto.setCityname( product.getCityname() );
        productDto.setDeparturetime( product.getDeparturetime() );
        productDto.setProductprice( product.getProductprice() );
        productDto.setProductdesc( product.getProductdesc() );
        productDto.setProductstatus( product.getProductstatus() );

        return productDto;
    }

    @Override
    public List<ProductDto> listEntityToDto(List<Product> productList) {
        if ( productList == null ) {
            return null;
        }

        List<ProductDto> list = new ArrayList<ProductDto>();
        for ( Product product : productList ) {
            list.add( entityToDto( product ) );
        }

        return list;
    }

    @Override
    public List<Product> listDtoToEntity(List<ProductDto> productDtoList) {
        if ( productDtoList == null ) {
            return null;
        }

        List<Product> list = new ArrayList<Product>();
        for ( ProductDto productDto : productDtoList ) {
            list.add( dtoToEntity( productDto ) );
        }

        return list;
    }

    @Override
    public Page<ProductDto> pageEntityToDto(Page<Product> page) {
        if ( page == null ) {
            return null;
        }

        Page<ProductDto> page1 = new Page<ProductDto>();

        page1.setPages( page.getPages() );
        List<ProductDto> list = listEntityToDto( page.getRecords() );
        if ( list != null ) {
            page1.setRecords( list );
        }
        page1.setTotal( page.getTotal() );
        page1.setSize( page.getSize() );
        page1.setCurrent( page.getCurrent() );
        page1.setSearchCount( page.isSearchCount() );

        return page1;
    }
}
